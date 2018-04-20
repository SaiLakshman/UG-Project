package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class HolidayDB 
{
	/**
	 * This funtion insert into the database the data
	 * */
	public void inserthol(Holiday h) throws SQLException,ClassNotFoundException, IOException
	{
		PreparedStatement ps=null;
		String com=" insert into Holiday_Master_Table(Event_Id,From_Date,To_Date,Reason) values(?,?,?,?)";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,h.getEvent_id());
		ps.setString(2,h.getStarting());
		ps.setString(3,h.getEnding());
		ps.setString(4,h.getReason());
		ps.executeUpdate();
	}
	
	/**
	 * This function selects from Attendance table depending on the Id
	 * */
	public String isid(int id) throws SQLException,ClassNotFoundException, IOException
	{
		Event ev= new Event();
		PreparedStatement ps= null;
		ResultSet rs= null;
		String com="select * from Attendance_Event_Master_Table where Event_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,id);
		rs= ps.executeQuery();
		while(rs.next())
		{
			ev.setEvent_name(rs.getString("Event_Name"));
			ev.setEvent_id(rs.getInt("Event_Id"));
		}
		return ev.getEvent_name();
	}
	
	/**
	 * This function select all data available in the database
	 * */
	public  ArrayList<Holiday> select(Holiday h) throws SQLException,ClassNotFoundException, IOException
	{
		ResultSet rs=null;
		PreparedStatement ps= null;
		ArrayList<Holiday> e1= new ArrayList<Holiday>();
		Holiday ev= new Holiday();
		String com="select * from Holiday_Master_Table a,Attendance_Event_Master_Table b where a.Event_Id= b.Event_Id and a.Event_Id= ?";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1,h.getEvent_id());
		rs= ps.executeQuery();
		while(rs.next())
		{
			ev.setEvent_name(rs.getString("Event_Name"));
			ev.setEvent_id(rs.getInt("Event_Id"));
			ev.setStarting(rs.getString("From_Date"));
			ev.setEnding(rs.getString("To_Date"));
			ev.setReason(rs.getString("Reason"));
			e1.add(ev);
			ev= new Holiday();
		}
		return e1;
	}	
}