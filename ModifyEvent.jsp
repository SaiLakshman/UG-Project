<html>
<head>
<title>Modification to event name</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<% Event event= (Event)request.getAttribute("modify");%>
<body>
<h1 align= "center"><font color="red"> <u>Modify Event Name</u></font></h1>
<center> 
<form action= "/Project1/campusadmin" method="post" name= "ModifyEventForm">
<table>
<tr>
	<td class="sai1">Event_Name </td>
	<td class="sai2"> <input name= "eventName" id="eventName" type= "text" value= "<%= event.getEvent_name() %>"></td>
</tr>
<tr>
<td class="sai1"><input type= "button" name= "btncancel" value= "CANCEL" align= "left" onclick= "javascript:cancelEvent()"></td>
<td class="sai2"><input type= "button" name= "btnupdate" value= "SUBMIT" onclick= "javascript:modifyEvent(<%=event.getEvent_id()%>)"></td>
</tr>
</table>
<input type="hidden" name="module" value="attendance">
<input type="hidden" name="access" value="">
<input type="hidden" name="EventId" value="">
</form>
</body>
</html>

