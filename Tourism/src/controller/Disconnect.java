
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * This class is used to disable the connection of the user by delete their
 * session and redirect their browser
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
@WebServlet("/Controller/Disconnect")
public class Disconnect extends HttpServlet {

	private static final long serialVersionUID = 2750267846811457967L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate(); // invalidate the session
		resp.sendRedirect(req.getContextPath() + "/index.jsp"); // redirection
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);

	}
}
