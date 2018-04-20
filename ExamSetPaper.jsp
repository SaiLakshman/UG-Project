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
<form name= "examsetpaperForm" method= "post" action="/Project1/campusteacher">
<h1><u>Set Exams</u></h1>
<% ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("papers");
ArrayList<ExamPaper> ep= (ArrayList<ExamPaper>) request.getAttribute("exams");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
int i= 0;
%>
<table>
<%if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="1mark" value="">
		<select name="1examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="2mark" value="">
		<select name="2examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="3mark" value="">
		<select name="3examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="4mark" value="">
		<select name="4examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="5mark" value="">
		<select name="5examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="6mark" value="">
		<select name="6examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="7mark" value="">
		<select name="7examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="8mark" value="">
		<select name="8examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="9mark" value="">
		<select name="9examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 1;cnt < 6; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="10mark" value="">
		<select name="10examcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}
		%>
		</select> </td>
	<%
	}
	%>
</tr>
<%}
	i++;%>
</table>
<center>
<input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()">
<input type= "button" name= "coursepaper" value="Submit" onclick= "javascript:setexampapers()"></center>
<input type= "hidden" name= "Paper_Id" value= "">
<input type= "hidden" name= "module" value= "exampaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "ecoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "ebatch" value= "<%=c.getBatch()%>">
<input type= "hidden" name= "year" value= "<%=c.getYear()%>">
<input type= "hidden" name= "semester" value= "<%=c.getSemester()%>">

</form>
</body>
</html>
