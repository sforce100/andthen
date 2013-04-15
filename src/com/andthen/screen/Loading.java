package com.andthen.screen;

import com.andthen.actor.AnimalActor;
import com.andthen.actor.ProgressBar;
import com.andthen.main.AndThenGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class Loading extends AbstractScreen{
	
	ProgressBar bar;
	AnimalActor animal;
	Stage stage;
	AssetManager manager;
	boolean hasini;

	public Loading(AndThenGame game) {
		// TODO Auto-generated method stub
		
		super(game);
		
		bar = new ProgressBar(0, 0);
		//创建新舞台
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		stage.addActor(bar);
		//记得初始化一下AssetManager实例
		manager = new AssetManager();
		//传入AssetManger的引用，便于animal的资源初始化，但是注意了，只有在调用iniResourse()后资源才被初始化
		animal = new AnimalActor(manager);
		//把资源加入载入列表,这里我放了一个29帧的动画，在asset文件夹下animal下有29张图片
		//还没真正加载
		for(int i=1;i<30;i++)
			manager.load("animal/"+i+".png", Texture.class);

	}
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		bar.dispose();
		animal.dispose();
		manager.clear();
		manager.dispose();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1f, 1f, 1f, 0f);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		//update才真正加载,加载完就返回true
		if(!manager.update()){
			bar.setProgress(manager.getProgress()*100);
		}
		//加载完成且之前没有初始化过AnimalActor，且在手触摸屏幕时初始化AnimalActor,
		//并将进度条从舞台中移除，并加入AnimalActor对象
		if(!hasini && manager.update() && Gdx.input.isTouched()){
		   stage.removeActor(bar);
           animal.iniResource();
//	           stage.addActor(animal);
           hasini=true;
           this.game.setScreen(game.getMenuScreen());
		}
		
	   //我们做一个标记，看看未加载（Queued）完成的资源和已载入完成的资源的数量（Loaded）
       if(!manager.update()){
	       System.out.println("QueuedAssets:"+manager.getQueuedAssets());
	       System.out.println("LoadedAssets:"+manager.getLoadedAssets());
	       System.out.println("Progress:"+manager.getProgress());
       }
	}

}
