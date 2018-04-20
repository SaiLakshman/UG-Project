package bca.batch2011.project1.ct;

public class Papers_Course {
	private String paper_title= "",paper_code= "",course_name= "";
	private int paper_id, course_id,batch,year,semester,duration;
	/**Constructor for Paper_Course which takes zero arguments*/
	public Papers_Course()
	{
	}
	
	/**Constructor for Paper_Course which takes one arguments*/
	public Papers_Course(String coursename)
	{
		this.course_name= coursename;
	}
	
	/**Constructor for Paper_Course which takes two arguments*/
	public Papers_Course(String coursename,int courseid)
	{
		this.course_id= courseid;
		this.course_name= coursename;
	}
	/**Getter and setter methods for Paper_title*/
	public String getPaper_title()
	{
		return paper_title;
	}
	
	public void setPaper_title(String paper_title)
	{
		this.paper_title = paper_title;
	}

	/**Getter and setter methods for Paper_code*/
	public String getPaper_code()
	{
		return paper_code;
	}
	
	public void setPaper_code(String paper_code)
	{
		this.paper_code = paper_code;
	}
	
	/**Getter and setter methods for Paper_id*/
	public int getPaper_id()
	{
		return paper_id;
	}
	
	public void setPaper_id(int paper_id)
	{
		this.paper_id = paper_id;
	}
	
	/**Getter and setter methods for Duration of a course*/
	public int getDuration()
	{
		return duration;
	}
	
	public void setDuration(int duration)
	{
		this.duration = duration;
	}
	
	/**Getter and setter methods for Year*/
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	/**Getter and setter methods for Semester*/
	public int getSemester()
	{
		return semester;
	}
	
	public void setSemester(int semester)
	{
		this.semester = semester;
	}
	
	/**Getter and setter methods for Batch*/
	public int getBatch()
	{
		return batch;
	}
	
	public void setBatch(int batch)
	{
		this.batch = batch;
	}
	
	/**Getter and setter methods for Course_id*/
	public int getCourse_id()
	{
		return course_id;
	}
	
	public void setCourse_id(int course_id)
	{
		this.course_id = course_id;
	}
	
	/**Getter and setter methods for Course_name*/
	public String getCourse_name()
	{
		return course_name;
	}
	
	public void setCourse_name(String course_name)
	{
		this.course_name = course_name;
	}
}
