package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Student
{
	private int studentId;
	private String name;
	private int regdno;
	private String f_name;
	private String m_name;
	private String g_name;
	private Date dob;
	private String bg;
	private int yoj;
	private String courseName;
	private int course_Id;
	private int yearNum;
	private String nationality; 
	private String caste;
	private String check;
	private String talents;	
	private AddressBean[] addresses;
	private ContactBean[] contacts;
	
	/**
	 * This is the default constructor
	 * */
	public Student()
	{
		name= "";
		regdno= 0;
		f_name= "";
		m_name= "";
		g_name= "";
		dob= null;
		bg= "";
		yoj= 0;
		courseName= "";
		course_Id= 0;
		yearNum= 0;
		nationality= "";
		caste= "";
		check= "";
		talents= "";
	}
	
	/**
	 * This is multiple argument constructor for initializing the member variable 
	 * */
	public Student(int studentId, String name, int regdno, String f_name,
					String m_name, String g_name, Date dob, String bg, int yoj,String courseName,int course_Id,
					int yearNum,String nationality, String caste, String check, String talents)
	{
		this.studentId = studentId;
		this.name = name;
		this.regdno = regdno;
		this.f_name = f_name;
		this.m_name = m_name;
		this.g_name = g_name;
		this.dob = dob;
		this.bg = bg;
		this.yoj = yoj;
		this.courseName= courseName;
		this.course_Id= course_Id;
		this.yearNum= yearNum;
		this.nationality = nationality;
		this.caste = caste;
		this.check = check;
		this.talents = talents;
	}

	/**This is Getter method for getting Student_Id*/
	public int getStudentId()
	{
		return studentId;
	}

	/**This is Setter method for setting Student_Id*/
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}

	/**This is Getter method for getting Student's name*/
	public String getName()
	{
		return name;
	}

	/**This is Setter method for setting Student's name*/
	public void setName(String name)
	{
		this.name = name;
	}

	/**This is Getter method for getting Regd_no*/
	public int getRegdno()
	{
		return regdno;
	}

	/**This is Setter method for setting Regd_no*/
	public void setRegdno(int regdno)
	{
		this.regdno = regdno;
	}

	/**This is Getter method for getting Father's name*/
	public String getF_name()
	{
		return f_name;
	}

	/**This is Setter method for setting Father's name*/
	public void setF_name(String f_name)
	{
		this.f_name = f_name;
	}

	/**This is Getter method for getting Mother's name*/
	public String getM_name()
	{
		return m_name;
	}

	/**This is Setter method for setting Mother's name*/
	public void setM_name(String m_name)
	{
		this.m_name = m_name;
	}

	/**This is Getter method for getting Guardian's name*/
	public String getG_name()
	{
		return g_name;
	}

	/**This is Setter method for setting Guardian's name*/
	public void setG_name(String g_name)
	{
		this.g_name = g_name;
	}

	/**This is Getter method for getting Date of birth*/
	public Date getDob()
	{
		return dob;
	}

	/**This is Setter method for setting Date of Birth*/
	public void setDob(Date dob)
	{
		this.dob = dob;
	}

	/**This is Getter method for getting Blood Group*/
	public String getBg()
	{
		return bg;
	}

	/**This is Setter method for setting blood group*/
	public void setBg(String bg)
	{
		this.bg = bg;
	}

	/**This is Getter method for getting year of joining*/
	public int getYoj()
	{
		return yoj;
	}

	/**This is Setter method for setting year of joining*/
	public void setYoj(int yoj)
	{
		this.yoj = yoj;
	}

	/**This is Getter method for getting coursename*/
	public String getCourseName()
	{
		return courseName;
	}

	/**This is setter method for setting coursename*/
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	/**This is Getter method for gettin Course_Id*/
	public int getCourse_Id()
	{
		return course_Id;
	}

	/**This is Setter method for setting Course_Id*/
	public void setCourse_Id(int course_Id)
	{
		this.course_Id = course_Id;
	}

	/**This is Getter method for getting year of study*/
	public int getYearNum()
	{
		return yearNum;
	}

	/**This is Setter method for setting year of study*/
	public void setYearNum(int yearNum)
	{
		this.yearNum = yearNum;
	}

	/**This is Getter method for getting natioanlity details*/
	public String getNationality()
	{
		return nationality;
	}

	/**This is Setter method for setting nationality details*/
	public void setNationality(String nationality)
	{
		this.nationality = nationality;
	}

	/**This is Getter method for getting Caste*/
	public String getCaste()
	{
		return caste;
	}

	/**This is setter method for setting Caste*/
	public void setCaste(String caste)
	{
		this.caste = caste;
	}

	/**This is Getter method for getting to know the Caste Certificate is presented or not*/
	public String getCheck()
	{
		return check;
	}

	/**This is Setter method for setting to know the Caste Certificate is presented or not*/
	public void setCheck(String check)
	{
		this.check = check;
	}

	/**This is Getter method for getting talents*/
	public String getTalents()
	{
		return talents;
	}

	/**This is Setter method for setting talents*/
	public void setTalents(String talents)
	{
		this.talents = talents;
	}

	/**This is Getter method for getting address details*/
	public AddressBean[] getAddress()
	{
		return addresses;
	}

	/**This is Setter method for setting address details*/
	public void setAddress(AddressBean[] addresses)
	{
		this.addresses = addresses;
	}

	/**This is Getter method for getting contact details*/
	public ContactBean[] getContacts()
	{
		return contacts;
	}

	/**This is Setter method for setting contact details*/
	public void setContacts(ContactBean[] contacts)
	{
		this.contacts = contacts;
	}
	
	/**
	 * This function gets the value from jsps and sets according to the request of the user
	 * */
	public static void insertStudent(Student student,HttpServletRequest req,PrintWriter out) throws ClassNotFoundException,SQLException,IOException
	{
		student.setName(req.getParameter("Name"));
		student.setRegdno(Integer.parseInt(req.getParameter("Regdno")));
		student.setF_name(req.getParameter("f_name"));
		student.setM_name(req.getParameter("m_name"));
		student.setG_name(req.getParameter("g_name"));
		String dateofbirth= req.getParameter("dateofbirth");
		Date dob= Date.valueOf(dateofbirth);
		student.setDob(dob);
		student.setBg(req.getParameter("bg"));
		student.setYoj(Integer.parseInt(req.getParameter("yoj")));
		student.setCourse_Id(Integer.parseInt(req.getParameter("courseId")));
		student.setYearNum(Integer.parseInt(req.getParameter("yearNum")));
		student.setNationality(req.getParameter("nationality"));
		student.setCaste(req.getParameter("caste"));
		student.setCheck(req.getParameter("Check"));
		student.setTalents(req.getParameter("talents"));
		student.setContacts(ContactBean.insertContact(req,out));
		student.setAddress(AddressBean.insertAddress(req, out));
		return;
	}
	
	/**
	 * This function captures all the values in an String array
	 * */
	public static void deleteStudent(HttpServletResponse res,HttpServletRequest req) throws ClassNotFoundException,SQLException,IOException
	{
		PrintWriter out= res.getWriter();
		StudentDB delStudent= new StudentDB();
		String[] str= req.getParameterValues("deleteBox");
		String studentIds= "";
		if(str != null)
		{
			for(int i= 0;i < str.length;i++)
			{
				if(i == str.length-1)
					studentIds= studentIds.concat(str[i]);
				else
					studentIds= studentIds.concat(str[i]+",");
			}
		}
		delStudent.deleteStudent(studentIds);
		return;
	}
}