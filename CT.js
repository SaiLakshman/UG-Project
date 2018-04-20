/*holiday*/
//function for taking data from user
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
//function for viewing holidays
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
/*course paper*/
//function for setting papers to a course
function setcoursepapers()
{
			document.forms[0].access.value= "setpapercourse";
			document.forms[0].submit();
}
//function for smodifying papers
function setmodifycoursepapers()
{
			document.forms[0].access.value= "setmodifypapercourse";
			document.forms[0].submit();
}
//function for taking data from user
function checkpaper()
{
			var x= document.getElementById("coursename");
			if(x.value == "" || x.value == null)
			{
				alert("please select a course");
			}
			var y= document.getElementById("batch");
			if(y.value == "" || y.value == null)
			{
				alert("please select a batch");
			}
			else if(x.value != "" && x.value != null && y.value != "" && y.value != null){		
				document.forms[0].access.value= "check";
				document.forms[0].submit();
			}
}
//function for setting papers
function setpaper()
{
			document.forms[0].access.value= "setpaper";
			document.forms[0].submit();
}
//function for modifying papers
function modifypaper()
{
			document.forms[0].access.value= "modifypaper";
			document.forms[0].submit();
}
//function for copying data
function copydraft()
{
			document.forms[0].access.value= "copydraft";
			document.forms[0].submit();
}
/*Teacher Paper*/
//function for setting teachers to papers
function setteacherpapers()
{
			document.forms[0].access.value= "setteacherpaper";
			document.forms[0].submit();
}
//function for modifying teachers for papers
function modifyteacherpaper()
{
			alert("Do u wish to modify ?");
			document.forms[0].access.value= "modifyteacherspaper";
			document.forms[0].submit();
}
//function for taking data from user
function checkteacher()
{
			var x= document.getElementById("coursename");
			if(x.value == "" || x.value == null)
			{
				alert("please select a course");
			}
			var y= document.getElementById("batch");
			if(y.value == "" || y.value == null)
			{
				alert("please select a batch");
			}
			else if(x.value != "" && x.value != null && y.value != "" && y.value != null){		
				document.forms[0].access.value= "check";
				document.forms[0].submit();
			}
}
//function for setting teachers
function setteacher()
{
			document.forms[0].access.value= "setteacher";
			document.forms[0].submit();
}
//function for modifying teachers
function modifyteacher()
{
			document.forms[0].access.value= "modifyteacher";
			document.forms[0].submit();
}
//function for copying data of other batch
function copyteacherpaperdraft()
{
			var x= document.getElementById("teacherbatch");
			if(x.value == "" || x.value == null)
			{
				alert("please select a batch");
			}
			else{
				document.forms[0].access.value= "copyteacherpaperdraft";
				document.forms[0].submit();
			}
}
/*ExamPaper*/
//function for taking data from user
function checkexam()
{
			
			var x= document.getElementById("ecoursename");
			if(x.value == "" || x.value == null)
			{
				alert("please select a course");
			}
			var y= document.getElementById("ebatch");
			if(y.value == "" || y.value == null)
			{
				alert("please select a batch");
			}
			else if(x.value != "" && x.value != null && y.value != "" && y.value != null){	
				document.forms[0].access.value= "echeck";
				document.forms[0].submit();
			}
}
//function from setting exams
function setexams()
{
			document.forms[0].access.value= "setexam";
			document.forms[0].submit();
}
//function for setting exams to papers
function setexampapers()
{
			document.forms[0].access.value= "setexampaper";
			document.forms[0].submit();
}
//function for modifying exams of papers
function modexampapers()
{
			document.forms[0].access.value= "modexampaper";
			document.forms[0].submit();
}
//function for modifying exams
function modifyexam()
{
			document.forms[0].access.value= "modifyexam";
			document.forms[0].submit();
}
/*Student marks*/
//function for viewing the starting page
function Cancel()
{
	if(confirm("Are you Sure to Cancel") == 1)
	{
		document.forms[0].access.value= "cancel";
		document.forms[0].submit();
	}
}
//function for taking the data from user
function checkstudentmarks()
{
			
			var x= document.getElementById("smcoursename");
			if(x.value == "" || x.value == null)
			{
				alert("please select a course");
			}
			var y= document.getElementById("smbatch");
			if(y.value == "" || y.value == null)
			{
				alert("please select a batch");
			}
			else if(x.value != "" && x.value != null && y.value != "" && y.value != null){	
				document.forms[0].access.value= "smcheck";
				document.forms[0].submit();
			}
}
//function for viewing the marks
function viewmarks()
{
			document.forms[0].access.value= "viewmarks";
			document.forms[0].submit();
}
//function for setting the marks
function setmarks()
{
			document.forms[0].access.value= "setmarks";
			document.forms[0].submit();
}
//function for modifying the marks
function modifymarks()
{
			document.forms[0].access.value= "modifymarks";
			document.forms[0].submit();
}
//function for setting the marks to students
function setmarkstostudents()
{
			if(confirm("Do U wish to set marks") == 1){
				document.forms[0].access.value= "setmarkstostudents";
				document.forms[0].submit();
			}
}
//function for modifying the marks for students
function modifymarkstostudents()
{
			if(confirm("Do U wish to modify marks") == 1){
				document.forms[0].access.value= "modmarkstostudents";
				document.forms[0].submit();
			}
}
/*Frames*/
//function for course paper frame
function CoursePaperframe()
{
			document.forms[0].module.value= "coursepaper";
			document.forms[0].access.value= "Frames";
			document.forms[0].submit();
}
//function for paper teacher frame
function PaperTeacherframe()
{
			document.forms[0].module.value= "teacherpaper";
			document.forms[0].access.value= "Frames";
			document.forms[0].submit();
}
//function for exam paper frame
function ExamPaperframe()
{
			document.forms[0].module.value= "exampaper";
			document.forms[0].access.value= "Frames";
			document.forms[0].submit();
}
//function for student marks frame
function MarksStudentsframe()
{
			document.forms[0].module.value= "marksstudents";
			document.forms[0].access.value= "Frames";
			document.forms[0].submit();
}
//function for attendance frame
function Attendanceframe()
{
			document.forms[0].module.value= "attendance";
			document.forms[0].access.value= "Frames";
			document.forms[0].submit();
}
