package quanlydiemsinhvien.service;

import java.util.List;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.TeacherGradeModel;
import quanlydiemsinhvien.model.TeacherModel;

public interface ITeacherService {
	TeacherModel getTeacherInfo(Long teacherid);
	TeacherModel findbynameandpassword(String name, String password);
	List<TeacherGradeModel> findAllStudentGrade(String subjectid, Long teacherid);
	void insertStudentGrade(StudentGradeModel studentGradeModel);
}
