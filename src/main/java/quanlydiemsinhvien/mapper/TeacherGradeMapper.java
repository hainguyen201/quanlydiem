package quanlydiemsinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlydiemsinhvien.model.TeacherGradeModel;

public class TeacherGradeMapper implements RowMapper<TeacherGradeModel> {

	@Override
	public TeacherGradeModel mapRow(ResultSet resultSet) {
		try {
			TeacherGradeModel teacherGradeModel = new TeacherGradeModel();
			teacherGradeModel.setSemester(resultSet.getString("semester"));
			teacherGradeModel.setSubjectid(resultSet.getString("subjectid"));
			teacherGradeModel.setSubjectname(resultSet.getString("subjectname"));
			teacherGradeModel.setCredit(resultSet.getString("credit"));
			teacherGradeModel.setClassid(resultSet.getString("classid"));
			teacherGradeModel.setGrade1(resultSet.getFloat("grade1"));
			teacherGradeModel.setGrade2(resultSet.getFloat("grade2"));
			teacherGradeModel.setStudentname(resultSet.getString("studentname"));
			teacherGradeModel.setWeight(resultSet.getFloat("weight"));
			teacherGradeModel.setNote(resultSet.getString("note"));
			teacherGradeModel.setStudentid(resultSet.getLong("studentid"));
			return teacherGradeModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
