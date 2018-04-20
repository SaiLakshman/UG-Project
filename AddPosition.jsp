<html>
<head>
<title> Position information</title>
<script type= "text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<body>
<form name= "Addform" method= "post" action= "/Project1/sac">
<center><h2>Add Positions</h2>
<table cellspacing= "2" align= "center">
<tr class="sai1">
	<td class="sai1">Position Title</td>
	<td class="sai2"><input name= "name" type= "text"></td>
</tr>
<tr class="sai1">
	<td class="sai1">Points</td>
	<td class="sai2"><input name= "point" type= "text"></td>

<tr class="sai1">
<td class="sai2"><input type= "button" name= "cancel" value= "Cancel" onclick= "javascript:back2()"></td>
<td class="sai2" align="right"><input type= "button" name= "add" value= "Add" onclick= "javascript:AddNewPosition()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "position">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>

