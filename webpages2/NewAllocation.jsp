<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> New Fees Amount Allocation </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
<form name= "formNewAllocation" method= "post" action= "/Project1/hostelteacher">
<% Fees_AmountBean fee= (Fees_AmountBean) request.getAttribute("newAllocation");
   ArrayList<Fees_Type> type= (ArrayList<Fees_Type>) request.getAttribute("feeType");%>
<table align= "center">
<tr>
	<td><h3 align= "center"> Please Select The Fees Type and Enter The Amount </h3></td>
</tr>
<% String s= "";
   if(fee.getSemester() % 2 == 1)
	s= "Odd";
   if(fee.getSemester() % 2 == 0)
	s= "Even";   
%>
<tr>
	<td>Year: <%= fee.getYear() %> </td>
	<td>Semester: <%= s %> </td>
</tr>
</table>
<table align= "center">
<% for(int i= 0;i < 30;i++)
   { %>
	<tr></tr>
  <% } %>
<tr>
	<td>Fees_Type:</td>
	<td align= "center"><select name= "feestype">
		<option value= ""> Select </option>
		<%for(int i= 0;i < type.size();i++)
		  { %>
			<option value= "<%= type.get(i).getfees_Id()%>"> <%= type.get(i).getfees_Name() %> </option>
		<%} %>	
	</select></td>
</tr>
<tr>
	<td>Amount:</td>
	<td align= "center"><input type= "text" name= "amount"></td>
 </tr>
<tr>
	<td><input type= "button" name= "btnBack" value= "Back" onclick= "javascript: feescancel()"></td>
	<td align= "right"><input type= "button" name= "btnAdd" value= "Add" onclick= "javascript: addFeesAmount()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "fees_Amount">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "year" value= "<%= fee.getYear()%>">
<input type= "hidden" name= "semester" value= "<%= fee.getSemester()%>">
</form>
</body>
</html>
