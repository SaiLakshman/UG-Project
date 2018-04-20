package bca.batch2011.project1.ca;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Semester 
{
	private String startingDate,endingDate;
	private int year;
	private int semester;
	
	/**
	 * Default constructor for member variables
	 * */
	public Semester()
	{
		Calendar c= new GregorianCalendar();
		year= c.get(Calendar.YEAR);
		startingDate= "";
		endingDate= "";
		semester= 1;
	}
	
	/**
	 * Following are the Getter-Setter for different member variables
	 * */
	public String getStartingDate()
	{
		return startingDate;
	}
	
	public void setStartingDate(String startingDate)
	{
		this.startingDate= startingDate;
	}
	
	public String getEndingDate()
	{
		return endingDate;
	}
	
	public void setEndingDate(String endingDate)
	{
		this.endingDate= endingDate;
	}
	
	public int getYear()
	{
		return year;
	}
	
	public void setYear(int year)
	{
		this.year= year;
	}
	
	public int getSemester()
	{
		return semester;
	}
	
	public void setSemester(int semester) 
	{
		this.semester= semester;
	}
}