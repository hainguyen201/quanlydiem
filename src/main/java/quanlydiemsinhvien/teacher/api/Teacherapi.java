package quanlydiemsinhvien.teacher.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.TeacherGradeModel;
import quanlydiemsinhvien.service.ITeacherService;

@WebServlet(urlPatterns = {"/adminapi"})
public class Teacherapi extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ITeacherService teacherService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		// chuyển từ String json về Model
		Long teacherid=new Long(Long.parseLong(request.getParameter("teacherid")));
		String subjectid= request.getParameter("subjectid");
		List<TeacherGradeModel> teacherGradeModels=teacherService.findAllStudentGrade(subjectid, teacherid);
		mapper.writeValue(response.getOutputStream(), teacherGradeModels);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentGradeModel studentGradeModel=new StudentGradeModel();
		studentGradeModel.setStudentname("Nguyễn Ngọc Trung Kiên");
		studentGradeModel.setStudentid(new Long(20173204));
		studentGradeModel.setClassid("678123");
		studentGradeModel.setGrade1(new Float(8));
		studentGradeModel.setGrade2(new Float(9));
		studentGradeModel.setSemester("20191");
		studentGradeModel.setSubjectid("It3090");
		studentGradeModel.setNote("no");
		teacherService.insertStudentGrade(studentGradeModel);
		
		
	}
	
	
}
