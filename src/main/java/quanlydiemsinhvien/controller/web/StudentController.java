package quanlydiemsinhvien.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlydiemsinhvien.model.StudentModel;
import quanlydiemsinhvien.service.IStudentService;
import quanlydiemsinhvien.utils.SessionUtil;
@WebServlet(urlPatterns = {"/student-view"})
public class StudentController extends HttpServlet{
	/**
	 * 
	 */
	@Inject
	private IStudentService studentService;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentModel studentModel = studentService.findbynameandpassword(request.getParameter("username"),
				request.getParameter("password"));
		if (studentModel.getMessage().equals("success")) {
			request.setAttribute("studentModel", studentModel);
			if (studentModel != null && studentModel.getRoleid() == 2) {
				SessionUtil.getInstance().putValue(request, "studentModel", studentModel);
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
				rd.forward(request, response);
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/login.jsp");
			rd.forward(request, response);
		}
		
		
	}
}
