package com.andthen.map;

import java.util.ArrayList;
import java.util.List;

public class MapModel {
	
	List<float[]> refreshpoint = new ArrayList<float[]>();//int[] Ϊ��λ����  �ֱ�Ϊ  ˢ�ֵ����� x,y,z,�����˳�������
	int enemycount;   //ÿ�����˵�����
	//�ϰ�������  
	//�ϰ���ͼƬ��Դ	
	//����ͼƬ
	//����ֵ��˵�����
	
	
	public MapModel(){
	//test����	
	float[] a={100,100,1,1};
	float[] b={700,300,0.5f,2};
	float[] c={700,200,0.7f,2};
	refreshpoint.add(a);
	refreshpoint.add(b);
	refreshpoint.add(c);
	enemycount=2;
	}
	
	
	

}
