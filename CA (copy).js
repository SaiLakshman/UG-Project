/*----------Campus Administration
Student Module
to add Student*/
function addStudent()
{
   	if(confirm("Do you want to add new Student") == 1)
   	{
     		document.forms[0].access.value= "Add New Student";
     		document.forms[0].submit();
   	}
}
//to modify the Students
function modifyStudent(x)
{
	if(confirm("Are You Sure?You Want to Modify") == 1)
   	{ 
     		document.forms[0].studentId.value= x;
     		document.forms[0].access.value= "modifystudent";
     		document.forms[0].submit();
   	}
}
//to cancel any changes
function cancelStudent()
{
   	if(confirm("Do you want to cancel?") == 1)
   	{
     		document.forms[0].access.value= "Frames";
     		document.forms[0].submit();
   	}
}
//inserting into database
function insertStudent()
{
	if(document.forms[0].Name.value == "")
	{
		alert("Fill the Student's Name");
		document.forms[0].Name.focus();
		return;
	}
	
	if(document.forms[0].f_name.value == "")
	{
		if(document.forms[0].m_name.value == "")
		{
			if(document.forms[0].g_name.value == "")
			{
				alert("Fill atleast one column about Parental Details");
				document.forms[0].f_name.focus();
				return;
			}
		}
	}

	if(document.forms[0].dateofbirth.value == 0)
	{
		alert("Fill the Date_Of_Birth");
		document.forms[0].Dob.focus();
		return;
	}

	if(document.forms[0].bg.value == "")
	{
		alert("Fill the Blood Group");
		document.forms[0].bg.focus();
		return;
	}

	if(document.forms[0].yoj.value == 0)
	{
		alert("Fill the Year_Of_Joining");
		document.forms[0].yoj.focus();
		return;
	}

	if(document.forms[0].nationality.value == "")
	{
		alert("Fill the Nationality");
		document.forms[0].nationality.focus();
		return;
	}
	if(document.forms[0].caste.value == "")
	{
		alert("Fill the Caste");
		document.forms[0].caste.focus();		
		return;
	}
	if(document.forms[0].relation.value == "")
	{
		alert("Fill the Relation");
		document.forms[0].relation.focus();		
		return;
	}
	if(document.forms[0].contactno.value == "")
	{
		alert("Fill the Contact Number");
		document.forms[0].contactno.focus();		
		return;
	}
	alert("Student is Successfully added");
   	document.forms[0].access.value= "insertstudent";
   	document.forms[0].submit();
}
//update into database
function updateStudent(x)
{
   	if(confirm("Sure to change the details?") == 1)
   	{
		if(confirm("Are You Sure?") == 1)
		{
			document.forms[0].studentId.value= x;
     			document.forms[0].access.value= "updatestudent";
     			document.forms[0].submit();
		}
   	}
}
//deleting the Students
function DeleteStudent()
{
	if(confirm("Are you sure to delete the Student(s)?") == 1)
	{
		alert("You will delete Student permanently");
		document.forms[0].access.value= "deletestudent";
		document.forms[0].submit();
	}
}
//viewing the Students
function viewStudent(x)
{
	if(confirm("You want to View the Student") == 1)
	{
		document.forms[0].studentId.value= x;
		document.forms[0].access.value= "viewstudent";
		document.forms[0].submit();
	}
}
//checking the Students, if existing
function check()
{
	if(document.forms[0].Check.value == "")
	{
		alert("Please mention about Caste Certificate");
	}
}

