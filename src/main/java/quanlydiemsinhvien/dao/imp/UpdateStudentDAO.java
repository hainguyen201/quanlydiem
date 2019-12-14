package quanlydiemsinhvien.dao.imp;

import quanlydiemsinhvien.dao.IUpdateStudentDAO;
import quanlydiemsinhvien.mapper.StudentGradeMapper;
import quanlydiemsinhvien.model.StudentGradeModel;

public class UpdateStudentDAO extends AbstractDAO<StudentGradeModel> implements IUpdateStudentDAO{

	@Override
	public StudentGradeModel insertStudentGrade(StudentGradeModel studentGradeModel) {
		StringBuilder sql=new StringBuilder("insert into student (studentid, studentname) values (?, ?)\r\n" + 
				"insert into grade (studentid,subjectid,semester,classid,grade1, grade2, note) values (?,?,?,?,?, ?, ?)");
		return insert(sql.toString(), studentGradeModel.getStudentid(),
				studentGradeModel.getStudentname(),
				studentGradeModel.getStudentid(),
				studentGradeModel.getSubjectid(),
				studentGradeModel.getSemester(),
				studentGradeModel.getClassid(),
				studentGradeModel.getGrade1(),
				studentGradeModel.getGrade2(),
				studentGradeModel.getNote());	
	}

	@Override
	public void deleteStudentGrade(Long studentid) {
		StringBuilder sql=new StringBuilder("delete from student\r\n" + 
				"where studentid=" +studentid+ 
				" delete from grade \r\n" + 
				"where studentid="+studentid);
		delete(sql.toString(), new StudentGradeMapper());
		
	}

	@Override
	
	public void updateStudentGrade(StudentGradeModel studentGradeModel, Long studentid) {
	   StringBuilder sql=new StringBuilder("update student set studentname=?,studentid=? where studentid=?");
	   sql.append(" update grade set studentid=?,grade1=?, grade2=?, note=?, classid=?, semester=?, subjectid=? where studentid=?");
	   delete(sql.toString(), new StudentGradeMapper(), 
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
			   studentid);
	}
	
}
