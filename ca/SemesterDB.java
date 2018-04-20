package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class SemesterDB
{	
	/**
	 * Selects all the entry from the database and returns the ArrayList
	 * */
	public  ArrayList<Semester> select(PrintWriter out) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		ArrayList<Semester> semArray= null;
		Semester sem= new Semester();
		String query="select * from Semester_Master_Table";
		Connection conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(query);
		while(rs.next())
		{
			if(semArray == null)
				semArray= new ArrayList<Semester>();
			sem.setYear(rs.getInt("Year"));
			sem.setSemester(rs.getInt("Semester"));
			sem.setStartingDate(rs.getDate("Starting_Date").toString());
			sem.setEndingDate(rs.getDate("Ending_Date").toString());
			semArray.add(sem);
			sem= new Semester();
		}
		if(semArray == null)
			semArray= getDefaultSelected();
		Database.freeConnection(conn);
		return semArray;
	}
	
	/**
	 * Depending on the present year this function will perform addition and
	 * subtraction to get previous and next few years
	 * */
	public  ArrayList<Semester> getDefaultSelected() throws IOException, SQLException, ClassNotFoundException
	{
		ArrayList<Semester> semArray= new ArrayList<Semester>();
		Semester sem= new Semester();
		int startYear= sem.getYear() - 2;
		int endYear= sem.getYear() + 2;
		for(int i= startYear; i <= endYear; i++)
		{
			for(int j= 1; j <= 2; j++)
			{
				sem.setYear(i);
				sem.setSemester(j);
				semArray.add(sem);
				sem= new Semester();
			}
		}
		return semArray;
	}
	
	/**
	 * This function will first delete the data already existing and insert the data fresh
	 * */
	public void update(int year,int semester,Date startingDate,Date endingDate,PrintWriter out)throws IOException, SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String delQuery= "delete from Semester_Master_Table where Year=? and Semester=?";
		ps= conn.prepareStatement(delQuery);
		ps.setInt(1, year);
		ps.setInt(2, semester);
		ps.executeUpdate();
		String insQuery= "insert into Semester_Master_Table(Year,Semester,Starting_Date,Ending_Date)values(?,?,?,?)";
		ps= conn.prepareStatement(insQuery);
		ps.setInt(1,year);
		ps.setInt(2,semester);
		ps.setDate(3,startingDate);
		ps.setDate(4,endingDate);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
}