/*  Course Module
updating in the database*/
function updateCourse(a)
{
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].courseId.value= a;
		document.forms[0].access.value= "updatecourse";
		document.forms[0].submit();
	}
}
//deleting the Course
function deleteCourse()
{
	if(confirm("Are you Sure to Delete")== 1)
	{
		document.forms[0].access.value= "deletecourse";
		document.forms[0].submit();
	}
}
//adding new Course
function addCourse()
{
	document.forms[0].access.value= "Add New Course";
	document.forms[0].submit();
}
//inserting into database
function insertCourse()
{
	if(confirm("Do you want to add")== 1)
	{
		var x= document.getElementById("coursename");
		var y= document.getElementById("coursetitle");
		if(x.value == "" && y.value != "")
		{
			alert("please enter coursename");
			return false;
		}
		if(y.value == "" && x.value != "")
		{
			alert("please enter coursetitle");
			return false;
		}
		if(x.value == "" && y.value == "")
		{
			alert("please fill the requirements");
			return false;
		}
		else 
		{
			document.forms[0].access.value= "insertcourse";
			document.forms[0].submit();
		}
	}
}
//canceling the changes
function cancelCourse()
{
	if(confirm("Do you want to cancel the process") == 1)
	{ 
		document.forms[0].access.value= "Frames";
		document.forms[0].submit();
	}
}
//modifying the Courses
function modifyCourse(x)
{
	if(confirm("Are you sure that, you want to modify")== 1)
	{
		document.forms[0].courseId.value= x;
		document.forms[0].access.value= "modifycourse";
		document.forms[0].submit();
	}
}

/*      Exam Module
updating Exam*/
function modifyExam(a)
{
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].examId.value= a;
		document.forms[0].access.value= "modifyexam";
		document.forms[0].submit();
	}
}
//deleting the Exam
function deleteExam()
{
	if(!document.forms[0].deleteBox.checked)
	{
		alert("None to delete");
		return;
	}
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].access.value= "deleteexam";
		document.forms[0].submit();
	}
}
//adding new Exam
function addnewExam()
{
	document.forms[0].access.value= "Add New Exam";
	document.forms[0].submit();
}
//inserting into database
function addExam()
{
	if(confirm("Do you want to add")== 1)
	{
		var x= document.getElementById("examcode");
		var y= document.getElementById("examtitle");
		if(x.value == "" && y.value != "")
		{
			alert("please enter examcode");
			return false;
		}
		if(y.value == "" && x.value != "")
		{
			alert("please enter examtitle");
			return false;
		}
		if(x.value == "" && y.value == "")
		{
			alert("please fill the requirements");
			return false;
		}
		else 
		{
			document.forms[0].access.value= "insertexam";
			document.forms[0].submit();
		}
	}
}
//canceling the changes
function cancelExam()
{
	if(confirm("Do you want to cancel the Process") == 1)
	{
		document.forms[0].access.value= "Frames";
		document.forms[0].submit();
	}
}
//modifying the Exam
function updateExam(x)
{
	if(confirm("Are you sure that, you want to modify")== 1)
	{
		document.forms[0].examId.value= x;
		document.forms[0].access.value= "updateexam";
		document.forms[0].submit();
	}
}

/*   Department Module */
function adddepartment()
{
	if(confirm("Do you really want to add")== 1)
	{
		document.forms[0].access.value="ADDNEWDEPARTMENT";
		document.forms[0].submit();
	}
}
function subdepartment(x)
{
	if(confirm("Going to Modify") == 1)
	{
		document.forms[0].department_id.value=x;
		document.forms[0].access.value="MODIFY";
		document.forms[0].submit();
	}
}
function deldepartment()
{
	if(confirm("Do you really want to DELETE")== 1)
	{
		document.forms[0].access.value="DELETE";
		document.forms[0].submit();
	}
}
function insertdepartment()
{
	var i=1;
	for(i=1;i<3;i++)
	{
		var x= document.getElementById(i);
		if(x.value == null || x.value== "")
		{
			alert("Please Enter the"+x.name);
			return false;
		}
	}
	if(i == 3)
	{
		if(confirm("Inserted Successfully") == 1)
		{
			document.forms[0].access.value="ADD";
			document.forms[0].submit();
		}
	}
}
function canceldepartment()
{
	if(confirm("Go Back") == 1)
	{
	 	document.forms[0].access.value="CANCEL";
		document.forms[0].submit();
	}
}
function modifydepartment(x)
{
	if(confirm("Updated Successfully")== 1)
	{
		document.forms[0].department_id.value= x;
		document.forms[0].access.value="UPDATE";
		document.forms[0].submit();
	}
}

