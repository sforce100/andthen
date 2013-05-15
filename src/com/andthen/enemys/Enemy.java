package com.andthen.enemys;

import com.andthen.action.LeftRight;
import com.andthen.action.RightLeft;
import com.andthen.action.ShowType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends Actor {

	public enum State { // ����״̬ �³��� ���� ����
		NEW, FIRE, DIE, RUN
	}

	State state = State.NEW; // ����״̬

	Texture enemyresource;        //����ͼƬ��Դ
	TextureRegion enemytexture; // ����Ƥ��
	float height; // ͼƬ�߶�
	float width; // ͼƬ���

	TextureRegion hole; // ����
	float holeheight; // ���׸߶�
	float holewidth; // ���׿��
	
	TextureRegion fire;      //��
	float fireheight; //�𻨸߶�
	float firewidth; //�𻨿��

	Rectangle enemyrect; // �����ı��η�Χ

	float z; // z����

//	long beginfire; // ��ʼ��ǹʱ��
	

	int health; // ��������
	int damage;// �˺�
	// ��������

	ShowType st; // ���˵ĳ�����ʽ �������ʽ

	int counter = 0;

	public Enemy(float x, float y, float z, float showtype) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		enemyresource = new Texture(Gdx.files.internal("enemys.png"));
		enemytexture=new TextureRegion(enemyresource,0,0,65,102);    
		
		height = 102* z;
		width = 64 * z;

		hole = new TextureRegion(enemyresource,187,0,17,16);
		holeheight = 16 * z;
		holewidth = 17 * z;
		
		fire = new TextureRegion(enemyresource,187,16,24,24);
		fireheight = 24* z;
		firewidth =24 * z;

		action(showtype);
		health = 30;
		damage=5;

		// ���˷�Χ
		enemyrect = new Rectangle();
		enemyrect.x = this.x;
		enemyrect.y = this.y;
		enemyrect.width = width;
		enemyrect.height = height;

	}

	// ѡ���������
	public void action(float x) {
		int t = (int) x;
		switch (t) {
		case 1:
			st = new LeftRight(this.x, this.y, width);
			break;
		case 2:
			st = new RightLeft(this.x, this.y, width);
			break;
		}
	}

	// �������˲�ѡ����
	private void change() {
		float newx = this.x, newy = this.y;
		Vector2 p = new Vector2();
		switch (st.getState()) {
		case 1:
			p = st.show();
			newx = p.x;
			newy = p.y;
			break;
		case 2:
            counter++;
			break;			
		case 3:
			p = st.hide();
			newx = p.x;
			newy = p.y;
			break;			
		case 4:
			state = State.RUN;
			break;

		}
		this.x = newx;
		this.y = newy;
		enemyrect.setX(newx);
		enemyrect.setY(newy);
	}

	// ������ʱ���˺�
	public void hurt(int damage) {
		health -= damage;
	}

	// ���
	public void fire() {

	}

	@Override
	public void draw(SpriteBatch batch, float arg1) {
		change();// ��������
		batch.draw(enemytexture, this.x, this.y, width, height);
		// �ж��Ƿ�����
		if (health < 0) {
			batch.draw(hole, this.x + 13 * z, this.y + 65 * z, holewidth,
					holeheight);
			st.setState(5);
			state = State.DIE;			
		}
		// �ж��Ƿ�ǹ
		if (st.getState() == 2) {

			if (counter == 100){
				batch.draw(fire, this.x + 3 * z, this.y + 27 * z, firewidth,
						fireheight);
				       state=State.FIRE;		
			}
			if(counter==101)
				state=State.NEW;
				
			     
			if (counter == 170){
				batch.draw(fire, this.x + 3 * z, this.y + 27 * z, firewidth,
						fireheight);
				       state=State.FIRE;		
			}
			if(counter==171)
				state=State.NEW;
			if (counter == 250){
				counter=0;
			    st.setState(3);		
			}
		}

	}

	public State getState() {
		return state;
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		return null;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Rectangle getEnemyrect() {
		return enemyrect;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
