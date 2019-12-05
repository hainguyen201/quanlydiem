package quanlydiemsinhvien.dao.imp;

import quanlydiemsinhvien.dao.ITeacherDAO;
import quanlydiemsinhvien.mapper.TeacherMapper;
import quanlydiemsinhvien.model.TeacherModel;

public class TeacherDAO extends AbstractDAO<TeacherModel> implements ITeacherDAO {

	@Override
	public TeacherModel getTeacherInfo(Long teacherid) {
		StringBuilder sql = new StringBuilder("select * from teacher where teacherid= " + teacherid);
		return query(sql.toString(), new TeacherMapper()).get(0);
	}

	@Override
	public TeacherModel findbynameandpassword(String username, String password) {
		StringBuilder sql=new StringBuilder("select * from teacher t inner join userrole u\r\n" + 
				"on t.teacherid=u.userid\r\n" + 
				"where username= '" +username+ 
				"' and password='"+password+"'");
		return query(sql.toString(), new TeacherMapper()).get(0);
	}
}
