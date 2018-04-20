package bca.batch2011.project1.ca;

public class PaperBean
{
	private int paperid;
	private String papertitle="";
	
	/**
	 * Default constructor for initializing the member variables 
	 **/
	public PaperBean()
	{
		paperid= 0;
		papertitle="";
	}
	
	/**
	 * Following are the Getter-Setter methods for the member variables
	 * */
	public int getPaperid()
	{
		return paperid;
	}

	public void setPaperid(int paperid) 
	{
		this.paperid = paperid;
	}

	public String getPapertitle() 
	{
		return papertitle;
	}

	public void setPapertitle(String papertitle) 
	{
		this.papertitle = papertitle;
	}
}