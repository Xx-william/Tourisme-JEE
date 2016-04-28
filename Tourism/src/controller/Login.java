package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Users;
import model.db.UserDB;

@WebServlet("/Controller/Login")
public class Login extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
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
