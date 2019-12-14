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
import quanlydiemsinhvien.utils.HttpUtil;

@WebServlet(urlPatterns = { "/adminapi" })
public class Teacherapi extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ITeacherService teacherService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		// chuyển từ String json về Model
		Long teacherid = new Long(Long.parseLong(request.getParameter("teacherid")));
		String subjectid = request.getParameter("subjectid");
		List<TeacherGradeModel> teacherGradeModels = teacherService.findAllStudentGrade(subjectid, teacherid);
		mapper.writeValue(response.getOutputStream(), teacherGradeModels);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");

		StudentGradeModel studentGradeModel = HttpUtil.of(request.getReader()).toModel(StudentGradeModel.class);
		studentGradeModel=teacherService.insertStudentGrade(studentGradeModel);
		mapper.writeValue(response.getOutputStream(), studentGradeModel);

	}
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		StudentGradeModel studentGradeModel=new StudentGradeModel();
		
		String id = request.getParameter("studentid");
		if (id != null) {
			Long studentid = new Long(Long.parseLong(id));
			teacherService.deleteStudentGrade(studentid);
			studentGradeModel.setMessage("Xóa thành công sinh viên có id "+id);
			mapper.writeValue(response.getOutputStream(), studentGradeModel);
		} 
	}
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentid=request.getParameter("studentid");
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		if(studentid!=null) {
			StudentGradeModel studentGradeModel = HttpUtil.of(request.getReader()).toModel(StudentGradeModel.class);
			teacherService.updateStudentGrade(studentGradeModel, Long.parseLong(studentid));
			mapper.writeValue(response.getOutputStream(), studentGradeModel);
		}
		
	} 
}
