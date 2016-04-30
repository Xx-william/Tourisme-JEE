package model;

import java.util.HashMap;

public class Country {
	private String name;
	private HashMap<Integer, Double> tourists;
	private HashMap<Integer, Double> income;
	private String hckey="";

	public Country(String name,String hckey,HashMap<Integer, Double> touristsm,HashMap<Integer, Double> income){
		this.setName(name);
		this.setHckey(hckey);
		this.setIncome(income);
		this.setTourists(touristsm);
	}
	
	public void setHckey(String hckey){
		this.hckey = hckey;
	}
	public String getHckey(){
		return this.hckey;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	
	public void setTourists(HashMap<Integer,Double> tourists){
		this.tourists = tourists;
	}
	public void addTourists(int year,double number){
		this.tourists.put(year, number);
	}
	public HashMap<Integer,Double> getTourists(){
		return this.tourists;
	}
	public void setIncome(HashMap<Integer,Double> income){
		this.income = income;
	}
	public void addIncome(int year,double money){
		this.income.put(year, money);
	}
	public HashMap<Integer,Double> getIncome(){
		return this.income;
	}
}
