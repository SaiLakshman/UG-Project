<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> Student Bank Allocation </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formNewAllocation" method= "post" action= "/Project1/hostelteacher">
<%ArrayList<Student> students= (ArrayList<Student>) request.getAttribute("studentarray");%>
<h3 align= "center"> Please Select Student and Enter The Details </h3>
<table align= "center">
<% for(int i= 0;i < 30;i++)
   { %>
	<tr></tr>
  <% } %>
<tr>
	<th>Student Name:</th>
	<td>
		<select name= "student">
			<option value= ""> Select </option>
			<%for(int j= 0;j < students.size();j++)
			  { %>
				<option value= "<%= students.get(j).getStudentId()%>"> <%= students.get(j).getName()%></option>
			<%} %>
		</select>
	</td>
</tr>
<tr>
	<th>Bank_Name:</th>
	<th>Account_No:</th>
	<th>ATM_Card_No: </th>
</tr>
<tr>
	
	<%for(int i= 0;i < 3;i++){%>
	<tr>
		<td align= "left"><input type= "text" name= "bankname"></td>
		<td align= "center""><input type= "text" name= "accno"></td>
		<td 	align= "right"><input type= "text" name= "atmcard"></td>
	</tr>
	<%}%>
</tr>
<tr>
	<td><input type= "button" name= "btnBack" value= "Back" onclick= "javascript: cancel()"></td>
	<td colspan= "20" align= "right"><input type= "button" name= "btnAdd" value= "Add" onclick= "javascript: addStudentbank()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "studentbank">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
