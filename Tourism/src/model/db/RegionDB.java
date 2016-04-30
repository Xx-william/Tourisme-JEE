package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Country;
import model.Region;

public class RegionDB {

	private static String GET_ALL_REGION ="SELECT * FROM region";
	private static String GET_NAMES_REGION = "SELECT region_name FROM region";
	
	public static ArrayList<String> getAllRegionName(){
		Connection conn = null;
		ArrayList<String> regions = new ArrayList<String>();
		
		try{
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_NAMES_REGION);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String regionName = rs.getString("region_name");
				regions.add(regionName);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				DBUtil.dropConnection(conn);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return regions;
	}
	
	
	public static ArrayList<Region> getAllRegion(){
		Connection conn = null;
		ArrayList<Region> regions = new ArrayList<Region>();
		
		try{
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_ALL_REGION);
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String regionName = rs.getString("region_name");
				ArrayList<Country> countrys = CountryDB.getCountrysByRegion(regionName);
				Region region = new Region(regionName,countrys);
				regions.add(region);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				DBUtil.dropConnection(conn);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return regions;
	}
}
