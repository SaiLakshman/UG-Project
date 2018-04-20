<html>
<head>
<title>Events</title>
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
<center>
<form name= "EventsForm" method= "post" action="/Project1/campusadmin">
<h1>List of Events</h1>
<p>[click on the event name to modify it]</p>
<% ArrayList<Event> event= (ArrayList<Event>) request.getAttribute("show");%>
<table class= "Border" cellspacing= "5" cellpadding= "10">
<tr>
<th class= "sai1">		 </th>
<th class= "labelred">Event Name </th>
</tr>
<%
String style= "";
for(int i= 0;i < event.size();i++)
{
	if(i%2 == 0)
		style= "sai1";
	else
		style= "sai2";
%>
<tr class= "sai1">
 <td class="<%=style%>"><input type= "checkbox" name= "deleteBox" value= "<%= event.get(i).getEvent_id() %>"></td>
<td class= "sai1"><a href= "javascript:submissioneve(<%= event.get(i).getEvent_id() %>)"><%=event.get(i).getEvent_name()%></a></td>
</tr>
<%
}
%>
</table>
<input type= "hidden" name= "EventId" value="">
<input type="hidden" name="module" value="attendance">
<input type="hidden" name="access" value="">
<td class= "label"><input type= "button" name= "btndelete" value= "DELETE" onclick= "javascript:delEvent()">
<td class= "label"><input type= "button" name= "btnaddnewevent" value= "ADD NEW EVENT" onclick= "javascript:addnewevent()">
</form>
</body>
</html>
