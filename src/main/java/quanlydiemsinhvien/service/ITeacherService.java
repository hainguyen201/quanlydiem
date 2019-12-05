package quanlydiemsinhvien.service;

import quanlydiemsinhvien.model.TeacherModel;

public interface ITeacherService {
	TeacherModel getTeacherInfo(Long teacherid);
	TeacherModel findbynameandpassword(String name, String password);
}
