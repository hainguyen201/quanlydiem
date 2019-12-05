package quanlydiemsinhvien.model;

import java.sql.Date;

public class StudentModel extends AbstractModel{
	private String email;
	private String faculty;
	private String district;
	private Date dateofbirth;
	private String gender;
	private String studentclass;
	private StudentGradeModel studentGradeModel;
	public StudentGradeModel getStudentGradeModel() {
		return studentGradeModel;
	}
	public void setStudentGradeModel(StudentGradeModel studentGradeModel) {
		this.studentGradeModel = studentGradeModel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public Date getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStudentclass() {
		return studentclass;
	}
	public void setStudentclass(String studentclass) {
		this.studentclass = studentclass;
	}
	

}
