package bca.batch2011.project1.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentDB 
{
	/**
	 * This function insert the data in the database
	 * */
	public void insert(DepartmentBean dept1)throws SQLException,ClassNotFoundException, IOException
	{
		PreparedStatement ps=null;
		String query="insert into Department_Master_Table(Department_Name,Department_Title)values(?,?);";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		ps=conn.prepareStatement(query);
		ps.setString(1,dept1.getDepartmentname());
		ps.setString(2,dept1.getDepartmenttitle());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**
	 * Deletion of data is done through this function
	 * */
	public  void delete(String id) throws SQLException,ClassNotFoundException, IOException
	{
		 Statement ps=null;
		 String query= "delete from Department_Master_Table where Department_Id in("+id+");";
		 Connection conn= Database.getConnection();
		 ps= conn.createStatement();
		 ps.executeUpdate(query);
		 Database.freeConnection(conn);
	}
	
	/**
	 * This function selects data from database and returns ArrayList
	 * */
	public  ArrayList<DepartmentBean> select() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<DepartmentBean>dept2= new ArrayList<DepartmentBean>();
		 DepartmentBean dept1= new DepartmentBean();
		 String query="select * from Department_Master_Table";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(query);	
		 while(rs.next())
		 {
			 dept1.setDepartmentid(rs.getInt(("Department_Id")));
			 dept1.setDepartmentname(rs.getString("Department_Name"));
			 dept1.setDepartmenttitle(rs.getString("Department_Title"));
			 dept2.add(dept1);
			 dept1= new DepartmentBean();
		}
		Database.freeConnection(conn);
		return dept2;
	}
	
	/**
	 * This function selects from the database the desired tuple to be changed or modified
	 * */
	public DepartmentBean modify(DepartmentBean dept1) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs=null;
		PreparedStatement ps= null;
		String query= "select  * from Department_Master_Table where Department_Id= ?;";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		ps= conn.prepareStatement(query);
		ps.setInt(1, dept1.getDepartmentid());
		rs= ps.executeQuery();
		rs.next();
		dept1.setDepartmentid(rs.getInt(("Department_Id")));
		dept1.setDepartmentname(rs.getString("Department_Name"));
		dept1.setDepartmenttitle(rs.getString("Department_Title"));
		Database.freeConnection(conn);
		return dept1;
	}
	
	/**
	 * This function sets the new entry in the database
	 * */
	public void update(DepartmentBean dept1)throws SQLException,ClassNotFoundException, IOException
	{
		 PreparedStatement ps=null;
		 String query=" update Department_Master_Table set Department_Name=?,Department_Title= ? where Department_Id= ?;";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 ps=conn.prepareStatement(query);
		 ps.setString(1,dept1.getDepartmentname());
		 ps.setString(2,dept1.getDepartmenttitle());
		 ps.setInt(3,dept1.getDepartmentid());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	
	/**
	 * This function check if the data already exists in the database 
	 * */
	public boolean isexists(DepartmentBean dept1,ArrayList<DepartmentBean>dept2)throws SQLException,ClassNotFoundException
	{
		for(int i= 0;i< dept2.size();i++)
	   	{
	   		if(dept1.getDepartmentname().trim().equalsIgnoreCase(dept2.get(i).getDepartmentname().trim()))
	   			if(dept1.getDepartmenttitle().trim().equalsIgnoreCase(dept2.get(i).getDepartmenttitle().trim()))
	   			    return false;
	   	}
    	return true;
     }
	 
	/**
	 * This function selects the Department_Id from the Department table and it returns integer
	 * */
	 public int getid(DepartmentBean dept1) throws SQLException,ClassNotFoundException, IOException
	 {
	 	ResultSet rs=null;
	 	PreparedStatement ps= null;
		String query= "select Department_Id from Department_Master_Table where Department_Name= ?;";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		ps= conn.prepareStatement(query);
		ps.setString(1, dept1.getDepartmentname());
		rs= ps.executeQuery();
		rs.next();
		dept1.setDepartmentid(rs.getInt(("Department_Id")));
		Database.freeConnection(conn);
		return dept1.getDepartmentid();
	}
}