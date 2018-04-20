package bca.batch2011.project1.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PaperDB 
{
	/**
	 * This function insert into the Paper table
	 * */
	public void insert(PaperBean paper)throws SQLException,ClassNotFoundException, IOException
	{
		 PreparedStatement ps=null;
		 String query="insert into Paper_Master_Table(Paper_Title)values(?);";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 ps=conn.prepareStatement(query);
		 ps.setString(1,paper.getPapertitle());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	
	/**
	 * Deletion is done by getting all the Id's in a string array format
	 * */
	public  void delete(String id) throws SQLException,ClassNotFoundException, IOException
	{
		 Statement ps=null;
		 String query="delete from Paper_Master_Table where Paper_Id in("+id+");";
		 Connection conn= Database.getConnection();
		 ps=conn.createStatement();
		 ps.executeUpdate(query);
		 Database.freeConnection(conn);
	}

	/**
	 * This function selects data from the database returns ArrayList 
	 * */
	public  ArrayList<PaperBean> select() throws SQLException,ClassNotFoundException, IOException
	{
		 ResultSet rs=null;
		 ArrayList<PaperBean>paper2= new ArrayList<PaperBean>();
		 PaperBean paper1= new PaperBean();
		 String query="select * from Paper_Master_Table";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(query);	
		 while(rs.next())
		 {
			paper1.setPaperid(rs.getInt(("Paper_Id")));
			paper1.setPapertitle(rs.getString("Paper_Title"));
			paper2.add(paper1);
			paper1= new PaperBean();
		 }
		 Database.freeConnection(conn);
		 return paper2;
	}
	
	/**
	 * For modification it select the particular tuple from database depending on the Id 
	 * */
	public PaperBean modify(PaperBean paper1) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs=null;
		PreparedStatement ps= null;
		String query= "select  * from Paper_Master_Table where Paper_Id= ?;";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		ps= conn.prepareStatement(query);
		ps.setInt(1, paper1.getPaperid());
		rs= ps.executeQuery();
		rs.next();
		paper1.setPaperid(rs.getInt(("Paper_Id")));
		paper1.setPapertitle(rs.getString("Paper_Title"));
		Database.freeConnection(conn);
		return paper1;
	}
	
	/**
	 * This function updates the data in the database
	 * */
	public void update(PaperBean paper1)throws SQLException,ClassNotFoundException, IOException
	{
		 PreparedStatement ps=null;
		 String query=" update Paper_Master_Table set Paper_Title= ? where Paper_Id= ?;";
		 Connection conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 ps=conn.prepareStatement(query);
		 ps.setString(1,paper1.getPapertitle());
		 ps.setInt(2,paper1.getPaperid());
		 ps.executeUpdate();
		 Database.freeConnection(conn);
	}
	
	/**
	 * This checks the existing database before entering
	 * */
	public boolean isexists(PaperBean paper1,ArrayList<PaperBean>paper2)throws SQLException,ClassNotFoundException
	{
	  	for(int i= 0;i< paper2.size();i++)
	   	{
	   		if(paper1.getPapertitle().trim().equalsIgnoreCase(paper2.get(i).getPapertitle().trim()))
	   			return false;
	   	}
	  	return true;	
    }
}