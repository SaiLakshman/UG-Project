<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> New Fees Amount Allocation </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formNewAllocation" method= "post" action= "/Project1/hostelteacher">
<% StudentFeesBean studentfee= (StudentFeesBean) request.getAttribute("newAllocation");
   ArrayList<Student> students= (ArrayList<Student>) request.getAttribute("studentarray");
   ArrayList<Fees_Type> type= (ArrayList<Fees_Type>) request.getAttribute("feeType");%>
<h3 align= "center"> Please Select Student,Fees Type and Enter The Amount </h3>
<table align= "center">
<% String s= "";
   if(studentfee.getSemester() % 2 == 1)
	s= "Odd";
   if(studentfee.getSemester() % 2 == 0)
	s= "Even";   
%>
<tr>
	<td><b><u>Year</b></u>: <%= studentfee.getYear() %> </td>
	<td colspan= "20" align= "right"><b><u>Semester</b></u>: <%= s %> </td>
</tr>
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
	<th>Fees_Type:</th>
	<th>Amount:</th>
	<th>Receipt_No: </th>
</tr>
<tr>

	<%for(int j= type.size();j > 0;j--)
	{%>
		<td align= "left">
			<select name= "feestype">
				<option value= ""> Select </option>
				<%for(int i= 0;i < type.size();i++)
			 	  { %>
					<option value= "<%= type.get(i).getfees_Id()%>"> <%= type.get(i).getfees_Name() %> </option>
				<%} %>	
			</select>
		</td>
		<td align= "center"><input type= "text" name= "amount"></td>
		<td colspan= "5" align= "right"><input type= "text" name= "receipt"></td>
 		</tr>
<%} %>
<tr>
	<td><input type= "button" name= "btnBack" value= "Back" onclick= "javascript: cancel()"></td>
	<td colspan= "20" align= "right"><input type= "button" name= "btnAdd" value= "Add" onclick= "javascript: addStudentFees()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "studentfees">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "year" value= "<%= studentfee.getYear()%>">
<input type= "hidden" name= "semester" value= "<%= studentfee.getSemester()%>">
</form>
</body>
</html>
