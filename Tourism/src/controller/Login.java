
package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Users;
import model.db.AdminDB;
import model.db.UserDB;

/**
 * 
 * This class is use to specify the method of login. If the request is send by
 * method 'Post', it is the admin login, then check the password If the request
 * is send by method 'Get', it is the user login, we record the type of the user
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
@WebServlet("/Controller/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 2774917559919029001L;

	// Admin login
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String password = req.getParameter("password");
		boolean check = AdminDB.checkAdmin(password);
		if (check) {
			HttpSession session = req.getSession();
			session.setAttribute("isLogin", "true");

			RequestDispatcher dispatcher = req.getRequestDispatcher("/graphical.jsp");
			dispatcher.forward(req, resp);
		} else {
			String json = "{ \"isSuccess\" : \"false\"}";
			resp.setContentType("application/json");
			PrintWriter out = resp.getWriter();
			out.println(json);
		}

	}

	// User login
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idStr = req.getParameter("id");
		int id = Integer.parseInt(idStr);
		Users user = UserDB.getUser(id);
		user.addCount();
		UserDB.refreshUser(id, user);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/graphical.jsp");
		dispatcher.forward(req, resp);
	}
}
