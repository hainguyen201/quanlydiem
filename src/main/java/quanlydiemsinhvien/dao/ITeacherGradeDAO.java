package quanlydiemsinhvien.dao;

import java.util.List;

import quanlydiemsinhvien.model.TeacherGradeModel;

public interface ITeacherGradeDAO {
	List<TeacherGradeModel> findAllStudentGrade(String subjectid, Long teacherid);
}
