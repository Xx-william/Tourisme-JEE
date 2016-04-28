package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Country;
import model.db.CountryDB;

@WebServlet("/Controller/Graphic")
public class Graphic extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String countryName = req.getParameter("country");
		Country country = CountryDB.getCountryByName(countryName);
		
		Gson gson = new Gson();
		String json = gson.toJson(country);
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.println(json);
		System.out.println(json);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
