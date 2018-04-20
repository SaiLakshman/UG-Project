<html>
<head>
<title>Set Syllabus</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ct.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<center>
<form name= "coursesetpaperForm" method= "post" action="/Project1/campusteacher">
<h1><u>SelectPapers</u></h1>
<% ArrayList<Papers_Course> show= (ArrayList<Papers_Course>) request.getAttribute("papers");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
%>
<table>
<tr>
<td><strong>1st SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 11; cnt++)
	{
	%>
		<td><input type= "text" name="1code" value="">
		<select name="1paperid" id="papername">
		<option value="">SELECT</option>
		<%
 		for(int i= 0;i < show.size();i++)
		{
		%>
				<option value="<%= show.get(i).getPaper_id() %>"><%=show.get(i).getPaper_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<td><strong>2nd SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 11; cnt++)
	{
	%>
		<td><input type= "text" name="2code" value="">
		<select name="2paperid" id="papername">
		<option value="">SELECT</option>
		<%
 		for(int i= 0;i < show.size();i++)
		{
		%>
				<option value="<%= show.get(i).getPaper_id() %>"><%=show.get(i).getPaper_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<td><strong>3rd SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 11; cnt++)
	{
	%>
		<td><input type= "text" name="3code" value="">
		<select name="3paperid" id="papername">
		<option value="">SELECT</option>
		<%
 		for(int i= 0;i < show.size();i++)
		{
		%>
				<option value="<%= show.get(i).getPaper_id() %>"><%=show.get(i).getPaper_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<td><strong>4th SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 11; cnt++)
	{
	%>
		<td><input type= "text" name="4code" value="">
		<select name="4paperid" id="papername">
		<option value="">SELECT</option>
		<%
 		for(int i= 0;i < show.size();i++)
		{
		%>
				<option value="<%= show.get(i).getPaper_id() %>"><%=show.get(i).getPaper_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%if(c.getDuration()>2){%>
<td><strong>5th SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 11; cnt++)
	{
	%>
		<td><input type= "text" name="5code" value="">
		<select name="5paperid" id="papername">
		<option value="">SELECT</option>
		<%
 		for(int i= 0;i < show.size();i++)
		{
		%>
				<option value="<%= show.get(i).getPaper_id() %>"><%=show.get(i).getPaper_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<td><strong>6th SEM:</strong></td></tr>
</tr>
<tr>
	<%
	for(int cnt= 1;cnt < 11; cnt++)
	{
	%>
		<td><input type= "text" name="6code" value="">
		<select name="6paperid" id="papername">
		<option value="">SELECT</option>
		<%
 		for(int i= 0;i < show.size();i++)
		{
		%>
				<option value="<%= show.get(i).getPaper_id() %>"><%=show.get(i).getPaper_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}%>
</table>
<center>
<input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()">
<input type= "button" name= "coursepaper" value="Submit" onclick= "javascript:setcoursepapers()"></center>
<input type= "hidden" name= "Paper_Id" value= "">
<input type= "hidden" name= "module" value= "coursepaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "Course_Id" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">

</form>
</body>
</html>
