<html>
<head>
<title>
Modify Allocation
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
	ArrayList<Room> rooms= (ArrayList<Room>) request.getAttribute("rooms");
	ArrayList<TeacherAllocation> roomarray= (ArrayList<TeacherAllocation>) request.getAttribute("roomnos");
	ArrayList<TeacherAllocation> roomallocarray= (ArrayList<TeacherAllocation>) request.getAttribute("roomallocarray");
%>
<body>
<form action="/Project1/hostelteacher" name="Modify Allocation" method="post">
	Year:&nbsp;<%= get.getYear()%>
	<% String c= "";
	if(get.getSemester() % 2 == 1)
	{
		c= "Odd";
	}
	if(get.getSemester() % 2 == 0)
	{
		c= "Even";
	}%>
	<%int l= 90;
	while(l> 2)
	{%>
	&nbsp
	<%;
		l--;
		}%>
	Semester:&nbsp;<%= c%>
	<hr>
	<table align= "center">
	<%
	for(int i= 0;i< rooms.size();i++)
	{%>
		<tr><td><%=rooms.get(i).getRoomNo()%></td></tr>
		<tr><td><select name= teachermodify>
		<%
		for(int a= 0;a< roomarray.size();a++)
		{
			for(int k= 0;k< roomallocarray.size();k++)
			{
				if(rooms.get(i).getRoomId() == roomarray.get(a).getRoomId() && roomallocarray.get(k).getTeacherName().equals(roomarray.get(a).getTeacherName()))
				{
				%>
				<option value= "<%=roomallocarray.get(k).getTeacherId()%>,<%=rooms.get(i).getRoomId()%>"><%=roomallocarray.get(k).getTeacherName()%></option>
				<option>-------------------------------------------</option>
				<%
				}
			}
			
		}%>
		<option><option>
		
		
		<%for(int b= 0;b< roomallocarray.size();b++)
			{
		%>
		
		<option value= "<%=roomallocarray.get(b).getTeacherId()%>,<%=rooms.get(i).getRoomId()%>"><%=roomallocarray.get(b).getTeacherName()%></option>
			<%}%>
		</select></td></tr>
	<%
	}
	%>
	</table>
	<table align= "center">
	<tr>
	<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelAllocation()"></td>
	<%  int j= 50;
		while(j> 0)
		{
	%>
		<td></td>
	<%  j--;
		}
	%>
	<td align= "right"><input Name= "Update" type= "button" value="Update" onclick= "javascript: updatemodifyAllocation()"></td>
	</tr>
	</table>
	<input Name= "module" type= "hidden" value="TeacherRoomAllocation">
	<input Name= "access" type= "hidden" value="">
	<input Name= "year" type= "hidden" value="<%= get.getYear()%>">
	<input Name= "semester" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
