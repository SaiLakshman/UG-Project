package bca.batch2011.project1.ct;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bca.batch2011.project1.ca.TeacherBean;

public class PaperTeacherDB {
	/**This function is for getting details of Course_Id,batch and Semester from Paper_Teacher_Table*/
	public  ArrayList<Papers_Course> selectforteachercourse() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		 Papers_Course c2= new Papers_Course();
		 String com= "select Course_Id,Year_Of_Joining,Semester from Paper_Teacher_Table;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 c2.setCourse_id(rs.getInt("Course_Id"));
			 c2.setBatch(rs.getInt("Year_Of_Joining"));
			 c2.setSemester(rs.getInt("Semester"));
			 c1.add(c2);
			 c2= new Papers_Course();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	
	/**This function is for getting all the details about teacher who are present in Paper_Teacher_Table*/
	public  ArrayList<TeacherBean> selectforteacher() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<TeacherBean> t1= new ArrayList<TeacherBean>();
		 TeacherBean t2= new TeacherBean();
		 String com= "select a.Teacher_Id,b.Teacher_Name from Paper_Teacher_Table a,Teacher_Master_Table b where a.Teacher_Id=b.Teacher_Id;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 t2.setTeacherid(rs.getInt("Teacher_Id"));
			 t2.setTeachername(rs.getString("Teacher_Name"));
			 t1.add(t2);
			 t2= new TeacherBean();
		 }
		 Database.freeConnection(conn);		
		 return t1;
	}
	
	/**This function is for getting all the teacher information from T_M_T*/
	public  ArrayList<TeacherBean> selectteachers() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<TeacherBean> t1= new ArrayList<TeacherBean>();
		 TeacherBean t2= new TeacherBean();
		 String com= "select * from  Teacher_Master_Table";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(com);
		 while(rs.next())
		 {
			 t2.setTeachername(rs.getString("Teacher_Name"));
			 t2.setTeacherid(rs.getInt("Teacher_Id"));
			 t1.add(t2);
			 t2= new TeacherBean();
		 }
		 Database.freeConnection(conn);
		 return t1;
	}
	/**This function is for getting Paper_Id,paper_Code and Paper_Title for a particular course,batch,year and semester from Paper_Course_Table and P_M_T*/
	public  ArrayList<Papers_Course> selectpaperidnaco(Papers_Course c) throws SQLException,ClassNotFoundException,IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		 Papers_Course p2= new Papers_Course();
		 String com= "select a.Paper_Id,a.Paper_Code,b.Paper_Title from  Paper_Course_Table a,Paper_Master_Table b where a.Paper_Id= b.Paper_Id and a.Year_Of_Joining= ? and a.Course_Id= ? and a.Semester= ? and a.Year_Num= ?";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1, c.getBatch());
		 ps.setInt(2, c.getCourse_id());
		 ps.setInt(3, c.getSemester());
		 ps.setInt(4, c.getYear());
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			p2.setPaper_code(rs.getString("Paper_Code"));
			p2.setPaper_title(rs.getString("Paper_Title"));
			p2.setPaper_id(rs.getInt("Paper_Id"));
			p1.add(p2);
			p2= new Papers_Course();
		 }
		 Database.freeConnection(conn);	
		 return p1;
	}
	
	/**This function is for deleting details of a particular course,batch from Paper_Teacher_Table*/
	public void deleteteacherpaper(Papers_Course c) throws IOException,SQLException,ClassNotFoundException
	{
		 PreparedStatement ps= null;
		 String com= "delete from Paper_Teacher_Table where Course_Id = ? and Year_Of_Joining= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,c.getCourse_id());
		 ps.setInt(2,c.getBatch());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	/**This function is for inserting paper_Id,Teacher_Id,batch,year,semester and course_Id into Paper_Teacher_Table*/
	public void insertteacherpaper(String []teacherid,ArrayList<Papers_Course> papers,Papers_Course cou) throws SQLException,ClassNotFoundException, IOException
	{
		for(int i= 0;i < teacherid.length;i++)
		{
			if(teacherid[i] != null && teacherid[i] != "" )
			{
				int a= Integer.parseInt(teacherid[i]);
				 PreparedStatement ps= null;
				 String com="insert into Paper_Teacher_Table(Paper_Id,Teacher_Id,Year_Of_Joining,Year,Semester,Course_Id)values(?,?,?,?,?,?);";
				 Connection conn= Database.getConnection();
				 ps= conn.prepareStatement(com);
				 ps.setInt(1,papers.get(i).getPaper_id());
				 ps.setInt(2,a);
				 ps.setInt(3,cou.getBatch());
				 ps.setInt(4,cou.getYear());
				 ps.setInt(5,cou.getSemester());
				 ps.setInt(6,cou.getCourse_id());
				 ps.executeUpdate();
				 Database.freeConnection(conn);
			}
		}
	}
	
	/**This function is for getting distinct Paper_Id,paper_Code and Paper_Title for a particular course,batch,year and semester from Paper_Course_Table and P_M_T*/
	public  ArrayList<Papers_Course> selectforpapercodetitleteacher(Papers_Course c) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		 Papers_Course p2= new Papers_Course();
		 String com= " select distinct a.Paper_Id,b.Paper_Code,c.Paper_Title from Paper_Teacher_Table a,Paper_Master_Table c,Paper_Course_Table b where a.Paper_Id=b.Paper_Id and a.Paper_Id= c.Paper_Id and b.Paper_Id=c.Paper_Id and b.Course_Id= ? and b.Year_Of_Joining= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1, c.getCourse_id());
		 ps.setInt(2, c.getBatch());
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
	
	/**This function is for getting all details for a particular course,batch,year,semester from P_T_T and C_M_T*/
	public  ArrayList<Papers_Course> selectforpaperbatchteachercourse(Papers_Course c) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		 Papers_Course c2= new Papers_Course();
		 String com= "select a.Course_Id,a.Year_Of_Joining,a.Year,a.Semester,b.Duration from Paper_Teacher_Table a,Course_Master_Table b where a.Course_Id= b.Course_Id and a.Course_Id= ? and a.Year_Of_Joining= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1, c.getCourse_id());
		 ps.setInt(2, c.getBatch());
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
	/**This function is for getting all the teachers who are Present in P_T_T and their information from T_M_T*/
	public  ArrayList<TeacherBean> selectforteacherpapercourse(Papers_Course c) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<TeacherBean> t1= new ArrayList<TeacherBean>();
		 TeacherBean t2= new TeacherBean();
		 String com= "select a.*,b.Teacher_Name from Paper_Teacher_Table a,Teacher_Master_Table b where a.Teacher_Id=b.Teacher_Id and a.Course_Id= ? and a.Year_Of_Joining= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1, c.getCourse_id());
		 ps.setInt(2,c.getBatch());
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			 t2.setTeacherid(rs.getInt("Teacher_Id"));
			 t2.setTeachername(rs.getString("Teacher_Name"));
			 t1.add(t2);
			 t2= new TeacherBean();
		 }
		 Database.freeConnection(conn);
		 return t1;
	}
	/**This function is for getting distinct years from P_T_T for a particular course id*/
	public  ArrayList<Papers_Course> selectteacherpaperyears(Papers_Course c) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		 Papers_Course c2= new Papers_Course();
		 String com= "select distinct Year_Of_Joining from Paper_Teacher_Table where Course_Id= ?";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,c.getCourse_id());
		 rs= ps.executeQuery();
		 while(rs.next())
		 {
			c2.setBatch(rs.getInt("Year_Of_Joining"));
			c1.add(c2);
			c2= new Papers_Course();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	/**This function is for getting Teacher_Id's from P_T_T for a particular batch and course_Id*/
	public  ArrayList<TeacherBean> selectforcopyteacher(Papers_Course oc) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<TeacherBean> t1= new ArrayList<TeacherBean>();
		 TeacherBean t2= new TeacherBean();
		 String com= "select * from Paper_Teacher_Table where Year_Of_Joining= ? and Course_Id= ?;";
		 try
		{
				Connection conn= Database.getConnection();
				ps= conn.prepareStatement(com);
				ps.setInt(1,oc.getBatch());
				ps.setInt(2,oc.getCourse_id());
				rs= ps.executeQuery();	
				while(rs.next())
				{
					t2.setTeacherid(rs.getInt("Teacher_Id"));
					t1.add(t2);
					t2= new TeacherBean();
				}
		}
		catch(SQLException e)
		{
				e.printStackTrace();
		} 
		catch (ClassNotFoundException e)
		{
				e.printStackTrace();
		}
		 return t1;
	}
	/**This function is for inserting the copied data of particular year from P_T_T to the selected year */
	public void addcopyteacher(Papers_Course c,Papers_Course oc,ArrayList<Papers_Course> c1, ArrayList<Papers_Course> p1,ArrayList<TeacherBean> t) throws SQLException,ClassNotFoundException, IOException
	{
		for(int i= 0;i < c1.size();i++)
		{
			PreparedStatement ps= null;
			String com="insert into Paper_Teacher_Table(Paper_Id,Teacher_Id,Year_Of_Joining,Year,Semester,Course_Id)values(?,?,?,?,?,?);";
			Connection conn= Database.getConnection();
			ps=conn.prepareStatement(com);
			ps.setInt(1,p1.get(i).getPaper_id());
			ps.setInt(2,t.get(i).getTeacherid());
			ps.setInt(3,c.getBatch());
			ps.setInt(4,c1.get(i).getYear());
			ps.setInt(5,c1.get(i).getSemester());
			ps.setInt(6,oc.getCourse_id());
			ps.executeUpdate();
			Database.freeConnection(conn);
		}
	}
}