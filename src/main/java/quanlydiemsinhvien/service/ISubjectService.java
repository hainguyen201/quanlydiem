package quanlydiemsinhvien.service;

import java.util.List;

import quanlydiemsinhvien.model.SubjectModel;

public interface ISubjectService {
	List<SubjectModel> getAllSubjectByTeacherid(Long teacherid);
}
