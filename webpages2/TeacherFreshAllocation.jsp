<html>
<head>
<title>
Fresh Allocation
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
	ArrayList<Room> roomlist= (ArrayList<Room>) request.getAttribute("arraylist");
	ArrayList<TeacherAllocation> roomalloc= (ArrayList<TeacherAllocation>) request.getAttribute("roomalloc");
%>
<body>
<form action="/Project1/hostelteacher" name="Fresh Allocation" method="post">
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
	int k= 0;
	for(int i= 0; i< roomlist.size(); i++)
	{
	%>
		<tr>
			<td><%=roomlist.get(i).getRoomNo()%></td>
			<input Name= "roomno" type= "hidden" value="<%= roomlist.get(i).getRoomNo()%>">
				<tr><td><select name= "input">
				<option></option>
				<% for(int j= 0;j< roomalloc.size();j++)
				{
				%>
					<option value="<%=roomalloc.get(j).getTeacherId()%>"><%=roomalloc.get(j).getTeacherName()%></option>
				<%
				}
				%>
				</select>
			</td></tr>
		</tr>
	<%
	}
	%>
	
	</table>
<table align= center>
<tr>
	<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelfreshAllocation()"></td>
	<%  int j= 50;
		while(j> 0)
		{
	%>
		<td></td>
	<%  j--;
		}
	%>
	<td align= "right"><input Name= "Update" type= "button" value="Update" onclick= "javascript: teacherupdateAllocation()"></td>
</tr>
</table>
<input Name= "module" type= "hidden" value="TeacherRoomAllocation">
<input Name= "access" type= "hidden" value="">
<input Name= "yearh" type= "hidden" value="<%= get.getYear()%>">
<input Name= "semesterh" type= "hidden" value="<%= get.getSemester()%>">
<input Name= "roomlistsize" type= "hidden" value="<%=roomlist.size()%>">
<input Name= "roomallocsize" type= "hidden" value="<%=roomalloc.size()%>">
</form>
</body>
</html>
