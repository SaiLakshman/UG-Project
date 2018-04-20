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
<form name= "formModifyAllocation" method= "post" action= "/Project1/hostelteacher">
<% Fees_AmountBean fee= (Fees_AmountBean) request.getAttribute("yearnsem");
   ArrayList<Fees_AmountBean> fees= (ArrayList<Fees_AmountBean>) request.getAttribute("feesAmount");
   ArrayList<Fees_Type> feetype= (ArrayList<Fees_Type>) request.getAttribute("fees");%>
<table align= "center">
<tr>
	<td><h3 align= "center"> Modification of Fees Type and Amount </h3></td>
</tr>
<% String s= "";
   if(fee.getSemester() % 2 == 1)
	s= "Odd";
   if(fee.getSemester() % 2 == 0)
	s= "Even";   
%>
<tr>
	<td align= "left"><b><u>Year</b></u>: <%= fee.getYear() %> </td>
	<td align= "right"><b><u>Semester</b></u>: <%= s %> </td>
</tr>
<%for(int i= 0;i < 30;i++)
  {%>
	<tr></tr>
<%}%>
<tr>
	<th class= "sai6">Fees_Type: </th>
	<th class= "sai6">Amount:    </th>
</tr>

<%
  for(int i= 0;i < fees.size();i++)
  {%> 
	<tr>
		<td align= "center"><select name= "feesname">
			<option value= "">Select</option> 
   	<%for(int j= 0; j < feetype.size();j++)
	  {%>
	  	<option value= "<%= feetype.get(j).getfees_Id()%>"<% if(feetype.get(j).getfees_Id() == fees.get(i).getFees_Id()) out.print("selected");%>><%= feetype.get(j).getfees_Name()%></option>
        <%} %>
		</select></td>
		<td>
			<input type= "text" name= "modamount" value= "<%=fees.get(i).getAmount()%>">
	</td></tr>
<%}
  for(int i = fees.size();i<feetype.size();i++)
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
	</td></tr>
<%}%>
  
<tr>
	<td class= "input.btn"><input type= "button" name= "back" value= "Back to View" onclick= "javascript: searchFees()">
	<td class= "input.btn"><input type= "button" name= "btnUpdate" value= "Update" onclick= "javascript: updatefeestype()">
</tr>
</table>
<input type= "hidden" name= "module" value= "fees_Amount">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "year" value= "<%= fee.getYear()%>">
<input type= "hidden" name= "semester" value= "<%= fee.getSemester()%>">
</form>
</body>
</html>
