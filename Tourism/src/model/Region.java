package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Region {
	private ArrayList<Country> countrys;
	private String name;
	private HashMap<Integer,Double> numTourist;
	
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
	
	public void addNumTourist(int year,double num){
		this.numTourist.put(year, num);
	}
	public HashMap<Integer,Double> getNumTourist(){
		return this.numTourist;
	}
}