/*    Paper Module */
function addpaper()
{
	if(confirm("Do you really want to add")== 1)
	{
		document.forms[0].access.value="ADDNEWPAPER";
		document.forms[0].submit();
	}
}
function subpaper(x)
{
	if(confirm("Going to Modify") == 1)
	{
		document.forms[0].paper_id.value=x;
		document.forms[0].access.value="MODIFY";
		document.forms[0].submit();
	}
}
function delpaper()
{
	if(confirm("Do you really want to DELETE")== 1)
	{
		document.forms[0].access.value="DELETE";
		document.forms[0].submit();
	}
}
function insertpaper()
{
	var i=1;
	for(i=1;i<2;i++)
	{
		var x= document.getElementById(i);
		if(x.value == null || x.value== "")
		{
			alert("Please Enter the"+x.name);
			return false;
		}
	}
	if(i == 2)
	{
		if(confirm("Inserted Successfully") == 1)
		{
			document.forms[0].access.value="ADD";
			document.forms[0].submit();
		}
	}
	
}
function cancelpaper()
{
	if(confirm("Go Back") == 1)
	{
	 	document.forms[0].access.value="CANCEL";
		document.forms[0].submit();
	}
}
function modifypaper(x)
{
	if(confirm("Updated Successfully")== 1)
	{
		document.forms[0].paper_id.value= x;
		document.forms[0].access.value="UPDATE";
		document.forms[0].submit();
	}
}

/*      Semester Module
updating the Semester */
function updateSemesters()
{
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].access.value= "updatesem";
		document.forms[0].submit();
	}
}

/*      Hostel Administration 
	Self reliance department module
add button is pressed */
function addSRD()
{
	if(confirm("Do you want to add Self Reliance Department") == 1)
	{
		document.forms[0].access.value= "Add New SRD";
		document.forms[0].submit();
	}
}

//inserting into SRD
function insertSRD()
{
	if(document.forms[0].srdName.value == "")
	{
		alert("Fill the SRD's Name");
		document.forms[0].srdName.focus();
		return;
	}
	alert("SRD is Successfully added");
   	document.forms[0].access.value= "insertsrd";
   	document.forms[0].submit();
}
//modification of the self-reliance-department
function modifySRD(x)
{
	if(confirm("Are You Sure?You Want to Modify") == 1)
   	{ 
     		document.forms[0].srdId.value= x;
     		document.forms[0].access.value= "modifysrd";
     		document.forms[0].submit();
   	}
}
//updating into the self-reliance-department
function updateSRD(x)
{
   	if(confirm("Sure to change the details?") == 1)
   	{
		if(confirm("Are You Sure?") == 1)
		{
			document.forms[0].srdId.value= x;
     			document.forms[0].access.value= "updatesrd";
     			document.forms[0].submit();
		}
   	}
}

//canceling the self-reliance-department
function cancelSRD()
{
   	if(confirm("Do you want to cancel?") == 1)
   	{
     		document.forms[0].access.value= "Frames";
     		document.forms[0].submit();
   	}
}
//deleting the self-reliance-department
function DeleteSRD()
{
	if(confirm("Are you sure to delete the SRD(s)?") == 1)
	{
		alert("You will delete SRD permanently");
		document.forms[0].access.value= "deletesrd";
		document.forms[0].submit();
	}
}

