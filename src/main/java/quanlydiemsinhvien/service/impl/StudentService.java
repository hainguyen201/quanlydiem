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
	@Inject
	private IStudentGradeDAO studentGradeDao;
	@Override
	public List<StudentModel> getall() {
		return studentDao.getall();
	}
	@Override
	public List<StudentGradeModel> getStudentGradeById(Long studentid) {
		// TODO Auto-generated method stub
		return studentDao.getStudentGradeById(studentid);
	}
	@Override
	public StudentModel findbynameandpassword(String username, String password) {
		return studentDao.findbynameandpassword(username, password);
	}

}
