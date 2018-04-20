<html>
<%@ page import= "bca.batch2011.project1.ht.*"%>
<%@ page import= "java.util.ArrayList"%>
<%@ page errorPage= "/ErrorPage.jsp"%>
<head>
<title> Fees_Amount </title>
<link rel= stylesheet href="style.css">
<script type= "text/javascript" src= "HT.js"></script>
</head>
<body>
   <h1 align= "center"><b>This is to Search, if the Student Fees Exists for the Year and Semester</b></h1>
   <form name= "formSearch" method= "post" action= "/Project1/hostelteacher">
   <table align= "center">
     <tr><td align= "right"class= "txt"> Year:     <input type= "text" name= "year"></td></tr>
     <tr><td class= "txt"> Semester: <input type= "text" name= "semester"></td></tr>
     <tr>
   	<td class= "labelred" align= "right"> <input type= "button" name= "btnSearch" value= "Search" onclick= "javascript:searchStudentfees()"></td>
     </tr>
   </table>
   <input type= "hidden" name= "module" value= "studentfees">
   <input type= "hidden" name= "access" value= "">
   </form>
</body>
</html>
