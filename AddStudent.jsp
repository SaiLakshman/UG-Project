<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<%@ page import= "bca.batch2011.project1.ca.*" %>
<%@ page import= "java.util.*" %>
<%@ page import= "java.sql.*" %>
<head>
<title> Student Information Page </title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<%    ArrayList<Course> cour= (ArrayList<Course>)  request.getAttribute("course");%>
<!--Student Personal Details-->
<h1 align= "center">@ Please Enter the Details of the Student @</h1>
<form name= "formAddStudent" method= "post" action= "/Project1/campusadmin">
<table align= "center">
<tr>
   <td class= "text1"> Regd_No: </td>
   <td> <input class= "text" type= "text" name= "Regdno"> </td>
</tr>
<tr>
   <td class= "text1"> Name: </td>
   <td> <input class= "text" type= "text" name= "Name"> </td>
</tr>
<tr>
   <td class= "text1"> Father Name: </td>
   <td> <input class= "text" type= "text" name= "f_name"> </td>
</tr>
<tr>
   <td class= "text1"> Mother Name: </td>
   <td> <input class= "text" type= "text" name= "m_name"> </td>
</tr>
<tr>
   <td class= "text1"> Guardian Name: </td>
   <td> <input class= "text" type= "text" name= "g_name"> </td>
</tr>
<tr>
 <td class= "text1"> Date Of Birth: </td>
 <td> <input class= "text" type= "text" name= "dateofbirth" placeholder= "yyyy-mm-dd"></td>
</tr>
<tr>
 <td class= "text1"> Blood Group: </td>
 <td> <input class= "text" type= "text" name= "bg"></td>
</tr>
<tr>
 <td class= "text1"> Year Of Joining: </td>
 <td> <input class= "text" type= "text" name= "yoj"></td>
</tr>
<tr>
 <td class= "text1"> Course Name: </td>
 <td><select name= "courseId">
	<option value= "0">Select</option>
	<% for(int i= 0;i < cour.size();i++)
	{ %>
	   <option value= "<%= cour.get(i).getCourseid() %>"> <%= cour.get(i).getCoursename()%></option>
	<% } %>
 </td>
</tr>
<tr>
<td class= "text1"> Year: </td>
  <td><select name= "yearNum">
	<option value= "0">Select</option>
	<% int j= 0;
		for(int i= 0;i < cour.get(j).getDuration();i++)
	{ %>
	   <option value= "<%=i+1%>"><%=i+1%></option>
	<% } %>
      </select>
 </td>
</tr>
<tr>
 <td class= "text1"> Nationality: </td>
 <td> <input class= "text" type= "text" name= "nationality"></td>
</tr>
<tr>
 <td class= "text1"> Caste: </td>
 <td> <input class= "text" type= "text" name= "caste""></td>
</tr>
<tr>
 <td class= "text1"> If SC,Did he Submit the Certificate: </td>
 <td> <input class= "text" type= "radio" name= "Check" value= "Y"> Yes <input type= "radio" name= "Check" value= "N"> No </td>
</tr>
<tr>
 <td class= "text1"> Talents: </td>
 <td> <input class= "text" type= "text" name= "talents""></td>
</tr>
</table>
<h1 align= "center"> @ Please Enter the Student Address Details @ </h1>
<table align= "center">
<tr>
	<td class= "text1">Address-Type:- </td>
		<td><select name= "addrtype">
			<option value= ""> 	Select 		</option>
			<option value= "1"> 	Permanent	</option>
			<option value= "2"> 	Temporary	</option>
			<option value= "3"> 	Guardian	</option>
			<option value= "4"> 	Postal		</option>
</tr>
<tr>
	<th class= "text1"> Line-1 </th>
	<td class= "text1"><input type= "text" name= "line1"></td>
</tr>
<tr>
	<th class= "text1"> Line-2 </th>
	<td class= "text1"><input type= "text" name= "line2"></td>
</tr>
<tr>
	<th class= "text1"> Line-3 </th>
	<td class= "text1"><input type= "text" name= "line3"></td>
<tr>
	<th class= "text1"> Place </th>
	<td class= "text1"><input type= "text" name= "place"></td>
</tr>
<tr>
	<th class= "text1"> State </th>
	<td class= "text1"><input type= "text" name= "state"></td>
</tr>
<tr>
	<th class= "text1"> Pin-Code </th>
	<td class= "text1"><input type= "text" name= "pincode"></td>
</tr>
<tr>
	<td class= "text1">Address-Type:- </td>
		<td><select name= "addrtype">
			<option value= ""> 	Select 		</option>
			<option value= "1"> 	Permanent	</option>
			<option value= "2"> 	Temporary	</option>
			<option value= "3"> 	Guardian	</option>
			<option value= "4"> 	Postal		</option>
