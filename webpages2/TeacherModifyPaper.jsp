<html>
<head>
<title>Set Papers</title>
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
<form name= "teachermodifypaperForm" method= "post" action="/Project1/campusteacher">
<h1><font color= "green"><u>Modify Teachers</u></font></h1>
<% ArrayList<TeacherBean> show= (ArrayList<TeacherBean>) request.getAttribute("teacherpaper");
ArrayList<TeacherBean> teach= (ArrayList<TeacherBean>) request.getAttribute("allteachers");
ArrayList<Papers_Course> show1= (ArrayList<Papers_Course>) request.getAttribute("paperbatch");
ArrayList<Papers_Course> pap= (ArrayList<Papers_Course>) request.getAttribute("batchpaper");
Papers_Course c= (Papers_Course)request.getAttribute("coursename");
int counter= 0;
%>
<table>
<tr>
<td class= "sai13"><strong>1st SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
		if(show1.get(cnt).getCourse_id() == c.getCourse_id() && show1.get(cnt).getBatch() == c.getBatch() && show1.get(cnt).getYear() == 1 && show1.get(cnt).getSemester() == 1)
		{
	%>
					<td class= "sai1b"><font color= red><%=pap.get(cnt).getPaper_code()%>--<font color= blue><%=pap.get(cnt).getPaper_title()%></font>
					</td>
					<td class= "sai1b"><select name="1modteachpaperid" id="modteachpapername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < teach.size();i++)
					{
					%>
							<option value="<%= teach.get(i).getTeacherid() %>" <% if(teach.get(i).getTeacherid() == show.get(cnt).getTeacherid()) out.print("selected");%>>
								<%=teach.get(i).getTeachername()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	counter= 0;
	%>
</tr>
<tr><td class= "sai13"><strong>2nd SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
		if(show1.get(cnt).getCourse_id() == c.getCourse_id() && show1.get(cnt).getBatch() == c.getBatch() && show1.get(cnt).getYear() == 1 && show1.get(cnt).getSemester() == 2)
		{
	%>
					<td class= "sai1b"><font color= red><%=pap.get(cnt).getPaper_code()%>--<font color= blue><%=pap.get(cnt).getPaper_title()%></font>
					</td>
					<td class= "sai1b"><select name="2modteachpaperid" id="modteachpapername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < teach.size();i++)
					{
					%>
							<option value="<%= teach.get(i).getTeacherid() %>" <% if(teach.get(i).getTeacherid() == show.get(cnt).getTeacherid()) out.print("selected");%>>
								<%=teach.get(i).getTeachername()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	counter= 0;
	%>
</tr>
<tr><td class= "sai13"><strong>3rd SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
		if(show1.get(cnt).getCourse_id() == c.getCourse_id() && show1.get(cnt).getBatch() == c.getBatch() && show1.get(cnt).getYear() == 2 && show1.get(cnt).getSemester() == 1)
		{
	%>
					<td class= "sai1b"><font color= red><%=pap.get(cnt).getPaper_code()%>--<font color= blue><%=pap.get(cnt).getPaper_title()%></font>
					</td>
					<td class= "sai1b"><select name="3modteachpaperid" id="modteachpapername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < teach.size();i++)
					{
					%>
							<option value="<%= teach.get(i).getTeacherid() %>" <% if(teach.get(i).getTeacherid() == show.get(cnt).getTeacherid()) out.print("selected");%>>
								<%=teach.get(i).getTeachername()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	counter= 0;
	%>
</tr>
<tr><td class= "sai13"><strong>4th SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
		if(show1.get(cnt).getCourse_id() == c.getCourse_id() && show1.get(cnt).getBatch() == c.getBatch() && show1.get(cnt).getYear() == 2 && show1.get(cnt).getSemester() == 2)
		{
	%>
					<td class= "sai1b"><font color= red><%=pap.get(cnt).getPaper_code()%>--<font color= blue><%=pap.get(cnt).getPaper_title()%></font>
					</td>
					<td class= "sai1b"><select name="4modteachpaperid" id="modteachpapername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < teach.size();i++)
					{
					%>
							<option value="<%= teach.get(i).getTeacherid() %>" <% if(teach.get(i).getTeacherid() == show.get(cnt).getTeacherid()) out.print("selected");%>>
								<%=teach.get(i).getTeachername()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	counter= 0;
	%>
</tr>
<%if(c.getDuration()>2){%>
<tr><td class= "sai13"><strong>5th SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
		if(show1.get(cnt).getCourse_id() == c.getCourse_id() && show1.get(cnt).getBatch() == c.getBatch() && show1.get(cnt).getYear() == 3 && show1.get(cnt).getSemester() == 1)
		{
	%>
					<td class= "sai1b"><font color= red><%=pap.get(cnt).getPaper_code()%>--<font color= blue><%=pap.get(cnt).getPaper_title()%></font>
					</td>
					<td class= "sai1b"><select name="5modteachpaperid" id="modteachpapername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < teach.size();i++)
					{
					%>
							<option value="<%= teach.get(i).getTeacherid() %>" <% if(teach.get(i).getTeacherid() == show.get(cnt).getTeacherid()) out.print("selected");%>>
								<%=teach.get(i).getTeachername()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	counter= 0;
	%>
</tr>
<tr><td class= "sai13"><strong>6th SEM:</strong></td></tr>
<tr>
	<%
	for(int cnt= 0;cnt < pap.size(); cnt++)
	{
		if(show1.get(cnt).getCourse_id() == c.getCourse_id() && show1.get(cnt).getBatch() == c.getBatch() && show1.get(cnt).getYear() == 3 && show1.get(cnt).getSemester() == 2)
		{
	%>
					<td class= "sai1b"><font color= red><%=pap.get(cnt).getPaper_code()%>--<font color= blue><%=pap.get(cnt).getPaper_title()%></font>
					</td>
					<td class= "sai1b"><select name="6modteachpaperid" id="modteachpapername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < teach.size();i++)
					{
					%>
							<option value="<%= teach.get(i).getTeacherid() %>" <% if(teach.get(i).getTeacherid() == show.get(cnt).getTeacherid()) out.print("selected");%>>
								<%=teach.get(i).getTeachername()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	counter= 0;
	%>
</tr>
<%}%>
</table>
<input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()">
<input type= "button" name= "coursepaper" value="Modify" onclick= "javascript:modifyteacherpaper()">

<input type= "hidden" name= "Paper_Id" value= "">
<input type= "hidden" name= "module" value= "teacherpaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">

</form>
</body>
</html>
