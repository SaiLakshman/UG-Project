package bca.batch2011.project1.ht;

public class RoomAllocation
{
	int studentId,roomId,year,semester;
	String roomNo,name,courseName,batch;
	/**Getter Method to get the StudentId*/
	public int getStudentId() {
		return studentId;
	}
	/**Getter Method to set the StudentId*/
	public void setStudentId(int stuId) {
		studentId = stuId;
	}
	/**Getter Method to get the RoomId*/
	public int getRoomId() {
		return roomId;
	}
	/**Getter Method to set the RoomId*/
	public void setRoomId(int roId) {
		roomId = roId;
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
	/**Getter Method to get the RoomNo*/
	public String getRoomNo() {
		return roomNo;
	}
	/**Getter Method to set the RoomNo*/
	public void setRoomNo(String roNo) {
		roomNo = roNo;
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
