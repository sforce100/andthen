package com.andthen.map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


import com.andthen.actor.Player;
import com.andthen.enemys.Enemy;
import com.andthen.enemys.Enemylevel1;
import com.andthen.enemys.Enemylevel2;
import com.andthen.guns.Gun;
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
	private Gun main,second;
	private int wait=0;
	private long time;

	public GameMap(Stage s, MapModel m,Gun gun1,Gun gun2) {
		main=gun1;
		second=gun2;
		
		stage = s;
		mm = m;
		player = new Player(350, 200,main);
		
		
		stage.addActor(mm);
		stage.addActor(player);
	}

	// ��������
	public void addenemy(float[] a) {
		int enemylevel=(int)(Math.random()*6);
				if(enemylevel>mm.getEnemylevel()){
					enemylevel=1;
				}
		switch(enemylevel){
		case 1:
			Enemy enemy0 = new Enemy(a[0], a[1], a[2], a[3]); // ��������Ϊ ����x,y,z,��������
			enemys.add(enemy0);
			stage.getRoot().addActorBefore(mm, enemy0);
			break;
		case 2:
			Enemy enemy1 = new Enemylevel1(a[0], a[1], a[2], a[3]); // ��������Ϊ ����x,y,z,��������
			enemys.add(enemy1);
			stage.getRoot().addActorBefore(mm, enemy1);
			break;
		case 3:
			Enemy enemy2 = new Enemylevel2(a[0], a[1], a[2], a[3]); // ��������Ϊ ����x,y,z,��������
			enemys.add(enemy2);
			stage.getRoot().addActorBefore(mm, enemy2);
			break;
		default:
			Enemy enemy3 = new Enemy(a[0], a[1], a[2], a[3]); // ��������Ϊ ����x,y,z,��������
			enemys.add(enemy3);
			stage.getRoot().addActorBefore(mm, enemy3);
			break;
	
		}
	
	}

	public void render() {
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(mm.getBackground(), 0, 0); // ���Ʊ���
		stage.getSpriteBatch().end();

		enemymanage();
		// �������Ϊ�� ����һ�����˳���
		if (enemys.size() == 0 || enemys == null) { // �����������Ϊ�� �����һ������			
			
			if(wait==0){
				time=TimeUtils.millis();
				wait=1;
			}

			if(wait==1 && (TimeUtils.millis()-time)>2500){
			Integer[] res=randompoint();			
			for (int i = 0; i < mm.enemycount; i++) {
				int temp = res[i].intValue(); // ���ѡ��ˢ�ֵ�
				addenemy(mm.refreshpoint.get(temp));
			}
			wait=0;
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
				if(enemys.get(i).getCounter()>200){
					enemys.get(i).setCounter(0);
				}else{
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
		if ((oy + py+player.getHeight()) > Gdx.graphics.getHeight())
			py = Gdx.graphics.getHeight() - player.getHeight() - oy;
		if ((oy + py+player.getHeight()/2) < 0)
			py = 0 - oy-player.getHeight()/2;

		player.setposition(ox + px, oy + py);
		Gdx.app.log("pxpy", px + " " + py);
	}

	// ���
	public void fire() {

		if (player.getGun().getMagazineleft() != 0) {
			player.shot();

			boolean canshot = true;
			
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
	
	//��װ
	public void reload(){
		player.setDelay(1);
		player.setReloadbegin(TimeUtils.nanoTime());
	}
	
	//����ǹ
	public void changesecond(){
		player.setGun(second);
		
	}
	
	//����ǹ
	public void changemain(){
		player.setGun(main);
		
	}

}
