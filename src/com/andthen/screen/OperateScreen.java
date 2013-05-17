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

public class OperateScreen extends AbstractScreen{

	Button back;
	Button music;
	Button sound;
	Stage stage;
	Skin skin;
	Texture tback;
	BitmapFont font;
	boolean musicclose=true;
	boolean soundclose=true;
	
	private Texture resource ;
	private TextureRegion background;
	
	private int parent=0;
	
	
	public OperateScreen(AndThenGame game){
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
		
		
		
		
		
		resource =  new Texture(Gdx.files.internal("operate.png"));
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
				if(parent==0){
					game.setScreen(game.getMenuScreen());
				}else{
					game.setScreen(game.getPausescreen());
				}
				
			}
		});
		
		
		
		music = new Button(new TextureRegion(resource, 800,168, 50,50), new TextureRegion(resource, 800,218,50,50));
		music.x = 440;
		music.y = 233;
		music.width=50f;
		music.height=50f;
		
		music.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				musicclose=!musicclose;
				if(musicclose){
					game.getMusic().stop();
				}else{
					game.getMusic().setLooping(true);
					game.getMusic().play();
					game.getMusic().setVolume(15);
				}
			}
		});
		
		
		sound = new Button(new TextureRegion(resource, 800,168, 50,50), new TextureRegion(resource, 800,218,50,50));
		sound.x = 440;
		sound.y = 136;
		sound.width=50f;
		sound.height=50f;
		
		sound.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				soundclose=!soundclose;
				
			}
		});
		
	

		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(back);
		stage.addActor(music);
		stage.addActor(sound);
		

	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public boolean isSoundclose() {
		return soundclose;
	}

	public void setSoundclose(boolean soundclose) {
		this.soundclose = soundclose;
	}


	
	

}
