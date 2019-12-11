package quanlydiemsinhvien.dao.imp;

import java.util.List;

import quanlydiemsinhvien.dao.IStudentDAO;
import quanlydiemsinhvien.mapper.StudentGradeMapper;
import quanlydiemsinhvien.mapper.StudentMapper;
import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;

public class StudentDAO extends AbstractDAO<StudentModel> implements IStudentDAO{
	@Override
	public List<StudentModel> getall() {
		String sql = "select * from student";
		return query(sql, new StudentMapper());
	}

	@Override
	public StudentModel findbynameandpassword(String username, String password) {
		StringBuilder sql= new StringBuilder("select * from student s inner join userrole r on"
				+ " s.studentid=r.userid where username='"+username+"' and password='"+password+"'");
		List<StudentModel> studentModels=query(sql.toString(), new StudentMapper());
		if(studentModels.isEmpty()) {
			StudentModel studentModel=new StudentModel();
			studentModel.setMessage("error");
			return studentModel;
		}else {
			return studentModels.get(0);
		}
	}

	@Override
	public List<StudentGradeModel> getStudentGradeById(Long studentid) {
		StringBuilder sql= new StringBuilder("select * from student s inner join grade g on s.studentid=g.studentid");
		sql.append(" inner join subject sub on g.subjectid=sub.subjectid");
		sql.append(" where s.studentid="+studentid);
		return query(sql.toString(), new StudentGradeMapper());
	}
	
	

}
