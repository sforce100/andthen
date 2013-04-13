package com.andthen.screen;

import com.andthen.main.AndThenGame;
import com.andthen.tool.TempTexture;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class ShopScreen extends AbstractScreen{

	Button back, next;
	Stage stage;
	Label lmain;
	BitmapFont font;
	public ShopScreen(AndThenGame game){
		super(game);
		init();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
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
	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0f,0f,0f,0f);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();	
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
	
	private void init(){
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);

		NinePatch n = TempTexture.getButtonTexture();
		back = new Button(n, n, n);
		back.x = 10;
		back.y = 10;
		back.width = 100;
		back.height = 32;
		back.setClickListener(new ClickListener() {
			
			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new LevelSelect2(game));
			}
		});
		
		next = new  Button(n, n, n);
		next.x = Gdx.graphics.getWidth()-110;
		next.y = 10;
		next.width = 100;
		next.height = 32;
		next.setClickListener(new ClickListener() {
			
			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new GameScreen(game));
			}
		});
		
		lmain = new Label("ShopScreen", new LabelStyle(font, Color.WHITE));
		lmain.width = 200f;
		lmain.height = 50f;
		lmain.x = 200;
		lmain.y = 200;
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		stage.addActor(back);
		stage.addActor(next);
		stage.addActor(lmain);
	}

}
