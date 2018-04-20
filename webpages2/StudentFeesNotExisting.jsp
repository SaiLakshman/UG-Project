<html>
<%@ page import= "bca.batch2011.project1.ht.*" %>
<%@ page import= "java.util.*" %>
<%@ page errorPage= "/ErrorPage.jsp" %>
<head>
<title> Fresh Allocation </title>
<script type= "text/javascript"src="HT.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<form name= "formSearch" method= "post" action= "/Project1/hostelteacher">
<% StudentFeesBean studentfeesBean= (StudentFeesBean) request.getAttribute("notexists"); %>
<table class= "Border" cellspacing= "30" cellpadding= "10">
<% String s= "";
   if(studentfeesBean.getSemester() % 2 == 1)
	s= "Odd";
   if(studentfeesBean.getSemester() % 2 == 0)
	s= "Even";   
%>
	<tr>
		<td><b><u> Year</b></u>: <%= studentfeesBean.getYear() %> </td>
		<td><b><u> Semester</b></u>: <%= s%> </td>
	</tr>
	<tr>
		<td><h3 align= "center"> No Student Fees Amount Found</h3></td> <td><input align= "right" type= "button" name= "btnFresh" value= "Fresh Allocation" onclick= "javascript: notExisting()"></td>
	</tr>
	<tr>
		<td><h3 align= "center"> For Copying the Previous Data, Please Enter the Year and Semester </h3></td>
	</tr>
	<tr>
		<td>Year: <input type= "text" name= "year"></td><td>Semester: <input type= "text" name= "semester"></td>
	</tr>
	<tr>
		<td align= "right"> <input type= "button" name= "btnCopy" value= "Copy Existing" onclick= "javascript: copyExisting()"> </td>
	</tr>
</table>
<input type= "hidden" name= "module" value= "studentfees">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "yearhidden" value= "<%= studentfeesBean.getYear() %>">
<input type= "hidden" name= "semesterhidden" value= "<%= studentfeesBean.getSemester() %>">
</form>
</body>
</html>
