<html>
<head>
<title>
Copy Allocation
</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% 	
	RoomAllocation get= (RoomAllocation) request.getAttribute("allocation");
	ArrayList<Room> list= (ArrayList<Room>) request.getAttribute("allroom");
	ArrayList<Course> courlist= (ArrayList<Course>) request.getAttribute("courlist");
	ArrayList<RoomStudent> stulist= (ArrayList<RoomStudent>) request.getAttribute("stulist");
	ArrayList<RoomAllocation> roomalloc= (ArrayList<RoomAllocation>) request.getAttribute("roomarray");
%>
<body>
<form action="/Project1/hostelteacher" name="Copy Allocation" method="post">
	Year:&nbsp;<%= get.getYear()%>
	<% String a= "";
	if(get.getSemester() % 2 == 1)
	{
		a= "Odd";
	}
	if(get.getSemester() % 2 == 0)
	{
		a= "Even";
	}%>
	Semester:&nbsp;<%= a%>
<hr>
	<table align= "center">
	<% ArrayList<ArrayList<RoomAllocation>> BigList= (ArrayList<ArrayList<RoomAllocation>>) request.getAttribute("StList");
		ArrayList<Room> StudentList= (ArrayList<Room>) request.getAttribute("RmList");
		String s= "";
		
	    for (int i = 0; i < StudentList.size(); i++) 
	    { %>
	    	<tr><td><%=StudentList.get(i).getRoomNo()%></td></tr>
			<%for (int j= 0; j < BigList.get(i).size(); j++) 
			{%>
				<%String c= "";
				if(BigList.get(i).get(j).getBatch().equals("1"))
				{
					c= "I";
				}
				if(BigList.get(i).get(j).getBatch().equals("2"))
				{
					c= "II";
				}
				if(BigList.get(i).get(j).getBatch().equals("3"))
				{
					c= "III";
				}%>	
				<tr><td><%=BigList.get(i).get(j).getName()%>,<%=c%>-<%=BigList.get(i).get(j).getCourseName()%></td></tr>
			<%}
	    }%>
	    </table>
	    
<table align= center>
<tr>
	<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelAllocation()"></td>
</tr>
</table>
<input Name= "module" type= "hidden" value="RoomAllocation">
<input Name= "access" type= "hidden" value="">
<input Name= "yearh" type= "hidden" value="<%= get.getYear()%>">
<input Name= "semesterh" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
