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
<form name= "exammodifypaperForm" method= "post" action="/Project1/campusteacher">
<h1><u>Modify Exams</u></h1>
<% ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("papers");
ArrayList<Papers_Course> pid= (ArrayList<Papers_Course>) request.getAttribute("pid");
ArrayList<ExamPaper> ep= (ArrayList<ExamPaper>) request.getAttribute("exams");
ArrayList<ExamPaper> ep1= (ArrayList<ExamPaper>) request.getAttribute("yearsemexams");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
int i= 0,counter= 0,check= 0;
%>
<table>
<%if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="1modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="1modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="1modmark" value="">
		<select name="1modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="2modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="2modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="2modmark" value="">
		<select name="2modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="3modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="3modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="3modmark" value="">
		<select name="3modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="4modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="4modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="4modmark" value="">
		<select name="4modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="5modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="5modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="5modmark" value="">
		<select name="5modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="6modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="6modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="6modmark" value="">
		<select name="6modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="7modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="7modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="7modmark" value="">
		<select name="7modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="8modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="8modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="8modmark" value="">
		<select name="8modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="9modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="9modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="9modmark" value="">
		<select name="9modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;
if(i<pap.size()){%>
<tr>
<td class="sai12"><strong><%=pap.get(i).getPaper_code()%><%=pap.get(i).getPaper_title()%></strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < ep1.size(); cnt++)
	{
	if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){
	counter++;
	%>
		<td class= "sai1b"><input type= "text" name="10modmark" value="<%=ep1.get(cnt).getMarks()%>"><%}%>
		<%if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id()){%>
		<select name="10modexamcode" id="examname">
		<option value="">SELECT</option>
 		<%for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"<% if(pid.get(cnt).getPaper_id() == pap.get(i).getPaper_id() && ep.get(j).getExam_id() == ep1.get(cnt).getExam_id()) out.print("selected");%>><%=ep.get(j).getExam_title()%></option>
		<%
		}}%>
		</select> </td>
	<%
	}
	if(counter <ep.size()){
	for(int cnt= counter;cnt < ep.size(); cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="10modmark" value="">
		<select name="10modexamcode" id="examname">
		<option value="">SELECT</option>
		<%
 		for(int j= 0;j < ep.size();j++)
		{
		%>
				<option value="<%= ep.get(j).getExam_id() %>"><%=ep.get(j).getExam_title()%></option>
		<%
		}%>
		</select> </td>
	<%
	}}}
	counter= 0;
	i++;%>
</table>
<center>
<input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()">
<input type= "button" name= "coursepaper" value="Submit" onclick= "javascript:modexampapers()"></center>
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
