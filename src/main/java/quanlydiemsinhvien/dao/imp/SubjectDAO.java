package quanlydiemsinhvien.dao.imp;

import java.util.List;

import quanlydiemsinhvien.dao.ISubjectDAO;
import quanlydiemsinhvien.mapper.SubjectMapper;
import quanlydiemsinhvien.model.SubjectModel;

public class SubjectDAO extends AbstractDAO<SubjectModel> implements ISubjectDAO{
	@Override
	public List<SubjectModel> getAllSubjectByTeacherid(Long teacherid) {
		StringBuilder sql=new StringBuilder("select * from subject where teacherid=");
		sql.append(teacherid);
		return query(sql.toString(), new SubjectMapper());
	}

}
