<html>
<head>
<title>Insert Courses</title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<% Course gt= (Course) request.getAttribute("inse");
ArrayList<DepartmentBean> dept= (ArrayList<DepartmentBean>)request.getAttribute("dep");%>
<h2 align= center>Modify <font color="blue"><%= gt.getCoursename()%> COURSE</font> Details</h2>
<form name= "modifycourses" method="post" action= "/Project1/campusadmin">
<table align= "center">
  <tr class= "sai1">
     <td class= "sai1">Course Name:</td>
     <td class= "sai2"><input Name= "coursename" type= "text" value= "<%= gt.getCoursename() %>"></td>
  </tr>
  <tr class= "sai1">
     <td class= "sai1">Course Title:</td>
     <td class= "sai2"><input Name= "coursetitle" type= "text" value= "<%= gt.getCoursetitle() %>"></td>
  </tr> 
  <tr class= "sai1">
     <td class= "sai1">Duration:</td>
     <td class= "sai2"><input Name= "duration" type= "text" value= "<%= gt.getDuration() %>"></td>
  </tr> 
  <tr>
 	<td>Department</td>
	<td> <select name= "DepartmentId" >
    	<% for(int k= 0;k< dept.size();k++)
	       		{ if(gt.getDepartmentid() == dept.get(k).getDepartmentid()){%>
           			<option value= "<%= dept.get(k).getDepartmentid()%>"selected>
					<%= dept.get(k).getDepartmentname() %>
				</option>
		<%} else{%>
               		        <option value= "<%= dept.get(k).getDepartmentid()%>"><%= dept.get(k).getDepartmentname() %><%}%>
				</option>
    		<% }%>
     	</select>
    	</td>
</tr>
  <tr class= "sai1">
     <td class= "sai1" align= "center">
     <input Name= "btnCancel" type= "button" value="Cancel" onclick= "javascript: cancelCourse()"></td>
     <td class= "sai2" align= "center">
     <input Name= "btnSubmit" type= "button" value="Submit" onclick= "javascript: updateCourse(<%= gt.getCourseid() %>)"></td>
  </tr>
</table>
<input Name= "courseId" type= "hidden" value="">
<input Name= "module" type= "hidden" value="courses">
<input Name= "access" type= "hidden" value="">
</form>
</body>
</html>
