package quanlydiemsinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;

public class StudentGradeMapper implements RowMapper<StudentGradeModel> {
	/**
	 * Hàm map dữ liệu từ resultset vào StudentGradeModel
	 */
	@Override
	public StudentGradeModel mapRow(ResultSet resultSet) {
		try {
			StudentGradeModel studentgrade = new StudentGradeModel();
			studentgrade.setSemester(resultSet.getString("semester"));
			studentgrade.setSubjectid(resultSet.getString("subjectid"));
			studentgrade.setSubjectname(resultSet.getString("subjectname"));
			studentgrade.setCredit(resultSet.getString("credit"));
			studentgrade.setClassid(resultSet.getString("classid"));
			studentgrade.setGrade1(resultSet.getFloat("grade1"));
			studentgrade.setGrade2(resultSet.getFloat("grade2"));
			return studentgrade;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
