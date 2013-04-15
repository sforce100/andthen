package com.andthen.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.andthen.actor.Enemy;
import com.andthen.actor.Enemy.State;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

public class GameMap {  //������ͼ

	private Stage stage; // ��̨
	private MapModel mm; // ��ͼ����
	List<Enemy> enemys = new ArrayList<Enemy>(); // �洢һ������

	
	public GameMap(Stage s , MapModel m) {
		stage = s;
		mm = m;
	}

	// ��������
	public void addenemy(float[] a) {
		Enemy enemy = new Enemy(a[0], a[1], a[2], a[3]); // ��������Ϊ ����x,y,z,��������
		enemys.add(enemy);
		stage.addActor(enemy); // ������̨
	}

	public void render() {
		enemymanage();
		// �������Ϊ�� ����һ�����˳���
		if (enemys.size() == 0 || enemys == null) {           //�����������Ϊ��     �����һ������
			for (int i = 0; i < mm.enemycount; i++) {
				int temp = randompoint()[i].intValue();           //���ѡ��ˢ�ֵ�
				addenemy(mm.refreshpoint.get(temp)); 
			}
		}
	}

	// ���ѡ��ˢ�ֵ�
	public Integer[] randompoint() {
		Set<Integer> nums = new HashSet<Integer>();
		Random random = new Random();
		int temp;
		while (nums.size() < mm.enemycount) {
			temp = random.nextInt(mm.refreshpoint.size());   // ���������
			nums.add(temp);
		}
		Integer[] res = nums.toArray(new Integer[0]);
		return res;

	}

	
	//���˹�����
	public void enemymanage(){
		for(int i=0;i<enemys.size();i++){
			
			if(enemys.get(i).getState().equals(State.RUN)){           //����������������Ƴ�����
				stage.removeActor(enemys.get(i));
				enemys.remove(i);
				i--;
			}
			
		}
		
	}
}
