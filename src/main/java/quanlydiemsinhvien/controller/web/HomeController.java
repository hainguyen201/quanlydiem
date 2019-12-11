package quanlydiemsinhvien.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlydiemsinhvien.service.IStudentService;
import quanlydiemsinhvien.service.ITeacherService;
import quanlydiemsinhvien.utils.SessionUtil;

@WebServlet(urlPatterns = { "/trang-chu", "/dang-nhap", "/thoat" })
public class HomeController extends HttpServlet {
	/**
	 * 
	 */

	@Inject
	private IStudentService studentService;
	@Inject
	private ITeacherService teacherService;
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

		String status = request.getParameter("action");
		String type = request.getParameter("usertype");
		if (status.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("views/login.jsp");
			rd.forward(request, response);
		} else if (status.equals("logout")) {
			if (type.equals("student")) {
				SessionUtil.getInstance().removeValue(request, "studentModel");
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}else if(type.equals("teacher")) {
				SessionUtil.getInstance().removeValue(request, "teacherModel");
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}
		}
		/*
		 * else { response.sendRedirect(request.getContextPath() +"/student-view"); }
		 */

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String usertype = request.getParameter("usertype");
		
		if (action != null && action.equals("login")) {
			/* StudentModel model = FormUtil.toModel(StudentModel.class, request); */
			if (usertype.equals("student")) {
				RequestDispatcher rd=request.getRequestDispatcher("/student-view");
				rd.forward(request, response);
				
			} else if (usertype.equals("teacher")) {
				RequestDispatcher rd=request.getRequestDispatcher("/admin-home");
				rd.forward(request, response);
			}
			/*
			 * if (teacherModel != null) { System.out.println("đăng nhập thành công");
			 * SessionUtil.getInstance().putValue(request, "USERMODEL", teacherModel); //
			 * kiểm tra là user
			 * 
			 * if (teacherModel.getRoleid() == 2) {
			 * response.sendRedirect(request.getContextPath() +
			 * "/trang-chu?action=success");
			 * 
			 * } else // kiểm tra là admin else if
			 * (model.getRole().getCode().equals("ADMIN")) {
			 * response.sendRedirect(request.getContextPath() + "/admin-home"); }
			 * 
			 * } else { // nếu không tồn tại tài khoản nào thì chuyển tới trang đang nhập //
			 * hàm getContextPath sẽ lấy trả về //
			 * http://localhost:8080/new-jdbc-17-October-2019
			 * response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login");
			 * }
			 */
		}

	}

}
