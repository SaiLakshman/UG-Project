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
<% ArrayList<Fees_AmountBean> feeArray= (ArrayList<Fees_AmountBean>) request.getAttribute("feesdetails"); 
   Fees_AmountBean fees= (Fees_AmountBean) request.getAttribute("feesyearsem");%>
<h1 align= "center"> The Fees and Amount </h1>
<table align= "center">
<% String s= "";
   if(fees.getSemester() % 2 == 1)
	s= "Odd";
   if(fees.getSemester() % 2 == 0)
	s= "Even";   
%>
<tr>
	<td><b>Year: <%= fees.getYear() %> </b></td>
	<td><b>Semester: <%= s %> </b></td>
</tr>
<%for(int i= 0;i < 30;i++)
  { %>
	<tr></tr>
<%}%>
<tr>
	<th class= "sai6"><b><u>Fees Name</u></b></th>
	<th class= "sai6"><b><u>Amount</b></u></th>
</tr>
<%for(int i= 0;i<feeArray.size();i++){%>
	<tr>
		<td align= "center"><%=feeArray.get(i).getFeestype()%></td>
		<td align= "center"><%=feeArray.get(i).getAmount()%></td>
	</tr>
<%}%>
<tr>
	<td align= "left"><input type= "button" name= "btnBack" value= "Back" onclick= "javascript: feescancel()"></td>
	<td><input type= "button" name= "btnAdd" value= "New FeeAmount" onclick= "javascript: notExists()"></td>
	<td align= "right"><input type= "button" name= "btnModify" value= "Modify" onclick= "javascript: modifyfeesAmount()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "fees_Amount">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "yearhidden" value= "<%= fees.getYear()%>">
<input type= "hidden" name= "semesterhidden" value= "<%= fees.getSemester()%>">
</form>
</body>
</html>
