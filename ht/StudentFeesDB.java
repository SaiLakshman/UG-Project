package bca.batch2011.project1.ht;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import bca.batch2011.project1.ca.Student;
import bca.batch2011.project1.ha.Database;
import bca.batch2011.project1.ha.Fees_Type;

public class StudentFeesDB
{
	/** This function takes StudentFeesBean studentfee,PrintWriter out as an arguments.
	*It helps in getting studentid,name and his fees details from database.
	*It returns ArrayList<StudentFeesBean>.
	*/
	public ArrayList<StudentFeesBean> selectbyId(StudentFeesBean studentfee,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		PreparedStatement ps= null;
		Connection conn= Database.getConnection();
		ArrayList<StudentFeesBean> studentfeesBean= new ArrayList<StudentFeesBean>();
		StudentFeesBean studentfees= new StudentFeesBean();
		String com= "select a.Student_Id,a.Name,b.Fees_Id,b.Fees_Name,c.Amount,c.Year,c.Semester,c.Receipt_No"
				+ " from Student_Master_Table a, Fees_Type_Master_Table b,Student_Fees_Table c "
				+ "where a.Student_Id= c.Student_Id and b.Fees_Id= c.Fees_Id and c.Year= ? and c.Semester= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1, studentfee.getYear());
		ps.setInt(2, studentfee.getSemester());
		rs= ps.executeQuery();
		while(rs.next())
		{
			studentfees.setStudentId(rs.getInt("Student_Id"));
			studentfees.setStudentname(rs.getString("Name"));
			studentfees.setFeesId(rs.getInt("Fees_Id"));
			studentfees.setFeestype(rs.getString("Fees_Name"));
			studentfees.setAmount(rs.getInt("Amount"));
			studentfees.setYear(rs.getInt("Year"));
			studentfees.setSemester(rs.getInt("Semester"));
			studentfees.setReceiptno(rs.getString("Receipt_No"));
			studentfeesBean.add(studentfees);
			studentfees= new StudentFeesBean();
		}
		Database.freeConnection(conn);
		return studentfeesBean;
	}
	/** This function takes int year,int sem as an arguments.
	*It helps in getting studentfees details from database for that particular year and semester.
	*It returns ArrayList<StudentFeesBean>.
	*/
	public ArrayList<StudentFeesBean> selectExisting(int year,int sem) throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		ArrayList<StudentFeesBean> beanArray= new ArrayList<StudentFeesBean>();
		StudentFeesBean studentfeeBean= new StudentFeesBean();
		String com= "select * from Student_Fees_Table where Year= ? and Semester= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1,year);
		ps.setInt(2,sem);
		rs= ps.executeQuery();
		while(rs.next())
		{
			studentfeeBean.setStudentId(rs.getInt("Student_Id"));
			studentfeeBean.setFeesId(rs.getInt("Fees_Id"));
			studentfeeBean.setAmount(rs.getInt("Amount"));
			studentfeeBean.setYear(rs.getInt("Year"));
			studentfeeBean.setSemester(rs.getInt("Semester"));
			studentfeeBean.setReceiptno(rs.getString("Receipt_No"));
			beanArray.add(studentfeeBean);
			studentfeeBean= new StudentFeesBean();
		}
		Database.freeConnection(conn);
		return beanArray;
	}
	/** This function takes StudentFeesBean studentfeesBean,ArrayList<StudentFeesBean> studentfees,PrintWriter out as an arguments.
	*It checks whether that particular FeesId,StudentId,Year and Semester is present in database or not. 
	*It returns boolean.
	*/
	public boolean checkIfExists(StudentFeesBean studentfeesBean,ArrayList<StudentFeesBean> studentfees,PrintWriter out)
	{
		for(int i= 0;i < studentfees.size();i++)
		{
			if(studentfeesBean.getFeesId() == studentfees.get(i).getFeesId())
				if(studentfeesBean.getStudentId() == studentfees.get(i).getStudentId())
					if(studentfeesBean.getYear() == studentfees.get(i).getYear())
						if(studentfeesBean.getSemester() == studentfees.get(i).getSemester())
							return false;
		}
		return true;
	}
	/** This function takes StudentFeesBean studentfeesBean,ArrayList<StudentFeesBean> studentfees,PrintWriter out as an arguments.
	*It checks whether that particular year and semester is present in database or not. 
	*It returns boolean.
	*/
	public boolean checkExists(StudentFeesBean studentfeesBean,ArrayList<StudentFeesBean> studentfees,PrintWriter out)
	{
		for(int i= 0;i < studentfees.size();i++)
		{
				if(studentfeesBean.getYear() == studentfees.get(i).getYear())
					if(studentfeesBean.getSemester() == studentfees.get(i).getSemester())
						return false;
		}
		return true;
	}
	/** This function takes String[] feesId,StudentFeesBean studentfee,String[] amount,String[] receipt,PrintWriter out as an argument.
	*It helps in insert the Student_Fees details in to the database. 
	*It returns null.
	*/
	public void insert(String[] feesId,StudentFeesBean studentfee,String[] amount,String[] receipt,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0;i < feesId.length;i++)
		{
			if(feesId[i] != "")
			{
				String com= "insert into Student_Fees_Table(Student_Id,Fees_Id,Year,Semester,Amount,Receipt_No) values (?,?,?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setInt(1, studentfee.getStudentId());
				ps.setString(2, feesId[i]);
				ps.setInt(3, studentfee.getYear());
				ps.setInt(4, studentfee.getSemester());
				ps.setString(5, amount[i]);
				ps.setString(6, receipt[i]);
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
	}
	/** This function takes StudentFeesBean fee,ArrayList<StudentFeesBean> studentfee,PrintWriter out as an argument.
	*It helps in insert the Student_Fees details in to the database. 
	*It returns null.
	*/
	public void copyinsert(StudentFeesBean fee,ArrayList<StudentFeesBean> studentfee,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0;i < studentfee.size();i++)
		{
				String com= "insert into Student_Fees_Table(Student_Id,Fees_Id,Year,Semester,Amount,Receipt_No) values (?,?,?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setInt(1, studentfee.get(i).getStudentId());
				ps.setInt(2, studentfee.get(i).getFeesId());
				ps.setInt(3, fee.getYear());
				ps.setInt(4, fee.getSemester());
				ps.setInt(5, studentfee.get(i).getAmount());
				ps.setString(6, studentfee.get(i).getReceiptno());
				ps.executeUpdate();
		}
		Database.freeConnection(conn);
	}
	/** This function does not take any arguments.
	*It helps in getting feestype details from database.
	*It returns ArrayList<Fees_Type>.
	*/
	public ArrayList<Fees_Type> select() throws IOException,SQLException,ClassNotFoundException
	{
		ResultSet rs= null;
		ArrayList<Fees_Type> fees1= new ArrayList<Fees_Type>();
		Fees_Type fees= new Fees_Type();
		String com= "select * from Fees_Type_Master_Table;";
		Connection conn= null;
		conn= Database.getConnection();
		Statement stmt= conn.createStatement();
		rs= stmt.executeQuery(com);
		while(rs.next())
		{
			fees.setfees_Id(rs.getInt("Fees_Id"));
			fees.setfees_Name(rs.getString("Fees_Name"));
			fees1.add(fees);
			fees= new Fees_Type();
		}
		Database.freeConnection(conn);
		return fees1;
	}
	/** This function does not take any arguments.
	*It helps in getting student details from database.
	*It returns ArrayList<Student>.
	*/
	public  ArrayList<Student> select1() throws IOException, SQLException, ClassNotFoundException
	{
		 ResultSet rs=null;
		 ArrayList<Student> student1= new ArrayList<Student>();
		 Student student= new Student();
		 String com="select Student_Id,a.Regd_No Regd_No,a.Name Name,a.Father_Name Father_Name,a.Mother_Name Mother_Name,"
		 		+ "a.Guardian_Name Guardian_Name,a.Date_Of_Birth Date_Of_Birth,a.Blood_Group Blood_Group,a.Year_Of_Joining,"
		 		+ "Year_Of_Joining,b.Course_Name Course_Name,a.Year_Num Year_Num,a.Nationality Nationality,a.Caste Caste,"
		 		+ "a.Caste_Certificate Caste_Certificate,a.Talents Talents,b.Course_Id Course_Id"
		 		+ " from Student_Master_Table a inner join Course_Master_Table b on a.Course_Id = b.Course_Id;";
		 Connection conn= null;
		 conn= Database.getConnection();
		 Statement stmt= conn.createStatement();
		 rs= stmt.executeQuery(com);	
		 while(rs.next())
		 {
			student.setStudentId(rs.getInt("Student_Id"));
			student.setRegdno(rs.getInt("Regd_No"));
			student.setName(rs.getString("Name"));
			student.setF_name(rs.getString("Father_Name"));
			student.setM_name(rs.getString("Mother_Name"));
			student.setG_name(rs.getString("Guardian_Name"));
			student.setDob(rs.getDate("Date_Of_Birth"));
			student.setBg(rs.getString("Blood_Group"));
			student.setYoj(rs.getInt("Year_Of_Joining"));
			student.setCourseName(rs.getString("Course_Name"));
			student.setCourse_Id(rs.getInt("Course_Id"));
			student.setYearNum(rs.getInt("Year_Num"));
			student.setNationality(rs.getString("Nationality"));
			student.setCaste(rs.getString("Caste"));
			student.setCheck(rs.getString("Caste_Certificate"));
			student.setTalents(rs.getString("Talents"));
			student1.add(student);
			student= new Student();
		 }
		 Database.freeConnection(conn);
		 return student1;
	}
	/** This function takes String[] fees,StudentFeesBean studentfee,String[] amt,String[] receipt,PrintWriter out as an argument.
	*It helps in insert the Student_Fees details in to the database. 
	*It returns null.
	*/
	public void modupdate(String[] fees,StudentFeesBean studentfee,String[] amt,String[] receipt,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		for(int i= 0; i< fees.length;i++)
		{
			if(fees[i] != "" && amt[i] != "")
			{
				String com= "insert into Student_Fees_Table(Student_Id,Fees_Id,Year,Semester,Amount,Receipt_No) values (?,?,?,?,?,?);";
				ps= conn.prepareStatement(com);
				ps.setInt(1, studentfee.getStudentId());
				ps.setString(2, fees[i]);
				ps.setInt(3, studentfee.getYear());
				ps.setInt(4, studentfee.getSemester());
				ps.setString(5, amt[i]);
				ps.setString(6, receipt[i]);
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
	}
	/** This function takes int year,int sem,PrintWriter out as an argument.
	*It helps in delete the Student_Fees details from the database for that particular year and semester. 
	*It returns null.
	*/
	public void delete(int year,int sem,PrintWriter out) throws IOException,SQLException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "Delete from Student_Fees_Table where Year= ? and Semester= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1, year);
		ps.setInt(2, sem);
		ps.executeUpdate();
		Database.freeConnection(conn);
	}
}
