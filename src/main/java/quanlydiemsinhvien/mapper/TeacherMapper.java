package quanlydiemsinhvien.mapper;

import java.sql.ResultSet;

import quanlydiemsinhvien.model.TeacherModel;

public class TeacherMapper implements RowMapper<TeacherModel>{

	@Override
	public TeacherModel mapRow(ResultSet resultSet) {
		try {
			TeacherModel teacher=new TeacherModel();
			teacher.setEmail(resultSet.getString("email"));
			teacher.setTeacherid(resultSet.getLong("teacherid"));
			teacher.setTeachername(resultSet.getString("teachername"));
			teacher.setSubjectid(resultSet.getString("subjectid"));
			teacher.setRoleid(resultSet.getLong("roleid"));
			teacher.setMessage("success");
			return teacher;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	

}
