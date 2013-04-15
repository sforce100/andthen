package com.andthen.map;

import java.util.ArrayList;
import java.util.List;

public class MapModel {
	
	List<float[]> refreshpoint = new ArrayList<float[]>();//int[] 为四位数组  分别为  刷怪点坐标 x,y,z,跟敌人出场类型
	int enemycount;   //每批敌人的数量
	//障碍物坐标  
	//障碍物图片资源	
	//背景图片
	//会出现敌人的类型
	
	
	public MapModel(){
	//test数据	
	float[] a={100,100,1,1};
	float[] b={700,300,0.5f,2};
	float[] c={700,200,0.7f,2};
	refreshpoint.add(a);
	refreshpoint.add(b);
	refreshpoint.add(c);
	enemycount=2;
	}
	
	
	

}
