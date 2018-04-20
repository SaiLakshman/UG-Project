package bca.batch2011.project1.sac;
import java.sql.*;
public class PositionBean {
	private int positionid;
	private String positiontitle;
	private int points;
	public PositionBean()
	{
		positionid= 0;
		positiontitle= "";
		points= 0;
	}
	public PositionBean(String Positiontitle,int Positionid,int Points)	//Two argument constructor//
	{
		this.positiontitle= Positiontitle;
		this.positionid= Positionid;
		this.points= Points;
	}
	// the following are the getter setter methods of position bean class//
	public String getPositiontitle() {
		return positiontitle;
	}
	public void setPositiontitle(String positiontitle) {
		this.positiontitle = positiontitle;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	} 
}