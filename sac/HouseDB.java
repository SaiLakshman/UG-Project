package bca.batch2011.project1.sac;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import bca.batch2011.project1.ca.Course;
import bca.batch2011.project1.ca.Student;
public class HouseDB{
	/**
	 *  this function is to insert the data into house master table in the database//
	 * @throws SQLException 
	 */
	public void insert(HouseBean real) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		ResultSet rs= null;
		String query= "insert into House_Master_Table(House_Name)values(?);";
		Connection conn = Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1, real.getHouseName());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**
	 *  the function is to delete the data from house master table in the database//
	 */
	public void delete(String hid) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		String query1= "delete from House_Master_Table where House_Id in("+hid+");";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(query1);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
	 *  the function is to update the contents of the house master table in the database//
	 */
	public void update(HouseBean real) throws ClassNotFoundException, IOException, SQLException 
	{
		PreparedStatement ps=null;
		String query="update House_Master_Table set House_Name= ? where House_Id= ?;";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		ps=conn.prepareStatement(query);	
		ps.setString(1,real.getHouseName());
		ps.setInt(2,real.getHouseid());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**
	 *  this method is to modify the contents of the house master table in the database//
	 */
	public HouseBean modify(HouseBean real) throws ClassNotFoundException, IOException, SQLException
	{
		PreparedStatement ps= null;
		ResultSet rs= null;
		String query3= "select * from House_Master_Table where House_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query3);
		ps.setInt(1, real.getHouseid());
		rs= ps.executeQuery();
		rs.next();
        real.setHouseid(rs.getInt("House_Id"));
        real.setHouseName(rs.getString("House_Name"));
        Database.freeConnection(conn);
	    return real;
	}
	/**
	 * this method is to get the data from the database and captures these values
	 *  in ArrayList object of this class//
	 */
	public ArrayList<HouseBean> select() throws ClassNotFoundException, IOException, SQLException       
	{
		Statement ps = null;
		ResultSet rs= null;
		HouseBean house= new HouseBean();
		ArrayList<HouseBean> Housearray= new ArrayList<HouseBean>();
		String query3= "select * from House_Master_Table";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query3); 
	    rs= ps.executeQuery(query3);
	    while(rs.next())
		{
		   house.setHouseName(rs.getString("House_Name"));
		   house.setHouseid(rs.getInt("House_Id"));
		   Housearray.add(house);
		   house= new HouseBean();	
		}			
		Database.freeConnection(conn);
		return Housearray;
	}
	
	/**
	 * This method is to select details from Students tables
	 * */
	public ArrayList<Student> select1() throws ClassNotFoundException, IOException, SQLException       
	{
		PreparedStatement ps = null;
		ResultSet rs= null;
        Student student= new Student();  
		ArrayList<Student> studentarray= new ArrayList<Student>();
		String query= "select Student_Id, Name,Year_Num,Course_Id from Student_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement(); 
		rs= stmt.executeQuery(query);
		while(rs.next())
		{
		   student.setName(rs.getString("Name"));
		   student.setStudentId(rs.getInt("Student_Id"));
		   student.setCourse_Id(rs.getInt("Course_Id"));
		   student.setYearNum(rs.getInt("Year_Num"));
		   studentarray.add(student);
		   student= new Student();	
		}
		Database.freeConnection(conn);
		return studentarray;
	}
	
	/**
	 * This method is to select from Course tables
	 * */
	public ArrayList<Course> select2() throws ClassNotFoundException, IOException, SQLException       
	{
		PreparedStatement ps = null;
		ResultSet rs= null;
        Course course= new Course();  
		ArrayList<Course> coursearray= new ArrayList<Course>();
		String query= "select Course_Id,Course_Name,Duration from Course_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement(); 
	    rs= stmt.executeQuery(query);
		while(rs.next())
		{
		   course.setCourseid(rs.getInt("Course_Id"));
		   course.setCoursename(rs.getString("Course_Name"));
		   course.setDuration(rs.getInt("Duration"));
	       coursearray.add(course);
	       course= new Course();	
		}
		Database.freeConnection(conn);
		return coursearray;   
	}
}