<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<%@ page import= "bca.batch2011.project1.ca.*" %>
<%@ page import= "java.util.*" %>
<head>
<title> Modification Page</title>
<script type= "text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
</head>
<body>
<% Student s= (Student) request.getAttribute("up"); 
   ArrayList<Course> cour= (ArrayList<Course>) request.getAttribute("course");%>
<h1 align= "center"> Modify <%= s.getName() %>'s Details </h1>
<form name= "formModifyStudent" method= "post" action= "/Project1/campusadmin">
<table align= "center" class= "Border">
<tr>
   <td class= "sai1"> Regd No: </td>
   <td> <input class= "text1" type= "text" name= "Regdno" value= "<%=s.getRegdno()%>" > </td>
</tr>  
<tr>
   <td class= "sai1"> Name: </td> 
   <td> <input class= "text1"  type= "text" name= "Name" value= "<%=s.getName()%>" > </td>
</tr>
<tr>
   <td class= "sai1">Father Name: </td>
   <td> <input class= "text1"  type= "text" name= "f_name" value= "<%=s.getF_name()%>" > </td>
</tr>
<tr>
   <td class= "sai1"> Mother Name: </td>
   <td> <input class= "text1"  type= "text" name= "m_name" value= "<%=s.getM_name()%>" > </td>
</tr>
<tr> 
   <td class= "sai1"> Guardian Name: </td>
   <td> <input class= "text1"  type= "text" name= "g_name" value= "<%=s.getG_name()%>" > </td>
</tr>
<tr>
   <td class= "sai1"> Date of Birth: </td>
   <td> <input class= "text1"  type= "text" name= "dateofbirth" value= "<%=s.getDob()%>" > </td>
</tr>
<tr>
   <td class= "sai1"> Blood Group: </td>
   <td> <input class= "text1"  type= "text" name= "bg" value= "<%=s.getBg()%>" > </td>
</tr>
<tr>
   <td class= "sai1"> Year of Joining: </td>
   <td> <input class= "text1"  type= "text" name= "yoj" value= "<%=s.getYoj()%>" > </td>
</tr>
</tr>
<td class= "sai1">Course:</td>
	<td> <select name= "courseId">
	    	<% for(int k= 0;k<cour.size();k++)
	       		{ if(s.getCourse_Id() == cour.get(k).getCourseid()){%>
           			<option value= "<%= cour.get(k).getCourseid()%>"selected>
					<%= cour.get(k).getCoursename() %>
				</option>
		<%} else{%>
               		        <option value= "<%= cour.get(k).getCourseid()%>"><%= cour.get(k).getCoursename() %><%}%>
				</option>
    		<% }%>
     	     </select>
    	</td>
</tr>
<tr>
<td class= "sai1"> Year: </td>
  <td><select name= "yearNum">
	<option value= "0">Select</option>
		<% for(int i= 0;i < cour.get(i).getDuration();i++)
			{ if(s.getYearNum() == cour.get(i).getDuration()){%>
	   			<option value= "<%=i+1%>"selected><%=i+1%></option>
		<%} else{%>
			<option value= "<%=i+1%>"><%=i+1%></option> <% } %>
		<% } %>	
      </select>
 </td>
</tr>
<tr>
   <td class= "sai1"> Nationality: </td>
   <td> <input class= "text1"  type= "text" name= "nationality" value= "<%=s.getNationality()%>" > </td>
</tr>
<tr>
   <td class= "sai1"> Caste: </td>
   <td> <input class= "text1"  type= "text" name= "caste" value= "<%=s.getCaste()%>" > </td>
</tr>
<tr>
 <td class= "sai1"> If SC,Did he Submit the Certificate: </td>
 <td> <input class= "text1"  type= "radio" name= "Check" value= "<%= s.getCheck()%>"checked>Y  <input type= "radio" name= "Check" value= "<%=s.getCheck()%>"checked>N</td>
</tr>
<tr>
   <td class= "sai1"> Talents: </td>
   <td> <input class= "text1"  type= "text" name= "talents" value= "<%=s.getTalents()%>" > </td>
</tr>
</table>
<table align= "center">
	<h2 align= "center"><u> Address Details </u></h2>
	<%AddressBean[] address= s.getAddress();
	  for(int j= 0;j < address.length;j++)
	  {
		if(address[j] != null)
		{ %>
			<tr>
				<td class= "sai1"> Address Type:- </td>
				<td><select name= "addrtype">
					<option value= ""  <% if(address[j].getAddresstype() == 0) out.print("selected");%>>
						Select
					<option value= "1" <% if(address[j].getAddresstype() == 1) out.print("selected");%>>
						Permanent
					</option>
					<option value= "2" <% if(address[j].getAddresstype() == 2) out.print("selected");%>>
						Temporary
					</option>
					<option value= "3" <% if(address[j].getAddresstype() == 3) out.print("selected");%>>
						Guardian
					</option>
					<option value= "4" <% if(address[j].getAddresstype() == 4) out.print("selected");%>>
						Postal
					</option>	
				</select></td>
			</tr>
			<tr>
				<th class="sai1"> Line-1:-</th>
				<td><input class= "text1"  type= "text" name= "line1" value= "<%= address[j].getLine1()%>"></td>
			</tr>
			<tr>
				<th class="sai1"> Line-2:-</th>
				<td><input class= "text1"  type= "text" name= "line2" value= "<%= address[j].getLine2()%>"></td>
			</tr>
			<tr>
				<th class="sai1"> Line-3:-</th>
				<td><input class= "text1"  type= "text" name= "line3" value= "<%= address[j].getLine3()%>"></td>
			</tr>
			<tr>
				<th class="sai1"> Place:-</th>
				<td><input class= "text1"  type= "text" name= "place" value= "<%= address[j].getPlace()%>"></td>
			</tr>
			<tr>
				<th class="sai1"> State:-</th>
				<td><input class= "text1"  type= "text" name= "state" value= "<%= address[j].getState()%>"></td>
			</tr>
			<tr>
				<th class="sai1"> Pin-Code:-</th>
				<td><input class= "text1"  type= "text" name= "pincode" value= "<%= address[j].getPincode()%>"></td>
			</tr>
	     <% } %>
       <% } %>
</table>
<table align= "center">
	<h2 align= "center"><u> Contact Details </u></h2>
	<%ContactBean[] contacts= s.getContacts();
	  for(int i= 0;i < contacts.length;i++)
	  {
		if(contacts[i] != null)
		{ %>
			<tr>
				<th class="sai1"> Relationship:-</th>
				<td><input class= "text1"  type= "text" name= "relation" value= "<%= contacts[i].getRelation()%>"></td>
			</tr>
			<tr>
				<th class="sai1"> Contact Number:-</th>
				<td><input class= "text1"  type= "text" name= "contactno" value= "<%= contacts[i].getContactNo()%>"></td>
			</tr>
	     <%	} %>
      <% } %>
<tr>
   <td class= "input.btn"><input type= "button" name= "btnCancel" value= "Cancel" onclick= "javascript:viewStudent(<%= s.getStudentId()%>)"></td>
   <td align= "left"><input class= "input.btn"  type= "button" name= "btnBack" value= "Back to List Students" onclick= "javascript:cancelStudent()"></td>
   <td align= "right"><input class= "input.btn"  type= "button" name= "btnSubmit" value= "Submit" onclick= "javascript:updateStudent(<%= s.getStudentId() %>)"></td>
</tr>
</table>
<input type= "hidden" name= "studentId" value= "">
<input type= "hidden" name= "module" value= "students">
<input type= "hidden" name= "access" value= "">
</form>
</body>
</html>
