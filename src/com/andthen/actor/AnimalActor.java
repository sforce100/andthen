package com.andthen.actor;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Disposable;

public class AnimalActor extends Actor implements Disposable{

	//演员需要衣服
	ArrayList<Texture> texArray = new ArrayList<Texture>();
	//内衣
	ArrayList<TextureRegion> texReArray = new ArrayList<TextureRegion>();
	//演员需要演技
	Animation animation;
	//演技有动作
	TextureRegion[] walksFrame;
	float stateTime;
	TextureRegion currentFrame;//当前帧
	
	//有同步和异步之分,但是是相对而言的,同步都在render()里面,异步会再另开一个线程,
	//但是相对于UI线程都是异步的
	AssetManager manager;//保存progress里面保存的manager实例
	
	public AnimalActor(AssetManager manager){
		super();
	    //关联Progress内的AssetManager
		this.manager = manager;
	}


	@Override
	public void draw(SpriteBatch batch, float arg1) {
		// TODO Auto-generated method stub
		stateTime +=Gdx.graphics.getDeltaTime();
		currentFrame = animation.getKeyFrame(stateTime, true);
		//以(0,0)绘制为起点（左下角为0，0）画出动画，大小128*128
		batch.draw(currentFrame, 0, 0, 128, 128);
				
	}

	@Override
	public Actor hit(float arg0, float arg1) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean touchDown(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void touchDragged(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void touchUp(float arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
	
	//初始化方法，在Progress中的AssetManager初始化完成后通知AnimalActor初始化
	public void iniResource(){
		Texture tex;
		int j;
		for(int i=1;i<30;i++){
			texArray.add(manager.get("animal/"+i+".png", Texture.class));
		}
		
		for(int i=0;i<texArray.size();i++){
			tex = texArray.get(i);
			TextureRegion temtex = new TextureRegion(tex);
			texReArray.add(temtex);//内衣上加衣服
		}
		
		j = texReArray.size();
		walksFrame = new TextureRegion[j];
		for(int i=0;i<j;i++){
			//设置的是0.06s一帧
			animation = new Animation(0.06f, walksFrame);
		}
	}
	
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		for(int i=0;i<texArray.size();i++)
			texArray.get(i).dispose();
	}

}
