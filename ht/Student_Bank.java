package bca.batch2011.project1.ht;

public class Student_Bank
{
	private int studentId;
	private String studentname;
	private String bankName;
	private String accNo;
	private String ATMcardNo;
	/**This is Default Constructor*/
	public Student_Bank()
	{
		studentId= 0;
		bankName= "";
		accNo= "";
		ATMcardNo= "";
	}
	/**Multiple Argument Constructor*/
	public Student_Bank(int studentId, String bankName, String accNo, String atmcardNo)
	{
		this.studentId = studentId;
		this.bankName = bankName;
		this.accNo = accNo;
		this.ATMcardNo = atmcardNo;
	}
	/**Getter Method to get the Student_Id*/
	public int getStudentId()
	{
		return studentId;
	}
	/**Getter Method to set the Student_Id*/
	public void setStudentId(int studentId)
	{
		this.studentId = studentId;
	}
	/**Getter Method to get the Student_Name*/
	public String getStudentname()
	{
		return studentname;
	}
	/**Getter Method to set the Student_Name*/
	public void setStudentname(String studentname)
	{
		this.studentname = studentname;
	}
	/**Getter Method to get the Bank_Name*/
	public String getBankName()
	{
		return bankName;
	}
	/**Getter Method to set the Bank_Name*/
	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}
	/**Getter Method to get the AccNo*/
	public String getAccNo()
	{
		return accNo;
	}
	/**Getter Method to set the AccNo*/
	public void setAccNo(String accNo)
	{
		this.accNo = accNo;
	}
	/**Getter Method to get the ATMcardNo*/
	public String getATMcardNo()
	{
		return ATMcardNo;
	}
	/**Getter Method to set the ATMcardNo*/
	public void setATMcardNo(String atmcardNo)
	{
		this.ATMcardNo = atmcardNo;
	}	
}
