package com.andthen.actor;

import com.andthen.guns.Gun;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.TimeUtils;

public class Player extends Actor {

	Gun gun;//���ϵ�����
	int health; // ����ֵ
    int defense;//����
    
	Texture guntexture;//ǹеͼƬ
	float height; // ͼƬ�߶�
	float width; // ͼƬ���
	
	int bulletleft; // ��ǰ�����ӵ���
	Rectangle playerrect; // player��Χ

	BitmapFont maxleft, maxsize, bleft; // ʣ���ӵ�ֵ ���Я���� ����ʣ���ӵ���
	BitmapFont hp,def;   //����ֵ������ֵ

	//����ʱ��
	long reloadbegin; //������ʼʱ��
	int delay = 0;  //������ʶ

	public Player(float x, float y) {
		this.x = x;
		this.y = y;
		
		health=100;
		defense=35;
		
		gun = new Gun();
		guntexture = new Texture(Gdx.files.internal(gun.getTexture()));
		height = guntexture.getHeight();
		width = guntexture.getWidth();

		// ��ǰ�����ӵ���
		bulletleft = gun.getMagazines();
		// player��Χ
		playerrect = new Rectangle();
		playerrect.x = this.x + width / 2 - 2;
		playerrect.y = this.y + height - 2;
		playerrect.width = 4;
		playerrect.height = 4;

		// ����
		bleft = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		maxsize = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		maxleft = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		hp = new BitmapFont(Gdx.files.internal("font.fnt"), false);
        def= new BitmapFont(Gdx.files.internal("font.fnt"), false);
        }

	// ��ȡ����
	public Vector2 getposition() {
		Vector2 p = new Vector2();
		p.x = this.x;
		p.y = this.y;
		return p;

	}

	// ��������
	public void setposition(float x, float y) {
		this.x = x;
		this.y = y;
		playerrect.x = this.x + width / 2 - 2;
		playerrect.y = this.y + height - 2;
	}

	// ��ȡ�����Χ
	public Rectangle getPlayerrect() {
		return playerrect;
	}

	// ��װ�ӵ�
	public void reload() {

		if (gun.getMaxleft() > 0) {
			if (gun.getMaxleft() + bulletleft >= gun.getMagazines()) {
				gun.setMaxleft(gun.getMaxleft() + bulletleft
						- gun.getMagazines());
				bulletleft = gun.getMagazines();
			} else {
				bulletleft = bulletleft + gun.getMaxleft();
				gun.setMaxleft(0);
			}
		}
	}

	// ���
	public void shot() {
		bulletleft -= 1;
	}
	
	//������
	public void hurt(int damage){
		if(defense>0){
			defense-=damage;
			if(defense<0){
				health+=defense;
				defense=0;
			}		
		}else{
			health-=damage;
		}
		
	}

	@Override
	public void draw(SpriteBatch batch, float arg1) {
		batch.draw(guntexture, this.x, this.y);
		bleft.draw(batch, "" + bulletleft, 20, 40);
		maxsize.draw(batch, "" + gun.getMaxsize(), 20, 60);
		maxleft.draw(batch, "" + gun.getMaxleft(), 20, 80);
		hp.draw(batch, "" + health, Gdx.graphics.getWidth()-50, Gdx.graphics.getHeight()-20);
		def.draw(batch, "" + defense, Gdx.graphics.getWidth()-150,Gdx.graphics.getHeight()-20);

		//װ����ʱ
		if (delay == 1) {
			if (TimeUtils.nanoTime() - reloadbegin > gun.getReloadtime()){
				reload();
				delay = 0;
			}
		}

	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public int getBulletleft() {
		return bulletleft;
	}

	public void setBulletleft(int bulletleft) {
		this.bulletleft = bulletleft;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public long getReloadbegin() {
		return reloadbegin;
	}

	public void setReloadbegin(long reloadbegin) {
		this.reloadbegin = reloadbegin;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}


}
