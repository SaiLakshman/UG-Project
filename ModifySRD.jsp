<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<%@ page import= "bca.batch2011.project1.ha.*" %>
<%@ page import= "java.util.*" %>
<head>
<title> Modification Page</title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<% SRD s= (SRD) request.getAttribute("modify"); %>
<h1 align= "center"> Modify <%= s.getSrd_Name() %>'s Details </h1>
<form name= "formModifySRD" method= "post" action= "/Project1/hosteladmin">
<table align= "center" cellspacing= "5" cellpadding= "5">
<tr>
   <td class= "label"> SRD_Name: </td>
   <td> <input type= "text" name= "srdName" value= "<%= s.getSrd_Name()%>" > </td>
</tr>
<tr>
   <td class= "label"><input type= "button" name= "btnCancel" value= "Cancel" onclick= "javascript:cancelSRD()"></td>
   <td class= "label" align= "right"><input type= "button" name= "btnSubmit" value= "Submit" onclick= "javascript:updateSRD(<%= s.getSrd_Id() %>)"></td>
</tr>
</table>
<input type= "hidden" name= "srdId" value= "">
<input type= "hidden" name= "module" value= "srd">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
