package com.andthen.screen;

import com.andthen.main.AndThenGame;
import com.andthen.tool.TempTexture;
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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class LevelSelect2 extends AbstractScreen{

	Button back, next;
	Stage stage;
	Label lmain;
	BitmapFont font;
	Skin skin;
	public LevelSelect2(AndThenGame game){
		super(game);
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
	}
	
	private void init(){
//		skin = new Skin(Gdx.files.internal("skins/buttons.json"),Gdx.files.internal("button1_480.png"));
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);

		back = new Button(game.getBack1(), game.getBack2());
		back.x = 10;
		back.y = 10;
		back.width = 70;
		back.height = 70;
		back.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new LevelSelect1(game));
			}
		});
		
		next = new Button(game.getNext1(), game.getNext2());
		next.x = Gdx.graphics.getWidth()-110;
		next.y = 10;
		next.width = 70;
		next.height = 70;
		next.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new ShopScreen(game));
			}
		});
		
		lmain = new Label("LevelSelect2", new LabelStyle(font, Color.WHITE));
		lmain.width = 200f;
		lmain.height = 50f;
		lmain.x = 200;
		lmain.y = 200;
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(back);
		stage.addActor(next);
		stage.addActor(lmain);
		
		int k = 10;
		int kk = (Gdx.graphics.getWidth()-k*6)/5;
		int yy = Gdx.graphics.getHeight()-100;
		for(int i=1; i<11; i++){
			Button b = new Button(new TextureRegion(game.getUiresource(), 0, 124, 62, 63), new TextureRegion(game.getUiresource(), 62, 124, 62, 63));
			if(i>5){
				b.x = kk*(i-6)+k;
			}else{
				b.x = kk*(i-1)+k;
			}
			b.y = (i>5 ? yy-kk*2 : yy-kk);
			b.width = kk;
			b.height = kk;
			final String txt = "select level   "+i;
			final int tempNum = i;
			b.setClickListener(new ClickListener() {
				
				public void click(Actor arg0, float arg1, float arg2) {
					// TODO Auto-generated method stub
					lmain.setText(txt);
					game.getGameSource().setLevelNum(tempNum);
				}
			});
			stage.addActor(b);
			
			Label l = new Label(i+"", new LabelStyle(font, Color.WHITE));
			if(i>5){
				l.x = kk*(i-6)+k+kk/2;
			}else{
				l.x = kk*(i-1)+k+kk/2;
			}
			l.y = (i>5 ? yy-kk*2 : yy-kk);
			l.width = kk;
			l.height = kk;
			
			stage.addActor(l);
		}
		
		
	}

}
