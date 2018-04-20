<html>
<head>
<title>Event Holidays list</title>
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
<form name= "EventholidaysForm" method= "post" action="/Project1/campusadmin">
<h1>Event Holiday List</h1>
<% ArrayList<Event> show= (ArrayList<Event>) request.getAttribute("sai");%>
<table>
<tr>
<td class= "sai11"><strong>Event:</strong>
<select name="holeveid" id="holeveid">
<option value="">SELECT</option>
<%
 for(int i= 0;i < show.size();i++)
{
%>
<option value="<%= show.get(i).getEvent_id() %>"><%=show.get(i).getEvent_name()%></option>
<%
}
%>
</select> </td></tr><br>
<tr>
<td class= "sai12">Holiday</td><td class= "sai14"> From Date:<input type="text" name="starting" id="starting" placeholder="yyyy-mm-dd"></td>
<td class= "sai13">To Date:<input type="text" name="ending" id="ending" placeholder="yyyy-mm-dd"></td>
</tr>
<tr>
<td class= "labelred">Reason: </td><td><input type="text" name="reason" id="reason" placeholder="Not more than 50 letters"></td>
</tr>
<tr>
<td align="center"><input type= "button" name= "modholiday" value= "View HOLIDAYS" onclick= "javascript:viewhol()"></td>
<td align="center"><input type= "button" name= "modholiday" value= "Set HOLIDAY" onclick= "javascript:inshol()"></td></tr>
<input type= "hidden" name= "holeveid" value="">
<input type="hidden" name="module" value="holidays">
<input type="hidden" name="access" value="">

</form>
</body>
</html>