/*   	
 Module
updating into database */
function updateRoom(a)
{
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].roomId.value= a;
		document.forms[0].access.value= "updateroom";
		document.forms[0].submit();
	}
}
//deleting the Room
function deleteRoom()
{
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].access.value= "deleteroom";
		document.forms[0].submit();
	}
}
//addition of new Room
function addnewRoom()
{
	if(confirm("Are you sure")== 1)
	{
		document.forms[0].access.value= "Add New Room";
		document.forms[0].submit();
	}
}
//inserting into the database
function insertRoom()
{
	if(document.forms[0].roomNo.value == "")
	{
		alert("Fill the Room No");
		document.forms[0].roomNo.focus();
		return;
	}
	if(document.forms[0].numCupboards.value == "")
	{
		alert("Fill the total Number of Cupboards in the Room");
		document.forms[0].numCupboards.focus();
		return;
	}
	if(confirm("Are you Sure?")==1)
	{
		document.forms[0].access.value= "insertroom";
		document.forms[0].submit();
	}
}
//canceling the changes
function cancelRoom()
{
	if(confirm("Do you want to Cancel the process?") == 1)
	{
		document.forms[0].access.value= "Frames";
		document.forms[0].submit();
	}
}
//for modification
function modifyRoom(x)
{
	if(confirm("Are you sure that, you want to modify")== 1)
	{
		document.forms[0].access.value= "modifyroom";
		document.forms[0].roomId.value= x;
		document.forms[0].submit();
	}
}

/*	Fees Module
add button is pressed */
function addFees()
{
	if(confirm("Do you want to add Fees") == 1)
	{
		document.forms[0].access.value= "Add New Fees";
		document.forms[0].submit();
	}
}

//inserting into Fees_Type
function insertFees()
{
	if(document.forms[0].feesName.value == "")
	{
		alert("Fill the Fee Type");
		document.forms[0].feesName.focus();		
		return;
	}
	alert("Fees Type is Successfully added");
   	document.forms[0].access.value= "insertfeestype";
   	document.forms[0].submit();
}
//modification in the Fees
function modifyFees(x)
{
	if(confirm("Are You Sure?You Want to Modify") == 1)
   	{ 
     		document.forms[0].feesId.value= x;
     		document.forms[0].access.value= "modifyfeestype";
     		document.forms[0].submit();
   	}
}
//updating into the Fees
function updateFees(x)
{
   	if(confirm("Sure to change the details?") == 1)
   	{
		document.forms[0].feesId.value= x;
     		document.forms[0].access.value= "updatefeestype";
     		document.forms[0].submit();
   	}
}

//canceling the fees
function cancelFees()
{
   	if(confirm("Do you want to cancel?") == 1)
   	{
     		document.forms[0].access.value= "Frames";
     		document.forms[0].submit();
   	}
}
//deleting the Fees_Type
function DeleteFees()
{
	if(confirm("Are you sure to delete the Fees_Type(s)?") == 1)
	{
		alert("You will delete Fees_Type permanently");
		document.forms[0].access.value= "deletefeestype";
		document.forms[0].submit();
	}
}

//teacher module
function subteacher(x)
{
	if(confirm("Going to Modify") == 1)
	{
		document.forms[0].teacher_id.value=x;
		document.forms[0].access.value="MODIFY";
		document.forms[0].submit();
	}
}
function cancelteacher()
{
	if(confirm("Go Back") == 1)
	{
	 	document.forms[0].access.value="CANCEL";
		document.forms[0].submit();
	}
}
function addteacher()
{
	if(confirm("Do You Want to Add") == 1)
	{
		document.forms[0].access.value="ADDNEWTEACHER";
		document.forms[0].submit();
	}
}
function delteacher()
{
	if(confirm("Do you really want to DELETE")== 1)
	{
		document.forms[0].access.value="DELETE";
		document.forms[0].submit();
	}
}
function insertteacher()
{
	var i=1;
	for(i=1;i<5;i++)
	{
		var x= document.getElementById(i);
		if(x.value == null || x.value== "")
		{
			alert("Please Enter the"+x.name);
			return false;
		}
	}
	if(i == 5)
	{
		if(confirm("Inserted Successfully") == 1)
		{
			document.forms[0].access.value="ADD";
			document.forms[0].submit();
		}
	}
	
	

}
function modifyteacher(x)
{
	if(confirm("Updated Successfully")== 1)
	{
		document.forms[0].teacher_id.value= x;
		document.forms[0].access.value="UPDATE";
		document.forms[0].submit();
	}
}

