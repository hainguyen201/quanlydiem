package quanlydiemsinhvien.dao.imp;

import java.util.List;

import quanlydiemsinhvien.dao.IStudentDAO;
import quanlydiemsinhvien.mapper.StudentMapper;
import quanlydiemsinhvien.model.StudentModel;

public class StudentDAO extends AbstractDAO<StudentModel> implements IStudentDAO{

	@Override
	public List<StudentModel> getall() {
		String sql = "select * from student";
		return query(sql, new StudentMapper());
	}
	

}
