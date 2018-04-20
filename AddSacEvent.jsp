<html>
<head>
<title> Event information</title>
<script type= "text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%
ArrayList<EventBean> eventarray1= (ArrayList<EventBean>)request.getAttribute("eventlist");
%>
<form name= "Addform" method= "post" action= "/Project1/sac">
<center><h2>Add Event Details</h2>
<table cellspacing= "2" align= "center">
<tr>
	<td class= "sai1">EventName</td>
	<td><input name= "name" type= "text"></td>
</tr>
<tr>
 	<td class= "sai1">Group/Individual:</td>
	<td> <select name= "group_individual_id">
        <option value="">SELECT
    	<option value="0">Group</option>
    	<option value="1">Individual</option>
     	</select>
    	</td>
</tr>
<tr>
 	<td class= "sai1">Sports/Athletic/Cultural:</td>
	<td> <select name= "sports_id">
        <option value= "">SELECT
    	<option value="1">Sports</option>
    	<option value="2">Cultural</option>
    	<option value="3">Athletic</option>
     	</select>
    	</td>
</tr>
<tr>
<td class= "sai2"><input type= "button" name= "cancel" value= "Cancel" onclick= "javascript:back1()"></td>
<td class="sai2" align="center"><input type= "button" name= "add" value= "Add" onclick= "javascript:AddNewEvent()"></td>
</tr>
</table>
<input type= "hidden" name= "module" value= "event">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
