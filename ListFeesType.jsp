<html>
<%@ page import= "bca.batch2011.project1.ha.*" %>
<%@ page import= "java.util.*" %>
<%@ page import= "java.sql.*" %>
<head>
<title> Fees Types </title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<h1 align= "center"> List of Fees Types </h1>
<h2 align= "center">[Click on Fees_Name to Modify] </h2>
<form name= "formListFees" method= "post" action= "/Project1/hosteladmin">
<% ArrayList<Fees_Type> fees=  (ArrayList<Fees_Type>)request.getAttribute("show"); %>
<table align= "center" cellspacing= "3" cellpadding= "3">
<tr>
   <th class= "sai6">        </th>
   <th class= "labelred">Fees_Name: </th>
</tr>
<% 
String style= "";
for(int i= 0;i < fees.size();i++)
{
	if(i % 2 == 0)
		style= "sai1";
	else
		style= "sai2";
%>
<tr class= "sai1">
  <td class= "<%=style%>"><input type= "checkbox" name= "deleteBox" value= "<%= fees.get(i).getfees_Id()%>"></td>
  <td class= "<%=style%>"><a href= "javascript:modifyFees(<%= fees.get(i).getfees_Id()%>)"> <%= fees.get(i).getfees_Name() %> </a>
  </td>
<% } %>
</tr>
<tr>
   <td align= "left" class= "sai6"><input type= "button" name= "btnDelete" value= "Delete" onclick= "javascript:DeleteFees()"></td>
   <td align= "right" class= "sai6"><input type= "button" name= "btnAddNewStudent" value= "Add New Fees_Type" onclick= "javascript:addFees()"></td>
</tr>
</table>

<input type= "hidden" name= "feesId" value= "">
<input type= "hidden" name= "module" value= "fees">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
