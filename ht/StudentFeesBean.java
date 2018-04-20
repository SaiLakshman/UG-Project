package bca.batch2011.project1.ht;

public class StudentFeesBean
{
	private int studentId;
	private int feesId;
	private int year;
	private int semester;
	private int amount;
	private String receiptno;
	private String feestype;
	private String studentname;
	/**This is Default Constructor*/
	public StudentFeesBean()
	{
		this.studentId= 0;
		this.feesId= 0;
		this.year= 0;
		this.semester= 0;
		this.amount= 0;
		this.receiptno= "";
	}
	/**Multiple Argument Constructor*/
	public StudentFeesBean(int studentId, int feesId, int year, int semester,int amount, String receiptno)
	{
		this.studentId = studentId;
		this.feesId = feesId;
		this.year = year;
		this.semester = semester;
		this.amount = amount;
		this.receiptno = receiptno;
	}
	/**Getter Method to get the Student_Id*/
	public int getStudentId()
	{
		return studentId;
	}
	/**Setter Method to set the Student_Id*/
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	/**Getter Method to get the Fees_Id*/
	public int getFeesId()
	{
		return feesId;
	}
	/**Setter Method to set the Fees_Id*/
	public void setFeesId(int feesId)
	{
		this.feesId = feesId;
	}
	/**Getter Method to get the Year*/
	public int getYear()
	{
		return year;
	}
	/**Setter Method to set the Year*/
	public void setYear(int year)
	{
		this.year = year;
	}
	/**Getter Method to get the Semester*/
	public int getSemester()
	{
		return semester;
	}
	/**Setter Method to set the Semester*/
	public void setSemester(int semester)
	{
		this.semester = semester;
	}
	/**Getter Method to get the Amount*/
	public int getAmount()
	{
		return amount;
	}
	/**Setter Method to set the Amount*/
	public void setAmount(int amount)
	{
		this.amount = amount;
	}
	/**Getter Method to get the Receipt_No*/
	public String getReceiptno()
	{
		return receiptno;
	}
	/**Setter Method to set the Receipt_No*/
	public void setReceiptno(String receiptno)
	{
		this.receiptno = receiptno;
	}
	/**Getter Method to get the Fees_Type*/
	public String getFeestype()
	{
		return feestype;
	}
	/**Setter Method to set the Fees_Type*/
	public void setFeestype(String feestype)
	{
		this.feestype = feestype;
	}
	/**Getter Method to get the Student Name*/
	public String getStudentname()
	{
		return studentname;
	}
	/**Setter Method to set the Student Name*/
	public void setStudentname(String studentname)
	{
		this.studentname = studentname;
	}
}