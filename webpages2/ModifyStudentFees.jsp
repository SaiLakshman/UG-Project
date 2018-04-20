<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> Modification in Student Fees Allocation </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formModifyAllocation" method= "post" action= "/Project1/hostelteacher">
<% StudentFeesBean studentfee= (StudentFeesBean) request.getAttribute("yearnsem");
   ArrayList<StudentFeesBean> studentfees= (ArrayList<StudentFeesBean>) request.getAttribute("feesAmount");
   ArrayList<Fees_Type> feetype= (ArrayList<Fees_Type>) request.getAttribute("fees");
   ArrayList<Student> stu= (ArrayList<Student>) request.getAttribute("students");
   ArrayList<Fees_AmountBean> fee= (ArrayList<Fees_AmountBean>) request.getAttribute("amount");%>
	<h3 align= "center"> Modification of Student Fees and Amount </h3>
<table align= "center">
<tr>
</tr>
<% String s= "";
   if(studentfee.getSemester() % 2 == 1)
	s= "Odd";
   if(studentfee.getSemester() % 2 == 0)
	s= "Even";   
%>
<tr>
	<td align= "left"><b><u>Year</b></u>: <%= studentfee.getYear() %> </td>
	<td colspan= "20" align= "right"><b><u>Semester</b></u>: <%= s %> </td>
</tr>
<%for(int i= 0;i < 30;i++)
  {%>
	<tr></tr>
<%}%>
<tr>
	<th class= "sai6">Student Name </th>
	<th class= "sai6">Fees_Type </th>
	<th class= "sai6">Amount  </th>
	<th class= "sai6">Balance </th> 
	<th class= "sai6">Receipt_No </th>
</tr>
<%
  for(int i= 0;i < studentfees.size();i++)
  {
%> 
	<tr>
		<td align= "center"><select name= "name">
			<option value= "">Select </option>
			<%for(int k= 0;k < stu.size();k++)
			  {%>
		
				<option value= "<%= stu.get(k).getStudentId()%>"<% if(stu.get(k).getStudentId() == studentfees.get(i).getStudentId()) out.print("selected");%>><%= stu.get(k).getName()%> </option>
			<%}%>
			</select></td>
		<td align= "center"><select name= "feesname">
			<option value= "">Select</option> 
   	<%for(int j= 0; j < feetype.size();j++)
	  {%>
	  	<option value= "<%= feetype.get(j).getfees_Id()%>"<% if(feetype.get(j).getfees_Id() == studentfees.get(i).getFeesId()) out.print("selected");%>><%= feetype.get(j).getfees_Name()%></option>
        <%} %>
		</select></td>
		<td>
			<input type= "text" name= "modamount" value= "<%=studentfees.get(i).getAmount()%>">
		</td>
		<td>
			<input type= "text" name= "modbalance" value="<%=fee.get(i).getAmount()-studentfees.get(i).getAmount()%>">   
		</td>
		<td>
			<input type= "text" name= "modreceipt" value= "<%= studentfees.get(i).getReceiptno()%>">
		</td></tr>
<%}
  for(int i = studentfees.size();i<feetype.size();i++)
  {%> 
	<tr>
		<td align= "center"><select name= "feesname">
			<option value= "">Select</option> 
   	<%for(int j= 0; j < feetype.size();j++)
	  {%>
	  	<option value= "<%= feetype.get(j).getfees_Id()%>"><%= feetype.get(j).getfees_Name()%></option>
        <%} %>
		</select></td>
		<td>
			<input type= "text" name= "modamount" value= "">
		</td>
		<td>
			<input type= "text" name= "modbalance" value= "">	
		</td>
		<td>
			<input type= "text" name= "modreceipt" value= "">
		</td></tr>
<%}%>
  
<tr>
	<td><input type= "button" name= "back" value= "Back to View" onclick= "javascript: searchStudentfees()">
	<td colspan= "20" align= "right"><input type= "button" name= "btnUpdate" value= "Update" onclick= "javascript: updatestudentFees()">
</tr>
</table>
<input type= "hidden" name= "module" value= "studentfees">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "year" value= "<%= studentfee.getYear()%>">
<input type= "hidden" name= "semester" value= "<%= studentfee.getSemester()%>">
</form>
</body>
</html>
