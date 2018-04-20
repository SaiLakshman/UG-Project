package bca.batch2011.project1.ht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import bca.batch2011.project1.ha.Database;

public class Student_BankDB
{
	/** This function does not take any argument.
	*It helps in getting the student_Ids from the database. 
	*It returns ArrayList<Student_Bank>.
	*/
	public ArrayList<Student_Bank> selectbyId() throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		Connection conn= Database.getConnection();
		ArrayList<Student_Bank> studentarray= new ArrayList<Student_Bank>();
		Student_Bank studentbank= new Student_Bank();
		String com= "select Student_Id,Name from Student_Master_Table;";
		ps= conn.prepareStatement(com);
		rs= ps.executeQuery();
		while(rs.next())
		{
			studentbank.setStudentId(rs.getInt("Student_Id"));
			studentbank.setStudentname(rs.getString("Name"));
			studentarray.add(studentbank);
			studentbank= new Student_Bank();
		}
		Database.freeConnection(conn);
		return studentarray;
	}
	/** This function takes Student_Bank bank,ArrayList<Student_Bank> bankarray,printwriter as an arguments.
	*It checks whether that particular Student_Id is present in database or not. 
	*It returns boolean.
	*/
	public boolean checkExists(Student_Bank bank,ArrayList<Student_Bank> bankarray,PrintWriter out)
	{
		for(int i= 0;i < bankarray.size();i++)
		{
			if(bank.getStudentId() == bankarray.get(i).getStudentId())
				return false;
		}
		return true;
	}
	/** This function does not take any argument.
	*It helps in getting all student details from the database. 
	*It returns ArrayList<Student_Bank>.
	*/
	public ArrayList<Student_Bank> selectExisting() throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		ArrayList<Student_Bank> bankarray= new ArrayList<Student_Bank>();
		Student_Bank studentbank= new Student_Bank();
		String com= "select a.Name Name, a.Student_Id Student_Id, b.Bank_Name Bank_Name"
				  + ",b.Bank_Account_No Bank_Account_No,b.ATM_Card_No ATM_Card_No"
				  + " from Student_Master_Table a, Student_Bank_Table b where a.Student_Id= b.Student_Id;";
		ps= conn.prepareStatement(com);
		rs= ps.executeQuery();
		while(rs.next())
		{
			studentbank.setStudentId(rs.getInt("Student_Id"));
			studentbank.setStudentname(rs.getString("Name"));
			studentbank.setBankName(rs.getString("Bank_Name"));
			studentbank.setAccNo(rs.getString("Bank_Account_No"));
			studentbank.setATMcardNo(rs.getString("ATM_Card_No"));
			bankarray.add(studentbank);
			studentbank= new Student_Bank();
		}
		Database.freeConnection(conn);
		return bankarray;
	}
	/** This function takes Student_Bank studentid as an argument.
	*It helps in getting the student_Ids from the database. 
	*It returns ArrayList<Student_Bank>.
	*/
	public ArrayList<Student_Bank> selectbyid(Student_Bank studentid) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		Student_Bank bank= new Student_Bank();
		ArrayList<Student_Bank> bankarray= new ArrayList<Student_Bank>();
		String com= "select * from Student_Bank_Table where Student_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1, studentid.getStudentId());
		rs= ps.executeQuery();
		while(rs.next())
		{
			bank.setStudentId(rs.getInt("Student_Id"));
			bank.setBankName(rs.getString("Bank_Name"));
			bank.setAccNo(rs.getString("Bank_Account_No"));
			bank.setATMcardNo(rs.getString("ATM_Card_No"));
			bankarray.add(bank);
			bank= new Student_Bank();
		}
		Database.freeConnection(conn);
		return bankarray;
	}
	/** This function takes Student_Bank bank,String[] bankname,String[] accno,String[] atm,PrintWriter out as an argument.
	*It helps in inserting the studentbank details in to the database. 
	*It returns ArrayList<Student_Bank>.
	*/
	public void insert(Student_Bank bank,String[] bankname,String[] accno,String[] atm,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0;i < accno.length;i++)
		{
			if(accno[i] != "")
			{
				String com= "insert into Student_Bank_Table(Student_Id,Bank_Name,Bank_Account_No,ATM_Card_No) values (?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setInt(1, bank.getStudentId());
				ps.setString(2, bankname[i]);
				ps.setString(3, accno[i]);
				ps.setString(4, atm[i]);
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
	}
	/** This function takes Student_Bank id,PrintWriter out as an argument.
	*It helps in getting the student_Ids from the database. 
	*It returns null.
	*/
	public void update(Student_Bank bank,String[] bankname,String[] accno,String[] atm,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0;i < accno.length;i++)
		{
			if(accno[i] != "")
			{
				String com= "insert into Student_Bank_Table(Student_Id,Bank_Name,Bank_Account_No,ATM_Card_No) values (?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setInt(1, bank.getStudentId());
				ps.setString(2, bankname[i]);
				ps.setString(3, accno[i]);
				ps.setString(4, atm[i]);
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
	}
	/** This function takes Student_Bank id,PrintWriter out as an argument.
	*It helps in delete the student information from the database. 
	*It returns null.
	*/
	public void delete(Student_Bank id,PrintWriter out) throws SQLException,ClassNotFoundException,IOException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "Delete from Student_Bank_Table where Student_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1, id.getStudentId());
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
}
