package quanlydiemsinhvien.service.impl;

import java.util.List;

import javax.inject.Inject;

import quanlydiemsinhvien.dao.IStudentDAO;
import quanlydiemsinhvien.dao.ITeacherDAO;
import quanlydiemsinhvien.dao.ITeacherGradeDAO;
import quanlydiemsinhvien.dao.IUpdateStudentDAO;
import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.model.TeacherGradeModel;
import quanlydiemsinhvien.model.TeacherModel;
import quanlydiemsinhvien.service.IStudentService;
import quanlydiemsinhvien.service.ITeacherService;

public class TeacherService implements ITeacherService{
	@Inject
	private ITeacherDAO teacherDao;
	@Inject
	private ITeacherGradeDAO teacherGradeDao;
	@Inject 
	private IUpdateStudentDAO updateStudentDao;
	@Inject
	private IStudentDAO studentDao;
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
	public StudentGradeModel insertStudentGrade(StudentGradeModel studentGradeModel) {
		List<StudentModel> studentModels=studentDao.getAllStudent();
		for (StudentModel studentModel : studentModels) {
			if(studentModel.getStudentid().equals(studentGradeModel.getStudentid())
					&& studentModel.getStudentid().equals(studentGradeModel.getStudentid())) {
				return updateStudentDao.insertStudentGrade(studentGradeModel);
			}
		}
		return null;
		 
		
	}
	@Override
	public void deleteStudentGrade(Long studentid) {
		updateStudentDao.deleteStudentGrade(studentid);
		
	}
	@Override
	public void updateStudentGrade(StudentGradeModel studentGradeModel, Long studentid, String subjectid) {
		updateStudentDao.updateStudentGrade(studentGradeModel, studentid, subjectid);
		
	}
	
}
