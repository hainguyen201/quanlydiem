package quanlydiemsinhvien.dao;

import java.util.List;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;

public interface IStudentDAO {
	List<StudentModel> getall();
	StudentModel findbynameandpassword(String username, String password);
	List<StudentGradeModel> getStudentGradeById(Long studentid);
}
