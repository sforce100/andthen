package com.andthen.screen;

import com.andthen.main.AndThenGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class HelpScreen extends AbstractScreen{

	Button back;
	Stage stage;
	Skin skin;
	Texture tback;
	Label lhelp, lmain;
	BitmapFont font;
	public HelpScreen(AndThenGame game){
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
		Gdx.input.setInputProcessor(stage);		
	}
	
	
	
	private void init(){
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		//返回主菜单的按钮
		tback = new Texture(Gdx.files.internal("button1_480.png"));
		NinePatch np = new NinePatch(tback, 7, 7, 9, 9);
		back = new Button(np, np, np);
		back.x = 100;
		back.y = 100;
		back.width=100f;
		back.height=32f;
		
		back.setClickListener(new ClickListener() {
			
			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new MainMenuScreen(game));
			}
		});
		
	
		lhelp = new Label("back", new LabelStyle(new BitmapFont(), Color.RED), "返回");
		lhelp.x = Gdx.graphics.getWidth()/2;
		lhelp.y = Gdx.graphics.getHeight();
		
		
		lmain = new Label("HelpScreen", new LabelStyle(font, Color.WHITE));
//		lmain.setText("主菜单");
		lmain.width = 200f;
		lmain.height = 50f;
		lmain.x = 200;
		lmain.y = 200;
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(back);
		stage.addActor(lhelp);
		stage.addActor(lmain);
	}

}
