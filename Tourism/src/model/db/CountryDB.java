
package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.Country;

/**
 * This class is used to communicate with the DataBase in country data
 * 
 * @author WANG XI - GAUTHIER Pierre
 *
 */
public class CountryDB {
	private static String GET_ALL_COUNTRY_NAME = "SELECT country_name FROM country";
	private static String GET_INCOME = "SELECT income.income_money,income.income_year FROM country INNER JOIN income ON country.country_id=income.income_countryId WHERE country.country_name=?";
	private static String GET_NUM_TOURISTS = "SELECT tourist.tourist_num,tourist.tourist_year FROM country INNER JOIN tourist ON country.country_id=tourist.tourist_countryID WHERE country.country_name=?";
	private static String GET_ALL_COUNTRY = "SELECT * FROM country";
	private static String GET_YEARS = "SELECT income_year FROM income WHERE income_countryId = 2";
	private static String GET_HCKEY = "SELECT country_hckey FROM country WHERE country_name = ?";
	private static String GET_NAMES_BY_REGION = "SELECT country_name FROM country WHERE country_region=?";

	/**
	 * Get the HcKey according to country name
	 * 
	 * @param countryName
	 *            Country name
	 * @return HcKey
	 */
	public static String getHcKey(String countryName) {
		String hckey = "";
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_HCKEY);
			stmt.setString(1, countryName);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				hckey = rs.getString("country_hckey");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return hckey;
	}

	/**
	 * Get all country names in specified region
	 * 
	 * @param regionName
	 *            Region name
	 * @return All the country names in the region
	 */
	public static ArrayList<String> getCountryNamesByRegion(String regionName) {
		ArrayList<String> countryNames = new ArrayList<String>();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_NAMES_BY_REGION);
			stmt.setString(1, regionName);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("country_name");
				countryNames.add(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return countryNames;
	}

	/**
	 * Get all countrys in specified region
	 * 
	 * @param regionName
	 *            Region name
	 * @return All country in the region
	 */
	public static ArrayList<Country> getCountrysByRegion(String regionName) {
		ArrayList<Country> countrys = new ArrayList<Country>();
		ArrayList<String> countryNames = CountryDB.getCountryNamesByRegion(regionName);

		for (String name : countryNames) {
			Country country = CountryDB.getCountryByName(name);
			countrys.add(country);
		}
		return countrys;
	}

	/**
	 * Get all the year number we have in the DataBase
	 * 
	 * @return All the year number we have in the DataBase
	 */
	public static ArrayList<Integer> getYears() {
		ArrayList<Integer> years = new ArrayList<Integer>();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_YEARS);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int year = rs.getInt("income_year");
				years.add(year);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return years;
	}

	/**
	 * Get country by country name
	 * 
	 * @param countryName
	 *            Country name
	 * @return Country
	 * 
	 */
	public static Country getCountryByName(String countryName) {

		HashMap<Integer, Double> tourists = getTourist(countryName);
		HashMap<Integer, Double> incomes = getIncomes(countryName);
		String hckey = getHcKey(countryName);
		Country country = new Country(countryName, hckey, tourists, incomes);
		return country;
	}

	/**
	 * Get all country data
	 * 
	 * @return All country
	 */
	public static ArrayList<Country> getAllCountry() {
		ArrayList<Country> countrys = new ArrayList<Country>();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_ALL_COUNTRY);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String countryName = rs.getString("country_name");
				String hckey = rs.getString("country_hckey");
				HashMap<Integer, Double> tourists = getTourist(countryName);
				HashMap<Integer, Double> incomes = getIncomes(countryName);
				Country country = new Country(countryName, hckey, tourists, incomes);
				countrys.add(country);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return countrys;
	}

	/**
	 * Get all the tourist data in specify country name
	 * 
	 * @param country
	 *            country name
	 * @return All tourist data of the country
	 */
	public static HashMap<Integer, Double> getTourist(String country) {
		HashMap<Integer, Double> tourist = new HashMap<Integer, Double>();

		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_NUM_TOURISTS);
			stmt.setString(1, country);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				tourist.put(rs.getInt("tourist_year"), rs.getDouble("tourist_num"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return tourist;
	}

	/**
	 * Get incomes data in specify country name
	 * 
	 * @param country
	 *            Country name
	 * @return All incomes data of the country
	 */
	public static HashMap<Integer, Double> getIncomes(String country) {
		HashMap<Integer, Double> incomes = new HashMap<Integer, Double>();

		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_INCOME);
			stmt.setString(1, country);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				incomes.put(rs.getInt("income_year"), rs.getDouble("income_money"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return incomes;
	}

	/**
	 * Get all the country names
	 * 
	 * @return All the country names
	 */
	public static ArrayList<String> getAllCountryName() {
		Connection conn = null;
		ArrayList<String> countrys = new ArrayList<String>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_ALL_COUNTRY_NAME);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String name = rs.getString("country_name");
				countrys.add(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBUtil.dropConnection(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return countrys;
	}
}
