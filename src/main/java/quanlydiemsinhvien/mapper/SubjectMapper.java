package quanlydiemsinhvien.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.model.SubjectModel;

public class SubjectMapper implements RowMapper<SubjectModel>{
	/**
	 * Hàm map dữ liệu từ resultset vào Subject
	 */
	@Override
	public SubjectModel mapRow(ResultSet resultSet) {
		SubjectModel subject = new SubjectModel();
		try {
			subject.setSubjectid(resultSet.getString("subjectid"));
			subject.setSubjectname(resultSet.getString("subjectname"));
			return subject;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
