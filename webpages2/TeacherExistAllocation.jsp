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
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% 	
	TeacherAllocation get= (TeacherAllocation) request.getAttribute("allocation");
	ArrayList<TeacherAllocation> roomalloc= (ArrayList<TeacherAllocation>) request.getAttribute("roomarray");
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
	<%int l= 90;
	while(l> 2)
	{%>
	&nbsp
	<%;
		l--;
		}%>
	Semester:&nbsp;<%= a%>
	<hr>
	<table align= "center">
	<% ArrayList<ArrayList<TeacherAllocation>> BigList= (ArrayList<ArrayList<TeacherAllocation>>) request.getAttribute("StList");
		ArrayList<Room> StudentList= (ArrayList<Room>) request.getAttribute("RmList");
	    for (int i = 0; i < StudentList.size(); i++) 
	    { %>
	    	<tr><td><%=StudentList.get(i).getRoomNo()%></td></tr>
			<%for (int j= 0; j < BigList.get(i).size(); j++) 
			{%>
				<tr><td><%=BigList.get(i).get(j).getTeacherName()%></td></tr>
			<%}
	    }%>
		
		<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelAllocation()"></td>
		<%  int j= 50;
		while(j> 0)
		{
		%>
			<td></td>
		<%  j--;
			}
		%>
		<td align= "right"><input Name= "Update" type= "button" value="Modify" onclick= "javascript: teacherexistUpdate()"></td>
	</table>
	<input Name= "module" type= "hidden" value="TeacherRoomAllocation">
	<input Name= "access" type= "hidden" value="">
	<input Name= "year" type= "hidden" value="<%= get.getYear()%>">
	<input Name= "semester" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