//paper module
function addpaper()
{
	if(confirm("Do you really want to add")== 1)
	{
		document.forms[0].access.value="ADDNEWPAPER";
		document.forms[0].submit();
	}
}
function subpaper(x)
{
	if(confirm("Going to Modify") == 1)
	{
		document.forms[0].paper_id.value=x;
		document.forms[0].access.value="MODIFY";
		document.forms[0].submit();
	}
}
function delpaper()
{
	if(confirm("Do you really want to DELETE")== 1)
	{
		document.forms[0].access.value="DELETE";
		document.forms[0].submit();
	}
}
function insertpaper()
{
	var i=1;
	for(i=1;i<2;i++)
	{
		var x= document.getElementById(i);
		if(x.value == null || x.value== "")
		{
			alert("Please Enter the"+x.name);
			return false;
		}
	}
	if(i == 2)
	{
		if(confirm("Inserted Successfully") == 1)
		{
			document.forms[0].access.value="ADD";
			document.forms[0].submit();
		}
	}
	
}
function cancelpaper()
{
	if(confirm("Go Back") == 1)
	{
	 	document.forms[0].access.value="CANCEL";
		document.forms[0].submit();
	}
}
function modifypaper(x)
{
	if(confirm("Updated Successfully")== 1)
	{
		document.forms[0].paper_id.value= x;
		document.forms[0].access.value="UPDATE";
		document.forms[0].submit();
	}
}

//Department module
function adddepartment()
{
	if(confirm("Do you really want to add")== 1)
	{
		document.forms[0].access.value="ADDNEWDEPARTMENT";
		document.forms[0].submit();
	}
}
function subdepartment(x)
{
	if(confirm("Going to Modify") == 1)
	{
		document.forms[0].department_id.value=x;
		document.forms[0].access.value="MODIFY";
		document.forms[0].submit();
	}
}
function deldepartment()
{
	if(confirm("Do you really want to DELETE")== 1)
	{
		document.forms[0].access.value="DELETE";
		document.forms[0].submit();
	}
}
function insertdepartment()
{
	var i=1;
	for(i=1;i<3;i++)
	{
		var x= document.getElementById(i);
		if(x.value == null || x.value== "")
		{
			alert("Please Enter the"+x.name);
			return false;
		}
	}
	if(i == 3)
	{
		if(confirm("Inserted Successfully") == 1)
		{
			document.forms[0].access.value="ADD";
			document.forms[0].submit();
		}
	}
}
function canceldepartment()
{
	if(confirm("Go Back") == 1)
	{
	 	document.forms[0].access.value="CANCEL";
		document.forms[0].submit();
	}
}
function modifydepartment(x)
{
	if(confirm("Updated Successfully")== 1)
	{
		document.forms[0].department_id.value= x;
		document.forms[0].access.value="UPDATE";
		document.forms[0].submit();
	}
}

//	Attendance Module
function submissioneve(x)
{
	if(confirm("Do u wish to modify the Event Name")==1)
	{
		document.forms[0].EventId.value= x;
		document.forms[0].access.value= "modifyevent";
		document.forms[0].submit();
	}
}

function addnewevent()
{
	if(confirm("Do u wish to add new event") == 1)
	{
		document.forms[0].access.value= "ADD NEW EVENT";
		document.forms[0].submit();
	}
		
}

