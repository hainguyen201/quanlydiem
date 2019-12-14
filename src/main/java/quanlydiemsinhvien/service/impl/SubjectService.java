package quanlydiemsinhvien.service.impl;

import java.util.List;

import javax.inject.Inject;

import quanlydiemsinhvien.dao.imp.SubjectDAO;
import quanlydiemsinhvien.model.SubjectModel;
import quanlydiemsinhvien.service.ISubjectService;

public class SubjectService implements ISubjectService{

	@Inject
	private SubjectDAO subjectDao;
	@Override
	public List<SubjectModel> getAllSubjectByTeacherid(Long teacherid) {
		return subjectDao.getAllSubjectByTeacherid(teacherid);
	}
	
}
