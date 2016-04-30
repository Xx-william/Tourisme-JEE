package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Region {
	private ArrayList<Country> countrys = new ArrayList<Country>();
	private String name;
	private HashMap<Integer,Double> regionIncomes = new HashMap<Integer,Double>();
	private HashMap<Integer,Double> regionTourists = new HashMap<Integer,Double>();
	
	public Region(String name,ArrayList<Country> countrys){
		this.setName(name);
		this.countrys = countrys;
		this.setData();
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void addCountry(Country country){
		this.countrys.add(country);
	}
	public ArrayList<Country> getCountrys(){
		return this.countrys;
	}
	public HashMap<Integer,Double> getRegionIncomes(){
		return this.regionIncomes;
	}
	public HashMap<Integer,Double> getRegionTourists(){
		return this.regionTourists;
	}
	public void setData(){
		HashMap<Integer,Double> incomes = new HashMap<Integer,Double>();
		HashMap<Integer,Double> tourists = new HashMap<Integer,Double>();
		
		for(Country country : countrys){
			HashMap<Integer,Double> incomeT1 = country.getIncome();		
			for( Map.Entry<Integer, Double> incomeT2 : incomeT1.entrySet()){
				int year = incomeT2.getKey();
				if(incomes.containsKey(year)){
				double income = incomes.get(year) + incomeT2.getValue();
					incomes.replace(year, income);
				}else{
					incomes.put(year, incomeT2.getValue());
				}
			}
			
			HashMap<Integer,Double> touristsT1 = country.getTourists();	
			for(Map.Entry<Integer, Double> touristsT2 : touristsT1.entrySet()){
				
				int year = touristsT2.getKey();
				if(tourists.containsKey(year)){
				double tourist = tourists.get(year) + touristsT2.getValue();
					tourists.replace(year, tourist);
				}else{
					tourists.put(year, touristsT2.getValue());
				}
			}			
		}
		
		this.regionIncomes = incomes;
		this.regionTourists = tourists;
	}
	
}
