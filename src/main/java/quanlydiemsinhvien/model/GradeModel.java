package quanlydiemsinhvien.model;

public class GradeModel {
	private Long studentid;
	private Long subjectid;
	private double grade1;
	private double grade2;
	private String semester;
	private String weight;
	private String note;
	public Long getStudentid() {
		return studentid;
	}
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}
	public Long getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(Long subjectid) {
		this.subjectid = subjectid;
	}
	public double getGrade1() {
		return grade1;
	}
	public void setGrade1(double grade1) {
		this.grade1 = grade1;
	}
	public double getGrade2() {
		return grade2;
	}
	public void setGrade2(double grade2) {
		this.grade2 = grade2;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
