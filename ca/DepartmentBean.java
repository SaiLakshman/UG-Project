package bca.batch2011.project1.ca;

public class DepartmentBean 
{
		private int Departmentid;
		private String Departmentname="";
		private String Departmenttitle="";
		
		/**
		 * Default constructor for initializing member variables
		 * */
		public DepartmentBean()
		{
			Departmentid= 0;
			Departmentname="";
			Departmenttitle="";
		}

		/**
		 * The method below has Getter_Setter for all member variables
		 * */
		public DepartmentBean(String department) {
			this.Departmentname=department;
		}

		public int getDepartmentid() 
		{
			return Departmentid;
		}

		public void setDepartmentid(int departmentid) {
			Departmentid = departmentid;
		}

		public String getDepartmentname() {
			return Departmentname;
		}

		public void setDepartmentname(String departmentname) {
			Departmentname = departmentname;
		}

		public String getDepartmenttitle() {
			return Departmenttitle;
		}

		public void setDepartmenttitle(String departmenttitle) {
			Departmenttitle = departmenttitle;
		}
}