package bca.batch2011.project1.ca;


public class Holiday
{
	private int event_id;
	private String event_name= "",reason= "",starting= "",ending= "";

	/**
	 * Default constructor for initializing the member variables
	 * */
	public Holiday()
	{
		event_id= 0;
		event_name= "";
		reason= "";
		starting= "";
		ending= "";
	}
	/**
	 * Following are the Getter-Setter method for various mamber variables
	 * */
	public String getStarting()
	{
		return starting;
	}
	
	public void setStarting(String starting)
	{
		this.starting = starting;
	}
	
	public String getEnding()
	{
		return ending;
	}
	
	public void setEnding(String ending)
	{
		this.ending = ending;
	}
	
	public String getReason() 
	{
		return reason;
	}
	
	public void setReason(String reason)
	{
		this.reason = reason;
	}
	
	public int getEvent_id()
	{
		return event_id;
	}
	
	public void setEvent_id(int event_id)
	{
		this.event_id = event_id;
	}
	
	public String getEvent_name() {
		return event_name;
	}
	
	public void setEvent_name(String event_name)
	{
		this.event_name = event_name;
	}
}