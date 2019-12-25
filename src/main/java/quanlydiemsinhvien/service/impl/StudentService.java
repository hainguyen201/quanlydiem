package quanlydiemsinhvien.service.impl;

import java.util.List;

import javax.inject.Inject;

import quanlydiemsinhvien.dao.IStudentDAO;
import quanlydiemsinhvien.dao.IStudentGradeDAO;
import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.service.IStudentService;

public class StudentService implements IStudentService{
	@Inject
	private IStudentDAO studentDao;
	
	@Override
	public List<StudentGradeModel> getStudentGradeById(Long studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentGradeById(studentid);
	}
	@Override
	public StudentModel findbynameandpassword(String username, String password) {
		return studentDao.findbynameandpassword(username, password);
	}
	@Override
	public List<StudentModel> getAllStudent() {
		return studentDao.getAllStudent();
	}
	@Override
	public StudentModel insertStudent(StudentModel studentModel) {
		return studentDao.insertStudent(studentModel);
	}
	@Override
	public StudentModel deleteStudent(Long studentid) {
		StudentModel studentModel=new StudentModel();
		if(studentDao.deleteStudent(studentid)) {
			studentModel.setMessage("success");
			return studentModel;
		}else {
			studentModel.setMessage("error");
			return studentModel;
		}
	}
	@Override
	public StudentModel updateStudent(StudentModel studentModel, Long studentid) {
		if(studentDao.updateStudent(studentModel, studentid)) {
			studentModel.setMessage("success");
		}else {
			studentModel.setMessage("error");
		}
		return studentModel;
	}	
}
