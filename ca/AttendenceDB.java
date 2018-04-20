package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class AttendenceDB 
{
	/**
	 * This function will insert the data into Attendance_Event_Master_Table
	 * */
	public void insert(Event eve) throws SQLException,ClassNotFoundException, IOException
	{
		PreparedStatement ps=null;
		String com="insert into Attendance_Event_Master_Table(Event_Name)values(?);";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setString(1,eve.getEvent_name());
		ps.executeUpdate();
	}
	
	/**
	 * This function updates the database
	 * */
	public void modify(Event evemodify) throws SQLException,ClassNotFoundException, IOException
	{
		PreparedStatement ps=null;
		String com="update Attendance_Event_Master_Table set Event_Name= ? where Event_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setString(1,evemodify.getEvent_name());
		ps.setInt(2,evemodify.getEvent_id());
		ps.executeUpdate();
	}
	
	/**
	 * This function checks whether there is any duplicate entry
	 * */
	public boolean check(Event ev,ArrayList<Event> eve)
	{
		for(int i= 0;i< eve.size();i++)
		{
			if(ev.getEvent_name().trim().equalsIgnoreCase(eve.get(i).getEvent_name().trim()))
				return false;
		}
		return true;
	}
	
	/**
	 * This function retrives the data from database depending on the Id
	 * */
	public  Event isid(String id) throws SQLException,ClassNotFoundException, IOException
	{
		Event ev=new Event();
		PreparedStatement ps=null;
		ResultSet rs= null;
		String com="select * from Attendance_Event_Master_Table where Event_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setString(1,id);
		rs= ps.executeQuery();
		while(rs.next())
		{
			ev.setEvent_name(rs.getString("Event_Name"));
			ev.setEvent_id(rs.getInt("Event_Id"));
		}
		return ev;
	}
	
	/**
	 * This function retrives from the database and return ArrayList
	 * */
	public  ArrayList<Event> select() throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs=null;
		ArrayList<Event> e1= new ArrayList<Event>();
		Event ev= new Event();
		String com="select * from Attendance_Event_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(com);	
		while(rs.next())
		{
			ev.setEvent_name(rs.getString("Event_Name"));
			ev.setEvent_id(rs.getInt("Event_Id"));
			e1.add(ev);
			ev= new Event();
		}
		return e1;
	}
	
	/**
	 * This function captures all the Id's in string and deletes it from the database
	 * */
	public  void delete(String di) throws SQLException,ClassNotFoundException, IOException
	{
		Statement ps=null;
		String com="delete from Attendance_Event_Master_Table where Event_Id in("+di+");";
		Connection conn= Database.getConnection();
		ps=conn.createStatement();
		ps.executeUpdate(com);
	}
}