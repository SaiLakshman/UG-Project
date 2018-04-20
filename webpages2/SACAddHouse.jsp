<html>
<head>
<title> House information</title>
<script type= "text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<body>
<form name= "Addform" method= "post" action= "/Project1/sac">
<table cellspacing= "2" align= "center">
<tr>
	<th colspan="2">Add House Details</th>
</tr>
<tr class="sai1">
	<td class="sai1">House_Name</td>
	<td class="sai2"><input name= "name" type= "text"></td>
</tr>
<tr class="sai1">
<td class="sai2"><input type= "button" name= "cancel" value= "Cancel" onclick= "javascript:back()"></td>
<td class="sai2" align="right"><input type= "button" name= "add" value= "Add" onclick= "javascript:AddNewHouse()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "house">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>

