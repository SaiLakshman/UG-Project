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
<% Fees_Type fees= (Fees_Type) request.getAttribute("modify"); %>
<h1 align= "center"> Modify <%= fees.getfees_Name() %>'s Details </h1>
<form name= "formModifyFees" method= "post" action= "/Project1/hosteladmin">
<table class= "Border" align= "center" cellspacing= "5" cellpadding= "5" border= "1">
<tr>
   <td class= "sai3"> Fees_Name: </td>
   <td class= "sai6"> <input type= "text" name= "feesName" value= "<%= fees.getfees_Name()%>" > </td>
</tr>
<tr>
   <td class= "label"><input type= "button" name= "btnCancel" value= "Cancel" onclick= "javascript:cancelFees()"></td>
   <td class= "label" align= "right"><input type= "button" name= "btnSubmit" value= "Submit" onclick= "javascript:updateFees(<%= fees.getfees_Id() %>)"></td>
</tr>
</table>
<input type= "hidden" name= "feesId" value= "">
<input type= "hidden" name= "module" value= "fees">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
