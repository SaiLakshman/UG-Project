package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class CourseDB
{
	/**
	 * This function insert into the Course table the data
	 * */
	public void insert(Course course)throws IOException, SQLException, ClassNotFoundException
	{
		PreparedStatement ps= null;
		String com= "insert into Course_Master_Table(Course_Name,Course_Title,Duration,Department_Id)values(?,?,?,?);";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(com);
		ps.setString(1,course.getCoursename());
		ps.setString(2,course.getCoursetitle());
		ps.setInt(3,course.getDuration());
		ps.setInt(4,course.getDepartmentid());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**
	 * This function captures all the data available in the database and returns it in ArrayList form
	 * */
	public  ArrayList<Course> select() throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Course> c1= new ArrayList<Course>();
		Course c= new Course();
		String query="select * from Course_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(query);	
		while(rs.next())
		{
			c.setCoursename(rs.getString("Course_Name"));
			c.setCoursetitle(rs.getString("Course_Title"));
			c.setCourseid(rs.getInt("Course_Id"));
			c.setDuration(rs.getInt("Duration"));
			c.setDepartmentid(rs.getInt("Department_Id"));
			c1.add(c);
			c= new Course();
		}
		Database.freeConnection(conn);
		return c1;
	}
	
	/**
	 * This function captures all the Id's of data to be deleted from the database
	 * */
	public  void delete(String courseId) throws IOException, SQLException, ClassNotFoundException
	{
		PreparedStatement ps= null;
		String query="delete from Course_Master_Table where Course_Id in("+courseId+");";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**
	 * This function will update all the data to be modified and returns a bean object
	 * */
	public Course update(Course c)throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String query="update Course_Master_Table set Course_Name= ?, Course_Title= ?, Duration= ?, Department_Id= ? where Course_Id= ?;";
		ps=conn.prepareStatement(query);
		ps.setString(1,c.getCoursename());
		ps.setString(2,c.getCoursetitle());
		ps.setInt(3,c.getDuration());
		ps.setInt(4,c.getDepartmentid());
		ps.setInt(5,c.getCourseid());
		ps.executeUpdate();
		Database.freeConnection(conn);
		return c;
	}
	
	/**
	 * This select the courses and department from Course table and Department table and returns ArrayList 
	 * */
	public  ArrayList<Course> selectbydept() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<Course>course= new ArrayList<Course>();
		 Course cour= new Course();
		 String query= "select Course_Id, a.Course_Name Course_Name,"
				       + "b.Department_Name Department_Name,"
				       + "a.Course_Title Course_Title ,a.Duration Duration,b.Department_Id Department_Id"
				       + " from Course_Master_Table a inner join Department_Master_Table b "
				       + " on a.Department_Id = b.Department_Id;" ;
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(query);	
		 while(rs.next())
		 {
			 cour.setCourseid(rs.getInt("Course_Id"));
			 cour.setCoursename(rs.getString("Course_Name"));
			 cour.setCoursetitle(rs.getString("Course_Title"));
			 cour.setDuration(rs.getInt(("Duration")));
			 cour.setDepartmentname(rs.getString("Department_Name"));
			 cour.setDepartmentid(rs.getInt("Department_Id"));
			 course.add(cour);
			 cour= new Course();
		}
		Database.freeConnection(conn);
		return course;
	}
	
	/**
	 * This function get the desired data in order to execute the modification
	 * */
	public Course modify(Course courseid)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		Course cour= new Course(); 
		String query="select * from Course_Master_Table where Course_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setInt(1,courseid.getCourseid());
		rs= ps.executeQuery();
		rs.next();
		cour.setCourseid(rs.getInt("Course_Id"));
		cour.setCoursename(rs.getString("Course_Name"));
		cour.setCoursetitle(rs.getString("Course_Title"));
		cour.setDuration(rs.getInt("Duration"));
		cour.setDepartmentid(rs.getInt("Department_Id"));
		Database.freeConnection(conn);
		return cour;
	}

	/**
	 * This function checks if data exists in the database and returns true if not 
	 * */
	public  boolean isexists(Course course,ArrayList<Course> e)
	{
		for(int i= 0;i< e.size();i++)
		{
			if (course.getCoursename().trim().equalsIgnoreCase(e.get(i).getCoursename().trim()))
					return false;
		}
		return true;
	}
}