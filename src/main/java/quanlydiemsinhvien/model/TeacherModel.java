package quanlydiemsinhvien.model;

import java.util.List;

public class TeacherModel extends AbstractModel{
	
	private String subjectid;
	private String email;
	private List<String> subjectids;
	
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getSubjectids() {
		return subjectids;
	}
	public void setSubjectids(List<String> subjectids) {
		this.subjectids = subjectids;
	}
	
	
}
