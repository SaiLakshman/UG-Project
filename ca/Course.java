package bca.batch2011.project1.ca;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Course 
{
	private String Coursename,coursetitle,Departmentname;
	private int Courseid,Duration,Departmentid;
	
	/**
	 * This is a Default constructor
	 * */
	public Course()
	{
		Courseid= 0;
		Coursename= "";
		coursetitle= "";
		Departmentid= 0;
		Departmentname= "";
		Duration= 0;
	}

	/**
	 * The method below is getter & setter for member variables
	 * */
	public String getCoursename() {
		return Coursename;
	}

	public void setCoursename(String coursename) {
		Coursename = coursename;
	}

	public String getCoursetitle() {
		return coursetitle;
	}

	public void setCoursetitle(String coursetitle) {
		this.coursetitle = coursetitle;
	}

	public String getDepartmentname() {
		return Departmentname;
	}

	public void setDepartmentname(String departmentname) {
		Departmentname = departmentname;
	}

	public int getCourseid() {
		return Courseid;
	}

	public void setCourseid(int courseid) {
		Courseid = courseid;
	}

	public int getDuration() {
		return Duration;
	}

	public void setDuration(int duration) {
		Duration = duration;
	}

	public int getDepartmentid() {
		return Departmentid;
	}

	public void setDepartmentid(int departmentid) {
		Departmentid = departmentid;
	}	
}