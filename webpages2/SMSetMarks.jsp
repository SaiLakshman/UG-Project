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
<form name= "StudentmarkssetForm" method= "post" action="/Project1/campusteacher">
<%
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("coursesempaper");
ArrayList<ExamPaper> ep1= (ArrayList<ExamPaper>) request.getAttribute("selectedpaperexams");
ArrayList<Student> std= (ArrayList<Student>) request.getAttribute("allstudents");
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
	<%for(int j= 0;j<std.size();j++){%>
<tr>
	<td Class= "sai12">
	<select name= "student" id= "student">
	<option value="">SELECT</option>
	<%
	for(int i= 0; i < std.size(); i++)
	{
	%>
	<option value= "<%=std.get(i).getStudentId()%>"><%= std.get(i).getName()%></option>
	<%
	}
	%>
	</select> </td>
	<td></td><td></td>
	<%
	for(int k= 0; k < ep1.size(); k++)
	{
		if(ep1.size() >= 1){%>
			<td Class= "sai13"><select name= "1smmark" id= "1smmark">
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
			<td Class= "sai2"><select name= "2smmark" id= "2smmark">
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
			<td Class= "sai3"><select name= "3smmark" id= "3smmark">
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
			<td Class= "sai1b"><select name= "4smmark" id= "4smmark">
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
			<td Class= "sai11"><select name= "5smmark" id= "5smmark">
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
			<td Class= "sai12"><select name= "6smmark" id= "6smmark">
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
			<td Class= "sai14"><select name= "7smmark" id= "7smmark">
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
<td align="center"><input type= "button" name= "coursepaper" value="Set Marks" onclick= "javascript:setmarkstostudents()"></td></tr>

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
