package quanlydiemsinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import quanlydiemsinhvien.model.StudentModel;

public class StudentMapper implements RowMapper<StudentModel> {
	/**
	 * Hàm map dữ liệu từ resultset vào StudentModel
	 */
	@Override
	public StudentModel mapRow(ResultSet resultSet) {
		StudentModel student = new StudentModel();
		try {
			
			student.setStudentid(resultSet.getLong("studentid"));
			student.setStudentname(resultSet.getString("studentname"));
			student.setEmail(resultSet.getString("email"));
			student.setDateofbirth(resultSet.getDate("dateofbirth"));
			student.setGender(resultSet.getString("gender"));
			student.setDistrict(resultSet.getString("district"));
			student.setStudentclass(resultSet.getString("studentclass"));
			student.setFaculty(resultSet.getString("faculty"));
			student.setRoleid(resultSet.getLong("roleid"));
			student.setPhone(resultSet.getString("phone"));
			student.setMessage("success");
			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
