package bca.batch2011.project1.ct;

public class ExamPaper {
	private int exam_id,exam_paper_id,marks;
	private String exam_code= "",exam_title= "",exam_paper_title= "";
	
	/**Getter and setter methods for Exam_paper_title*/
	public String getExam_paper_title() {
		return exam_paper_title;
	}
	public void setExam_paper_title(String exam_paper_title) {
		this.exam_paper_title = exam_paper_title;
	}
	/**Getter and setter methods for Exam_paper_id*/
	public int getExam_paper_id() {
		return exam_paper_id;
	}
	public void setExam_paper_id(int exam_paper_id) {
		this.exam_paper_id = exam_paper_id;
	}
	/**Getter and setter methods for Marks*/
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	/**Getter and setter methods for Exam_id*/
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	/**Getter and setter methods for Exam_code*/
	public String getExam_code() {
		return exam_code;
	}
	public void setExam_code(String exam_code) {
		this.exam_code = exam_code;
	}
	/**Getter and setter methods for Exam_title*/
	public String getExam_title() {
		return exam_title;
	}
	public void setExam_title(String exam_title) {
		this.exam_title = exam_title;
	}
}