</tr>
<tr>
	<th class= "text1"> Line-1 </th>
	<td class= "text1"><input type= "text" name= "line1"></td>
</tr>
<tr>
	<th class= "text1"> Line-2 </th>
	<td class= "text1"><input type= "text" name= "line2"></td>
</tr>
<tr>
	<th class= "text1"> Line-3 </th>
	<td class= "text1"><input type= "text" name= "line3"></td>
<tr>
	<th class= "text1"> Place </th>
	<td class= "text1"><input type= "text" name= "place"></td>
</tr>
<tr>
	<th class= "text1"> State </th>
	<td class= "text1"><input type= "text" name= "state"></td>
</tr>
<tr>
	<th class= "text1"> Pin-Code </th>
	<td class= "text1"><input type= "text" name= "pincode"></td>
</tr>
<tr>
	<td class= "text1">Address-Type:- </td>
		<td><select name= "addrtype">
			<option value= ""> 	Select 		</option>
			<option value= "1"> 	Permanent	</option>
			<option value= "2"> 	Temporary	</option>
			<option value= "3"> 	Guardian	</option>
			<option value= "4"> 	Postal		</option>
</tr>
<tr>
	<th class= "text1"> Line-1 </th>
	<td class= "text1"><input type= "text" name= "line1"></td>
</tr>
<tr>
	<th class= "text1"> Line-2 </th>
	<td class= "text1"><input type= "text" name= "line2"></td>
</tr>
<tr>
	<th class= "text1"> Line-3 </th>
	<td class= "text1"><input type= "text" name= "line3"></td>
<tr>
	<th class= "text1"> Place </th>
	<td class= "text1"><input type= "text" name= "place"></td>
</tr>
<tr>
	<th class= "text1"> State </th>
	<td class= "text1"><input type= "text" name= "state"></td>
</tr>
<tr>
	<th class= "text1"> Pin-Code </th>
	<td class= "text1"><input type= "text" name= "pincode"></td>
</tr>
<tr>
	<td class= "text1">Address-Type:- </td>
		<td><select name= "addrtype">
			<option value= ""> 	Select 		</option>
			<option value= "1"> 	Permanent	</option>
			<option value= "2"> 	Temporary	</option>
			<option value= "3"> 	Guardian	</option>
			<option value= "4"> 	Postal		</option>
</tr>
<tr>
	<th class= "text1"> Line-1 </th>
	<td class= "text1"><input type= "text" name= "line1"></td>
</tr>
<tr>
	<th class= "text1"> Line-2 </th>
	<td class= "text1"><input type= "text" name= "line2"></td>
</tr>
<tr>
	<th class= "text1"> Line-3 </th>
	<td class= "text1"><input type= "text" name= "line3"></td>
<tr>
	<th class= "text1"> Place </th>
	<td class= "text1"><input type= "text" name= "place"></td>
</tr>
<tr>
	<th class= "text1"> State </th>
	<td class= "text1"><input type= "text" name= "state"></td>
</tr>
<tr>
	<th class= "text1"> Pin-Code </th>
	<td class= "text1"><input type= "text" name= "pincode"></td>
</tr>
</table>
<h1 align= "center"> @ Please Enter the Student Contact Details @ </h1>
<table align= "center" class= "Border">
<tr>
	<th class= "text1">Relation</th>
	<th class= "text1">Contact Number</th>
</tr>
<tr>
	<td class= "text1">
			   1. <input type= "text" name= "relation"> 
			      <input type= "text" name= "contactno">
	</td>
</tr>
<tr>
	<td class= "text1">
			   2. <input type= "text" name= "relation"> 
			      <input type= "text" name= "contactno">
	</td>
</tr>
<tr>
	<td class= "text1">
			   3. <input type= "text" name= "relation"> 
			      <input type= "text" name= "contactno">
	</td>
</tr>
<tr>
	<td class= "text1">
			   4. <input type= "text" name= "relation"> 
			      <input type= "text" name= "contactno">
	</td>
</tr>
<tr>
	<td class= "text1">
			   5. <input type= "text" name= "relation"> 
			      <input type= "text" name= "contactno">
	</td>
</tr>
<tr>
   <td class= "labelred"> <input type= "button" name= "btnCancel" value= "Cancel" onclick= "javascript:cancelStudent()"></td>
   <td class= "labelred" align= "right"> <input type= "button" name= "btnAdd" value= "Add" onclick= "javascript:insertStudent()"> </td>
</tr>
</table>
<input type= "hidden" name= "studentId" value= "">
<input type= "hidden" name= "module" value= "students">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
