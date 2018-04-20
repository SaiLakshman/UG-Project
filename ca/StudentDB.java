package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class StudentDB
{
	/**
	 * This function is to insert data into database.
	 * It also inserts information of Address and Contact by getting the last Id entered in database
	 * */
	public void insert(Student student)throws SQLException,ClassNotFoundException, IOException
	{
		int insertedId= 0;
		PreparedStatement ps=null;
		Connection conn= Database.getConnection();
		Statement stmt = conn.createStatement();
		String com="insert into Student_Master_Table(Regd_No,Name,Father_Name,Mother_Name,Guardian_Name,Date_Of_Birth,Blood_Group,Year_Of_Joining,Course_Id,Year_Num,Nationality,Caste,Caste_Certificate,Talents)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
		ps= conn.prepareStatement(com, Statement.RETURN_GENERATED_KEYS);
		ps.setInt(1,student.getRegdno());
		ps.setString(2,student.getName());
		ps.setString(3,student.getF_name());
		ps.setString(4,student.getM_name());
		ps.setString(5,student.getG_name());
		ps.setDate(6,student.getDob());
		ps.setString(7,student.getBg());
		ps.setInt(8,student.getYoj());
		ps.setInt(9,student.getCourse_Id());
		ps.setInt(10,student.getYearNum());
		ps.setString(11,student.getNationality());
		ps.setString(12,student.getCaste());
		ps.setString(13,student.getCheck());
		ps.setString(14,student.getTalents());
		ps.executeUpdate();
		ResultSet rs= ps.getGeneratedKeys();
		if(rs.next())
			insertedId= rs.getInt(1);
		ContactBean[] contacts= student.getContacts();
		String sql= "insert into Student_Contact_Table(Student_Id,Relationship,Contact_Number) values (?,?,?);";
		ps= conn.prepareStatement(sql);
		for(int i= 0;i < contacts.length;i++)
		{
			if(student.getContacts()[i] != null)
			{
				ps.setInt(1, insertedId);
				ps.setString(2, contacts[i].getRelation());
				ps.setString(3, contacts[i].getContactNo());
				ps.executeUpdate();
			}
		}
		AddressBean[] addresses= student.getAddress();
		String query= "insert into Student_Address_Table(Student_Id,Address_Line1,Address_Line2,Address_Line3,Place,State,Pin_Code,Address_Type) values (?,?,?,?,?,?,?,?);";
		ps= conn.prepareStatement(query);
		for(int j= 0;j < addresses.length;j++)
		{
			if(student.getAddress()[j] != null)
			{
				ps.setInt(1, insertedId);
				ps.setString(2, addresses[j].getLine1());
				ps.setString(3, addresses[j].getLine2());
				ps.setString(4, addresses[j].getLine3());
				ps.setString(5, addresses[j].getPlace());
				ps.setString(6, addresses[j].getState());
				ps.setString(7, addresses[j].getPincode());
				ps.setInt(8, addresses[j].getAddresstype());
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
	}
	
	/**
	 * This function captures all information from different tables like Student_Master_Table,
	 * Student_Address_Table,Student_Contact_Table and returns an ArrayList  
	 * */
	public  ArrayList<Student> select() throws IOException, SQLException, ClassNotFoundException
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
	
	/**
	 * This function selects data from the database according Id from three tables
	 * Student_Master_Table, Student_Contact_Table, Student_Address_Table
	 * */
	public Student selectbyid(Student studentId) throws IOException, SQLException, ClassNotFoundException
	{
		ResultSet rs=null;
		Student student= new Student();
		PreparedStatement ps= null;
		String com="select * from Student_Master_Table where Student_Id= ?;";
		Connection conn= null;
		conn= Database.getConnection();
		ps= conn.prepareStatement(com);
		ps.setInt(1, studentId.getStudentId());
		rs= ps.executeQuery();	
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
			student.setCourse_Id(rs.getInt("Course_Id"));
			student.setYearNum(rs.getInt("Year_Num"));
			student.setNationality(rs.getString("Nationality"));
			student.setCaste(rs.getString("Caste"));
			student.setCheck(rs.getString("Caste_Certificate"));
			student.setTalents(rs.getString("Talents"));
		}
		String sql= "select * from Student_Contact_Table where Student_Id= ?;";
		ps= conn.prepareStatement(sql);
		ps.setInt(1, studentId.getStudentId());
		rs= ps.executeQuery();
		int i= 0;
		ContactBean con[] = new ContactBean[5];
		ContactBean contacts= new ContactBean();
		while(rs.next())
		{
			student.setStudentId(rs.getInt("Student_Id"));
			String relation= rs.getString("Relationship");
			String number= rs.getString("Contact_Number");
			contacts.setRelation(relation);
			contacts.setContactNo(number);
			con[i]= contacts;
			contacts= new ContactBean();
			if(con[i] != null)
			{
				student.setContacts(con);
				i++;
			}
		}
		String query= "select * from Student_Address_Table where Student_Id= ?;";
		ps= conn.prepareStatement(query);
		ps.setInt(1, studentId.getStudentId());
		rs= ps.executeQuery();
		int j= 0;
		AddressBean addresses[] = new AddressBean[4];
		AddressBean address= new AddressBean();
		while(rs.next())
		{
			student.setStudentId(rs.getInt("Student_Id"));
			String addrline1= rs.getString("Address_Line1");
			String addrline2= rs.getString("Address_Line2");
			String addrline3= rs.getString("Address_Line3");
			String place= rs.getString("Place");
			String state= rs.getString("State");
			String pin= rs.getString("Pin_Code");
			int addrtype= rs.getInt("Address_Type");
			address.setLine1(addrline1);
			address.setLine2(addrline2);
			address.setLine3(addrline3);
			address.setPlace(place);
			address.setState(state);
			address.setPincode(pin);
			address.setAddresstype(addrtype);
			addresses[j]= address;
			address= new AddressBean();
			if(addresses[j] != null)
			{
				student.setAddress(addresses);
				j++;
			}
		}
		Database.freeConnection(conn);
		return student;
	}
	
	/**
	 * This function will set the new data in the database for students,addresses,contact tables
	 * */
	public Student update(Student s) throws IOException,SQLException, ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps=null;
		String com="update Student_Master_Table set Regd_No= ?,Name= ? ,Father_Name= ? ,Mother_Name= ?"
					+",Guardian_Name= ? ,Date_Of_Birth= ? ,Blood_Group= ? ,Year_Of_Joining= ?,Course_Id= ?, Year_Num= ?"
					+",Nationality= ? ,Caste= ? ,Caste_Certificate= ? ,Talents= ? where Student_Id= ?;";
		ps= conn.prepareStatement(com);
		ps.setInt(1,s.getRegdno());
		ps.setString(2,s.getName());
		ps.setString(3,s.getF_name());
		ps.setString(4,s.getM_name());
		ps.setString(5,s.getG_name());
		ps.setDate(6,s.getDob());
		ps.setString(7,s.getBg());
		ps.setInt(8,s.getYoj());
		ps.setInt(9,s.getCourse_Id());
		ps.setInt(10,s.getYearNum());
		ps.setString(11,s.getNationality());
		ps.setString(12,s.getCaste());
		ps.setString(13,s.getCheck());
		ps.setString(14,s.getTalents());
		ps.setInt(15, s.getStudentId());
		ps.executeUpdate();
		ContactBean[] contacts= s.getContacts();
		StudentDB del= new StudentDB();
		del.deleteContact(s.getStudentId());
		String sql= "insert into Student_Contact_Table(Student_Id,Relationship,Contact_Number) values (?,?,?);";
		ps= conn.prepareStatement(sql);
		for(int i= 0;i < contacts.length;i++)
		{
			if(s.getContacts()[i] != null)
			{
				ps.setInt(1, s.getStudentId());
				ps.setString(2, s.getContacts()[i].getRelation());
				ps.setString(3, s.getContacts()[i].getContactNo());
				ps.executeUpdate();
			}
		}
		AddressBean[] addresses= s.getAddress();
		del.deleteAddress(s.getStudentId());
		String query= "insert into Student_Address_Table(Student_Id,Address_Line1,Address_Line2,Address_Line3,Place,State,Pin_Code,Address_Type) values (?,?,?,?,?,?,?,?);";
		ps= conn.prepareStatement(query);
		for(int j= 0;j < addresses.length;j++)
		{
			if(s.getAddress()[j] != null)
			{
				ps.setInt(1, s.getStudentId());
				ps.setString(2, addresses[j].getLine1());
				ps.setString(3, addresses[j].getLine2());
				ps.setString(4, addresses[j].getLine3());
				ps.setString(5, addresses[j].getPlace());
				ps.setString(6, addresses[j].getState());
				ps.setString(7, addresses[j].getPincode());
				ps.setInt(8, addresses[j].getAddresstype());
				ps.executeUpdate();
			}
		}
		Database.freeConnection(conn);
		return s;
	}
	
	/**
	 * This checks in the database, if the student already exists and return boolean value
	 * */
	public boolean checkIfExist(Student s, ArrayList<Student> student,PrintWriter out)
	{
		for(int i= 0;i < student.size();i++)
		{
			if(s.getRegdno() == student.get(i).getRegdno())
				return false;
		}
		return true;
	}
	
	/**
	 * Deletion of the student which is combined in the string
	 * */
	public void deleteStudent(String studentId) throws SQLException,IOException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		String com= "Delete from Student_Master_Table where Student_Id in ("+studentId+");";
		Statement stmt=null;
		stmt= conn.createStatement();
		stmt.executeUpdate(com);
		Database.freeConnection(conn);
	}
	
	/**
	 * Deletin the students contact by using his Id 
	 * */
	public void deleteContact(int studentId) throws SQLException,IOException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String com= "Delete from Student_Contact_Table where Student_Id="+studentId+";";
		ps= conn.prepareStatement(com);
		ps.executeUpdate(com);
		Database.freeConnection(conn);
	}
	
	/**
	 * Deleting the students address by using the Id
	 * */
	public void deleteAddress(int studentId) throws SQLException,IOException,ClassNotFoundException
	{
		Connection conn= Database.getConnection();
		PreparedStatement ps= null;
		String sql= "Delete from Student_Address_Table where Student_Id="+studentId+";";
		ps= conn.prepareStatement(sql);
		ps.executeUpdate(sql);
		Database.freeConnection(conn);
	}
}