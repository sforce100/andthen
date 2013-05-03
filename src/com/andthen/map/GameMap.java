package com.andthen.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.andthen.actor.Enemy;

import com.andthen.actor.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

public class GameMap { // 构建地图

	private Stage stage; // 舞台
	private MapModel mm; // 地图属性
	List<Enemy> enemys = new ArrayList<Enemy>(); // 存储一批敌人
	private Player player;
	private float ox, oy;

	public GameMap(Stage s, MapModel m) {
		stage = s;
		mm = m;
		player = new Player(350, 200);
		stage.addActor(mm);
		stage.addActor(player);
	}

	// 创建敌人
	public void addenemy(float[] a) {
		Enemy enemy = new Enemy(a[0], a[1], a[2], a[3]); // 参数依次为 坐标x,y,z,出场类型
		enemys.add(enemy);
		// stage.addActor(enemy); // 加入舞台
		stage.getRoot().addActorBefore(mm, enemy);
	}

	public void render() {
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(mm.getBackground(), 0, 0); // 绘制背景
		stage.getSpriteBatch().end();

		enemymanage();
		// 如果数组为空 则下一批敌人出场
		if (enemys.size() == 0 || enemys == null) { // 如果敌人数组为空 添加下一批敌人
			for (int i = 0; i < mm.enemycount; i++) {
				int temp = randompoint()[i].intValue(); // 随机选择刷怪点
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
			temp = random.nextInt(mm.refreshpoint.size()); // 生成随机数
			nums.add(temp);
		}
		Integer[] res = nums.toArray(new Integer[0]);
		return res;

	}

	// 敌人管理器
	public void enemymanage() {
		for (int i = 0; i < enemys.size(); i++) {

			switch (enemys.get(i).getState()) {
			case RUN:
				stage.removeActor(enemys.get(i));
				enemys.remove(i);
				i--;
				break;
			case DIE:
				enemys.get(i).setCounter(enemys.get(i).getCounter() + 1);

				if (enemys.get(i).getCounter() == 20)
					enemys.get(i).visible = false;
				if (enemys.get(i).getCounter() == 40)
					enemys.get(i).visible = true;
				if (enemys.get(i).getCounter() == 60)
					enemys.get(i).visible = false;
				if (enemys.get(i).getCounter() == 80)
					enemys.get(i).visible = true;
				if (enemys.get(i).getCounter() == 145) {
					stage.removeActor(enemys.get(i));
					enemys.remove(i);
					mm.setEnemysum(mm.getEnemysum() - 1);
					i--;
				}
				break;
			case FIRE:
				player.hurt(enemys.get(i).getDamage());
				break;

			default:
				break;

			}

		}

	}

	// 控制主角
	public void playeroriginxy(int x, int y) {
		Vector2 p = new Vector2();
		p = player.getposition();
		ox = p.x;
		oy = p.y;
		Gdx.app.log("oxoy", ox + " " + oy);
	}

	public void playercontrol(int x, int y) {
		float px = 0f, py = 0f;

		px = x + x;
		py = -(px * y / (x + 1));

		if ((ox + px) > Gdx.graphics.getWidth())
			px = Gdx.graphics.getWidth() - 64 - ox;
		if ((ox + px) < 0)
			px = 0 - ox;
		if ((oy + py) > Gdx.graphics.getHeight())
			py = Gdx.graphics.getHeight() - 64 - oy;
		if ((oy + py) < 0)
			py = 0 - oy;

		player.setposition(ox + px, oy + py);
		Gdx.app.log("pxpy", px + " " + py);
	}

	// 射击
	public void fire() {

		if (player.getBulletleft() != 0) {
			player.shot();

			boolean canshot = true;
			// 添加判断射击障碍物
			for (int i = 0; i < mm.getBarrierrect().size(); i++) {
				if (mm.getBarrierrect().get(i).overlaps(player.getPlayerrect()) == true) {
					canshot = false;
				}
			}

			if (canshot == true) {
				for (int i = 0; i < enemys.size(); i++) {
					if (enemys.get(i).getEnemyrect()
							.overlaps(player.getPlayerrect()) == true) {
						Gdx.app.log("hitit", "hitit");
						enemys.get(i).hurt(player.getGun().getDamage());
					}
				}
			}
		} else {
			player.setDelay(1);
			player.setReloadbegin(TimeUtils.nanoTime());
		}
	}

}
