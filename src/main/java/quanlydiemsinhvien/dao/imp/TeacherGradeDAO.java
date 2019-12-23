package quanlydiemsinhvien.dao.imp;

import java.util.List;

import quanlydiemsinhvien.dao.ITeacherGradeDAO;
import quanlydiemsinhvien.mapper.TeacherGradeMapper;
import quanlydiemsinhvien.model.TeacherGradeModel;

public class TeacherGradeDAO extends AbstractDAO<TeacherGradeModel> implements ITeacherGradeDAO{
	/**
	 * Lấy thông tin điểm của một môn do giáo viên giảng dạy
	 */
	@Override
	public List<TeacherGradeModel> findAllStudentGrade(String subjectid, Long teacherid) {
		StringBuilder sql=new StringBuilder("select * from student s inner join grade g on s.studentid=g.studentid\r\n" + 
				"inner join subject sub on sub.subjectid=g.subjectid\r\n" + 
				"where teacherid=");
		sql.append(teacherid);
		sql.append(" and sub.subjectid='");
		sql.append(subjectid+"'");	
		return query(sql.toString(), new TeacherGradeMapper());
	}
}
