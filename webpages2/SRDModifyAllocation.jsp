<html>
<head>
<title>
Fresh Allocation
</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% 	
	SRDAllocation get= (SRDAllocation) request.getAttribute("allocation");
	ArrayList<SRDAllocation> srdlist= (ArrayList<SRDAllocation>) request.getAttribute("arraylist");
	ArrayList<SRDAllocation> srdalloc= (ArrayList<SRDAllocation>) request.getAttribute("srdalloc");
%>
<body>
<form action="/Project1/hostelteacher" name="Modify Allocation" method="post">
	Year:&nbsp;<%= get.getYear()%>
	<% String c= "";
	if(get.getSemester() % 2 == 1)
	{
		c= "Odd";
	}
	if(get.getSemester() % 2 == 0)
	{
		c= "Even";
	}%>
	Semester:&nbsp;<%= c%>
<hr>
	<table align= "center">
	<th>StudentName</th>
	<th>1st Preference</th>
	<th>2nd Preference</th>
	<th>3rd Preference</th>
	<% 
	for(int i= 0; i< srdalloc.size(); i++)
	{
	%>
	<input Name= "srdallocsize" type= "hidden" value="<%=srdalloc.size()%>">
				<%String s= "";
				if(srdalloc.get(i).getBatch().equals("1"))
				{
					s= "I";
				}
				if(srdalloc.get(i).getBatch().equals("2"))
				{
					s= "II";
				}
				if(srdalloc.get(i).getBatch().equals("3"))
				{
					s= "III";
				}%>
		<tr>
		<td><%=srdalloc.get(i).getName()%>,<%=s%>-<%=srdalloc.get(i).getCourseName()%></td>
		<% for(int k= 0;k< 3;k++)
		{
		%>
			<td><select name= "input<%=i%><%=k%>">
			<option></option>
			<% for(int j= 0;j< srdlist.size();j++)
			{
			%>	
				
				<option value= "<%=srdlist.get(j).getSrdName()%>"><%=srdlist.get(j).getSrdName()%></option>
			<%
			}
			%>
			</select></td>
		<%
		}
		%>
		</td>
	<%
	}
	%>
	
	</tr><tr><td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelmodifyAllocation()"></td>
	<td></td><td></td>
	<td align= "right"><input Name= "Update" type= "button" value="Update" onclick= "javascript: updatemodifyAllocation()"></td>
	</tr>
</table>
<input Name= "module" type= "hidden" value="SrdAllocation">
<input Name= "access" type= "hidden" value="">
<input Name= "yearh" type= "hidden" value="<%= get.getYear()%>">
<input Name= "semesterh" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
