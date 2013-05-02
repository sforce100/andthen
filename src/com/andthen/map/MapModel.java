package com.andthen.map;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MapModel extends Actor{
	
	List<float[]> refreshpoint = new ArrayList<float[]>();//int[] 为四位数组  分别为  刷怪点坐标 x,y,z,跟敌人出场类型
	
	Texture mapresource ;             //地图图片资源
	TextureRegion background;          //背景图片
	TextureRegion barrier1;
	TextureRegion barrier2;
	TextureRegion barrier3;
	TextureRegion barrier4;
	
	List<Rectangle> barrierrect =new ArrayList<Rectangle>();
	//障碍物坐标  
	//障碍物图片资源	
	
	//会出现敌人的类型
	int enemycount;   //每批敌人的数量
	int enemysum;//需杀死敌人数
	BitmapFont es;//需杀死敌人数字体
	
	
	
	
	public MapModel(){
//	//test数据	
//	float[] a={100,100,1,1};
//	float[] b={700,300,0.5f,2};
//	float[] c={700,200,0.7f,2};
	
	float[] c={646,59,1,2};
	float[] b={331,131,0.75f,2};
	float[] a={474,117,0.75f,1};
	float[] d={43,214,0.5f,1};
	float[] e={240,321,0.5f,2};
	float[] f={460,321,0.5f,1};
	
	refreshpoint.add(a);
	refreshpoint.add(b);
	refreshpoint.add(c);
	refreshpoint.add(d);
	refreshpoint.add(e);
	refreshpoint.add(f);
	
	
	
	mapresource =new Texture(Gdx.files.internal("map1.png")); 

	background=new TextureRegion(mapresource,0,139,800,480);    

	barrier1=new TextureRegion(mapresource,0,0,90,66);  
	barrier2=new TextureRegion(mapresource,90,0,195,123);  
	barrier3=new TextureRegion(mapresource,285,0,171,139);  
	barrier4=new TextureRegion(mapresource,463,0,291,99);  
	
	Rectangle rect1 = new Rectangle(0,210,90,66);
	Rectangle rect2 = new Rectangle(330,115,195,123);
	Rectangle rect3 = new Rectangle(629,54,171,139);
	Rectangle rect4 = new Rectangle(240,321,250,99);
	
	barrierrect.add(rect1);
	barrierrect.add(rect2);
	barrierrect.add(rect3);
	barrierrect.add(rect4);
	
	es=new BitmapFont(Gdx.files.internal("font.fnt"), false);
	
	enemysum=30;
	enemycount=3;
	
	}

	public TextureRegion getBackground() {
		return background;
	}

	public void setBackground(TextureRegion background) {
		this.background = background;
	}

	@Override
	public void draw(SpriteBatch batch, float arg1) {

		batch.draw(barrier1,0,210);
		batch.draw(barrier2,330,115);
		batch.draw(barrier3,629,54);
		batch.draw(barrier4,201,321);
		
		es.draw(batch, "" + enemysum, 10, Gdx.graphics.getHeight()-20);

	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getEnemysum() {
		return enemysum;
	}

	public void setEnemysum(int enemysum) {
		this.enemysum = enemysum;
	}

	public List<Rectangle> getBarrierrect() {
		return barrierrect;
	}

	public void setBarrierrect(List<Rectangle> barrierrect) {
		this.barrierrect = barrierrect;
	}
	
	
	

}
