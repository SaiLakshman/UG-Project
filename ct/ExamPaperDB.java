package bca.batch2011.project1.ct;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExamPaperDB {
	/**This function is for getting details about course from Course_Master_Table and Exam_Paper_Table using primary key of C_M_T and foreign key in E_P_T*/
	public  ArrayList<Papers_Course> selectforexambatchcourse() throws SQLException,ClassNotFoundException,IOException	
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		Papers_Course c2= new Papers_Course();
		String com= "select a.Course_Id,a.Year_Of_Joining,a.Year,a.Semester,b.Duration from Exam_Paper_Table a,Course_Master_Table b where a.Course_Id= b.Course_Id;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		rs= ps.executeQuery();	
		while(rs.next())
		{
			c2.setCourse_id(rs.getInt("Course_Id"));
			c2.setBatch(rs.getInt("Year_Of_Joining"));
			c2.setYear(rs.getInt("Year"));
			c2.setSemester(rs.getInt("Semester"));
			c2.setDuration(rs.getInt("Duration"));
			c1.add(c2);
			c2= new Papers_Course();
		}	
		Database.freeConnection(conn);
		return c1;
	}
	
	/**This function is for getting details about Exams for a particular course,batch,year,semester from Exam_Master_Table and Exam_Paper_Table using primary key of E_M_T and foreign key in E_P_T */
	public  ArrayList<ExamPaper> selectexamdetails(Papers_Course c) throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<ExamPaper> c1= new ArrayList<ExamPaper>();
		ExamPaper c2= new ExamPaper();
		String com= "select a.Exam_Paper_Id,a.Exam_Id,a.Total_Marks,b.Exam_Code,b.Exam_Title from Exam_Paper_Table a,Exam_Master_Table b where a.Exam_Id= b.Exam_Id and a.Course_Id= ? and a.Year_Of_Joining= ? and a.Year= ? and a.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,c.getCourse_id());
		ps.setInt(2,c.getBatch());
		ps.setInt(3,c.getYear());
		ps.setInt(4,c.getSemester());
		rs= ps.executeQuery();	
		while(rs.next())
		{
			c2.setExam_id(rs.getInt("Exam_Id"));
			c2.setExam_paper_id(rs.getInt("Exam_Paper_Id"));
			c2.setMarks(rs.getInt("Total_Marks"));
			c2.setExam_code(rs.getString("Exam_Code"));
			c2.setExam_title(rs.getString("Exam_Title"));
			c1.add(c2);
			c2= new ExamPaper();
		}	
		Database.freeConnection(conn);
		return c1;
	}
	
	/**This function is for getting all exam details from Exam_Master_Table*/
	public  ArrayList<ExamPaper> selectallexams() throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<ExamPaper> c1= new ArrayList<ExamPaper>();
		ExamPaper c2= new ExamPaper();
		String com= "select Exam_Id,Exam_Code,Exam_Title from Exam_Master_Table";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		rs= ps.executeQuery();	
		while(rs.next())
		{
			c2.setExam_id(rs.getInt("Exam_Id"));
			c2.setExam_code(rs.getString("Exam_Code"));
			c2.setExam_title(rs.getString("Exam_Title"));
			c1.add(c2);
			c2= new ExamPaper();
		}	
		Database.freeConnection(conn);
		return c1;
	}
	
	/**This is for getting Exam_Paper_Id,Exam_Id and marks for a particular course,batch,year,semester from E_M_T and E_P_T*/
	public  ArrayList<ExamPaper> selecteidsfromexpaper(Papers_Course c) throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<ExamPaper> c1= new ArrayList<ExamPaper>();
		ExamPaper c2= new ExamPaper();
		String com= "select a.Exam_Paper_Id,a.Exam_Id,a.Total_Marks,b.Exam_Code,b.Exam_Title,a.Paper_Id from Exam_Paper_Table a,Exam_Master_Table b where a.Exam_Id= b.Exam_Id and a.Course_Id= ? and a.Year_Of_Joining= ? and a.Year= ? and a.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,c.getCourse_id());
		ps.setInt(2,c.getBatch());
		ps.setInt(3,c.getYear());
		ps.setInt(4,c.getSemester());
		rs= ps.executeQuery();	
		while(rs.next())
		{
			c2.setExam_id(rs.getInt("Exam_Id"));
			c2.setExam_paper_id(rs.getInt("Exam_Paper_Id"));
			c2.setMarks(rs.getInt("Total_Marks"));
			c1.add(c2);
			c2= new ExamPaper();
		}	
		Database.freeConnection(conn);
		return c1;
	}
	
	/**This is for getting details of distinct paper code,paper id and paper title for a particular course,batch,year,semester from P_M_T and E_P_T,P_C_T*/
	public  ArrayList<Papers_Course> selectPaperBean(Papers_Course c) throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		Papers_Course p2= new Papers_Course();
		String com= "select distinct a.Paper_Id,b.Paper_Code,c.Paper_Title from Exam_Paper_Table a,Paper_Course_Table b,Paper_Master_Table c where a.Paper_Id=b.Paper_Id and a.Paper_Id= c.Paper_Id and a.Course_Id= ? and a.Year_Of_Joining= ? and a.Year= ? and a.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,c.getCourse_id());
		ps.setInt(2,c.getBatch());
		ps.setInt(3,c.getYear());
		ps.setInt(4,c.getSemester());
		rs= ps.executeQuery();	
		while(rs.next())
		{
			p2.setPaper_code(rs.getString("Paper_Code"));
			p2.setPaper_id(rs.getInt("Paper_Id"));
			p2.setPaper_title(rs.getString("Paper_Title"));
			p1.add(p2);
			p2= new Papers_Course();
		}	
		Database.freeConnection(conn);
		return p1;
	}
	
	/**This is for getting all details of paper code,paperid and paper title for a particular course,batch,year,semester from P_M_T and E_P_T,Paper_Course_Table*/
	public  ArrayList<Papers_Course> selectPaperBeanfromcoursetable(Papers_Course c) throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		Papers_Course p2= new Papers_Course();
		String com= "select a.Paper_Id,a.Paper_Code,b.Paper_Title from Paper_Course_Table a,Paper_Master_Table b where a.Paper_Id=b.Paper_Id  and a.Course_Id= ? and a.Year_Of_Joining= ? and a.Year_Num= ? and a.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,c.getCourse_id());
		ps.setInt(2,c.getBatch());
		ps.setInt(3,c.getYear());
		ps.setInt(4,c.getSemester());
		rs= ps.executeQuery();	
		while(rs.next())
		{
			p2.setPaper_code(rs.getString("Paper_Code"));
			p2.setPaper_id(rs.getInt("Paper_Id"));
			p2.setPaper_title(rs.getString("Paper_Title"));
			p1.add(p2);
			p2= new Papers_Course();
		}	
		Database.freeConnection(conn);
		return p1;
	}
	
	/**This is for getting paper_Id for a particular course,batch,year,semester from E_M_T and E_P_T*/
	public  ArrayList<Papers_Course> selectpid(Papers_Course c) throws SQLException,ClassNotFoundException,IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		Papers_Course p2= new Papers_Course();
		String com= "select a.Exam_Paper_Id,a.Exam_Id,a.Total_Marks,b.Exam_Code,b.Exam_Title,a.Paper_Id from Exam_Paper_Table a,Exam_Master_Table b where a.Exam_Id= b.Exam_Id and a.Course_Id= ? and a.Year_Of_Joining= ? and a.Year= ? and a.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,c.getCourse_id());
		ps.setInt(2,c.getBatch());
		ps.setInt(3,c.getYear());
		ps.setInt(4,c.getSemester());
		rs= ps.executeQuery();	
		while(rs.next())
		{
			p2.setPaper_id(rs.getInt("Paper_Id"));
			p1.add(p2);
			p2= new Papers_Course();
		}	
		Database.freeConnection(conn);
		return p1;
	}
	
	/**This is for inserting exam details of a particular paper into Exam_Paper_Table*/
	public void insertexampaper(String[] pid1, String[] pcode, Papers_Course c,int pap)  throws SQLException,ClassNotFoundException,IOException
	{
		for(int i= 0;i < pid1.length;i++)
		{
			pcode[i]= pcode[i].trim();
			if(pid1[i] != null && pid1[i] != "" && pcode[i] != "" && pcode[i] != null)
			{
				int a= Integer.parseInt(pid1[i]);
				int b= Integer.parseInt(pcode[i]);
				PreparedStatement ps= null;
				String com="insert into Exam_Paper_Table(Exam_Id,Course_Id,Paper_Id,Total_Marks,Year_Of_Joining,Year,Semester)values(?,?,?,?,?,?,?);";
				Connection conn= Database.getConnection();
				ps=conn.prepareStatement(com);
				ps.setInt(1,a);
				ps.setInt(2,c.getCourse_id());
				ps.setInt(3,pap);
				ps.setInt(4,b);
				ps.setInt(5,c.getBatch());
				ps.setInt(6,c.getYear());
				ps.setInt(7,c.getSemester());
				ps.executeUpdate();
				Database.freeConnection(conn);
			}	
		}
	}
	
	/**This is for checking weather syllabus of a particular course,batch,year and semester is present in Paper_Course_Table or not*/
	public boolean checkforpaperbatch(Papers_Course c1,ArrayList<Papers_Course> c2)
	{
		for(int i= 0;i< c2.size();i++)
		{
				if(c1.getCourse_id() == c2.get(i).getCourse_id())
					if(c1.getBatch() == c2.get(i).getBatch())
						if(c1.getYear() == c2.get(i).getYear())
							if(c1.getSemester() == c2.get(i).getSemester())
								return false;
		}
		return true;
	}
	
	/**This is for deleting details of exams from Exam_Paper_Table for a particular course,batch,year,semester*/
	public void delete(Papers_Course c)  throws SQLException,ClassNotFoundException,IOException
	{
		 PreparedStatement ps= null;
		 String com= "delete from Exam_Paper_Table where Course_Id = ? and Year_Of_Joining= ? and Year= ? and Semester= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,c.getCourse_id());
		 ps.setInt(2,c.getBatch());
		 ps.setInt(3,c.getYear());
		 ps.setInt(4,c.getSemester());
		 ps.executeUpdate();	
		 Database.freeConnection(conn);
	}
}