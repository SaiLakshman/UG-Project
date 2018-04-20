<html>
<head>
<title>
Notexist Allocation
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
<body>
<% RoomAllocation get= (RoomAllocation) request.getAttribute("notexist"); %>
<form action="/Project1/hostelteacher" name="Notexist Allocation" method="post">
<table align= "center">
	<tr><td class= "sai1">Year:&nbsp;<%= get.getYear()%></td>
	<% String a= "";
	if(get.getSemester() % 2 == 1)
	{
		a= "Odd";
	}
	if(get.getSemester() % 2 == 0)
	{
		a= "Even";
	}%>
	    <td></td>
	    <td  class= "sai1" align= "right">Semester:&nbsp;<%= a%></td></tr>
	    <%  int i= 20;
		while(i> 0)
		{
		%>
		<tr></tr>
	    <%  i--;
		}
		%>
	<tr><td>No Room Allocation Found.</td>
	    <td></td>
	    <td align= "right"><input Name= "freshallocation" type= "button" value= "Fresh Allocation" onclick= "javascript: freshAllocation()"></td></tr>
	<%  int k= 20;
		while(k> 0)
		{
		%>
		<tr></tr>
	    <%  k--;
		}
		%>
	<tr><td></td>
	    <td class= "sai6">Create a copy from</td></tr>
	<%  int j= 10;
		while(j> 0)
		{
		%>
		<tr></tr>
	    <%  j--;
		}
		%>
	<tr><td>Year:&nbsp;<input Name= "year" id= "year" type= "text"></td>
	    <td></td>
	    <td>Semester:&nbsp;<input Name= "semester" id= "semester" type= "text"></td></tr>
	<%  int g= 10;
		while(g> 0)
		{
		%>
		<tr></tr>
	    <%  g--;
		}
		%>
	    <tr><td align= "left"><input Name= "cancel" type= "button" value= "Cancel" onclick= "javascript: cancelAllocation()"></td>
	    <td></td>
	    <td align= "right"><input Name= "copy" type= "button" value= "Create Copy" onclick= "javascript: copyAllocation()"></td></tr>
</table>
<input Name= "module" type= "hidden" value="RoomAllocation">
<input Name= "access" type= "hidden" value="">
<input Name= "yearhidden" type= "hidden" value="<%= get.getYear()%>">
<input Name= "semesterhidden" type= "hidden" value="<%= get.getSemester()%>">
</form> 
</body>
</html>
