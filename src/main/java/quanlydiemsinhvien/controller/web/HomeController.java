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
	@Inject
	private IStudentService studentService;
	@Inject
	private ITeacherService teacherService;
	private static final long serialVersionUID = 1L;

	/**
	 * Hàm kiểm tra user đăng nhập là admin hay student và thực hiện chức năng thoát
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			} else if (type.equals("teacher")) {
				SessionUtil.getInstance().removeValue(request, "teacherModel");
				SessionUtil.getInstance().removeValue(request, "subjectModel");
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}
		}
	}

	/**
	 * Hàm kiểm tra user đăng nhập là admin hay student và thực hiện chức năng đăng
	 * nhập
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		String usertype = request.getParameter("usertype");
		if (action != null && action.equals("login")) {
			/* StudentModel model = FormUtil.toModel(StudentModel.class, request); */
			if (usertype.equals("student")) {
				RequestDispatcher rd = request.getRequestDispatcher("/student-view");
				rd.forward(request, response);
			} else if (usertype.equals("teacher")) {
				RequestDispatcher rd = request.getRequestDispatcher("/admin-home");
				rd.forward(request, response);
			}
		}
	}
}
