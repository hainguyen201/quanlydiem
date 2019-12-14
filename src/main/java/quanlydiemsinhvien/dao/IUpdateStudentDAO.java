package quanlydiemsinhvien.dao;

import quanlydiemsinhvien.model.StudentGradeModel;

public interface IUpdateStudentDAO {
	StudentGradeModel insertStudentGrade(StudentGradeModel studentGradeModel);
	void deleteStudentGrade(Long studentid);
	void updateStudentGrade(StudentGradeModel studentGradeModel, Long studentid);
	
}
