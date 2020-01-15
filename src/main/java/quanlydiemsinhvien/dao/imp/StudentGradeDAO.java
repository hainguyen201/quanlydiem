package quanlydiemsinhvien.dao.imp;

import java.util.List;

import quanlydiemsinhvien.dao.IStudentGradeDAO;
import quanlydiemsinhvien.mapper.StudentGradeMapper;
import quanlydiemsinhvien.model.StudentGradeModel;

public class StudentGradeDAO extends AbstractDAO<StudentGradeModel> implements IStudentGradeDAO{
	/**
	 * Hàm lấy toàn bộ điểm của sinh viên
	 */
	@Override
	public List<StudentGradeModel> getAllGradeByStudentId(Long studentid) {
		String sql = "select * from student s, grade g, teach\r\n" + 
				"where s.studentid=g.studentid\r\n" + 
				"and teach.classid=g.classid\r\n" + 
				"and s.studentid=?";
		return query(sql, new StudentGradeMapper(), studentid);
	}

}
