package com.andthen.actor;

import com.andthen.guns.Gun;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.TimeUtils;

public class Player extends Actor {

	Gun gun;//手上的武器
	int health; // 生命值
    int defense;//护甲
    
	Texture gunresource;//枪械图片
	
	
	TextureRegion guntexture;
	float height; // 图片高度
	float width; // 图片宽度
	
	Rectangle playerrect; // player范围

	BitmapFont maxleft, maxsize, bleft; // 剩余子弹值 最大携带量 弹夹剩余子弹数
	BitmapFont hp,def;   //生命值、护甲值

	
	long reloadbegin; //换弹开始时间
	int delay = 0;  //换弹标识
	
	

	
	
	private Texture uiresource;
	Image enemyImg, armorImg, hpImg;
	Label emenyLab, armorLab, hpLab;
	BitmapFont font;
	public Player(float x, float y,Gun thegun) {
		this.x = x;
		this.y = y;
		
		health=100;
		defense=35;
		
		gun =thegun;
		gunresource = new Texture(Gdx.files.internal("guns.png"));
		guntexture=new TextureRegion(gunresource,gun.getX0(),gun.getY0(),gun.getWidth(),gun.getHeight());    
		
		width = gun.getWidth();
		height = gun.getHeight();
		
		// player范围
		playerrect = new Rectangle();
		playerrect.x = this.x + width / 2 - 1;
		playerrect.y = this.y + height - 1;
		playerrect.width = 2;
		playerrect.height = 2;

		// 字体
		bleft = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		maxsize = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		maxleft = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		hp = new BitmapFont(Gdx.files.internal("font.fnt"), false);
        def= new BitmapFont(Gdx.files.internal("font.fnt"), false);
         
        font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
        initUi();
       
	}

	// 获取坐标
	public Vector2 getposition() {
		Vector2 p = new Vector2();
		p.x = this.x;
		p.y = this.y;
		return p;

	}

	// 设置坐标
	public void setposition(float x, float y) {
		this.x = x;
		this.y = y;
		playerrect.x = this.x + width / 2 - 1;
		playerrect.y = this.y + height - 1;
	}

	// 获取射击范围
	public Rectangle getPlayerrect() {
		return playerrect;
	}

	// 填装子弹
	public void reload() {

		if (gun.getMaxleft() > 0) {
			if (gun.getMaxleft() + gun.getMagazineleft() >= gun.getMagazines()) {
				gun.setMaxleft(gun.getMaxleft() + gun.getMagazineleft()
						- gun.getMagazines());
				gun.setMagazineleft( gun.getMagazines());
			} else {
				gun.setMagazineleft(gun.getMagazineleft() + gun.getMaxleft());
				gun.setMaxleft(0);
			}
		}
	}

	// 射击
	public void shot() {
		gun.setMagazineleft(gun.getMagazineleft()-1);
	}
	
	//被击中
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
		bleft.draw(batch, "" + gun.getMagazineleft(), 20, 40);
		maxsize.draw(batch, "" + gun.getMaxsize(), 20, 60);
		maxleft.draw(batch, "" + gun.getMaxleft(), 20, 80);
		
		hpImg.draw(batch, 100);
		armorImg.draw(batch, 100);
		enemyImg.draw(batch, 100);
//		hpLab.setText(health+"");
//		hpLab.x = Gdx.graphics.getWidth()-40;
//		hpLab.y = Gdx.graphics.getHeight()-40;
//		hpLab.width = 10;
//		hpLab.height = 10;
//		hpLab.draw(batch, 100);
		hp.draw(batch, "" + health, Gdx.graphics.getWidth()-70, Gdx.graphics.getHeight()-25);
		
		def.draw(batch, "" + defense, Gdx.graphics.getWidth()-220,Gdx.graphics.getHeight()-25);

		//装弹延时
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
	
	private void initUi(){
		 uiresource = new Texture(Gdx.files.internal("ui.png"));
	     hpImg = new Image(new TextureRegion(uiresource, 203,219, 79,36));
//	     hpLab = new Label("100", new LabelStyle(font, Color.WHITE));
	     hpImg.x = Gdx.graphics.getWidth()-100;
		 hpImg.y = Gdx.graphics.getHeight()-60;
		 hpImg.width = 80;
		 hpImg.height = 40;
		 
		 armorImg = new Image(new TextureRegion(uiresource, 282,219, 79,36));
		 armorImg.x = Gdx.graphics.getWidth()-250;
		 armorImg.y = Gdx.graphics.getHeight()-60;
		 armorImg.width = 80;
		 armorImg.height = 40;
//		 
		 enemyImg = new Image(new TextureRegion(uiresource, 124,219, 79,36));
		 enemyImg.x = 100;
		 enemyImg.y = Gdx.graphics.getHeight()-60;
		 enemyImg.width = 80;
		 enemyImg.height = 40;
	}

	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun thegun) {

		this.gun = thegun;
		
		guntexture=new TextureRegion(gunresource,gun.getX0(),gun.getY0(),gun.getWidth(),gun.getHeight());    
		
		width = gun.getWidth();
		height = gun.getHeight();
		
		
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

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}


}
