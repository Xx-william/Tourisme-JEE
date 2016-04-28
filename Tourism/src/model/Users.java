package model;

public class Users {
	private String type;
	private int count;
	
	public Users(){
		
	}
	public Users(String type,int count){
		this.setType(type);
		this.setCount(count);
	}
	public void setCount(int count){
		this.count = count;
	}
	public int getCount(){
		return this.count;
	}
	public void addCount(){
		this.count++;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}
}
