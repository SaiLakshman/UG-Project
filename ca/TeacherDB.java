package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

public class TeacherDB
{
	/**
	 * This function will insert data into the database
	 * */
	public void insert(TeacherBean teach)throws SQLException,ClassNotFoundException, IOException
	{
		 DepartmentBean dept= new DepartmentBean();
		 PreparedStatement ps=null;
		 String query="insert into Teacher_Master_Table(Teacher_Name,Qualification,Position,Department_Id)values(?,?,?,?);";
		 Connection conn= Database.getConnection();
		 Statement stmt = conn.createStatement();
		 ps=conn.prepareStatement(query);
		 ps.setString(1,teach.getTeachername());
		 ps.setString(2,teach.getQualification());
		 ps.setString(3,teach.getPosition());
		 ps.setInt(4,teach.getDepartmentid());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	
	/**
	 * Deleting a Teacher from the database using his Id
	 * */
	public  void delete(String id) throws SQLException,ClassNotFoundException, IOException
	{
		 Statement ps=null;
		 String query= "delete from Teacher_Master_Table where Teacher_Id in("+id+");";
		 Connection conn= Database.getConnection();
		 ps= conn.createStatement();
		 ps.executeUpdate(query);
		 Database.freeConnection(conn);
	}
	
	/**
	 * This returns the ArrayList and selects all the data which exists in the database
	 * */
	public  ArrayList<TeacherBean> select() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs= null;
		 ArrayList<TeacherBean>teacher= new ArrayList<TeacherBean>();
		 TeacherBean teach= new TeacherBean();
		 DepartmentBean dept= new DepartmentBean();
		 String query="select * from Teacher_Master_Table";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(query);	
		 while(rs.next())
		 {
			teach.setTeacherid(rs.getInt(("Teacher_Id")));
			teach.setTeachername(rs.getString("Teacher_Name"));
			teach.setQualification(rs.getString("Qualification"));
			teach.setPosition(rs.getString("Position"));
			teach.setDepartmentid(rs.getInt("Department_Id"));
			teacher.add(teach);
			teach= new TeacherBean();
		}
		Database.freeConnection(conn);
		return teacher;
	}
	
	/**
	 * This function will select the particular tuple from database to modify
	 * */
	public TeacherBean modify(TeacherBean teach) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs=null;
		PreparedStatement ps= null;
		String query= "select  * from Teacher_Master_Table where Teacher_Id= ?;";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		ps= conn.prepareStatement(query);
		ps.setInt(1, teach.getTeacherid());
		rs= ps.executeQuery();
		rs.next();
		teach.setTeacherid(rs.getInt(("Teacher_Id")));
		teach.setTeachername(rs.getString("Teacher_Name"));
		teach.setQualification(rs.getString("Qualification"));
		teach.setPosition(rs.getString("Position"));
		teach.setDepartmentid(rs.getInt("Department_Id"));
		Database.freeConnection(conn);
		return teach;
	}
	
	/**
	 * This function will set the new data in the database to that particular tuple
	 * */
	public void update(TeacherBean teach)throws SQLException,ClassNotFoundException, IOException
	{
		 PreparedStatement ps=null;
		 String query="update Teacher_Master_Table set Teacher_Name= ?,Qualification=? ,Position= ?,Department_Id= ? where Teacher_Id= ?;";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 ps=conn.prepareStatement(query);
		 ps.setString(1,teach.getTeachername());
		 ps.setString(2,teach.getQualification());
		 ps.setString(3,teach.getPosition());
		 ps.setInt(4,teach.getDepartmentid());
		 ps.setInt(5,teach.getTeacherid());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	
	/**
	 * This function will check if the data exists in the database and returns the boolean value
	 * */
    public boolean isexists(TeacherBean teach,ArrayList<TeacherBean>teacher)throws SQLException,ClassNotFoundException
    {
    	for(int i= 0;i< teacher.size();i++)
    	{
    		if(teach.getTeachername().trim().equalsIgnoreCase(teacher.get(i).getTeachername().trim()))
    			if(teach.getQualification().trim().equalsIgnoreCase(teacher.get(i).getQualification().trim()))
    				if(teach.getPosition().trim().equalsIgnoreCase(teacher.get(i).getPosition().trim()))
    						return false;
    	}
    	return true;
    	
    }
    
    /**
     * This function selects the department name from Department table and all other details from Teacher table 
     * */
    public  ArrayList<TeacherBean> selectbydept( PrintWriter out) throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<TeacherBean>teacher= new ArrayList<TeacherBean>();
		 TeacherBean teach= new TeacherBean();
		 String query= "select Teacher_Id, a.Teacher_Name Teacher_Name,"
			       + "b.Department_Name Department_Name,"
			       + "a.Qualification Qualification,a.Position Position,b.Department_Id Department_Id"
			       + " from Teacher_Master_Table a inner join Department_Master_Table b "
			       + "on a.Department_Id = b.Department_Id;" ;
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(query);	
		 while(rs.next())
		 {
			teach.setTeacherid(rs.getInt("Teacher_Id"));
			teach.setTeachername(rs.getString("Teacher_Name"));
			teach.setQualification(rs.getString("Qualification"));
			teach.setPosition(rs.getString("Position"));
			teach.setDepartmentname(rs.getString("Department_Name"));
			teach.setDepartmentid(rs.getInt("Department_Id"));
			teacher.add(teach);
			teach= new TeacherBean();
		 }	
		 Database.freeConnection(conn);
		 return teacher;
	}
}