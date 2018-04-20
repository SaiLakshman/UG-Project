package bca.batch2011.project1.ct;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaperCourseDB {
	/**This function is for getting details about course from Course_Master_Table*/
	public  ArrayList<Papers_Course> selectcourse() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<Papers_Course> e1= new ArrayList<Papers_Course>();
		 Papers_Course ev= new Papers_Course();
		 String com="select * from  Course_Master_Table";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(com);	
		 while(rs.next())
		 {
			 ev.setCourse_name(rs.getString("Course_Name"));
			 ev.setDuration(rs.getInt("Duration"));
			 ev.setCourse_id(rs.getInt("Course_Id"));
			 e1.add(ev);
			 ev= new Papers_Course();
		 }	
		 Database.freeConnection(conn);
		 return e1;
	}
	
	/**This function is for getting details about papers from Paper_Master_Table*/
	public  ArrayList<Papers_Course> selectpapers() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		 Papers_Course p2= new Papers_Course();
		 String com= "select * from  Paper_Master_Table";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(com);	
		 while(rs.next())
		 {
			 p2.setPaper_title(rs.getString("Paper_Title"));
			 p2.setPaper_id(rs.getInt("Paper_Id"));
			 p1.add(p2);
			 p2= new Papers_Course();
		}
		Database.freeConnection(conn);	
		return p1;
	}
	
	/**This function is for inserting details about papers and course in to Paper_Course_Table*/
	public void insertcoursepaper(String []papername,String []papercode, Papers_Course cou) throws SQLException,ClassNotFoundException, IOException
	{
		for(int i= 0;i < papername.length;i++)
		{
			papercode[i]= papercode[i].trim();
			if(papername[i] != null && papername[i] != "" && papercode[i] != "" && papercode[i] != null)
			{
				int a= Integer.parseInt(papername[i]);
				 PreparedStatement ps= null;
				 String com="insert into Paper_Course_Table(Paper_Id,Course_Id,Paper_Code,Year_Of_Joining,Year_Num,Semester)values(?,?,?,?,?,?);";
				 Connection conn= Database.getConnection();
				 ps=conn.prepareStatement(com);
				 ps.setInt(1,a);
				 ps.setInt(2,cou.getCourse_id());
				 ps.setString(3,papercode[i]);
				 ps.setInt(4,cou.getBatch());
				 ps.setInt(5,cou.getYear());
				 ps.setInt(6,cou.getSemester());
				 ps.executeUpdate();
				 Database.freeConnection(conn);
			}
		}
	}
	/**This function is for getting details about course which are present in Paper_Course_Table using Course_Master_Table*/
	public  ArrayList<Papers_Course> selectforpaperbatch() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		 Papers_Course c2= new Papers_Course();
		 String com= "select a.Course_Id,a.Year_Of_Joining,a.Year_Num,a.Semester,b.Duration from Paper_Course_Table a,Course_Master_Table b where a.Course_Id= b.Course_Id;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			c2.setCourse_id(rs.getInt("Course_Id"));
			c2.setBatch(rs.getInt("Year_Of_Joining"));
			c2.setYear(rs.getInt("Year_Num"));
			c2.setSemester(rs.getInt("Semester"));
			c2.setDuration(rs.getInt("Duration"));
			c1.add(c2);
			c2= new Papers_Course();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	
	/**This function is for getting distinct years for a particular course from Paper_Course_Table*/
	public  ArrayList<Papers_Course> selectyears(Papers_Course c) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		Papers_Course c2= new Papers_Course();
		String com= "select distinct Year_Of_Joining from Paper_Course_Table where Course_Id= ?";
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
	
	/**This function is for getting all the course details for a particular course and batch from Paper_Course_Table*/
	public  ArrayList<Papers_Course> selectforcopycourse(Papers_Course oc) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> c1= new ArrayList<Papers_Course>();
		 Papers_Course c2= new Papers_Course();
		 String com= "select * from Paper_Course_Table where Year_Of_Joining= ? and Course_Id= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,oc.getBatch());
		 ps.setInt(2,oc.getCourse_id());
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
			c2.setYear(rs.getInt("Year_Num"));
			c2.setSemester(rs.getInt("Semester"));
			c1.add(c2);
			c2= new Papers_Course();
		 }
		 Database.freeConnection(conn);
		 return c1;
	}
	/**This function is for getting all the paper details for a particular course and batch from Paper_Course_Table*/
	public  ArrayList<Papers_Course> selectforcopypaper(Papers_Course oc) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		 Papers_Course p2= new Papers_Course();
		 String com= "select * from Paper_Course_Table where Year_Of_Joining= ? and Course_Id= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
	 	 ps.setInt(1,oc.getBatch());
		 ps.setInt(2,oc.getCourse_id());
		 rs= ps.executeQuery();	
		 while(rs.next())
		 {
		 	 p2.setPaper_id(rs.getInt("Paper_Id"));
			 p2.setPaper_code(rs.getString("Paper_Code"));
			 p1.add(p2);
			 p2= new Papers_Course();
		 }
		 Database.freeConnection(conn);
		 return p1;
	}
	/**This function is for getting paper code,paper id and paper title of all the papers present in Paper_Course_Table using Paper_Id foreign key in Paper_Course_Table with primary key in Paper_Master_Table*/
	public  ArrayList<Papers_Course> selectforpapercodetitle() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 ArrayList<Papers_Course> p1= new ArrayList<Papers_Course>();
		 Papers_Course p2= new Papers_Course();
		 String com= "select a.Paper_Id,a.Paper_Code,b.Paper_Title from Paper_Course_Table a,Paper_Master_Table b where a.Paper_Id=b.Paper_Id;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
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
	
	/**This function is for checking the selected Course id and batch with data of Paper_Course_Table*/
	public boolean checkforpaperbatch(Papers_Course c1,ArrayList<Papers_Course> c2)
	{
		for(int i= 0;i< c2.size();i++)
		{
				if(c1.getCourse_id() == c2.get(i).getCourse_id())
					if(c1.getBatch() == c2.get(i).getBatch())
						return false;
		}
		return true;
	}
	/**This function is for deleting from Paper_Course_Table for a particular course id and batch*/
	public void deletecoursepaper(Papers_Course c) throws IOException, SQLException, ClassNotFoundException
	{
		PreparedStatement ps= null;
		String com= "delete from Paper_Course_Table where Course_Id = ? and Year_Of_Joining= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,c.getCourse_id());
		ps.setInt(2,c.getBatch());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**This function is for getting the duration of a particular course*/
	public  int duration(Papers_Course cou) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 PreparedStatement ps= null;
		 String com="select Course_Name,Duration from Course_Master_Table where Course_Id= ?;";
		 Connection conn= Database.getConnection();
		 ps= conn.prepareStatement(com);
		 ps.setInt(1,cou.getCourse_id());
		 rs= ps.executeQuery();
		 rs.next();
		 cou.setDuration(rs.getInt("Duration"));
		 cou.setCourse_name(rs.getString("Course_Name"));
		 Database.freeConnection(conn);
		 return cou.getDuration();
	}
	
	/**This function is for inserting the course papers details which ae copied from other batch*/
	public void addcopy(Papers_Course c,Papers_Course oc,ArrayList<Papers_Course> c1, ArrayList<Papers_Course> p1) throws SQLException,ClassNotFoundException, IOException
	{
		for(int i= 0;i < c1.size();i++)
		{
			PreparedStatement ps= null;
			String com="insert into Paper_Course_Table(Paper_Id,Course_Id,Paper_Code,Year_Of_Joining,Year_Num,Semester)values(?,?,?,?,?,?);";
			Connection conn= Database.getConnection();
			ps=conn.prepareStatement(com);
			ps.setInt(1,p1.get(i).getPaper_id());
			ps.setInt(2,oc.getCourse_id());
			ps.setString(3,p1.get(i).getPaper_code());
			ps.setInt(4,c.getBatch());
			ps.setInt(5,c1.get(i).getYear());
			ps.setInt(6,c1.get(i).getSemester());
			ps.executeUpdate();
			Database.freeConnection(conn);
		}
	}
}