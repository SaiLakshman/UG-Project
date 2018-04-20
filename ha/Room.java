package bca.batch2011.project1.ha;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Room 
{
	private int roomId;
	private String roomNo;
	private int numCupboards;
	/** This is default constructor**/
	public Room()
	{
		roomId= 0;
		roomNo = "";
		numCupboards = 0;
	}
	/** This is Two Argument constructor**/
	public Room(int roomId, String roomNo, int numCupboards)
	{
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.numCupboards = numCupboards;
	}
    /** This function will get RoomId**/
	public int getRoomId()
	{
		return roomId;
	}
    /** This function will set the RoomId**/
	public void setRoomId(int roomId)
	{
		this.roomId = roomId;
	}
    /** This function will get RoomNo**/
	public String getRoomNo()
	{
		return roomNo;
	}
    /** This function will set RoomNo**/
	public void setRoomNo(String roomNo) 
	{
		this.roomNo = roomNo;
	}
	/** This function will get NumCupboards**/
	public int getNumCupboards()
	{
		return numCupboards;
	}
    /** This function will set NumCupboards**/
	public void setNumCupboards(int numCupboards)
	{
		this.numCupboards = numCupboards;
	}
    /** This function will captures the data from the jsps**/
	public static void fillRoom(Room room,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{	
		room.setRoomNo(req.getParameter("roomNo"));
		room.setNumCupboards(Integer.parseInt(req.getParameter("numCupboards")));
		return;
	}
	/** 
         * This function insert the data into the database.
         **/
	public static void insertRoom(Room room,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		RoomDB insertroom= new RoomDB();
		ArrayList<Room> roomArray= new ArrayList<Room>();
		fillRoom(room, req);
		roomArray= insertroom.select();
		boolean isAbsent= insertroom.checkIfExist(room,roomArray);
		if(isAbsent == true)
			insertroom.insert(room);
		return;
	}
	/**
     * This function updates the data in the database.
    * */
	public static void updateRoom(Room room,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		fillRoom(room, req);
		RoomDB update= new RoomDB();
		int roomId= Integer.parseInt(req.getParameter("roomId"));
		room.setRoomId(roomId);
		update.update(room,roomId);
		return;
	}
	/**
     * This function deletes the data from the database.
    **/
	public static void deleteRoom(HttpServletResponse res,HttpServletRequest req) throws IOException,ClassNotFoundException,SQLException
	{
		PrintWriter out= res.getWriter();
		RoomDB delRoom= new RoomDB();
		String[] str= req.getParameterValues("deleteBox");
		String roomIds= "";
		if(str != null)
		{
			for(int i= 0;i < str.length;i++)
			{
				if(i == str.length-1)
					roomIds= roomIds.concat(str[i]);
				else
					roomIds= roomIds.concat(str[i]+",");
			}
		}
		delRoom.delete(roomIds,out);
		return;
	}
}