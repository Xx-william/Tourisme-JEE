package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import model.Country;

public class CountryDB {
	private static String GET_ALL_COUNTRY_NAME = "SELECT country_name FROM country";
	private static String GET_INCOME = "SELECT income.income_money,income.income_year FROM country INNER JOIN income ON country.country_id=income.income_countryId WHERE country.country_name=?";
	private static String GET_NUM_TOURISTS = "SELECT tourist.tourist_num,tourist.tourist_year FROM country INNER JOIN tourist ON country.country_id=tourist.tourist_countryID WHERE country.country_name=?";
	private static String GET_ALL_COUNTRY = "SELECT * FROM country";
	private static String GET_YEARS = "SELECT income_year FROM income WHERE income_countryId = 2";

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

	public static Country getCountryByName(String countryName) {

		HashMap<Integer, Double> tourists = getTourist(countryName);
		HashMap<Integer, Double> incomes = getIncomes(countryName);

		Country country = new Country(countryName, tourists, incomes);
		return country;
	}

	public static ArrayList<Country> getAllCountry() {
		ArrayList<Country> countrys = new ArrayList<Country>();
		Connection conn = null;

		try {
			conn = DBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(GET_ALL_COUNTRY);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String countryName = rs.getString("country_name");
				HashMap<Integer, Double> tourists = getTourist(countryName);
				HashMap<Integer, Double> incomes = getIncomes(countryName);
				Country country = new Country(countryName, tourists, incomes);
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