function delEvent()
{
	if(confirm("Do u wish to delete")==1)
	{
		document.forms[0].access.value= "deleteevent";
		document.forms[0].submit();
	}
}
function cancelEvent()
{
	if(confirm("Do u wish to cancel")==1)
	{
		document.forms[0].access.value= "Frames";
		document.forms[0].submit();
	}
}
function Submit()
{
	if(confirm("Do u wish to submit")==1)
	{
		document.forms[0].access.value= "ok";
		document.forms[0].submit();
	}
}
function modifyEvent(x)
{
	if(confirm("Do u wish to submit")==1)
	{
		var y= document.getElementById("eventName");
		if(y.value == null  || y.value == "")
		{ 
			alert("Please Enter Name");
			document.forms[0].eventName.focus();
			return false;
		}
		else
		{
			document.forms[0].EventId.value= x;
			document.forms[0].access.value= "updateevent";
			document.forms[0].submit();
		}	
	}
}
function insertEvent()
{
	
	if(confirm("Do u wish to insert")==1)
	{
		var x= document.getElementById("event_name");
		if(x.value == null  || x.value == "")
		{ 
			alert("Please Enter Name");
			document.forms[0].eventName.focus();
			return false;
		}
		else 
		{
			document.forms[0].access.value= "insertevent";
			document.forms[0].submit();
		}
	}
}

/*holiday*/
function inshol()
{
	if(confirm("Do u wish to submit")==1)
	{
		var x= document.getElementById("holeveid");
		if(x.value == null  || x.value == "")
		{ 
			alert("Please select an Event");
			document.forms[0].event_name.focus();
			return false;
		}
		var y= document.getElementById("starting");
		if(y.value == null  || y.value == "")
		{ 
			alert("Please enter the date");
			document.forms[0].event_name.focus();
			return false;
		}
		var z= document.getElementById("ending");
		if(z.value == null  || z.value == "")
		{ 
			alert("Please enter the date");
			document.forms[0].event_name.focus();
			return false;
		}
		var reason= document.getElementById("reason")
		if(reason.value == null  || reason.value == "" || reason.trim == "")
		{ 
			alert("Please enter the reason");
			document.forms[0].event_name.focus();
			return false;
		}
		else if((x.value != null  && x.value != "") && (y.value != null  && y.value != "") && (z.value != null  || z.value != "") && reason.value != null  && reason.value != "" )
		{ 
			document.forms[0].access.value= "Modholiday";
			document.forms[0].submit();
		}	

	}
}
function viewhol()
{
		var x= document.getElementById("holeveid");
		if(x.value == null  || x.value == "")
		{ 
			alert("Please select an Event");
			document.forms[0].event_name.focus();
			return false;
		}
		else{
			document.forms[0].access.value= "viewholiday";
			document.forms[0].submit();
		}
}

function Cancel()
{
	document.forms[0].access.value= "cancel";
	document.forms[0].submit();
}
//-----------Frames for Different Modules
function Semestersframe()
{
	document.forms[0].module.value= "semesters";
	document.forms[0].access.value= "update";
	document.forms[0].submit();
}
function Departmentsframe()
{
	document.forms[0].module.value= "department";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Papersframe()
{
	document.forms[0].module.value= "paper";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Coursesframe()
{
	document.forms[0].module.value= "courses";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Teachersframe()
{
	document.forms[0].module.value= "teacher";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Examsframe()
{
	document.forms[0].module.value= "exams";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Studentsframe()
{
	document.forms[0].module.value= "students";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Attendanceframe()
{
	document.forms[0].module.value= "attendance";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
function Holidaysframe()
{
	document.forms[0].module.value= "holidays";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}

function Roomsframe()
{
	document.forms[0].module.value= "rooms";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}

function SRDsframe()
{
	document.forms[0].module.value= "srd";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}

function Fees_Typeframe()
{
	document.forms[0].module.value= "fees";
	document.forms[0].access.value= "Frames";
	document.forms[0].submit();
}
