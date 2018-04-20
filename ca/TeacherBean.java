package bca.batch2011.project1.ca;

public class TeacherBean
{
	private int teacherid;
	private String teachername="";
	private String qualification="";
	private String position="";
	private int departmentid;
	private String departmentname="";

	/**
	 * Default constructor for member variables of the class
	 * */
	public TeacherBean()
	{
		teacherid= 0;
		teachername="";
		qualification="";
		position="";
		departmentid= 0;
		departmentname="";
	}
	
	/**
	 * Following are the Getter-Setter methods for member variables
	 * */
	public int getTeacherid()
	{
		return teacherid;
	}
	
	public void setTeacherid(int teacherid) 
	{
		this.teacherid = teacherid;
	}
	
	public String getTeachername() 
	{
		return teachername;
	}
	
	public void setTeachername(String teachername) 
	{
		this.teachername = teachername;
	}
	
	public String getQualification() 
	{
		return qualification;
	}
	
	public void setQualification(String qualification) 
	{
		this.qualification = qualification;
	}
	
	public String getPosition() 
	{
		return position;
	}
	
	public void setPosition(String position) 
	{
		this.position = position;
	}
	
	public int getDepartmentid()
	{
		return departmentid;
	}
	
	public void setDepartmentid(int departmentid)
	{
		this.departmentid = departmentid;
	}
	
	public String getDepartmentname() 
	{
		return departmentname;
	}
	
	public void setDepartmentname(String departmentname)
	{
		this.departmentname = departmentname;
	}	
}