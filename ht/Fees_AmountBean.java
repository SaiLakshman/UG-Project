package bca.batch2011.project1.ht;

public class Fees_AmountBean
{
	private int fees_Id;
	private int amount;
	private int year;
	private int semester;
	private String feestype;
	/**This is the Default Constructor*/
	public Fees_AmountBean()
	{
		this.fees_Id= 0;
		this.amount= 0;
		this.year= 0;
		this.semester= 0;
	}
	/**This is a Multiple Argument Constructor*/
	public Fees_AmountBean(int fees_Id,int amount,int year,int semester)
	{
		this.fees_Id= fees_Id;
		this.amount= amount;
		this.year= year;
		this.semester= semester;
	}
	/**Getter Method to get the Fees_Id*/
	public int getFees_Id()
	{
		return fees_Id;
	}
	/**Setter Method to set the Fees_Id*/
	public void setFees_Id(int fees_Id)
	{
		this.fees_Id = fees_Id;
	}
	/**Getter Method to get the Fees_Type*/
	public String getFeestype()
	{
		return feestype;
	}
	/**Setter Method to set the Fees_Id*/
	public void setFeestype(String feestype)
	{
		this.feestype = feestype;
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
}