package com.andthen.guns;

public class Gun {
	
	int damage;          //伤害
	int firerate;        //射速
	int accuracy;        // 精准度
	int reloadtime;       //装弹时间
	int magazines;        //弹夹容量
	int maxsize;          //最大携带量
	int maxleft;          //玩家携带量
	
	String texture;
	
	public Gun(){
		texture="pistol.png";
		damage=16;
		maxsize=400;
		magazines=15;
		maxleft=300;
		reloadtime=500000000;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMagazines() {
		return magazines;
	}

	public void setMagazines(int magazines) {
		this.magazines = magazines;
	}

	public int getMaxsize() {
		return maxsize;
	}

	public void setMaxsize(int maxsize) {
		this.maxsize = maxsize;
	}
	
	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public int getMaxleft() {
		return maxleft;
	}

	public void setMaxleft(int maxleft) {
		this.maxleft = maxleft;
	}

	public int getFirerate() {
		return firerate;
	}

	public void setFirerate(int firerate) {
		this.firerate = firerate;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public int getReloadtime() {
		return reloadtime;
	}

	public void setReloadtime(int reloadtime) {
		this.reloadtime = reloadtime;
	}




	
}
