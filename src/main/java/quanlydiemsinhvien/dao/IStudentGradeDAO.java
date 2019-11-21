package quanlydiemsinhvien.dao;

import java.util.List;

import quanlydiemsinhvien.model.StudentGradeModel;

public interface IStudentGradeDAO {
	List<StudentGradeModel> getAllGradeByStudentId(Long studentid);
}
