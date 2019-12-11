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
import quanlydiemsinhvien.service.IStudentService;

@WebServlet(urlPatterns = {"/student"})
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
		/*
		 * Long studentid = (long) 20173089;
		 * 
		 * StudentModel studentModel1=
		 * HttpUtil.of(request.getReader()).toModel(StudentModel.class);
		 * 
		 * List<StudentModel> studentModel = studentService.getall();
		 * 
		 * List<StudentGradeModel>
		 * studentGradeModels=studentService.getStudentGradeById(studentModel1.
		 * getStudentid());
		 * 
		 * mapper.writeValue(response.getOutputStream(), studentModel);
		 */
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		// khi client gửi lên tiếng việt màkhông bị lỗi font
		request.setCharacterEncoding("UTF-8");
		// khi server gửi về phải định nghĩa kiểu json
		response.setContentType("application/json");
		String id=request.getParameter("studentid");
		if(id!=null) {
			Long studentid=new Long(Long.parseLong(id));
			List<StudentGradeModel> studentGradeModels= studentService.getStudentGradeById(studentid);
			mapper.writeValue(response.getOutputStream(), studentGradeModels);
		}
		
		// chuyển từ String json về Model
		/*
		 * StringBuffer jb = new StringBuffer(); String line = null; try {
		 * BufferedReader reader = request.getReader(); while ((line =
		 * reader.readLine()) != null) jb.append(line); } catch (Exception e) { report
		 * an error }
		 * 
		 * try { JSONObject jsonObject = HTTP.toJSONObject(jb.toString()); } catch
		 * (JSONException e) { // crash and burn throw new
		 * IOException("Error parsing JSON request string"); }
		 */
	}
}
