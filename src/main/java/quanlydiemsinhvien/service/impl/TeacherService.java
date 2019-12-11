package quanlydiemsinhvien.service.impl;

import java.util.List;

import javax.inject.Inject;

import quanlydiemsinhvien.dao.ITeacherDAO;
import quanlydiemsinhvien.dao.ITeacherGradeDAO;
import quanlydiemsinhvien.dao.IUpdateStudentDAO;
import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.TeacherGradeModel;
import quanlydiemsinhvien.model.TeacherModel;
import quanlydiemsinhvien.service.ITeacherService;

public class TeacherService implements ITeacherService{
	@Inject
	private ITeacherDAO teacherDao;
	@Inject
	private ITeacherGradeDAO teacherGradeDao;
	@Inject 
	private IUpdateStudentDAO updateStudentDao;
	@Override
	public TeacherModel getTeacherInfo(Long teacherid) {
		return teacherDao.getTeacherInfo(teacherid);
	}
	@Override
	public TeacherModel findbynameandpassword(String name, String password) {
		return teacherDao.findbynameandpassword(name, password);
	}
	@Override
	public List<TeacherGradeModel> findAllStudentGrade(String subjectid, Long teacherid) {
		return teacherGradeDao.findAllStudentGrade(subjectid, teacherid);
	}
	@Override
	public void insertStudentGrade(StudentGradeModel studentGradeModel) {
		updateStudentDao.insertStudentGrade(studentGradeModel);
		
	}
	
}
