package quanlydiemsinhvien.controller.teacher;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlydiemsinhvien.model.TeacherModel;
import quanlydiemsinhvien.service.ITeacherService;
import quanlydiemsinhvien.utils.SessionUtil;
@WebServlet(urlPatterns = {"/admin-home"})
public class TeacherController extends HttpServlet{
	/**
	 * 
	 */
	@Inject
	private ITeacherService teacherService;
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherModel teacherModel = teacherService.findbynameandpassword(request.getParameter("username"),
				request.getParameter("password"));
		if (teacherModel.getMessage().equals("success")) {
			request.setAttribute("teacherModel", teacherModel);
			if (teacherModel != null && teacherModel.getRoleid() == 1) {
				SessionUtil.getInstance().putValue(request, "teacherModel", teacherModel);
				RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
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
