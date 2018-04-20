package bca.batch2011.project1.sac;
import java.sql.*;

public class EventBean {
	private int eventid;
	private String eventname;
	private int group_individual;
	private int sports_cultural_athletic;
	
	/**Default argument constructor*/
	public EventBean()
	{
		eventid= 0;
		eventname= "";
		group_individual= 0;
		sports_cultural_athletic= 0;
	}
	
	/**Multiple argument constructor*/
	public EventBean(String Eventname,int Eventid,int Group_Individual,int Sports_Cultural_Athletic)		
	{
		this.eventname= Eventname;
		this.eventid= Eventid;
		this.group_individual= Group_Individual;
		this.sports_cultural_athletic= Sports_Cultural_Athletic;
	} 
	/**
     * the following are getter setter methods of Event class
 * 
     */
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getEventname() {
		return eventname;
	}
	public void setEventname(String eventname) {
		this.eventname = eventname;
	}
	public int getGroup_individual() {
		return group_individual;
	}
	public void setGroup_individual(int group_individual) {
		this.group_individual = group_individual;
	}
	public int getSports_cultural_athletic() {
		return sports_cultural_athletic;
	}
	public void setSports_cultural_athletic(int sports_cultural_athletic) {
		this.sports_cultural_athletic = sports_cultural_athletic;
	}
}