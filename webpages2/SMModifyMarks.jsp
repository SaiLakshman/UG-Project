<html>
<head>
<title>Set Marks</title>
<link rel="stylesheet"
        type="text/css"
        href="style.css"
        title="cas" />
<script type="text/javascript"
src= "CT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "bca.batch2011.project1.ct.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<center>
<form name= "StudentmarksmodifyForm" method= "post" action="/Project1/campusteacher">
<%
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("coursesempaper");
ArrayList<ExamPaper> ep1= (ArrayList<ExamPaper>) request.getAttribute("selectedpaperexams");
ArrayList<ExamPaper> ep2= (ArrayList<ExamPaper>) request.getAttribute("exampaperidsandmarks");
ArrayList<Student> sm1= (ArrayList<Student>) request.getAttribute("studentmarks");
ArrayList<Student> sm2= (ArrayList<Student>) request.getAttribute("allstudents");
ArrayList<Student> sm3= (ArrayList<Student>) request.getAttribute("noofstudents");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
Papers_Course ep= (Papers_Course)request.getAttribute("selected paper");
%>
<h1 class="labelred"> @ Set Marks for <font color="black"><%=c.getCourse_name()%></font> for the batch <font color=" black"><%=c.getBatch()%> </font> for the Year  <font color="black"><%=c.getYear()%></font> And Semester <font color="black"> <%=c.getSemester()%></font></h1>
<h2 class="label" align= "right">*examcode--|marks|</h2>
<table>
<tr></tr><tr></tr><tr></tr><tr>
	<%for(int i= 0;i < pap.size();i++){%>
		<td class= "sai1b"><%if(pap.get(i).getPaper_id() == ep.getPaper_id()) {%><strong><u><%=pap.get(i).getPaper_code()%>--<%=pap.get(i).getPaper_title()%> </u></strong></td>
	<%}}%>
	<%for(int i= 0;i < ep1.size();i++){%>
		<td class= "sai1b">*<%=ep1.get(i).getExam_code()%>--|<%=ep1.get(i).getMarks()%>|</td>
	<%}%>
</tr>

<tr><td><strong>Student:</strong></td></tr>
	<%int z= 0,store= 0,id= 0;
	for(int l= 0;l < sm3.size();l++)
	{%> <tr><td><select name= 'modstudent' id= 'modstudent'>
	<option value=''>SELECT</option>
		<% for(int m= 0;m < sm2.size();m++)
		{ %>
			<option value= '<%=sm2.get(m).getStudentId() %>' 
			<%
			if(sm2.get(m).getStudentId() == sm3.get(l).getStudentId()) 
			{
				id= sm2.get(m).getStudentId();
				out.print("selected>");
			}
			else
			{ %>
				>
			<% }%><%=sm2.get(m).getName()%></option>
		<%}%></select> </td>  
		<td></td><td></td>
	<%
	for(int k= 0; k < ep1.size(); k++)
	{
		if(ep1.size() >= 1){
			%>
				<td Class= "sai13"><select name= "mod1smmark" id= "mod1smmark">
				<option value="">SELECT</option>
			<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if( ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id() && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1 ){ out.print("selected");z= 1; store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		if(ep1.size() >= 2){
		%>
			<td Class= "sai2"><select name= "mod2smmark" id= "mod2smmark">
			<option value="">SELECT</option>
		<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if(ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id()  && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1){ out.print("selected");z= 1;store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		if(ep1.size() >= 3){%>
			<td Class= "sai3"><select name= "mod3smmark" id= "mod3smmark">
			<option value="">SELECT</option>
		<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if( ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id() && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1){ out.print("selected");z= 1;store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		if(ep1.size() >= 4){%>
			<td Class= "sai1b"><select name= "mod4smmark" id= "mod4smmark">
			<option value="">SELECT</option>
		<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if( ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id() && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1){ out.print("selected");z= 1;store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		if(ep1.size() >= 5){%>
			<td Class= "sai11"><select name= "mod5smmark" id= "mod5smmark">
			<option value="">SELECT</option>
		<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if( ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id() && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1){ out.print("selected");z= 1;store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		if(ep1.size() >= 6){%>
			<td Class= "sai12"><select name= "mod6smmark" id= "mod6smmark">
			<option value="">SELECT</option>
			<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if( ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id() && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1){ out.print("selected");z= 1;store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		if(ep1.size() >= 7){%>
			<td Class= "sai14"><select name= "mod7smmark" id= "mod7smmark">
			<option value="">SELECT</option>
			<%z= 0;
			for(int a= store; a < ep2.size(); a++)
			{
				if(z == 0){
				for(int i= 0; i < ep1.get(k).getMarks(); i++)
				{
				%>
					<option value= "<%=i+1%>" <%if( ep1.get(k).getExam_paper_id() == ep2.get(a).getExam_paper_id() && sm1.get(a).getStudentId() == id && ep2.get(a).getMarks() == i+1){ out.print("selected");z= 1;store= a+1;}%>><%= i+1%></option>
				<%
				}z= 1;}
			}%></select></td>
		<%}k++;
		}%>
	</tr><%}%>

	<%
	for(int j= sm3.size();j<sm2.size();j++){%>
<tr>
	<td Class= "sai12">
	<select name= "modstudent" id= "modstudent">
	<option value="">SELECT</option>
	<%
	for(int i= 0; i < sm2.size(); i++)
	{
	%>
	<option value= "<%=sm2.get(i).getStudentId()%>"><%= sm2.get(i).getName()%></option>
	<%
	}
	%>
	</select> </td>
	<td></td><td></td>
	<%
	for(int k= 0; k < ep1.size(); k++)
	{
		if(ep1.size() >= 1){%>
			<td Class= "sai13"><select name= "mod1smmark" id= "mod1smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		if(ep1.size() >= 2){%>
			<td Class= "sai2"><select name= "mod2smmark" id= "mod2smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		if(ep1.size() >= 3){%>
			<td Class= "sai3"><select name= "mod3smmark" id= "mod3smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		if(ep1.size() >= 4){%>
			<td Class= "sai1b"><select name= "mod4smmark" id= "mod4smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		if(ep1.size() >= 5){%>
			<td Class= "sai11"><select name= "mod5smmark" id= "mod5smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		if(ep1.size() >= 6){%>
			<td Class= "sai12"><select name= "mod6smmark" id= "mod6smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		if(ep1.size() >= 7){%>
			<td Class= "sai14"><select name= "mod7smmark" id= "mod7smmark">
			<option value="">SELECT</option>
			<%
			for(int i= 0; i < ep1.get(k).getMarks(); i++)
			{
			%>
				<option value= "<%=i+1%>"><%= i+1%></option>
			<%
			}
		}k++;
		k= ep1.size();}%>
</tr>
	<%}%>
<tr>
<td><input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()"></td>
<td align="center"><input type= "button" name= "coursepaper" value="Modify Marks" onclick= "javascript:modifymarkstostudents()"></td></tr>

</table>
<input type= "hidden" name= "module" value= "marksstudents">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "smcoursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "smbatch" value= "<%=c.getBatch()%>">
<input type= "hidden" name= "smyear" value= "<%=c.getYear()%>">
<input type= "hidden" name= "smsemester" value= "<%=c.getSemester()%>">
<input type= "hidden" name= "smpaper" value= "<%=ep.getPaper_id()%>">
</form>
</body>
</html>
