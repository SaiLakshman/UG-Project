<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<%@ page import= "bca.batch2011.project1.ca.*" %>
<%@ page import= "java.util.*" %>
<%@ page import= "java.sql.*" %>
<head>
<title> List of Students </title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<h1 align= "center"> List Of All the Students </h1>
<h2 align= "center"> [Click on Name to View the Students Details] </h2>
<form name= "formListStudents" method= "post" action= "/Project1/campusadmin">
<% ArrayList<Student> s=  (ArrayList<Student>)request.getAttribute("in"); %>
<table align= "center" cellspacing= "3" cellpadding= "3" border= "1">

<tr>
   <th class= "labelred">        	     	</th>
   <th class= "labelred">Regd No 	    	</th>
   <th class= "labelred">Name 	    	</th>   
   <th class= "labelred">Date of Birth   	</th>
   <th class= "labelred">Blood Group     	</th>
   <th class= "labelred">Year of Joining 	</th>
   <th class= "labelred">Course_Name	</th>
   <th class= "labelred">Year		</th>
   <th class= "labelred">Nationality   	</th>
   <th class= "labelred">Caste 	  	</th>
</tr>
<% 
String style= "";
for(int i= 0;i < s.size();i++)
{
	if(i % 2 == 0)
		style= "sai12";
	else
		style= "sai13";
%>
<tr class= "sai1">
  <td class= "<%=style%>"><input type= "checkbox" name= "deleteBox" value= "<%= s.get(i).getStudentId()%>"></td>
  <td class= "<%=style%>"> <%= s.get(i).getRegdno() %> </td>
  <td class= "<%=style%>"><a href= "javascript:viewStudent(<%= s.get(i).getStudentId()%>)"> <%= s.get(i).getName() %> </a></td>
  <td class= "<%=style%>"> <%= s.get(i).getDob() %>        </td>
  <td class= "<%=style%>"> <%= s.get(i).getBg() %> 	   </td>
  <td class= "<%=style%>"> <%= s.get(i).getYoj() %> 	   </td>
  <td class= "<%=style%>"> <%= s.get(i).getCourseName()%>  </td>
  <td class= "<%=style%>"> <%= s.get(i).getYearNum()%>     </td>
  <td class= "<%=style%>"> <%= s.get(i).getNationality() %></td>
  <td class= "<%=style%>"> <%= s.get(i).getCaste() %>      </td>
<% } %>
</tr>
<tr>
   <td class= "txt"><input type= "button" name= "btnDelete" value= "Delete" onclick= "javascript:DeleteStudent() "></td>
   <td colspan= "20" class= "sai6" align= "right"><input type= "button" name= "btnAddNewStudent" value= "Add New Student" onclick= "javascript:addStudent()"></td>
</tr>
</table>

<input type= "hidden" name= "studentId" value= "">
<input type= "hidden" name= "module" value= "students">
<input type= "hidden" name= "access" value= "List">
</form>
</body>
</html>
