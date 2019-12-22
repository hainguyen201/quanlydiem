package quanlydiemsinhvien.dao;

import java.util.List;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;

public interface IStudentDAO {
	List<StudentModel> getAllStudent();
	StudentModel findbynameandpassword(String username, String password);
	List<StudentGradeModel> getStudentGradeById(Long studentid);
	StudentModel insertStudent(StudentModel studentModel);
	boolean deleteStudent(Long studentid);
	boolean updateStudent(StudentModel studentModel, Long studentid);
}
