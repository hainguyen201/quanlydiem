package quanlydiemsinhvien.controller.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.fasterxml.jackson.databind.ObjectMapper;

import quanlydiemsinhvien.model.StudentGradeModel;
import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.service.IStudentService;
import quanlydiemsinhvien.utils.HttpUtil;

@WebServlet("/student" )
public class StudentGradeapi extends HttpServlet {
	/**
	 * 
	 */
	@Inject
	private IStudentService studentService;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// TODO Auto-generated method stub

		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		// chuyển từ String json về Model
		Long studentid=(long) 20173089;
		HttpUtil h=HttpUtil.of(request.getReader());
		String s=h.getValue();
		List<StudentModel> studentModel = studentService.getall();
		List<StudentGradeModel> studentGradeModels=studentService.getStudentGradeById(studentid);	
		mapper.writeValue(response.getOutputStream(),studentGradeModels.get(0));	
	}
}
