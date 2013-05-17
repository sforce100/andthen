package com.andthen.map;

//Ñ¡ÔñµØÍ¼
//		db.execSQL("CREATE TABLE map (level integer, num integer, is_lock integer, get_star integer, req_star integer)");
public class LevelMap2 {
	int level;
	int num;
	int is_lock;
	int get_star;
	int req_star;
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getIs_lock() {
		return is_lock;
	}
	public void setIs_lock(int is_lock) {
		this.is_lock = is_lock;
	}
	public int getGet_star() {
		return get_star;
	}
	public void setGet_star(int get_star) {
		this.get_star = get_star;
	}
	public int getReq_star() {
		return req_star;
	}
	public void setReq_star(int req_star) {
		this.req_star = req_star;
	}
	
	
}
