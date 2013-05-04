package com.andthen.model;

//		db.execSQL("CREATE TABLE armor (name varchar2(10), cost integer, defence integer, is_lock integer)");
public class Armor {
	String name;
	int cost;
	int defence;
	int is_lock;
	int residue;
	
	
	public int getResidue() {
		return residue;
	}
	public void setResidue(int residue) {
		this.residue = residue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDefence() {
		return defence;
	}
	public void setDefence(int defence) {
		this.defence = defence;
	}
	public int getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(int is_lock) {
		this.is_lock = is_lock;
	}
	
	
}
