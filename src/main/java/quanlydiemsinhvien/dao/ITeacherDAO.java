package quanlydiemsinhvien.dao;

import quanlydiemsinhvien.model.TeacherModel;

public interface ITeacherDAO {
	TeacherModel getTeacherInfo(Long teacherid);
	TeacherModel findbynameandpassword(String username, String password);
}
