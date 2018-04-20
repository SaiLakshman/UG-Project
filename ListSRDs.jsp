<html>
<%@ page import= "bca.batch2011.project1.ha.*" %>
<%@ page import= "java.util.*" %>
<%@ page import= "java.sql.*" %>
<head>
<title> Self Reliance Department </title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<h1 align= "center"> List of Self Reliance Department </h1>
<h2 align= "center">[Click on SRD_Name to Modify] </h2>
<form name= "formListSRDs" method= "post" action= "/Project1/hosteladmin">
<% ArrayList<SRD> srd=  (ArrayList<SRD>)request.getAttribute("show"); %>
<table class= "Border" align= "center" cellpadding= "10" cellspacing= "5">
<tr>
   <th class= "sai6">        </th>
   <th class= "labelred">SRD_Name: </th>
</tr>
<% 
String style= "";
for(int i= 0;i < srd.size();i++)
{
	if(i % 2 == 0)
		style= "sai1";
	else
		style= "sai2";
%>
<tr class= "sai1">
  <td class= "<%=style%>" align= "center"><input type= "checkbox" name= "deleteBox" value= "<%= srd.get(i).getSrd_Id()%>"></td>
  <td class= "<%=style%>" align= "center"> <a href= "javascript:modifySRD(<%= srd.get(i).getSrd_Id()%>)"> <%= srd.get(i).getSrd_Name() %> </a></td>
<% } %>
</tr>
<tr>
   <td class= "txt"><input type= "button" name= "btnDelete" value= "Delete" onclick= "javascript:DeleteSRD()"></td>
   <td class= "txt" align= "right"><input type= "button" name= "btnAddNewStudent" value= "Add New SRD" onclick= "javascript:addSRD()"></td>
</tr>
</table>

<input type= "hidden" name= "srdId" value= "">
<input type= "hidden" name= "module" value= "srd">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
