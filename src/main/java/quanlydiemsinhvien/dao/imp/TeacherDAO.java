package quanlydiemsinhvien.dao.imp;

import java.util.List;

import quanlydiemsinhvien.dao.ITeacherDAO;
import quanlydiemsinhvien.mapper.TeacherGradeMapper;
import quanlydiemsinhvien.mapper.TeacherMapper;
import quanlydiemsinhvien.model.TeacherGradeModel;
import quanlydiemsinhvien.model.TeacherModel;

public class TeacherDAO extends AbstractDAO<TeacherModel> implements ITeacherDAO {
	/**
	 * Hàm lấy thông tin giáo viên
	 */
	@Override
	public TeacherModel getTeacherInfo(Long teacherid) {
		StringBuilder sql = new StringBuilder("select * from teacher where teacherid= " + teacherid);
		return query(sql.toString(), new TeacherMapper()).get(0);
	}
	/**
	 * Hàm lấy thông tin giáo viên ứng với username và password
	 */
	@Override
	public TeacherModel findbynameandpassword(String username, String password) {
		StringBuilder sql=new StringBuilder("select * from teacher t inner join userrole u\r\n" + 
				"on t.teacherid=u.userid\r\n" + 
				"where username= '" +username+ 
				"' and password='"+password+"'");
		List<TeacherModel> teacherModels=query(sql.toString(), new TeacherMapper());
		if(teacherModels.isEmpty()) {
			TeacherModel teacherModel=new TeacherModel();
			teacherModel.setMessage("error");
			return teacherModel;
		}
		return teacherModels.get(0);
	}

	
}
