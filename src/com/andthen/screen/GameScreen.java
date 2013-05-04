package com.andthen.screen;

import com.andthen.main.AndThenGame;
import com.andthen.map.GameMap;
import com.andthen.map.MapModel;
import com.andthen.tool.TempTexture;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;




public class GameScreen extends AbstractScreen implements InputProcessor{

    Stage stage;
	private GameMap gamemap;
	private MapModel mm;
	private int x0,y0,x1,y1;
	Button fire;
	




	public GameScreen(AndThenGame game) {
		super(game);

		// TODO Auto-generated constructor stub
	}

	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
	}

	public void hide() {
		// TODO Auto-generated method stub

	}

	public void pause() {
		// TODO Auto-generated method stub

	}

	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(1f,1f,1f,0f);
//		stage.act(Gdx.graphics.getDeltaTime());
		stage.act(0.05f);
//		Gdx.app.log("render",""+Gdx.graphics.getDeltaTime());
		
		gamemap.render();
		stage.draw();

	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	public void resume() {
		// TODO Auto-generated method stub

	}

	public void show() {
		// TODO Auto-generated method stub
		// 
		
		
		
		mm=new MapModel();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		
		//需添加一个  根据前面screen选择的 地图   构造出一个对应的mapmodel的方法
		
		//需添加一个  根据前面screen选择的 武器情况   构造出一个对应的player的方法
		
		
		

		gamemap=new GameMap(stage,mm);      //传入舞台 跟 地图属性
		
		
		
		fire = new Button(new TextureRegion(game.getUiresource(), 124, 281, 62, 62), new TextureRegion(game.getUiresource(), 186, 281, 62, 62));
		fire.x = Gdx.graphics.getWidth()-110;;
		fire.y = 10;
		fire.width = 100;
		fire.height = 100;
		fire.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				gamemap.fire();
				Gdx.app.log("hit", "okhit");
			}
		});
		
		
		
		
	
//		Gdx.input.setInputProcessor(stage);
		  InputMultiplexer multiplexer = new InputMultiplexer();
		  multiplexer.addProcessor(stage);
		  multiplexer.addProcessor(this);
			 
			 Gdx.input.setInputProcessor(multiplexer);
			 stage.addActor(fire);

	}

	public boolean keyDown(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean keyTyped(char arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean keyUp(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean scrolled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

       if(arg0<(Gdx.graphics.getWidth()/2)){
		x0=arg0;
		y0=arg1;
		gamemap.playeroriginxy(x0,y0);
		Gdx.app.log("x0y0", x0+" "+y0+" "+Gdx.graphics.getWidth());}
		return true;
	}

	public boolean touchDragged(int arg0, int arg1, int pointer) {
		// TODO Auto-generated method stub


	           
		
		if(arg0<(Gdx.graphics.getWidth()/2)){
		x1=arg0;
		y1=arg1;
		gamemap.playercontrol(x1-x0, y1-y0);

		Gdx.app.log("x1y1", x1+" "+y1);}
		return true;
		
	}

	public boolean touchMoved(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
