package quanlydiemsinhvien.dao.imp;

import quanlydiemsinhvien.dao.IUpdateStudentDAO;
import quanlydiemsinhvien.mapper.StudentGradeMapper;
import quanlydiemsinhvien.model.StudentGradeModel;

public class UpdateStudentDAO extends AbstractDAO<StudentGradeModel> implements IUpdateStudentDAO{
	/**
	 * Thêm điểm sinh viên
	 */
	@Override
	public StudentGradeModel insertStudentGrade(StudentGradeModel studentGradeModel) {
		StringBuilder sql=new StringBuilder("");
		/* sql.append("insert into student (studentid, studentname) values (?, ?) "); */
		sql.append("insert into grade (studentid,subjectid,semester,classid,grade1, grade2, note) values (?,?,?,?,?, ?, ?)");
		
		return insert(sql.toString(),
				studentGradeModel.getStudentid(),
				studentGradeModel.getSubjectid(),
				studentGradeModel.getSemester(),
				studentGradeModel.getClassid(),
				studentGradeModel.getGrade1(),
				studentGradeModel.getGrade2(),
				studentGradeModel.getNote());	
	}
	/**
	 * Xóa điểm sinh viên
	 */
	@Override
	public void deleteStudentGrade(Long studentid) {
		StringBuilder sql=new StringBuilder(" delete from grade \r\n" + 
				"where studentid="+studentid);
		update(sql.toString(), new StudentGradeMapper());
		
	}
	/**
	 * Cập nhật điểm sinh viên
	 */
	@Override
	public void updateStudentGrade(StudentGradeModel studentGradeModel, Long studentid, String subjectid) {
	   StringBuilder sql=new StringBuilder("update student set studentname=?,studentid=? where studentid=?");
	   sql.append(" update grade set studentid=?,grade1=?, grade2=?, note=?, classid=?, semester=?, subjectid=? where studentid=? and subjectid=?");
	   update(sql.toString(), new StudentGradeMapper(), 
			   studentGradeModel.getStudentname(),
			   studentGradeModel.getStudentid(),
			   studentid,
			   studentGradeModel.getStudentid(),
			   studentGradeModel.getGrade1(),
			   studentGradeModel.getGrade2(),
			   studentGradeModel.getNote(),
			   studentGradeModel.getClassid(),
			   studentGradeModel.getSemester(),
			   studentGradeModel.getSubjectid(),
			   studentid,
			   subjectid);
	}
	
}
