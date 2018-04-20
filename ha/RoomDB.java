package bca.batch2011.project1.ha;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import bca.batch2011.project1.ht.Database;
import bca.batch2011.project1.ht.RoomAllocation;

public class RoomDB
{
	/**
	 * This function insert the data into the database.
	 **/	
	public void insert(Room room)throws IOException, SQLException, ClassNotFoundException
	{
		PreparedStatement ps= null;
		String com= "insert into Room_Master_Table(Room_No,Num_Cupboards)values(?,?);";
		Connection conn= Database.getConnection();
		ps=conn.prepareStatement(com);
		ps.setString(1,room.getRoomNo());
		ps.setInt(2,room.getNumCupboards());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
	 *this function is to get the data from the database and captures these values in ArrayList object of this class//
	 **/
	public  ArrayList<Room> select() throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Room> room1= new ArrayList<Room>();
		Room room= new Room();
		String query="select * from Room_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(query);	
		while(rs.next())
		{
			room.setRoomId(rs.getInt("Room_Id"));
			room.setRoomNo(rs.getString("Room_No"));
			room.setNumCupboards(rs.getInt("Num_Cupboards"));
			room1.add(room);
			room= new Room();
		}
		Database.freeConnection(conn);
		return room1;
	}
	/**
          * This function is to get the data from the database and captures these values in ArrayList object of this class//
         **/
	public Room selectbyid(String roomId,PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		Room room= new Room(); 
		String query="select * from Room_Master_Table where Room_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setInt(1,Integer.parseInt(roomId));
		rs= ps.executeQuery();
		while(rs.next())
		{
			room.setRoomId(rs.getInt("Room_Id"));
			room.setRoomNo(rs.getString("Room_No"));
			room.setNumCupboards(rs.getInt("Num_Cupboards"));
		}
		Database.freeConnection(conn);
		return room;
	}
	/**
          * This function updates the data in the database
        **/
	public Room update(Room room,int roomId)throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps=null;
		String com="update Room_Master_Table set Room_No= ?,Num_Cupboards= ? where Room_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setString(1,room.getRoomNo());
		ps.setInt(2, room.getNumCupboards());
		ps.setInt(3, roomId);
		ps.executeUpdate();
		Database.freeConnection(conn);
		return room;
	}
         /**
           * This function will check the particular data whether it is present in the database
         **/ 	
	public  boolean checkIfExist(Room room,ArrayList<Room> roomArray)
	{
		for(int i= 0;i< roomArray.size();i++)
		{
			if (room.getRoomNo().trim().equalsIgnoreCase(roomArray.get(i).getRoomNo().trim()))
				if(room.getNumCupboards() == roomArray.get(i).getNumCupboards())
					return false;
		}
		return true;
	}
	/**
          * This function deletes the data from the database.
        **/
	public void delete(String roomId,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		PreparedStatement ps= null;
		String query="delete from Room_Master_Table where Room_Id in("+roomId+");";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/**
          * This function is to get the data from the database and captures these values in ArrayList object of this class//
         **/
	public  ArrayList<Room> selectid(RoomAllocation roomalloc,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Room> roomarray= new ArrayList<Room>();
		Room room= new Room();
		Connection conn= Database.getConnection();
		String query="select DISTINCT b.Room_No,a.Room_Id,b.Num_Cupboards from Student_Room_Table a,Room_Master_Table b where a.Room_Id= b.Room_Id and Year= ? and Semester= ?;";
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1, roomalloc.getYear());
		ps.setInt(2, roomalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			room.setRoomNo(rs.getString("Room_No"));
			room.setRoomId(rs.getInt("Room_Id"));
			room.setNumCupboards(rs.getInt("Num_Cupboards"));
			roomarray.add(room);
			room= new Room();
		}
		Database.freeConnection(conn);
		return roomarray;
	}
}