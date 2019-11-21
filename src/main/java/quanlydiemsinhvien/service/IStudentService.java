package quanlydiemsinhvien.service;

import java.util.List;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;

public interface IStudentService {
	List<StudentModel> getall();
	List<StudentGradeModel> getStudentGradeById(Long studentid);
}
