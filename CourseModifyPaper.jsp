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
<%@ page import= "bca.batch2011.project1.ct.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.*"%>
<%@ page errorPage="/ErrorPage.jsp" %>
<body>
<center>
<form name= "coursemodifypaperForm" method= "post" action="/Project1/campusteacher">
<h1>SelectPapers</h1>
<% ArrayList<Papers_Course> show= (ArrayList<Papers_Course>) request.getAttribute("papers");
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
					<td class= "sai1b"><input type= "text" name="1modcode" value="<%=pap.get(cnt).getPaper_code()%>">
					<select name="1modpaperid" id="papername">
					<option value="">SELECT</option>				
					<%
			 		for(int i= 0;i < show.size();i++)
					{
					%>
							<option value="<%= show.get(i).getPaper_id() %>" <% if(show.get(i).getPaper_id() == pap.get(cnt).getPaper_id()) out.print("selected");%>>
								<%=show.get(i).getPaper_title()%>
							</option>
					<%
					}
					%>
				</select> </td>
	<%
				counter++;
		}
	}
	for(int cnt= 1;cnt+counter <= 10; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="1modcode" value="">
		<select name="1modpaperid" id="papername">
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
				<td class= "sai12"><input type= "text" name="2modcode" value="<%=pap.get(cnt).getPaper_code()%>">
				<select name="2modpaperid" id="papername">
				<option value="">SELECT</option>
				<%
		 		for(int i= 0;i < show.size();i++)
				{
				%>
						<option value="<%= show.get(i).getPaper_id() %>" <% if(show.get(i).getPaper_id() == pap.get(cnt).getPaper_id()) out.print("selected");%>><%=show.get(i).getPaper_title()%></option>
				<%
				}
				%>
				</select> </td>
	<%
				counter++;
		}
	}
	for(int cnt= 1;cnt+counter <= 10; cnt++)
	{
	%>
		<td class= "sai12"><input type= "text" name="2modcode" value="">
		<select name="2modpaperid" id="papername">
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
				<td class= "sai1b"><input type= "text" name="3modcode" value="<%=pap.get(cnt).getPaper_code()%>">
				<select name="3modpaperid" id="papername">
				<option value="">SELECT</option>
				<%
		 		for(int i= 0;i < show.size();i++)
				{
				%>
						<option value="<%= show.get(i).getPaper_id() %>" <% if(show.get(i).getPaper_id() == pap.get(cnt).getPaper_id()) out.print("selected");%>><%=show.get(i).getPaper_title()%></option>
				<%
				}
				%>
				</select> </td>
	<%
				counter++;
		}
	}
	for(int cnt= 1;cnt+counter <= 10; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="3modcode" value="">
		<select name="3modpaperid" id="papername">
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
				<td class= "sai12"><input type= "text" name="4modcode" value="<%=pap.get(cnt).getPaper_code()%>">
				<select name="4modpaperid" id="papername">
				<option value="">SELECT</option>
				<%
		 		for(int i= 0;i < show.size();i++)
				{
				%>
						<option value="<%= show.get(i).getPaper_id() %>" <% if(show.get(i).getPaper_id() == pap.get(cnt).getPaper_id()) out.print("selected");%>><%=show.get(i).getPaper_title()%></option>
				<%
				}
				%>
				</select> </td>
	<%
				counter++;
		}
	}
	for(int cnt= 1;cnt+counter <= 10; cnt++)
	{
	%>
		<td class= "sai12"><input type= "text" name="4modcode" value="">
		<select name="4modpaperid" id="papername">
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
				<td class= "sai1b"><input type= "text" name="5modcode" value="<%=pap.get(cnt).getPaper_code()%>">
				<select name="5modpaperid" id="papername">
				<option value="">SELECT</option>
				<%
		 		for(int i= 0;i < show.size();i++)
				{
				%>
						<option value="<%= show.get(i).getPaper_id() %>" <% if(show.get(i).getPaper_id() == pap.get(cnt).getPaper_id()) out.print("selected");%>><%=show.get(i).getPaper_title()%></option>
				<%
				}
				%>
				</select> </td>
	<%
				counter++;
		}
	}
	for(int cnt= 1;cnt+counter <= 10; cnt++)
	{
	%>
		<td class= "sai1b"><input type= "text" name="5modcode" value="">
		<select name="5modpaperid" id="papername">
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
				<td class= "sai12"><input type= "text" name="6modcode" value="<%=pap.get(cnt).getPaper_code()%>">
				<select name="6modpaperid" id="papername">
				<option value="">SELECT</option>
				<%
		 		for(int i= 0;i < show.size();i++)
				{
				%>
						<option value="<%= show.get(i).getPaper_id() %>" <% if(show.get(i).getPaper_id() == pap.get(cnt).getPaper_id()) out.print("selected");%>><%=show.get(i).getPaper_title()%></option>
				<%
				}
				%>
				</select> </td>
	<%
				counter++;
		}
	}
	for(int cnt= 1;cnt+counter <= 10; cnt++)
	{
	%>
		<td class= "sai12"><input type= "text" name="6modcode" value="">
		<select name="6modpaperid" id="papername">
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
	counter= 0;
	%>
</tr>
<%}%>
</table>
<input type= "button" name= "cancel" value= "CANCEL"  onclick= "javascript:Cancel()">
<input type= "button" name= "coursepaper" value="Submit" onclick= "javascript:setmodifycoursepapers()">

<input type= "hidden" name= "Paper_Id" value= "">
<input type= "hidden" name= "module" value= "coursepaper">
<input type= "hidden" name= "access" value= "">
<input type= "hidden" name= "coursename" value= "<%=c.getCourse_id()%>">
<input type= "hidden" name= "batch" value= "<%=c.getBatch()%>">

</form>
</body>
</html>
