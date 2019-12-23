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
		String sql = "select semester, g.subjectid, sub.subjectname, sub.credit, g.classid, g.grade1, g.grade2 " + 
				"from grade g, subject sub, student \r\n" + 
				"where g.studentid=?\r\n" + 
				"and g.subjectid=sub.subjectid\r\n" + 
				"and student.studentid=g.studentid";
		return query(sql, new StudentGradeMapper(), studentid);
	}

}
