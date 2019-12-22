package quanlydiemsinhvien.service;

import java.util.List;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.model.TeacherModel;

public interface IStudentService {
	List<StudentModel> getAllStudent();
	List<StudentGradeModel> getStudentGradeById(Long studentid);
	StudentModel findbynameandpassword(String username, String password);
	StudentModel insertStudent(StudentModel studentModel);
	StudentModel deleteStudent(Long studentid);
	StudentModel updateStudent(StudentModel studentModel, Long studentid);
}
