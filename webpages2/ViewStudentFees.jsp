<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> View fees Amount </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formViewFees" method= "post" action= "/Project1/hostelteacher">
<% ArrayList<StudentFeesBean> studentfeeArray= (ArrayList<StudentFeesBean>) request.getAttribute("feesdetails"); 
   StudentFeesBean studentfees= (StudentFeesBean) request.getAttribute("feesyearsem");%>
<h1 align= "center"> Student's Information of Fees </h1>
<table align= "center" cellpadding= "10">
<% String s= "";
   if(studentfees.getSemester() % 2 == 1)
	s= "Odd";
   if(studentfees.getSemester() % 2 == 0)
	s= "Even";   
%>
<tr>
	<td><b>Year: <%= studentfees.getYear() %> </b></td>
	<td colspan= "20" align= "right"><b>Semester: <%= s %> </b></td>
</tr>
<%for(int i= 0;i < 30;i++)
  { %>
	<tr></tr>
<%}%>
<tr>
	<td class= "sai6"><b><u>Student's Name</u></b></td>
	<td class= "sai6"><b><u>Fees Name</u></b></td>
	<td class= "sai6"><b><u>Amount</b></u></td>
	<td class= "sai6"><b><u>Receipt No.</u></b></td>
</tr>
<%for(int i= 0;i< studentfeeArray.size();i++){%>
	<tr>
		<td align= "center"><%= studentfeeArray.get(i).getStudentname()%></td>
		<td align= "center"><%= studentfeeArray.get(i).getFeestype()%></td>
		<td align= "center"><%= studentfeeArray.get(i).getAmount()%></td>
		<td align= "center"><%= studentfeeArray.get(i).getReceiptno()%></td>
	</tr>
<%}%>
<tr>
	<td align= "left"><input type= "button" name= "btnBack" value= "Back" onclick= "javascript: studentcancel()"></td>
	<td align= "center"><input type= "button" name= "btnAdd" value= "Add New Student" onclick= "javascript: notExisting()"></td>
	<td colspan= "20" align= "right"><input type= "button" name= "btnModify" value= "Modify" onclick= "javascript: modifystudentFees()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "studentfees">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "yearhidden" value= "<%= studentfees.getYear()%>">
<input type= "hidden" name= "semesterhidden" value= "<%= studentfees.getSemester()%>">
</form>
</body>
</html>
