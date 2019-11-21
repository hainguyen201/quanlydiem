package quanlydiemsinhvien.model;

public class StudentGradeModel {
	private String semester;
	private String subjectid;
	private String subjectname;
	private String credit;
	private String classid;
	private float grade1;
	private float grade2;
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getSubjectname() {
		return subjectname;
	}
	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public float getGrade1() {
		return grade1;
	}
	public void setGrade1(float grade1) {
		this.grade1 = grade1;
	}
	public float getGrade2() {
		return grade2;
	}
	public void setGrade2(float grade2) {
		this.grade2 = grade2;
	}
}
