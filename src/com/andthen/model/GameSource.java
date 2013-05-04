package com.andthen.model;

//开始游戏前的地图和枪支的选择
public class GameSource {
	
	int level;//大地图
	int levelNum;//小地图
	String gunName;//枪
	String armorName;//护甲
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevelNum() {
		return levelNum;
	}
	public void setLevelNum(int levelNum) {
		this.levelNum = levelNum;
	}
	public String getGunName() {
		return gunName;
	}
	public void setGunName(String gunName) {
		this.gunName = gunName;
	}
	public String getArmorName() {
		return armorName;
	}
	public void setArmorName(String armorName) {
		this.armorName = armorName;
	}
	
	
	
}
