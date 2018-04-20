<html>
<%@ page errorPage= "/ErrorPage.jsp" %>
<%@ page import= "bca.batch2011.project1.ca.*"%>
<%@ page import= "java.util.*" %>
 <% Student stu= (Student)request.getAttribute("view1");
    ArrayList<Course> cou=(ArrayList<Course>)request.getAttribute("coursearray");
%>
<script type="text/javascript" src= "CA.js"></script>
<link rel= stylesheet href= "style.css">
<head>
<title> View of Student </title>
</head>
<body>
<h1 align= "center"><u> <%= stu.getName() %>'s Profile </u></h1>
<form name= "viewStudent" method= "post" action= "/Project1/campusadmin">
<table align= "center">
        <h2 align= "center"><u> Personal Details </u></h2>
	<tr><th class="text1"> Regd No:-         </th><td>  <%= stu.getRegdno()%>      		</td></tr>
	<tr><th class="text1"> Name:-            </th><td>  <%= stu.getName()%>        		</td></tr>
	<tr><th class="text1"> Father Name:-     </th><td>  <%= stu.getF_name()%>      		</td></tr>
 	<tr><th class="text1"> Mother Name:-     </th><td>  <%= stu.getM_name()%>      		</td></tr>
 	<tr><th class="text1"> Guardian Name:-   </th><td>  <%= stu.getG_name()%>     		</td></tr>
 	<tr><th class="text1"> Date of Birth:-   </th><td>  <%= stu.getDob()%>	     		</td></tr>
	<tr><th class="text1"> Blood Group:-     </th><td>  <%= stu.getBg()%> 	     		</td></tr>
	<tr><th class="text1"> Year of Joining:- </th><td>  <%= stu.getYoj()%> 	     		</td></tr>
	<tr><th class="text1"> Course Year:-     </th><td>  <%= stu.getYearNum()%>     		</td></tr>
	<tr><th class="text1"> Course Name:-	</th><td>   <%= cou.get(0).getCoursename()%>  	</td></tr>
	<tr><th class="text1"> Nationality:-     </th><td>  <%= stu.getNationality()%> 		</td></tr>
	<tr><th class="text1"> Caste:-           </th><td>  <%= stu.getCaste()%>      		</td></tr>
	<tr><th class="text1"> Caste_Certificate </th><td>  <%= stu.getCheck()%>	     	</td></tr>
	<tr><th class="text1"> Talents:-         </th><td>  <%= stu.getTalents()%>     		</td></tr>
</table>
<table align= "center">
	<h2 align= "center"><u> Address Details </u></h2>
	<%AddressBean[] address= stu.getAddress();
	  for(int j= 0;j < address.length;j++)
	  {
		if(address[j] != null)
		{%>
			<%String s= "";
			s= String.valueOf(address[j].getAddresstype());
			if(s.equals("1"))
				s= "Permanent";
			if(s.equals("2"))
				s= "Temporary";
			if(s.equals("3"))
				s= "Guardian";
			if(s.equals("4"))
				s= "Postal";%>
			<tr><th class="text1"> Address-Type:-	        </th><td><u><b><%= s%><input type= "hidden" name= "addrtype" value= "<%= address[j].getAddresstype()%>">	</b></u></td></tr>
			<tr><th class="text1"> Line-1:-	        	</th><td>  <%= address[j].getLine1() %>		</td></tr>
			<tr><th class="text1"> Line-2:-	       		</th><td>  <%= address[j].getLine2() %>		</td></tr>
			<tr><th class="text1"> Line-3:-	       		</th><td>  <%= address[j].getLine3() %>		</td></tr>
			<tr><th class="text1"> Place:-	        	</th><td>  <%= address[j].getPlace() %>		</td></tr>
			<tr><th class="text1"> State:-	        	</th><td>  <%= address[j].getState() %>		</td></tr>
			<tr><th class="text1"> Pin-Code:-	        </th><td>  <%= address[j].getPincode() %>	</td></tr>
			
	     <% } %>
       <% } %>
</table>
<table align= "center">
	<h2 align= "center"><u> Contact Details </u></h2>
	<%ContactBean[] contacts= stu.getContacts();
	  for(int i= 0;i < contacts.length;i++)
	  {
		if(contacts[i] != null)
		{ %>
			<tr><th class="text1"> Relationship:-	</th><td>  <%= contacts[i].getRelation() %>	</td></tr>
			<tr><th class="text1"> Contact Number:-	</th><td>  <%= contacts[i].getContactNo() %>	</td></tr>
	     <%	} %>
      <% } %>
<tr>
   <td class="label"><input type= "button" name= "btnBack" value= "Back" onclick= "javascript:cancelStudent() "></td>
   <td class="label" align= "right"><input type= "button" name= "btnModify" value= "Modify" onclick= "javascript: modifyStudent(<%= stu.getStudentId() %>)"></td>
</tr>
</table>
<input type= "hidden" name= "studentId" value= "">
<input type= "hidden" name= "courseId" value= "<%=stu.getCourse_Id()%>">
<input type= "hidden" name= "module" value= "students">
<input type= "hidden" name= "access" value= "">
</body>
</html>
