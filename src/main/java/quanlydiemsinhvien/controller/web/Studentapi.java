package quanlydiemsinhvien.controller.web;

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
import quanlydiemsinhvien.service.IStudentService;

@WebServlet("/student-grade" )
public class Studentapi extends HttpServlet {
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
		
		
	}

	private Long Long(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
