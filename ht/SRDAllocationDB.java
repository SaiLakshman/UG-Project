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

public class SRDAllocationDB {

	/** This function takes SRDAllocation srd,PrintWriter out as an arguments.
	* This function helps to get the details of all SRD in that particular year and semester.
	* It returns ArrayList<SRDAllocation>
	*/
	public  ArrayList<SRDAllocation> select(SRDAllocation srd,PrintWriter out ) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<SRDAllocation> srdarray= new ArrayList<SRDAllocation>();
		SRDAllocation srdalloc= new SRDAllocation();
		String query="select a.SRD_Id,a.Year,a.Semester,b.SRD_Name from Student_SRD_Table a , SRD_Master_Table b where a.SRD_Id= b.SRD_Id and Year= ? and Semester= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1, srd.getYear());
		ps.setInt(2, srd.getSemester());
		rs= ps.executeQuery();
		
		while(rs.next())
		{
			srdalloc.setSrdId(rs.getInt("SRD_Id"));
			srdalloc.setSrdName(rs.getString("SRD_Name"));
			srdalloc.setYear(rs.getInt("Year"));
			srdalloc.setSemester(rs.getInt("Semester"));
			srdarray.add(srdalloc);
			srdalloc= new SRDAllocation();
		}
		Database.freeConnection(conn);
		return srdarray;
	}
	/** This function takes SRDAllocation r,ArrayList<SRDAllocation> e,printwriter as an arguments.
	*It checks whether that particular year and semester is present in database or not. 
	*It returns boolean.
	*/
	public boolean check(SRDAllocation srd,ArrayList<SRDAllocation> e,PrintWriter out)
	{
		for(int i= 0;i< e.size();i++)
		{
			if (srd.getYear()== e.get(i).getYear())
				if(srd.getSemester()== e.get(i).getSemester())
					return false;
		}
		return true;
	}
	/** This function takes SRDAllocation srd,PrintWriter out as an arguments.
	* This function helps to get the details of all SRD in that particular year and semester.
	* It returns ArrayList<SRDAllocation>
	*/
	public static  ArrayList<SRDAllocation> selectid(SRDAllocation srdalloc,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<SRDAllocation> roomarray= new ArrayList<SRDAllocation>();
		SRDAllocation room= new SRDAllocation();
		Connection conn= Database.getConnection();
		String query="select DISTINCT b.SRD_Name,a.SRD_Id from Student_SRD_Table a,SRD_Master_Table b where a.SRD_Id= b.SRD_Id and Year= ? and Semester= ?;";
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1, srdalloc.getYear());
		ps.setInt(2, srdalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			room.setSrdName(rs.getString("SRD_Name"));
			room.setSrdId(rs.getInt("SRD_Id"));
			roomarray.add(room);
			room= new SRDAllocation();
		}
		Database.freeConnection(conn);
		return roomarray;
	}
	/** This function takes SRDAllocation srd,PrintWriter out as an arguments.
	* This function helps to get the details of all students in that particular year and semester with particular SRD_Name.
	* It returns ArrayList<SRDAllocation>
	*/
	public ArrayList<SRDAllocation> selectbysrd(SRDAllocation srdalloc,String srdName,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<SRDAllocation> stulist= new ArrayList<SRDAllocation>();
		GregorianCalendar calender= new GregorianCalendar();
		int presentyear= 0;
		presentyear= calender.get(Calendar.YEAR);
		
		SRDAllocation stu= new SRDAllocation();
		String query="select a.Name,a.Year_Of_Joining,d.Course_Name,b.Student_Id from Student_Master_Table a,Student_SRD_Table b,SRD_Master_Table c,Course_Master_Table d"
				+ " where a.Student_Id= b.Student_Id and a.Course_Id= d.Course_Id and b.SRD_Id= c.SRD_Id and c.SRD_Name= ? and b.Year= ? and b.Semester= ?;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		ps.setString(1, srdName);
		ps.setInt(2, srdalloc.getYear());
		ps.setInt(3, srdalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			stu.setName(rs.getString("Name"));
			stu.setCourseName(rs.getString("Course_Name"));
			stu.setBatch(String.valueOf(presentyear-rs.getInt("Year_Of_joining")));
			stu.setStudentId(rs.getInt("Student_Id"));
			stulist.add(stu);
			stu = new SRDAllocation();
		}
		Database.freeConnection(conn);
		return stulist;
	}
	/** This function takes PrintWriter out as an argument.
	* This function helps to get the details of all SRD.
	* It returns ArrayList<SRDAllocation>
	*/
	public ArrayList<SRDAllocation> select(PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<SRDAllocation> srdarray= new ArrayList<SRDAllocation>();
		SRDAllocation srd= new SRDAllocation();
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		String query="select * from SRD_Master_Table";
		rs= stmt.executeQuery(query);	
		while(rs.next())
		{
			srd.setSrdName(rs.getString("SRD_Name"));
			srdarray.add(srd);
			srd= new SRDAllocation();
		}
		Database.freeConnection(conn);
		return srdarray;
	}
	/** This function takes PrintWriter out as an argument.
	* This function helps to get the details of Students and there Courses.
	* It returns ArrayList<SRDAllocation>
	*/
	public ArrayList<SRDAllocation> studentcourse(PrintWriter out)  throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		ArrayList<SRDAllocation> courlist= new ArrayList<SRDAllocation>();
		GregorianCalendar calender= new GregorianCalendar();
		int presentyear= 0;
		presentyear= calender.get(Calendar.YEAR);
		SRDAllocation cour= new SRDAllocation();
		String query="select a.Name,a.student_Id,a.Year_Of_Joining,b.Course_Name from Student_Master_Table a,Course_Master_Table b where a.Course_Id= b.Course_Id;";
		Connection conn= Database.getConnection();
		ps= conn.prepareStatement(query);
		rs= ps.executeQuery();
		while(rs.next())
		{
			cour.setCourseName(rs.getString("Course_Name"));
			cour.setName(rs.getString("Name"));
			cour.setStudentId(rs.getInt("Student_Id"));
			cour.setBatch(String.valueOf(presentyear-rs.getInt("Year_Of_joining")));
			courlist.add(cour);
			cour= new SRDAllocation();
		}
		Database.freeConnection(conn);
		return courlist;
	}
	/** This function takes String s,PrintWriter out as an arguments.
	* This function helps to get the SRD_Ids for that particular SRD_Name.
	* It returns int
	*/
	public int roomselectid(String srdname, PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		int b= 0;
		SRDAllocation srd= new SRDAllocation();
		String query="select SRD_Id from SRD_Master_Table where SRD_Name= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement stat= conn.prepareStatement(query);
		stat.setString(1,srdname);
		rs= stat.executeQuery();
		while(rs.next())
		{
			srd.setSrdId(rs.getInt("SRD_Id"));
		}
		b= srd.getSrdId();
		Database.freeConnection(conn);
		return b;
	}
	/** This function takes String s,PrintWriter out as an arguments.
	* This function helps to get the Student_Ids for that particular studentName.
	* It returns int
	*/
	public int selectid(String studentname, PrintWriter out) throws IOException, SQLException, ClassNotFoundException
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
	/** This function takes int studentid, int srdid, SRDAllocation srdAllocation,PrintWriter out as an arguments.
	* This function helps to insert the details of student and srd.
	* It returns null
	*/
	public void insert(int studentid, int srdid, SRDAllocation srdAllocation,PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String insQuery= "insert into Student_SRD_Table(Student_Id,SRD_Id,Year,Semester)values(?,?,?,?)";
		ps= conn.prepareStatement(insQuery);
		ps.setInt(1,studentid);
		ps.setInt(2,srdid);
		ps.setInt(3,srdAllocation.getYear());
		ps.setInt(4,srdAllocation.getSemester());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	/** This function takes int studentid,SRDAllocation srdalloc,PrintWriter out as an argument.
	* This function helps to get SRD_Names .
	* It returns ArrayList<SRDAllocation>
	*/
	public ArrayList<SRDAllocation> selected(int studentid,SRDAllocation srdalloc,PrintWriter out)  throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<SRDAllocation> arraylist= new ArrayList<SRDAllocation>();
		String query= " select a.SRD_Name from SRD_Master_Table a,Student_SRD_Table b where a.SRD_Id= b.SRD_Id and b.Student_Id= ? and Year= ? and Semester= ?;";
		Connection conn= Database.getConnection();
		PreparedStatement ps= conn.prepareStatement(query);
		ps.setInt(1,studentid);
		ps.setInt(2,srdalloc.getYear());
		ps.setInt(3,srdalloc.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			srdalloc.setSrdName(rs.getString("SRD_Name"));
			arraylist.add(srdalloc);
			srdalloc= new SRDAllocation();
		}
		Database.freeConnection(conn);
		return arraylist;
	}
	/** This function takes SRDAllocation srdAllocation,PrintWriter out as an arguments.
	* This function helps to delete the details of student and srd in that particular year and semester.
	* It returns null
	*/
	public void delete(SRDAllocation srdAllocation, PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String query= "delete from Student_SRD_Table where Year= ? and Semester= ?;";
		ps= conn.prepareStatement(query);
		ps.setInt(1,srdAllocation.getYear());
		ps.setInt(2,srdAllocation.getSemester());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}

}
