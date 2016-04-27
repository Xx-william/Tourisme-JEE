package model;

import java.util.HashMap;

public class Country {
	private String name;
	private Region region;
	private HashMap<Integer, Double> tourists;
	private HashMap<Integer, Double> income;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setRegion(Region region){
		this.region = region;
	}
	public Region getRegion(){
		return this.region;
	}
	
	public void addTourists(int year,double number){
		this.tourists.put(year, number);
	}
	public HashMap<Integer,Double> getRourists(){
		return this.tourists;
	}
	public void addIncome(int year,double money){
		this.income.put(year, money);
	}
	public HashMap<Integer,Double> getIncome(){
		return this.income;
	}
}
