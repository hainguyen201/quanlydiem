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
import quanlydiemsinhvien.service.impl.StudentService;
import quanlydiemsinhvien.utils.HttpUtil;
@WebServlet(urlPatterns = "/listapi")
public class Listapi extends HttpServlet{
	@Inject 
	private StudentService studentService;
	private static final long serialVersionUID = 1L;
	/**
	 * Hàm lấy toàn bộ danh sách sinh viên
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		List<StudentModel> studentModels=studentService.getAllStudent();
		mapper.writeValue(response.getOutputStream(), studentModels);
		
	}
	/**
	 * Hàm xóa sinh viên
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
			StudentModel studentModel=studentService.deleteStudent(studentid);
			studentGradeModel.setMessage("Xóa thành công sinh viên có id "+id);
			mapper.writeValue(response.getOutputStream(), studentGradeModel);
		} 
	}
	/**
	 * Hàm sửa thông tin sinh viên
	 */
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		StudentModel studentModel=HttpUtil.of(request.getReader()).toModel(StudentModel.class);
		String id=request.getParameter("studentid");
		if(id!=null) {
			Long studentid=Long.parseLong(id);
			studentModel=studentService.updateStudent(studentModel, studentid);
			mapper.writeValue(response.getOutputStream(), studentModel);
		}
		
		
	}
}
