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
import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.model.TeacherGradeModel;
import quanlydiemsinhvien.service.IStudentService;
import quanlydiemsinhvien.service.ITeacherService;
import quanlydiemsinhvien.service.impl.StudentService;
import quanlydiemsinhvien.utils.HttpUtil;

@WebServlet(urlPatterns = { "/adminapi" })
public class Teacherapi extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ITeacherService teacherService;
	@Inject
	private IStudentService studentService;
	
	/**
	 * Hàm lấy điểm của sinh viên với mã môn và mã giáo viên tương ứng
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		// chuyển từ String json về Model
		String teacherid=request.getParameter("teacherid");
		String subjectid = request.getParameter("subjectid");
		if(teacherid!=null && subjectid!=null) {
			List<TeacherGradeModel> teacherGradeModels = teacherService.findAllStudentGrade(subjectid, Long.parseLong(teacherid));
			mapper.writeValue(response.getOutputStream(), teacherGradeModels);
		}else {
			List<StudentModel> studentModels=studentService.getAllStudent();
			mapper.writeValue(response.getOutputStream(), studentModels);
		}
	}
	/**
	 * Controller thêm thông tin của một sinh viên mới nếu chưa tồn tại
	 * Controller thêm điểm của một sinh viên nếu đã tồn tại sv
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		String type=request.getParameter("type");
		if(type!=null) {
			StudentModel studentModel= HttpUtil.of(request.getReader()).toModel(StudentModel.class);
			studentModel=studentService.insertStudent(studentModel);
			mapper.writeValue(response.getOutputStream(), studentModel);
		}else {
			StudentGradeModel studentGradeModel = HttpUtil.of(request.getReader()).toModel(StudentGradeModel.class);
			studentGradeModel=teacherService.insertStudentGrade(studentGradeModel);
			mapper.writeValue(response.getOutputStream(), studentGradeModel);
		}
	}
	/**
	 * Xóa điểm của một sinh viên
	 */
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
		String subjectid=request.getParameter("subjectid");
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		if(studentid!=null) {
			StudentGradeModel studentGradeModel = HttpUtil.of(request.getReader()).toModel(StudentGradeModel.class);
			teacherService.updateStudentGrade(studentGradeModel, Long.parseLong(studentid), subjectid);
			mapper.writeValue(response.getOutputStream(), studentGradeModel);
		}
		
	} 
}
