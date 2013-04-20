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

public class GameMap {  //构建地图

	private Stage stage; // 舞台
	private MapModel mm; // 地图属性
	List<Enemy> enemys = new ArrayList<Enemy>(); // 存储一批敌人

	
	public GameMap(Stage s , MapModel m) {
		stage = s;
		mm = m;
	}

	// 创建敌人
	public void addenemy(float[] a) {
		Enemy enemy = new Enemy(a[0], a[1], a[2], a[3]); // 参数依次为 坐标x,y,z,出场类型
		enemys.add(enemy);
		stage.addActor(enemy); // 加入舞台
	}

	public void render() {
		enemymanage();
		// 如果数组为空 则下一批敌人出场
		if (enemys.size() == 0 || enemys == null) {           //如果敌人数组为空     添加下一批敌人
			for (int i = 0; i < mm.enemycount; i++) {
				int temp = randompoint()[i].intValue();           //随机选择刷怪点
				addenemy(mm.refreshpoint.get(temp)); 
			}
		}
	}

	// 随机选择刷怪点
	public Integer[] randompoint() {
		Set<Integer> nums = new HashSet<Integer>();
		Random random = new Random();
		int temp;
		while (nums.size() < mm.enemycount) {
			temp = random.nextInt(mm.refreshpoint.size());   // 生成随机数
			nums.add(temp);
		}
		Integer[] res = nums.toArray(new Integer[0]);
		return res;

	}

	
	//敌人管理器
	public void enemymanage(){
		for(int i=0;i<enemys.size();i++){
			
			if(enemys.get(i).getState().equals(State.RUN)){           //如果敌人逃跑了则移除敌人
				stage.removeActor(enemys.get(i));
				enemys.remove(i);
				i--;
			}
			
		}
		
	}
}
