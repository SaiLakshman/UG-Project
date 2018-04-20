<html>
<head>
<title> List Exams </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "CA.js">
</script>
</head>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<body>
<h1 align= center><u><b>List Of Exams</b></u></h1><br><h3 align= center>(Click on <u>ExamCode</u> to Modify)</h3>
<form action="/Project1/campusadmin" name="listexams" method="post">
<%
  ArrayList<Exam> list= (ArrayList<Exam>) request.getAttribute("show");
%>
<table border= "0" align= "center" width= "800">
<tr>
  <th></th>
  <th>Exam Code</th>
  <th>Exam Title</th>
</tr>
<% 
String style= "";
for(int i= 0; i < list.size(); i++)
{
  if(i % 2 == 0)
    style= "sai1";
  else
    style= "sai2";
%>
<tr class="sai1">
 <td class= "<%= style%>" align="center"><input type= "checkbox" name= "deleteBox" value= "<%= list.get(i).getExamId() %>"></td>
 <td class= "<%= style%>" align="center"><a href= "javascript: modifyExam(<%= list.get(i).getExamId() %>)"><%= list.get(i).getExamCode() %> 
 </a></td>
<td class="<%= style%>" align="center"><%= list.get(i).getExamTitle()%></td>
<%
}
%>
</tr>
<tr>
  <td align="left" class="sai2"><input type= "button" name= "btnDelete" value= "Delete" onclick= "javascript: deleteExam()"></td>
  <td class="sai2"></td>
  <td align="right" class="sai2"><input type= "button" name= "btnAdd New Exam" value= "Add New Exam" onclick= "javascript: addnewExam()"></td>
</tr>
</table>
<input type= "hidden" name= "examId" value= "">
<input type= "hidden" name= "module" value= "exams">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
