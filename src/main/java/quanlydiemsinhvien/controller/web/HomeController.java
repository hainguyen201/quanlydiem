package quanlydiemsinhvien.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/trang-chu" })
public class HomeController extends HttpServlet {
	/**
	 * 
	 */
	/*
	 * @Inject private IStudentService studentService;
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * // TODO Auto-generated method stub
		 * 
		 * ObjectMapper mapper = new ObjectMapper(); // khi client gửi lên tiếng việt
		 * màkhông bị lỗi font request.setCharacterEncoding("UTF-8"); // khi server gửi
		 * về phải định nghĩa kiểu json response.setContentType("application/json"); //
		 * chuyển từ String json về Model List<StudentModel> studentModel =
		 * studentService.getall(); mapper.writeValue(response.getOutputStream(),
		 * studentModel);
		 */
		RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
		rd.forward(request, response);

	}

}
