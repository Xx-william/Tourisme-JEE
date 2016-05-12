
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This class is used as a model of the Region (Asia，Europe, Africa.....)
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
public class Region {
	// all the countrys in the region
	private ArrayList<Country> countrys = new ArrayList<Country>();
	// the name of the region
	private String name;
	// the incomes of the region
	private HashMap<Integer, Double> regionIncomes = new HashMap<Integer, Double>();
	// the number of tourists of the region
	private HashMap<Integer, Double> regionTourists = new HashMap<Integer, Double>();

	/**
	 * The constructor of the class Region
	 * 
	 * @param name
	 *            The name of the Region
	 * @param countrys
	 *            All country in the region
	 */
	public Region(String name, ArrayList<Country> countrys) {
		this.setName(name);
		this.countrys = countrys;
		this.setData();
	}

	/**
	 * Set region name
	 * 
	 * @param name
	 *            The region name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get region name
	 * 
	 * @return The region name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Add country to this region
	 * 
	 * @param country
	 *            Country
	 */
	public void addCountry(Country country) {
		this.countrys.add(country);
	}

	/**
	 * Get all country of this region
	 * 
	 * @return All country of this region
	 */
	public ArrayList<Country> getCountrys() {
		return this.countrys;
	}

	/**
	 * Get the region incomes
	 * 
	 * @return Region incomes
	 */
	public HashMap<Integer, Double> getRegionIncomes() {
		return this.regionIncomes;
	}

	/**
	 * Get the number of the tourists in this region
	 * 
	 * @return The number of the tourists
	 */
	public HashMap<Integer, Double> getRegionTourists() {
		return this.regionTourists;
	}

	/**
	 * This class is used to initialize the characters 'regionIncomes' and
	 * 'regionTourists' according to the character 'countrys'of this class
	 */
	public void setData() {
		HashMap<Integer, Double> incomes = new HashMap<Integer, Double>();
		HashMap<Integer, Double> tourists = new HashMap<Integer, Double>();

		for (Country country : countrys) {
			HashMap<Integer, Double> incomeT1 = country.getIncome();
			for (Map.Entry<Integer, Double> incomeT2 : incomeT1.entrySet()) {
				int year = incomeT2.getKey();
				if (incomes.containsKey(year)) {
					double income = incomes.get(year) + incomeT2.getValue();
					incomes.replace(year, income);
				} else {
					incomes.put(year, incomeT2.getValue());
				}
			}

			HashMap<Integer, Double> touristsT1 = country.getTourists();
			for (Map.Entry<Integer, Double> touristsT2 : touristsT1.entrySet()) {

				int year = touristsT2.getKey();
				if (tourists.containsKey(year)) {
					double tourist = tourists.get(year) + touristsT2.getValue();
					tourists.replace(year, tourist);
				} else {
					tourists.put(year, touristsT2.getValue());
				}
			}
		}

		this.regionIncomes = incomes;
		this.regionTourists = tourists;
	}

}
