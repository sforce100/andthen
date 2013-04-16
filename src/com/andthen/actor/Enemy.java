package com.andthen.actor;


import com.andthen.showtype.LeftRight;
import com.andthen.showtype.RightLeft;
import com.andthen.showtype.ShowType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Enemy extends Actor {

	 public enum State {             //敌人状态   新出场    死了    逃跑
	 NEW,  DIE, RUN               
	 }
	
	 State state = State.NEW;          //敌人状态

	Texture enemytexture;             //敌人皮肤

	//Rectangle enemyrect;           //敌人四边形范围
	
	float height;                   //图片高度
	float width;                     // 图片宽度
	
	//int health                  //敌人生命
	
	
	ShowType st;                       //敌人的出场方式 和射击方式
	
	
	public Enemy(float x, float y, float z,float showtype) {
		super();
		this.x = x;
		this.y = y;
		enemytexture = new Texture(Gdx.files.internal("enemy.png"));
		height = enemytexture.getHeight()*z;
		width = enemytexture.getWidth()*z;
		action(showtype);

		// 敌人范围
	    // enemyrect = new Rectangle();
		// enemyrect.x=this.x;
		// enemyrect.y=this.y;
		// enemyrect.width = width;
		// enemyrect.height = height;

	}
	//选择出场类型
	public void action(float x) {
		int t = (int)x;
		switch (t) {
		case 1:
			st = new LeftRight(this.x, this.y, width);
			break;
		case 2:
			st = new RightLeft(this.x, this.y, width);
			break;
		}
	}

	//更新座標并选择动作
	private void change() {
		float newx=this.x,newy=this.y;
		Vector2 p = new Vector2();
		switch (st.getState()) {
		case 1:         
			p=st.show();
			newx = p.x;
			newy = p.y;
			break;
		case 2:
			p=st.hide();
			newx = p.x;
			newy = p.y;
			break;
		case 3:
			break;
		case 4:
            state=State.RUN;
			break;
		}
		this.x=newx;
		this.y=newy;
	}

    @Override
	public void draw(SpriteBatch batch, float arg1) {
		change();//更新坐标
		batch.draw(enemytexture, this.x, this.y,width,height);
		
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

}
