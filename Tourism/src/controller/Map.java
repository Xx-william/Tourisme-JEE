
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

/**
 * 
 * This class is used to get all region information and send it back to
 * requester in format of json
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
@WebServlet("/Controller/Map")
public class Map extends HttpServlet {

	private static final long serialVersionUID = 8561527636514278221L;

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
		doPost(req, resp);
	}
}
