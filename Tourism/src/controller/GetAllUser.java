package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Users;
import model.db.UserDB;

@WebServlet("/Controller/GetAllUser")
public class GetAllUser extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<Users> users = new ArrayList<Users>();
		users = UserDB.getAllUsers();
		
		Gson gson = new Gson();
		String json = gson.toJson(users);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.println(json);
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
