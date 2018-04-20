<html>
<head>
<title>View Holidays </title>
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
<form name= "holidaydetailsForm" method= "post" action="/Project1/campusadmin">
<% Holiday h1= (Holiday) request.getAttribute("holidaydetails");
ArrayList<Holiday> h= (ArrayList<Holiday>) request.getAttribute("hol");%>
<h1><%=h1.getEvent_name()%> Holidays List</h1>
<table border= 3>
<tr>
	<td class= "sai12">From Date</td>
	<td class= "sai13">To Date</td>
	<td class= "labelred">Reason</td>
</tr>
<%for(int i= 0; i< h.size();i++){%>
<tr>
	<td><%=h.get(i).getStarting()%></td>
	<td><%=h.get(i).getEnding()%></td>
	<td><%=h.get(i).getReason()%></a></td>
</tr>
<%}%>
<tr>
<td align="center"><input type= "button" name= "modholiday" value= "Back" onclick= "javascript:Cancel()"></td></tr>
<input type= "hidden" name= "holeveid" value="<%=h1.getEvent_id()%>">
<input type="hidden" name="module" value="holidays">
<input type="hidden" name="access" value="">

</form>
</body>
</html>
