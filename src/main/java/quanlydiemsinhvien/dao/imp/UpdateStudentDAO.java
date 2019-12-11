package quanlydiemsinhvien.dao.imp;

import quanlydiemsinhvien.dao.IUpdateStudentDAO;
import quanlydiemsinhvien.model.StudentGradeModel;

public class UpdateStudentDAO extends AbstractDAO<StudentGradeModel> implements IUpdateStudentDAO{

	@Override
	public void insertStudentGrade(StudentGradeModel studentGradeModel) {
		StringBuilder sql=new StringBuilder("insert into student (studentid, studentname) values (?, N'?')\r\n" + 
				"insert into grade (studentid,subjectid,semester,classid,grade1, grade2, note) values (?,'?','?','?',?, ?, '?')");
		insert(sql.toString(), studentGradeModel.getStudentid(),
				studentGradeModel.getStudentname(),
				studentGradeModel.getStudentid(),
				studentGradeModel.getSubjectid(),
				studentGradeModel.getSemester(),
				studentGradeModel.getClassid(),
				studentGradeModel.getGrade1(),
				studentGradeModel.getGrade2(),
				studentGradeModel.getNote());	
	}
	
}
