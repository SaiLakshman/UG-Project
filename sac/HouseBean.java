package bca.batch2011.project1.sac;

public class HouseBean 
{
	int houseId;
	int Eventid;
	int Positionid;
	int Year;
	String Eventname=null;
	String houseName=null;
	String Positionname=null;
	public HouseBean()// default constructor//
	{
		
	}
	/**
     * the following are getter setter methods of HouseBean class
     */
	
	public int getHouseid()
	{
		return houseId;
	}
	public void setHouseid(int houseid)
	{
		houseId = houseid;
	}
	public int getEventid()
	{
		return Eventid;
	}
	public void setEventid(int eventid) 
	{
		Eventid = eventid;
	}
	public int getPositionid() 
	{
		return Positionid;
	}
	public void setPositionid(int positionid)
	{
		Positionid = positionid;
	}
	public int getYear() 
	{
		return Year;
	}
	public void setYear(int year) 
	{
		Year = year;
	}
	public String getEventname() 
	{
		return Eventname;
	}
	public void setEventname(String eventname) 
	{
		Eventname = eventname;
	}
	public String getHouseName()
	{
		return houseName;
	}
	public void setHouseName(String houseName) 
	{
		this.houseName = houseName;
	}
	public String getPositionname() {
		return Positionname;
	}
	public void setPositionname(String positionname) {
		Positionname = positionname;
	}
}