<html>
<head>
<title>
Modify Allocation
</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "bca.batch2011.project1.ha.*"%>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<% 	
	RoomAllocation get= (RoomAllocation) request.getAttribute("allocation");
	ArrayList<Room> roomlist= (ArrayList<Room>) request.getAttribute("arraylist");
	ArrayList<RoomAllocation> roomalloc= (ArrayList<RoomAllocation>) request.getAttribute("roomalloc");
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
	<% ArrayList<ArrayList<RoomAllocation>> BigList= (ArrayList<ArrayList<RoomAllocation>>) request.getAttribute("StList");
	ArrayList<Room> StudentList= (ArrayList<Room>) request.getAttribute("RmList");
	int k= 0;
	for(int i= 0; i< roomlist.size(); i++)
	{
	%>
		<tr>
			<td><%=roomlist.get(i).getRoomNo()%></td>
			<%k= roomlist.get(i).getNumCupboards();%>
			<input Name= "roomno" type= "hidden" value="<%=roomlist.get(i).getRoomNo()%>">
			<input Name= "cupno" type= "hidden" value="<%=roomlist.get(i).getNumCupboards()%>">
			
			<% for(int a= 0;a< k;a++)
			{
			%>
				<tr><td><select name= "input">
				<option></option>
				<% for(int j= 0;j< roomalloc.size();j++)
				{
				%>
					<%String s= "";
					if(roomalloc.get(j).getBatch().equals("1"))
					{
						s= "I";
					}
					if(roomalloc.get(j).getBatch().equals("2"))
					{
						s= "II";
					}
					if(roomalloc.get(j).getBatch().equals("3"))
					{
						s= "III";
					}%>
					<option value= "<%=roomalloc.get(j).getName()%>,<%=s%>-<%=roomalloc.get(j).getCourseName()%>"><%=roomalloc.get(j).getName()%>,<%=s%>-<%=roomalloc.get(j).getCourseName()%></option>
				<%
				}
				%>
				</select>
			<%
			}
			%>
			
			</td></tr>
		</tr>
	<%
	}
	%>
		    	
		<td align= "left"><input Name= "Cancel" type= "button" value="Cancel" onclick= "javascript: cancelAllocation()"></td>
		<%  int j= 50;
		while(j> 0)
		{
		%>
			<td></td>
		<%  j--;
			}
		%>
		<td align= "right"><input Name= "Update" type= "button" value="Update" onclick= "javascript: updatemodifyAllocation()"></td>
	</table>
	<input Name= "module" type= "hidden" value="RoomAllocation">
	<input Name= "access" type= "hidden" value="">
	
	<input Name= "year" type= "hidden" value="<%= get.getYear()%>">
	<input Name= "semester" type= "hidden" value="<%= get.getSemester()%>">
</form>
</body>
</html>
