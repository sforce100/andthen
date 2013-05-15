package com.andthen.guns;

import com.badlogic.gdx.math.Rectangle;

public class Gun {
	
	int damage;          //�˺�
	int firerate;        //����
	int accuracy;        // ��׼��
	int reloadtime;       //װ��ʱ��
	int magazines;        //��������
	int maxsize;          //���Я����
	int maxleft;          //���Я����
	String name;
	
	
	int is_lock;
	int gun_cost;
	int bullet_cost;
	
	int x0,y0;
	int width,height;
	int magazineleft;     //����ʣ����
	
	
	
	
	
	
	
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
