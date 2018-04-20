<html>
<head>
<title>
Exist Allocation
</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% 	
	RoomAllocation get= (RoomAllocation) request.getAttribute("allocation");
	ArrayList<RoomAllocation> roomalloc= (ArrayList<RoomAllocation>) request.getAttribute("roomarray");
	ArrayList<Room> rooms= (ArrayList<Room>) request.getAttribute("allroom");
%>
<body>
<form action="/Project1/hostelteacher" name="Exist Allocation" method="post">
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
	    for (int i = 0; i < StudentList.size(); i++) 
	    { %>
	    	<tr><td><%=StudentList.get(i).getRoomNo()%></td></tr>
			<%for (int j= 0; j < BigList.get(i).size(); j++) 
			{%>
				<%String s= "";
				if(BigList.get(i).get(j).getBatch().equals("1"))
				{
					s= "I";
				}
				if(BigList.get(i).get(j).getBatch().equals("2"))
				{
					s= "II";
				}
				if(BigList.get(i).get(j).getBatch().equals("3"))
				{
					s= "III";
				}%>
				<tr><td><%=BigList.get(i).get(j).getName()%>,<%=s%>-<%=BigList.get(i).get(j).getCourseName()%></td></tr>
			<%}
	    }%>
		
		<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelAllocation()"></td>
		<td></td>
		<td align= "right"><input Name= "Update" type= "button" value="Modify" onclick= "javascript: existUpdate()"></td>
	</table>
	<input Name= "module" type= "hidden" value="RoomAllocation">
	<input Name= "access" type= "hidden" value="">
	
	<input Name= "year" type= "hidden" value="<%= get.getYear()%>">
	<input Name= "semester" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
