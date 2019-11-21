package quanlydiemsinhvien.dao;

import java.util.List;

import quanlydiemsinhvien.model.SubjectModel;

public interface ISubjectDAO extends GenericDAO<SubjectModel>{
	List<SubjectModel> getall();

}
