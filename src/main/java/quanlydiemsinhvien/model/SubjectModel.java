package quanlydiemsinhvien.model;

public class SubjectModel {
	private String subjectid;
	private String subjectname;
	private int credit;
	private String department;
	private Long teacherid;
	
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Long getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(Long teacherid) {
		this.teacherid = teacherid;
	}
	
	
}
