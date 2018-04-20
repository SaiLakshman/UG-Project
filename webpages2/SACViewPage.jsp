<html>
<head>
<title>View Houses</title>
<script type= "text/javascript"
src="SAC.js">
</script>
<link rel= stylesheet href= "style.css">
</head>
<%@ page import= "bca.batch2011.project1.sac.*"%>
<%@ page import="java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<% int year=Calendar.getInstance().getWeekYear();%>
<form name="formviewstudents" method= "post" action="/Project1/sac">
<table align= center>
<td>Year</td>
	<td><select name="year">
	<%for(int i= 5;i> -5;i--)
	  {%>
	 	<option value= "<%=year-1-i%>"><%=year-1-i%></option>
	<%}%>
</select></td>
<tr>
	<td class="label"><input type= "button" name= "check" value= "SUBMIT" onclick="javascript:checking()"></td>
</tr>
</table>
<input type= "hidden" name="module" value="houseevent">
<input type= "hidden" name="access" value="">
<input type="hidden"  name="house_id" value="">
</form>
</body>
</html>
