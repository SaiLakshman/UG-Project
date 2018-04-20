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
import bca.batch2011.project1.ca.Student;
import bca.batch2011.project1.ha.Room;

public class RoomAllocationDB 
{
	/** This function does not take any arguments.
	*It returns ArrayList<RoomAllocation>
	*/
	public  ArrayList<RoomAllocation> select() throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<RoomAllocation> roomaray= new ArrayList<RoomAllocation>();
		RoomAllocation roomalloc= new RoomAllocation();
		String query="select a.Room_Id,a.Year,a.Semester,b.Room_No from Student_Room_Table a , Room_Master_Table b where a.Room_Id= b.Room_Id";
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
			roomalloc= new RoomAllocation();
		}
		Database.freeConnection(conn);
		return roomaray;
	}
	/** This function does not take any arguments.
	*It returns ArrayList<Student>
	*/
	public  ArrayList<Student> selectid() throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Student> roomaray= new ArrayList<Student>();
		Student roomalloc= new Student();
		String query="select a.Student_Id,b.Name from Student_Room_Table a,Student_Master_Table b where a.Student_Id= b.Student_Id";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(query);	
		while(rs.next())
		{
			roomalloc.setStudentId(rs.getInt("Student_Id"));
			roomalloc.setName(rs.getString("Name"));
			roomaray.add(roomalloc);
			roomalloc= new Student();
		}
		Database.freeConnection(conn);
		return roomaray;
	}
	/** This function takes printwriter as an argument.
	*It helps in getting the student details from the database. 
	*It returns ArrayList<Student>.
	*/
	public  ArrayList<Student> selectstudent(PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Student> studentarray= new ArrayList<Student>();
		Student student= new Student();
		String query="select a.Name from Student_Master_Table a,Student_Room_Table b where a.Student_Id= b.Student_Id;";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(query);	
		while(rs.next())
		{
			student.setStudentId(rs.getInt("Student_Id"));
			student.setCourse_Id(rs.getInt("Course_Id"));
			student.setName(rs.getString("Name"));
			studentarray.add(student);
			student= new Student();
		}
		Database.freeConnection(conn);
		return studentarray;
	}
	/** This function takes String s,printwriter as an arguments.
	*It helps in getting the studentIds from the database with the help of Studentname. 
	*It returns int.
	*/
	public int selectid(String studentname,PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		int b= 0;
		Student student= new Student();
		String query="select Student_Id from Student_Master_Table where Name= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement stat= conn.prepareStatement(query);
		stat.setString(1,studentname);
		rs= stat.executeQuery();
		while(rs.next())
		{
			student.setStudentId(rs.getInt("Student_Id"));
		}
		b= student.getStudentId();
		Database.freeConnection(conn);
		return b;
	}
	/** This function takes int x,int y,RoomAllocation r,printwriter as an arguments.
	*It helps in inserting the values in database. 
	*It returns null(void).
	*/
	public  void insert(int studentid,int roomid,RoomAllocation room,PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
			Connection conn= Database.getConnection();
			PreparedStatement ps= null;
			String insQuery= "insert into Student_Room_Table(Student_Id,Room_Id,Year,Semester)values(?,?,?,?)";
			ps= conn.prepareStatement(insQuery);
			ps.setInt(1,studentid);
			ps.setInt(2,roomid);
			ps.setInt(3,room.getYear());
			ps.setInt(4,room.getSemester());
			ps.executeUpdate();
			Database.freeConnection(conn);
	}
	/** This function takes RoomAllocation r,ArrayList<RoomAllocation> e,printwriter as an arguments.
	*It checks whether that particular year and semester is present in database or not. 
	*It returns boolean.
	*/
	public boolean check(RoomAllocation room,ArrayList<RoomAllocation> e,PrintWriter out) {
		for(int i= 0;i< e.size();i++)
		{
			if (room.getYear()== e.get(i).getYear())
				if(room.getSemester()== e.get(i).getSemester())
					return false;
		}
		return true;
	}
	/** This function takes String s,PrintWriter as the arguments
            *It helps in getting the Room_Id,Num_Cupboards from the database with the help of Room_No.
            *It returns int.
         **/ 
	public int roomselectid(String roomno, PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		int b= 0;
		Room room= new Room();
		String query="select Room_Id,Num_Cupboards from Room_Master_Table where Room_No= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement stat= conn.prepareStatement(query);
		stat.setString(1,roomno);
		rs= stat.executeQuery();
		while(rs.next())
		{
			room.setRoomId(rs.getInt("Room_Id"));
			room.setNumCupboards(rs.getInt("Num_Cupboards"));
		}
		b= room.getRoomId();
		Database.freeConnection(conn);
		return b;
	}
	/** This function takes as RoomAllocation a, as an argument.
	*It helps in getting the student details from the database. 
	*It returns ArrayList<Student>.
	*/
	public ArrayList<Student> selectbyys(RoomAllocation room)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Student> arraylist= new ArrayList<Student>();
		Student roomalloc= new Student();
		String query="select a.Student_Id,b.Name from Student_Room_Table a , Student_Master_Table b where a.Student_Id= b.Student_Id and Year= ? and Semester= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement stat= conn.prepareStatement(query);
		stat.setInt(1,room.getYear());
		stat.setInt(2,room.getSemester());
		rs= stat.executeQuery();
		while(rs.next())
		{
			roomalloc.setStudentId(rs.getInt("Student_Id"));
			roomalloc.setName(rs.getString("Name"));
			arraylist.add(roomalloc);
			roomalloc= new Student();
		}
		Database.freeConnection(conn);
		return arraylist;
	}
	/** This function takes RoomAllocation roomall,PrintWriter out as an arguments.
	* This function helps to get all the details of both room and student.
	* It returns ArrayList<RoomAllocation>
	*/
	public ArrayList<RoomAllocation> selected(RoomAllocation roomall,PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<RoomAllocation> arraylist= new ArrayList<RoomAllocation>();
		String query= "select b.Name Name,c.Room_No Room_No,d.Course_Name Course_Name from "
				+ "Student_Room_Table a inner join Student_Master_Table b inner join Room_Master_Table c inner join "
				+ "Course_Master_Table d on a.Student_Id =b.Student_Id and a.Room_Id=c.Room_Id and b.Course_Id = d.Course_Id "
				+ "and Year=? and Semester=?;";
		Connection conn= Database.getConnection();
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1,roomall.getYear());
		ps.setInt(2,roomall.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			roomall.setRoomNo(rs.getString("Room_No"));
			roomall.setName(rs.getString("Name"));
			roomall.setCourseName(rs.getString("Course_Name"));
			arraylist.add(roomall);
			roomall= new RoomAllocation();
		}
		Database.freeConnection(conn);
		return arraylist;
	}
	/** This function takes int x,PrintWriter out as an arguments.
	* This function helps to get the details of particular student.
	* It returns ArrayList<Student>
	*/
	public ArrayList<Student> selectstudent(int studentId, PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<Student> studentarray= new ArrayList<Student>();
		Student student= new Student(); 
		String query="select * from Student_Master_Table where Student_Id= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setInt(1,studentId);
		rs= ps.executeQuery();
		while(rs.next())
		{
			student.setCourse_Id(rs.getInt("Course_Id"));
			student.setName(rs.getString("Name"));
			student.setStudentId(rs.getInt("Student_Id"));
			studentarray.add(student);
		}
		Database.freeConnection(conn);
		return studentarray;
	}
	/** This function takes RoomAllocation r,ArrayList<RoomAllocation> e,printwriter as an arguments.
	*It checks whether that particular studentname is present in database or not. 
	*It returns boolean.
	*/
	public boolean check1(RoomAllocation roomalloc, ArrayList<RoomAllocation> e, PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		for(int i= 0;i< e.size();i++)
		{
				if(String.valueOf(roomalloc.getName()).trim().equalsIgnoreCase(String.valueOf(e.get(i).getName()).trim()))
					return false;
		}
		return true;
	}
	/** This function takes PrintWriter out as an argument.
	* This function helps to get the details of all students present in database.
	* It returns ArrayList<RoomAllocation>
	*/
	public static ArrayList<RoomAllocation> studentcourse(PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<RoomAllocation> courlist= new ArrayList<RoomAllocation>();
		GregorianCalendar calender= new GregorianCalendar();
		int presentyear= 0;
		presentyear= calender.get(Calendar.YEAR);
		RoomAllocation cour= new RoomAllocation();
		String query="select a.Name,a.Year_Of_Joining,b.Course_Name from Student_Master_Table a,Course_Master_Table b where a.Course_Id= b.Course_Id;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		rs= ps.executeQuery();
		while(rs.next())
		{
			cour.setCourseName(rs.getString("Course_Name"));
			cour.setName(rs.getString("Name"));
			cour.setBatch(String.valueOf(presentyear-rs.getInt("Year_Of_joining")));
			courlist.add(cour);
			cour= new RoomAllocation();
		}
		Database.freeConnection(conn);
		return courlist;
	}
	/** This function takes RoomAllocation r,String a,PrintWriter out as an arguments.
	* This function helps to get the details of all students and there courses.
	* It returns ArrayList<RoomAllocation>
	*/
	public ArrayList<RoomAllocation> selectbyroom(RoomAllocation roomalloc,String roomNo,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<RoomAllocation> stulist= new ArrayList<RoomAllocation>();
		GregorianCalendar calender= new GregorianCalendar();
		int presentyear= 0;
		presentyear= calender.get(Calendar.YEAR);
		
		RoomAllocation stu= new RoomAllocation();
		String query="select a.Name,a.Year_Of_Joining,d.Course_Name,b.Student_Id from Student_Master_Table a,Student_Room_Table b,Room_Master_Table c,Course_Master_Table d"
				+ " where a.Student_Id= b.Student_Id and a.Course_Id= d.Course_Id and b.Room_Id= c.Room_Id and c.Room_No= ? and b.Year= ? and b.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1, roomNo);
		ps.setInt(2, roomalloc.getYear());
		ps.setInt(3, roomalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			stu.setName(rs.getString("Name"));
			stu.setCourseName(rs.getString("Course_Name"));
			stu.setBatch(String.valueOf(presentyear-rs.getInt("Year_Of_joining")));
			stu.setStudentId(rs.getInt("Student_Id"));
			stulist.add(stu);
			stu = new RoomAllocation();
		}
		Database.freeConnection(conn);
		return stulist;
	}
	/** This function takes int r,RoomAllocation r,PrintWriter out as an arguments.
	* This function helps to delete the details of all students present in that particular room in that year and semester.
	* It returns null.
	*/
	public void delete(int roomid,RoomAllocation roomalloc,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		Connection conn= Database.getConnection();
		String delQuery= "delete from Student_Room_Table where Year= ? and Semester= ? and Room_Id= ?";
		ps= conn.prepareStatement(delQuery);
		ps.setInt(1, roomalloc.getYear());
		ps.setInt(2, roomalloc.getSemester());
		ps.setInt(3, roomid);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/** This function takes PrintWriter out as an arguments.
	* This function helps to get the details of all students.
	* It returns ArrayList<RoomAllocation>
	*/
	public ArrayList<RoomAllocation> select(PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<RoomAllocation> studentarray= new ArrayList<RoomAllocation>();
		RoomAllocation student= new RoomAllocation(); 
		String query="select * from Student_Master_Table;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		rs= ps.executeQuery();
		while(rs.next())
		{
			student.setName(rs.getString("Name"));
			student.setStudentId(rs.getInt("Student_Id"));
			studentarray.add(student);
		}
		Database.freeConnection(conn);
		return studentarray;
	}
	/** This function takes PrintWriter out as an arguments.
	* This function helps to get the details of all studentids and roomids.
	* It returns ArrayList<RoomAllocation>
	*/
	public ArrayList<RoomAllocation> selectfromroom(PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<RoomAllocation> studentarray= new ArrayList<RoomAllocation>();
		RoomAllocation student= new RoomAllocation(); 
		String query="select * from Student_Room_Table;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		rs= ps.executeQuery();
		while(rs.next())
		{
			student.setRoomId(rs.getInt("Room_Id"));
			student.setStudentId(rs.getInt("Student_Id"));
			studentarray.add(student);
		}
		Database.freeConnection(conn);
		return studentarray;
	}
}
