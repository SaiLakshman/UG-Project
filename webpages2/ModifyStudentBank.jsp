<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> Modification in Student Bank Allocation </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formModifyAllocation" method= "post" action= "/Project1/hostelteacher">
<% ArrayList<Student_Bank> bank= (ArrayList<Student_Bank>) request.getAttribute("bank");
   ArrayList<Student> stu= (ArrayList<Student>) request.getAttribute("studentarray");%>
<h3 align= "center"> Modification of Student Bank Information </h3>
<table align= "center">
<%for(int i= 0;i < 30;i++)
  {%>
	<tr></tr>
<%}%>
<tr>
	<th class= "sai6">Student Name </th>
	<th class= "sai6">Bank Name </th>
	<th class= "sai6">Account No  </th>
	<th class= "sai6">ATM_Card_No </th> 
</tr>
<%
  for(int i= 0;i < bank.size();i++)
  {
%> 
	<tr>
		<td align= "center"><select name= "name">
			<option value= "">Select </option>
			<%for(int k= 0;k < stu.size();k++)
			  {%>
		
				<option value= "<%= stu.get(k).getStudentId()%>"<% if(stu.get(k).getStudentId() == bank.get(i).getStudentId()) out.print("selected");%>><%= stu.get(k).getName()%> </option>
			<%}%>
			</select></td>
		<td>
			<input type= "text" name= "modbank" value= "<%=bank.get(i).getBankName()%>">
		</td>
		<td>
			<input type= "text" name= "modaccno" value="<%=bank.get(i).getAccNo()%>">   
		</td>
		<td>
			<input type= "text" name= "modatm" value= "<%= bank.get(i).getATMcardNo()%>">
		</td></tr>
 <%}%>
  
<tr>
	<td><input type= "button" name= "back" value= "Back to View" onclick= "javascript: cancel()">
	<td colspan= "20" align= "right"><input type= "button" name= "btnUpdate" value= "Update" onclick= "javascript: updatestudentbank()">
</tr>
</table>
<input type= "hidden" name= "studentId" value= "">
<input type= "hidden" name= "module" value= "studentbank">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
