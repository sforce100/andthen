package com.andthen.guns;

import com.badlogic.gdx.math.Rectangle;

public class Gun {
	
	int damage;          //伤害
	int firerate;        //射速
	int accuracy;        // 精准度
	int reloadtime;       //装弹时间
	int magazines;        //弹夹容量
	int maxsize;          //最大携带量
	int maxleft;          //玩家携带量
	String name;
	
	
	int is_lock;
	int gun_cost;
	int bullet_cost;
	int x,y,w,h,sx,sy,sw,sh;
	int state; //手枪:1,  机枪:2
	
	int x0,y0;
	int width,height;
	int magazineleft;     //弹夹剩余量
	
	
	
	
	
	
	
	
	
	public Gun(){

		damage=16;
		maxsize=400;
		magazines=15;
		maxleft=300;
		reloadtime=500000000;
		x0=280; y0=200;
		width=100;
		height=150;
		magazineleft=15;
	}
	
	public Gun(int test){

		damage=16;
		maxsize=400;
		magazines=15;
		maxleft=300;
		reloadtime=500000000;
		x0=0; y0=0;
		width=100;
		height=200;
		magazineleft=15;
	}
	


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
	}

	public int getSw() {
		return sw;
	}

	public void setSw(int sw) {
		this.sw = sw;
	}

	public int getSh() {
		return sh;
	}

	public void setSh(int sh) {
		this.sh = sh;
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

	public int getIs_lock() {
		return is_lock;
	}

	public void setIs_lock(int is_lock) {
		this.is_lock = is_lock;
	}

	public int getGun_cost() {
		return gun_cost;
	}

	public void setGun_cost(int gun_cost) {
		this.gun_cost = gun_cost;
	}

	public int getBullet_cost() {
		return bullet_cost;
	}

	public void setBullet_cost(int bullet_cost) {
		this.bullet_cost = bullet_cost;
	}



	public int getX0() {
		return x0;
	}



	public void setX0(int x0) {
		this.x0 = x0;
	}



	public int getY0() {
		return y0;
	}



	public void setY0(int y0) {
		this.y0 = y0;
	}



	public int getWidth() {
		return width;
	}



	public void setWidth(int width) {
		this.width = width;
	}



	public int getHeight() {
		return height;
	}



	public void setHeight(int height) {
		this.height = height;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	public int getMagazineleft() {
		return magazineleft;
	}

	public void setMagazineleft(int magazineleft) {
		this.magazineleft = magazineleft;
	}
	

}
