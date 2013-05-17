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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
	
	private Texture resource ;
	private TextureRegion background;
	
	
	public HelpScreen(AndThenGame game){
		super(game);
		init();
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
		Gdx.gl.glClearColor(0f,0f,0f,0f);
		stage.act(Gdx.graphics.getDeltaTime());
		
		
		
		
		
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(background, 0, 0); // 绘制背景
		stage.getSpriteBatch().end();
		
		
		
		
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
		Gdx.input.setInputProcessor(stage);		
	}
	
	
	
	private void init(){
		
		
		
		
		
		resource =  new Texture(Gdx.files.internal("helper.png"));
		background=new TextureRegion(resource, 0, 0, 800, 480);
		
		
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		//返回主菜单的按钮


		
		
		back = new Button(new TextureRegion(resource, 800,0, 84,84), new TextureRegion(resource, 800,84,84,84));
		back.x = 91;
		back.y = 347;
		back.width=84f;
		back.height=84f;
		
		back.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getMenuScreen());
			}
		});
		
	

		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(back);

	}

}
