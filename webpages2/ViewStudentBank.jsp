<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> View Student Bank </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formViewBank" method= "post" action= "/Project1/hostelteacher">
<% ArrayList<Student_Bank> bankarray= (ArrayList<Student_Bank>) request.getAttribute("bank"); %>
<h1 align= "center"> Student's Information of Bank </h1>
<h3 align= "center"> (Click on Name to Modify) </h3> 
<table align= "center" cellpadding= "10">
<%for(int i= 0;i < 30;i++)
  { %>
	<tr></tr>
<%}%>
<tr>
	<td class= "sai6"><b><u>Student Name</u></b></td>
	<td class= "sai6"><b><u>Bank Name</u></b></td>
	<td class= "sai6"><b><u>Account No</b></u></td>
	<td class= "sai6"><b><u>ATM_Card_No</u></b></td>
</tr>
<%for(int i= 0;i< bankarray.size();i++){%>
	<tr>
		<td align= "center"><a href= "javascript: modifystudentbank(<%=bankarray.get(i).getStudentId()%>)"><%= bankarray.get(i).getStudentname()%></td>
		<td align= "center"><%= bankarray.get(i).getBankName()%></td>
		<td align= "center"><%= bankarray.get(i).getAccNo()%></td>
		<td align= "center"><%= bankarray.get(i).getATMcardNo()%></td>
	</tr>
<%}%>
<tr>
	<td colspan= "4" align= "right"><input type= "button" name= "btnAdd" value= "Add New Student" onclick= "javascript: banknotExists()"></td>
</tr>
</table>
<input type= "hidden" name= "studentId" value= "">
<input type= "hidden" name= "module" value= "studentbank">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
