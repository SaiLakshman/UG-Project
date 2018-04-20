package bca.batch2011.project1.ct;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bca.batch2011.project1.ca.Student;

public class StudentsMarksDB {
	/** This function is for checking weather a particular Exam_paper_id present in Exam_Paper_Table or not*/
	public boolean isexist(ArrayList<ExamPaper> ep1,ArrayList<ExamPaper> ep2)
	{
		for(int i= 0;i< ep1.size();i++)
		{
			for(int j= 0;j< ep2.size();j++)
			{
				if(ep1.get(i).getExam_paper_id() == ep2.get(j).getExam_paper_id())
					return false;
			}
		}
		return true;
	}
	/**This function is for getting all the details of Exam and the selected paper title from E_P_T and E_M_T and P_M_T*/
	public  ArrayList<ExamPaper> selecteidsfromexpaper(Papers_Course c,int pid) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<ExamPaper> c1= new ArrayList<ExamPaper>();
		 ExamPaper c2= new ExamPaper();
		 String com= "select a.Exam_Paper_Id,a.Exam_Id,a.Total_Marks,b.Exam_Code,b.Exam_Title"
		 		+ ",a.Paper_Id,c.Paper_Title from Exam_Paper_Table a,Exam_Master_Table b,"
		 		+ "Paper_Master_Table c where a.Paper_Id= c.Paper_Id and  a.Exam_Id= b.Exam_Id"
		 		+ " and a.Course_Id= ? and a.Year_Of_Joining= ? and a.Year= ? and a.Semester= ?"
		 		+ " and a.Paper_Id= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,c.getCourse_id());
		 ps.setInt(2,c.getBatch());
		 ps.setInt(3,c.getYear());
		 ps.setInt(4,c.getSemester());
		 ps.setInt(5,pid);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 c2.setExam_id(rs.getInt("Exam_Id"));
			 c2.setExam_paper_id(rs.getInt("Exam_Paper_Id"));
			 c2.setMarks(rs.getInt("Total_Marks"));
			 c2.setExam_code(rs.getString("Exam_Code"));
			 c2.setExam_title(rs.getString("Exam_Title"));
			 c2.setExam_paper_title(rs.getString("Paper_Title"));
			 c1.add(c2);
			 c2= new ExamPaper();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	/**This function is for getting all Exam_Paper_Id's and their Marks from Student_Marks_Table order by Student_Id first,then Exam_Paper_Id*/
	public  ArrayList<ExamPaper> selecteidsfromsmtable() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<ExamPaper> c1= new ArrayList<ExamPaper>();
		 ExamPaper c2= new ExamPaper();
		 String com= "select * from Student_Marks_Table order by Student_Id,Exam_Paper_Id";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 c2.setExam_paper_id(rs.getInt("Exam_Paper_Id"));
			 c2.setMarks(rs.getInt("Marks"));
			 c1.add(c2);
			 c2= new ExamPaper();
		 }
		 Database.freeConnection(conn);	
		 return c1;
	}
	/**This function is for getting all Student_Id's from Student_Marks_Table order by Student_Id first, then Exam_Paper_Id*/
	public  ArrayList<Student> selectsidsfromsmtable() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Student> c1= new ArrayList<Student>();
		 Student c2= new Student();
		 String com= "select * from Student_Marks_Table order by Student_Id,Exam_Paper_Id";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 c2.setStudentId(rs.getInt("Student_Id"));
			 c1.add(c2);
			 c2= new Student();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	/**This function is for getting distinct Student_Id's from Student_Marks_Table order by Student_Id*/
	public  ArrayList<Student> distinctselectsidsfromsmtable() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Student> c1= new ArrayList<Student>();
		 Student c2= new Student();
		 String com= "select distinct Student_Id from Student_Marks_Table order by Student_Id";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 c2.setStudentId(rs.getInt("Student_Id"));
			 c1.add(c2);
			 c2= new Student();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	/**This function is for getting Student_Id and their Name from Student_Master_Table for a particular Course_Id and batch*/
	public  ArrayList<Student> selectstudents(Papers_Course c) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Student> c1= new ArrayList<Student>();
		 Student c2= new Student();
		 String com= "select Name,Student_Id from Student_Master_Table where Course_Id= ?"
		 		+ " and Year_Of_Joining= ?";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,c.getCourse_id());
		 ps.setInt(2,c.getBatch());
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 c2.setStudentId(rs.getInt("Student_Id"));
			 c2.setName(rs.getString("Name"));
			 c1.add(c2);
			 c2= new Student();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	/**This function is for inserting the Student_Id,Exam_Paper_Id and Marks into Student_Marks_Table  */
	public void insertstudentmarks(int exam_paper_id, String[] students,String[] mark) throws IOException, SQLException,ClassNotFoundException
	{
		for(int i= 0;i<students.length;i++)
		{
			if(students[i] != null && students[i] != "" && mark[i] != "" && mark[i] != null)
			{
				int a= Integer.parseInt(students[i]);
				int b= Integer.parseInt(mark[i]);
				PreparedStatement ps= null;
				String com="insert into Student_Marks_Table(Exam_Paper_Id,Student_Id,Marks)values(?,?,?);";
				Connection conn= Database.getConnection();
				ps= conn.prepareStatement(com);
				ps.setInt(1,exam_paper_id);
				ps.setInt(2,a);
				ps.setInt(3,b);
				ps.executeUpdate();
				Database.freeConnection(conn);
			}
		}
	}
	/**This function is for deleting the Student_Id,Exam_Paper_Id and Marks from Student_Marks_Table for a particular Exam_Paper_Id*/
	public void deletefromsm(ArrayList<ExamPaper> ep1) throws IOException,SQLException,ClassNotFoundException
	{
		PreparedStatement ps= null;
		for(int i= 0; i< ep1.size();i++)
		{
			String com= "delete from Student_Marks_Table where Exam_Paper_Id= ?;";
			Connection conn= Database.getConnection();
			ps= conn.prepareStatement(com);
			ps.setInt(1, ep1.get(i).getExam_paper_id());
			ps.executeUpdate();
			Database.freeConnection(conn);
		}
	}
}