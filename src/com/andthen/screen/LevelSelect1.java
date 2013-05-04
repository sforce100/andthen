package com.andthen.screen;

import java.util.ArrayList;

import com.andthen.main.AndThenGame;
import com.andthen.tool.sql.MapSqlOperator;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

public class LevelSelect1 extends AbstractScreen{

	Button back, next;
	
	Stage stage;
	Label lmain;
	BitmapFont font;
	
	ArrayList list;
	public LevelSelect1(AndThenGame game){
		super(game);
//		init();
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
		init();
		Gdx.input.setInputProcessor(stage);
		
		//¹Ø¿¨
//		MapSqlOperator sql = new MapSqlOperator(content);
		
	}
	
	private void init(){
	
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);

		back = new Button(game.getBack1(), game.getBack2());
		back.x = 10;
		back.y = 10;
		back.width = 70;
		back.height = 70;
		back.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new MainMenuScreen(game));
			}
		});
		
		next = new  Button(game.getNext1(), game.getNext2());
		next.x = Gdx.graphics.getWidth()-110;
		next.y = 10;
		next.width = 70;
		next.height = 70;
		next.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new LevelSelect2(game));
			}
		});
		
		lmain = new Label("select level", new LabelStyle(font, Color.WHITE));
//		lmain.width = 200f;
//		lmain.height = 50f;
		lmain.x = Gdx.graphics.getWidth()/3;
		lmain.y = Gdx.graphics.getHeight()-50;
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(back);
		stage.addActor(next);
		stage.addActor(lmain);
		
		int k = 10;
		int kk = (Gdx.graphics.getWidth()-k*6)/5;
		int yy = Gdx.graphics.getHeight()-100;
		for(int i=1; i<11; i++){
			Button b = new Button(new TextureRegion(game.getUiresource(), 374, 0, 138,141), new TextureRegion(game.getUiresource(), 512, 0, 138,141));
			if(i>5){
				b.x = kk*(i-6)+k;
			}else{
				b.x = kk*(i-1)+k;
			}
			
			b.y = (i>5 ? yy-kk*2 : yy-kk);
			b.width = kk;
			b.height = kk;
			final String txt = "select level   "+i;
			final int tempI = i;
			b.setClickListener(new ClickListener() {
				
				public void click(Actor arg0, float arg1, float arg2) {
					// TODO Auto-generated method stub
					lmain.setText(txt);
					game.getGameSource().setLevel(tempI);
				}
			});
			stage.addActor(b);
		}
		
	}

}
