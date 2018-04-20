package bca.batch2011.project1.ca;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddressBean
{
	private String line1;
	private String line2;
	private String line3;
	private String place;
	private String state;
	private String pincode;
	private int addresstype;
	
	/**This is a default constructor*/
	public AddressBean()
	{
		line1= "";
		line2= "";
		line3= "";
		place= "";
		state= "";
		pincode= "";
		addresstype= 0;
	}

	/**This is an multiple argument constructor for initializing a variable*/
	public AddressBean(String line1, String line2, String line3, String place,
			String state, String pincode, int addresstype)
	{
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.place = place;
		this.state = state;
		this.pincode = pincode;
		this.addresstype = addresstype;
	}
	
	/**This is Getter method for getting Line1*/
	public String getLine1()
	{
		return line1;
	}

	/**This is Setter method for setting Line1*/
	public void setLine1(String line1)
	{
		this.line1 = line1;
	}

	/**This is Getter method for getting Line2*/
	public String getLine2()
	{
		return line2;
	}

	/**This is Setter method for setting Line2*/
	public void setLine2(String line2)
	{
		this.line2 = line2;
	}

	/**This is Getter method for getting Line3*/
	public String getLine3()
	{
		return line3;
	}

	/**This is Setter method for setting Line3*/
	public void setLine3(String line3)
	{
		this.line3 = line3;
	}

	/**This is Getter method for getting Place*/
	public String getPlace()
	{
		return place;
	}

	/**This is Setter method for setting Place*/
	public void setPlace(String place)
	{
		this.place = place;
	}
	
	/**This is Getter method for getting State*/
	public String getState()
	{
		return state;
	}

	/**This is Setter method for setting State*/
	public void setState(String state)
	{
		this.state = state;
	}

	/**This is Getter method for getting Pin code*/
	public String getPincode()
	{
		return pincode;
	}

	/**This is Setter method for setting Pin code*/
	public void setPincode(String pincode)
	{
		this.pincode = pincode;
	}

	/**This is Getter method for gettin Addresstype*/
	public int getAddresstype() 
	{
		return addresstype;
	}

	/**This is Setter method for setting Addresstype*/
	public void setAddresstype(int addresstype)
	{
		this.addresstype = addresstype;
	}

	/**This is static method for getting the values from jsps*/
	public static AddressBean[] insertAddress(HttpServletRequest req,PrintWriter out)
	{
		AddressBean[] addresses= new AddressBean[4];
		AddressBean address= new AddressBean();
		String[] line1= req.getParameterValues("line1");
		String[] line2= req.getParameterValues("line2");
		String[] line3= req.getParameterValues("line3");
		String[] place= req.getParameterValues("place");
		String[] state= req.getParameterValues("state");
		String[] pincode= req.getParameterValues("pincode");
		String[] type= req.getParameterValues("addrtype");
		for(int i= 0;i < line1.length;i++)
		{
			if(!line1.equals(""))
			{
				address.setLine1(line1[i]);
				address.setLine2(line2[i]);
				address.setLine3(line3[i]);
				address.setPlace(place[i]);
				address.setState(state[i]);
				address.setPincode(pincode[i]);
				if(!type[i].equals(""))
				{	
					address.setAddresstype(Integer.parseInt(type[i]));
				}
				addresses[i]= address;
				if(line1[i].equals(""))
				{
					address.setLine1("Not Entered");
					address.setLine2("Not Entered");
					address.setLine3("Not Entered");
					address.setPlace("Not Entered");
					address.setState("Not Entered");
					address.setPincode("Not Entered");
					if(type[i].equals(""))
					{
						address.setAddresstype(0);
					}
					addresses[i]= address;
				}
				address= new AddressBean();
			}
		}
		return addresses;
	}
}