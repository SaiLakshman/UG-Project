package bca.batch2011.project1.ht;

import java.util.ArrayList;

import bca.batch2011.project1.ha.Room;
import bca.batch2011.project1.ca.Student;;

public class SRDAllocation
{
	int studentId,srdId;
	int year;
	int semester;
	String srdName,name,courseName,batch;
	/**Getter Method to get the Student_Id*/
	public int getStudentId() {
		return studentId;
	}
	/**Getter Method to set the Student_Id*/
	public void setStudentId(int stuId) {
		studentId = stuId;
	}

	/**Getter Method to get the Year*/
	public int getYear() {
		return year;
	}
	/**Getter Method to set the Year*/
	public void setYear(int y) {
		year = y;
	}
	/**Getter Method to get the Semester*/
	public int getSemester() {
		return semester;
	}
	/**Getter Method to set the Semester*/
	public void setSemester(int sem) {
		semester = sem;
	}
	/**Getter Method to get the Srd_Id*/

	public int getSrdId() {
		return srdId;
	}
	/**Getter Method to set the Srd_Id*/
	public void setSrdId(int srdId) {
		this.srdId = srdId;
	}
	/**Getter Method to get the SrdName*/
	public String getSrdName() {
		return srdName;
	}
	/**Getter Method to set the SrdName*/
	public void setSrdName(String srdName) {
		this.srdName = srdName;
	}
	/**Getter Method to get the Name*/
	public String getName() {
		return name;
	}
	/**Getter Method to set the Name*/
	public void setName(String n) {
		name = n;
	}
	/**Getter Method to get the CourseName*/
	public String getCourseName() {
		return courseName;
	}
	/**Getter Method to set the CourseName*/
	public void setCourseName(String courName) {
		courseName = courName;
	}
	/**Getter Method to get the Batch*/
	public String getBatch()
	{
		return batch;
	}
	/**Getter Method to set the Batch*/
	public void setBatch(String batch)
	{
		this.batch= batch;
	}
}
