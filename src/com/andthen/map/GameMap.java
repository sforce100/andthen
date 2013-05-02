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

public class GameMap { // ������ͼ

	private Stage stage; // ��̨
	private MapModel mm; // ��ͼ����
	List<Enemy> enemys = new ArrayList<Enemy>(); // �洢һ������
	private Player player;
	private float ox, oy;

	public GameMap(Stage s, MapModel m) {
		stage = s;
		mm = m;
		player = new Player(350, 200);
		stage.addActor(mm);
		stage.addActor(player);
	}

	// ��������
	public void addenemy(float[] a) {
		Enemy enemy = new Enemy(a[0], a[1], a[2], a[3]); // ��������Ϊ ����x,y,z,��������
		enemys.add(enemy);
		// stage.addActor(enemy); // ������̨
		stage.getRoot().addActorBefore(mm, enemy);
	}

	public void render() {
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(mm.getBackground(), 0, 0); // ���Ʊ���
		stage.getSpriteBatch().end();

		enemymanage();
		// �������Ϊ�� ����һ�����˳���
		if (enemys.size() == 0 || enemys == null) { // �����������Ϊ�� �����һ������
			for (int i = 0; i < mm.enemycount; i++) {
				int temp = randompoint()[i].intValue(); // ���ѡ��ˢ�ֵ�
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
			temp = random.nextInt(mm.refreshpoint.size()); // ���������
			nums.add(temp);
		}
		Integer[] res = nums.toArray(new Integer[0]);
		return res;

	}

	// ���˹�����
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

	// ��������
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

	// ���
	public void fire() {

		if (player.getBulletleft() != 0) {
			player.shot();

			boolean canshot = true;
			// ����ж�����ϰ���
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
