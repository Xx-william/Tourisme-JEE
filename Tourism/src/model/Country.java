
package model;

import java.util.HashMap;

/**
 * This class is used as a model of the Country
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
public class Country {

	private String name; // The name of the country
	private HashMap<Integer, Double> tourists; // the number of toursts of this
												// country in specify year
	private HashMap<Integer, Double> income; // the number of income of this
												// country in specify year
	private String hckey = ""; // the acronym of the country name

	/**
	 * This method is the constructor of the class 'Country'
	 * 
	 * @param name
	 *            The name of the Country
	 * @param hckey
	 *            The acronym of the country name
	 * @param touristsm
	 *            the number of tourists of this country in specify year
	 * @param income
	 *            the number of income of this country in specify year
	 */
	public Country(String name, String hckey, HashMap<Integer, Double> touristsm, HashMap<Integer, Double> income) {
		this.setName(name);
		this.setHckey(hckey);
		this.setIncome(income);
		this.setTourists(touristsm);
	}

	/**
	 * 
	 * @param hckey
	 *            The acronym of the country name
	 */
	public void setHckey(String hckey) {
		this.hckey = hckey;
	}

	/**
	 * 
	 * @return The acronyme of the country
	 */
	public String getHckey() {
		return this.hckey;
	}

	/**
	 * 
	 * @param name
	 *            The name of the country
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The name of the country
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param tourists
	 *            The numnber of the tourists of this country in specify year
	 */
	public void setTourists(HashMap<Integer, Double> tourists) {
		this.tourists = tourists;
	}

	/**
	 * Add a number of the tourist in specify year to this country
	 * 
	 * @param year
	 *            The year
	 * @param number
	 *            The number of the tourist
	 */
	public void addTourists(int year, double number) {
		this.tourists.put(year, number);
	}

	/**
	 * 
	 * @return The tourists
	 */
	public HashMap<Integer, Double> getTourists() {
		return this.tourists;
	}

	/**
	 * 
	 * @param income
	 *            The income
	 */
	public void setIncome(HashMap<Integer, Double> income) {
		this.income = income;
	}

	/**
	 * Add an income in specify year to this country
	 * 
	 * @param year
	 *            The year
	 * @param money
	 *            The money
	 */
	public void addIncome(int year, double money) {
		this.income.put(year, money);
	}

	/**
	 * 
	 * @return The Income
	 */
	public HashMap<Integer, Double> getIncome() {
		return this.income;
	}
}
