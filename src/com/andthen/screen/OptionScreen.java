package com.andthen.screen;

import com.andthen.main.AndThenGame;
import com.andthen.ui.ExitDialog;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.ValueChangedListener;

public class OptionScreen extends AbstractScreen{

	Stage stage;
	Slider music;
	Texture tex;
	TextureRegion texReg;
	
	public OptionScreen(AndThenGame game) {
		super(game);
		// TODO Auto-generated constructor stub
		init();
	}

	public void dispose() {
		// TODO Auto-generated method stub
		
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
		stage.draw();		
		
		if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
			Gdx.app.log("mainscreen", "presskey back");
			game.setScreen(new MainMenuScreen(game));
		}
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
		tex = new Texture(Gdx.files.internal("button1_480.png"));
		texReg = new TextureRegion(tex);
		NinePatch n1 = new NinePatch(tex, 7, 7, 9, 9); 
		
		music = new Slider(0f, 1f, 0.05f, new SliderStyle(n1, texReg));
		music.setValue(game.getGameOption().getMusicLength());
		music.setValueChangedListener(new ValueChangedListener() {
			
			public void changed(Slider slider, float value) {
				// TODO Auto-generated method stub
				Gdx.app.log("option", value+"");
				game.getGameOption().setMusicLength(value);
			}
		});
		music.width = 800f;
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(music);
	}
	
}
