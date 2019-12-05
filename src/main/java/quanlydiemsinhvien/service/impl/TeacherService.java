package quanlydiemsinhvien.service.impl;

import javax.inject.Inject;

import quanlydiemsinhvien.dao.ITeacherDAO;
import quanlydiemsinhvien.model.TeacherModel;
import quanlydiemsinhvien.service.ITeacherService;

public class TeacherService implements ITeacherService{
	@Inject
	private ITeacherDAO teacherDao;
	@Override
	public TeacherModel getTeacherInfo(Long teacherid) {
		return teacherDao.getTeacherInfo(teacherid);
	}
	@Override
	public TeacherModel findbynameandpassword(String name, String password) {
		return teacherDao.findbynameandpassword(name, password);
	}
	
}
