<html>
<head>
<title> Event information</title>
<script type="text/javascript" src= "SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%@ page import= " bca.batch2011.project1.sac.*"%>
<%@ page import= "java.io.*"%>
<%@ page import= "java.util.ArrayList" %>
<%
  EventBean event= (EventBean)request.getAttribute("eventdetails");
%>
<form name= "modifyform" method= "post" action= "/Project1/sac">
<table cellspacing= "3" align= "center">
<tr>
    <th colspan= "2">Modify Event Details</th>
<tr>
<tr class= "sai1">
	<td class="sai1">Event_Name </td>
	<td class="sai2"><input type= "text" name= "name" value="<%= event.getEventname()%>"></td>
</tr>
<tr>
<td class= "sai1"> Group_Individual </td>
<td class= "sai2">
<select name= "group_individual_id">
	<option value= "0" <% if(event.getGroup_individual() == 0) out.print("selected");%>>
		Group
	</option>
	<option value= "1" <% if(event.getGroup_individual() == 1) out.print("selected");%>>
		Individual
	</option>
</select></td>
<tr>
<td class= "sai1">Sports_Cultural_Athletic </td>
<td class= "sai2">
<select name= "sports_id">
<option value= "1" <% if(event.getSports_cultural_athletic() == 1) out.print("selected");%>>
	Sports
</option>
<option value= "2" <% if(event.getSports_cultural_athletic() == 2) out.print("selected");%>>
Cultural
</option>
<option value= "3" <% if(event.getSports_cultural_athletic() == 3) out.print("selected");%>>
Athletic
</option>
</select>
<tr>
<td><input type= "button" name="btncancel" value="Cancel" onclick= "javascript:modifyback()"></td>
<td class= "sai2" align= "right"><input type= "button" name= "back" value= "Update" onclick= "javascript:modifyevent(<%= event.getEventid()%>)">
</td>
</tr>
</table>
<input type= "hidden" name= "event_id" value= "">
<input type= "hidden" name= "module" value= "event">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
