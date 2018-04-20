<html>
<head>
<title>Enter the event</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<h1 align= "center"><font color="red"> <u> Please enter the Events</u></font></h1>
<center> 
<form action= "/Project1/campusadmin" method="post" name= "EventInsertForm">
<table class= "Border" cellspacing= "5" cellpadding= "5" align="center">
	<tr>
		<td class="sai1">Event_Name:</td>
		<td><input class="text1" name= "eventName"  id= "event_name" type= "text"></td>
	</tr>
	<tr>
		<td class="sai1"><input type= "button" name= "btncancel" value= "Cancel"  onclick= "javascript:cancelEvent()"></td>
		<td align= "right"><input type= "button" name= "btninsert" value= "Insert" onclick= "javascript:insertEvent()"></td>
	</tr>
</table>
<input type="hidden" name="module" value="attendance">
<input type="hidden" name="access" value=" ">
</form>
</body>
</html>
