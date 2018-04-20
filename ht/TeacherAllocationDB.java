package bca.batch2011.project1.ht;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import bca.batch2011.project1.ha.Room;

public class TeacherAllocationDB
{
	/** This function does not take any arguments.
	*It helps in getting room details from database.
	*It returns ArrayList<TeacherAllocation>.
	*/
	public  ArrayList<TeacherAllocation> select() throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<TeacherAllocation> roomaray= new ArrayList<TeacherAllocation>();
		TeacherAllocation roomalloc= new TeacherAllocation();
		String query="select a.Room_Id,a.Year,a.Semester,b.Room_No from Teacher_Room_Table a , Room_Master_Table b where a.Room_Id= b.Room_Id";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(query);	
		while(rs.next())
		{
			roomalloc.setRoomId(rs.getInt("Room_Id"));
			roomalloc.setRoomNo(rs.getString("Room_No"));
			roomalloc.setYear(rs.getInt("Year"));
			roomalloc.setSemester(rs.getInt("Semester"));
			roomaray.add(roomalloc);
			roomalloc= new TeacherAllocation();
		}
		Database.freeConnection(conn);
		return roomaray;
	}
	/** This function takes TeacherAllocation r,ArrayList<TeacherAllocation> e,printwriter as an arguments.
	*It checks whether that particular year and semester is present in database or not. 
	*It returns boolean.
	*/
	public boolean check(TeacherAllocation room,ArrayList<TeacherAllocation> e,PrintWriter out) {
		for(int i= 0;i< e.size();i++)
		{
			if (room.getYear()== e.get(i).getYear())
				if(room.getSemester()== e.get(i).getSemester())
					return false;
		}
		return true;
	}
	/** This function takes TeacherAllocation roomalloc,PrintWriter out as an argument.
	*It helps in getting the room details from the database. 
	*It returns ArrayList<Room>.
	*/
	public  ArrayList<Room> selectid(TeacherAllocation roomalloc,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Room> roomarray= new ArrayList<Room>();
		Room room= new Room();
		Connection conn= Database.getConnection();
		String query="select DISTINCT b.Room_No,a.Room_Id,b.Num_Cupboards from Teacher_Room_Table a,Room_Master_Table b where a.Room_Id= b.Room_Id and Year= ? and Semester= ?;";
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
	/** This function takes TeacherAllocation roomalloc,String roomNo,PrintWriter out as an argument.
	*It helps in getting the teacher details from the database for that particular year and semester with that particular roomno. 
	*It returns ArrayList<TeacherAllocation>.
	*/
	public ArrayList<TeacherAllocation> selectbyroom(TeacherAllocation roomalloc,String roomNo,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<TeacherAllocation> stulist= new ArrayList<TeacherAllocation>();
		GregorianCalendar calender= new GregorianCalendar();
		int presentyear= 0;
		presentyear= calender.get(Calendar.YEAR);
		
		TeacherAllocation stu= new TeacherAllocation();
		String query="select a.Teacher_Name,b.Teacher_Id from Teacher_Master_Table a,Teacher_Room_Table b,Room_Master_Table c"
				+ " where a.Teacher_Id= b.Teacher_Id and b.Room_Id= c.Room_Id and c.Room_No= ? and b.Year= ? and b.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1, roomNo);
		ps.setInt(2, roomalloc.getYear());
		ps.setInt(3, roomalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			stu.setTeacherName(rs.getString("Teacher_Name"));
			stu.setTeacherId(rs.getInt("Teacher_Id"));
			stulist.add(stu);
			stu = new TeacherAllocation();
		}
		Database.freeConnection(conn);
		return stulist;
	}
	/** This function takes PrintWriter out as an argument.
	*It helps in getting all the teacher details from the database. 
	*It returns ArrayList<TeacherAllocation>.
	*/
	public static ArrayList<TeacherAllocation> studentcourse(PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<TeacherAllocation> courlist= new ArrayList<TeacherAllocation>();
		GregorianCalendar calender= new GregorianCalendar();
		int presentyear= 0;
		presentyear= calender.get(Calendar.YEAR);
		TeacherAllocation cour= new TeacherAllocation();
		String query="select Teacher_Name,Teacher_Id from Teacher_Master_Table";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		rs= ps.executeQuery();
		while(rs.next())
		{
			cour.setTeacherName(rs.getString("Teacher_Name"));
			cour.setTeacherId(rs.getInt("Teacher_Id"));
			courlist.add(cour);
			cour= new TeacherAllocation();
		}
		Database.freeConnection(conn);
		return courlist;
	}
	/** This function takes String roomno, PrintWriter out as an argument.
	*It helps in getting the roomids from the database for that particular roomnos. 
	*It returns int.
	*/
	public int roomselectid(String roomno, PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		int b= 0;
		TeacherAllocation room= new TeacherAllocation();
		String query="select Room_Id from Room_Master_Table where Room_No= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement stat= conn.prepareStatement(query);
		stat.setString(1,roomno);
		rs= stat.executeQuery();
		while(rs.next())
		{
			room.setRoomId(rs.getInt("Room_Id"));
		}
		b= room.getRoomId();
		Database.freeConnection(conn);
		return b;
	}
	/** This function takes String teachername, PrintWriter out as an arguments.
	*It helps in getting the teacherids from the database for that particular teachername. 
	*It returns int.
	*/
	public int selectid(String teachername, PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		int b= 0;
		TeacherAllocation student= new TeacherAllocation();
		String query="select Teacher_Id from Teacher_Master_Table where Teacher_Name= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement stat= conn.prepareStatement(query);
		stat.setString(1,teachername);
		rs= stat.executeQuery();
		while(rs.next())
		{
			student.setTeacherId(rs.getInt("Teacher_Id"));
		}
		b= student.getTeacherId();
		Database.freeConnection(conn);
		return b;
	}
	/** This function takes as RoomAllocation a, as an argument.
	*It helps in delete the teacher details from the database with that particular year and semester. 
	*It returns null.
	*/
	public void delete(TeacherAllocation roomalloc) throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String query= "delete from Teacher_Room_Table where year= ? and Semester= ?;";
		ps= conn.prepareStatement(query);
		ps.setInt(1,roomalloc.getYear());
		ps.setInt(2,roomalloc.getSemester());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/** This function takes int teacherid, int roomid, TeacherAllocation roomAllocation,PrintWriter out as an argument.
	*It helps in insert the teacherroom details in to the database. 
	*It returns null.
	*/
	public void insert(int teacherid, int roomid, TeacherAllocation roomAllocation,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String insQuery= "insert into Teacher_Room_Table(Teacher_Id,Room_Id,Year,Semester)values(?,?,?,?)";
		ps= conn.prepareStatement(insQuery);
		ps.setInt(1,teacherid);
		ps.setInt(2,roomid);
		ps.setInt(3,roomAllocation.getYear());
		ps.setInt(4,roomAllocation.getSemester());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/** This function takes TeacherAllocation roomalloc,PrintWriter out as an argument.
	*It helps in getting the teachernames,roomid and roomnos from the database. 
	*It returns ArrayList<TeacherAllocation>.
	*/
	public ArrayList<TeacherAllocation> roomnos(TeacherAllocation roomalloc,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<TeacherAllocation> roomarray= new ArrayList<TeacherAllocation>();
		TeacherAllocation room= new TeacherAllocation();
		Connection conn= Database.getConnection();
		String query="select DISTINCT b.Room_No,a.Room_Id,c.Teacher_Name from Teacher_Room_Table a,Room_Master_Table b,Teacher_Master_Table c where a.Teacher_Id= c.Teacher_Id and a.Room_Id= b.Room_Id and Year= ? and Semester= ?;";
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1, roomalloc.getYear());
		ps.setInt(2, roomalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			room.setRoomNo(rs.getString("Room_No"));
			room.setRoomId(rs.getInt("Room_Id"));
			room.setTeacherName(rs.getString("Teacher_Name"));
			roomarray.add(room);
			room= new TeacherAllocation();
		}
		Database.freeConnection(conn);
		return roomarray;
	}
	/** This function takes TeacherAllocation roomalloc,PrintWriter out as an argument.
	*It helps in getting the studentname and roomno from the database. 
	*It returns ArrayList<TeacherAllocation>.
	*/
	public ArrayList<TeacherAllocation> selected(TeacherAllocation roomalloc,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<TeacherAllocation> arraylist= new ArrayList<TeacherAllocation>();
		String query= "select b.Teacher_Name Teacher_Name,c.Room_No Room_No from "
				+ "Teacher_Room_Table a inner join Teacher_Master_Table b inner join Room_Master_Table c "
				+ " on a.Student_Id =b.Student_Id and a.Room_Id=c.Room_Id"
				+ "and Year=? and Semester=?;";
		Connection conn= Database.getConnection();
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1,roomalloc.getYear());
		ps.setInt(2,roomalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			roomalloc.setRoomNo(rs.getString("Room_No"));
			roomalloc.setTeacherName(rs.getString("Name"));
			arraylist.add(roomalloc);
			roomalloc= new TeacherAllocation();
		}
		Database.freeConnection(conn);
		return arraylist;
	}
}
