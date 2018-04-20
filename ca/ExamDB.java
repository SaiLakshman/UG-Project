package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import bca.batch2011.project1.ha.Database;
import bca.batch2011.project1.ha.SRD;

public class ExamDB
{
	/**
	 * This function inserts into database
	 * */
	public void insert(Exam exam)throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "insert into Exam_Master_Table(Exam_Code,Exam_Title) values (?,?);";
		ps= conn.prepareStatement(com);
		ps.setString(1,exam.getExamCode());
		ps.setString(2, exam.getExamTitle());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
	
	/**
	 * This function select from the Exam_Master_Table if it exists and returns ArrayList
	 * */
	public  ArrayList<Exam> select() throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs= null;
		ArrayList<Exam> exam1= new ArrayList<Exam>();
		Exam exam= new Exam();
		String com= "select * from Exam_Master_Table;";
		Connection conn= null;
		conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(com);
		while(rs.next())
		{
			exam.setExamId(rs.getInt("Exam_Id"));
			exam.setExamCode(rs.getString("Exam_Code"));
			exam.setExamTitle(rs.getString("Exam_Title"));
			exam1.add(exam);
			exam= new Exam();
		}
		Database.freeConnection(conn);
		return exam1;
	}
	
	/**
	 * This funtion modifies the new change to be made in database and returns the Bean class object
	 * */
	public  Exam update(Exam exam,int id)throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps=null;
		String com="update Exam_Master_Table set Exam_Code= ?, Exam_Title= ? where Exam_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setString(1,exam.getExamCode());
		ps.setString(2,exam.getExamTitle());
		ps.setInt(3, id);
		ps.executeUpdate();
		Database.freeConnection(conn);
		return exam;
	}
	
	/**
	 * This funtion select the particular Exam depending on Id and returns Exam object
	 * */
	public  Exam selectbyid(String examid,PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		Exam exam= new Exam();
		PreparedStatement ps= null;
		String com="select * from Exam_Master_Table where Exam_Id= ?;";
		Connection conn= null;
		conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setString(1, examid);
		rs= ps.executeQuery();
		while(rs.next())
		{
			exam.setExamId(rs.getInt("Exam_Id"));
			exam.setExamCode(rs.getString("Exam_Code"));
			exam.setExamTitle(rs.getString("Exam_Title"));
		}
		Database.freeConnection(conn);
		return exam;
	}
	
	/**It checks, whether the entry already exists and return boolean value*/
	public  boolean checkIfExist(Exam exam,ArrayList<Exam> e)
	{
		for(int i= 0;i< e.size();i++)
		{
			if (exam.getExamCode().trim().equalsIgnoreCase(e.get(i).getExamCode().trim()))
				if(exam.getExamTitle().trim().equalsIgnoreCase(e.get(i).getExamTitle().trim()))
					return false;
		}
		return true;
	}
	
	/**
	 * This function deletes the data from database, it takes array of string to delete
	 * */
	public void delete(String examid) throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		String com= "Delete from Exam_Master_Table where Exam_Id in ("+examid+");";
		Statement stmt=null;
		stmt= conn.createStatement();
		stmt.executeUpdate(com);
		Database.freeConnection(conn);
	}
}