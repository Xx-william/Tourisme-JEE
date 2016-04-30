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

import model.Region;
import model.db.RegionDB;

@WebServlet("/Controller/Map")
public class Map extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String json = ";;;;";
		
		
			ArrayList<Region> regions = RegionDB.getAllRegion();
			Gson gson = new Gson();
			json = gson.toJson(regions);
			
	
		
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.println(json);		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
}
