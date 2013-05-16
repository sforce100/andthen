/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.andthen.screen;




import com.andthen.main.AndThenGame;
import com.andthen.ui.ExitDialog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;


public class SuccessScreen extends AbstractScreen {
	
	Button replay;
	Button shop;
	Button exit;
	
	Stage stage;
	Skin skin;

	Texture startImg1,startImg2,startImg3,tex;
	BitmapFont font;
	ExitDialog exitDialog;
	boolean isPressKeyBack = false;
	
	private Texture resource ;
	private TextureRegion star1,star2,star3,background;
	
	
	BitmapFont killnum, lefthp, price;
	
	int kill,hp,pr;
	int star;

	
	
	
	public SuccessScreen (AndThenGame game) {
		super(game);
		init();
		
		
	}
	
	public void setresult(int kill,int hp){
		this.kill=kill;
		this.hp=hp;
		pr=(kill+hp)*10;
		
		star=hp/30;
		
	}
	
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		skin.dispose();
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
		killnum.draw(stage.getSpriteBatch(), "" + kill, 280, 290);
		lefthp.draw(stage.getSpriteBatch(), "" + hp, 320,240);
		price.draw(stage.getSpriteBatch(), "" + pr, 265,120);
		
		switch(star){
		case 3:
			stage.getSpriteBatch().draw(star1,265,140); 
			stage.getSpriteBatch().draw(star2, 340,140); 
			stage.getSpriteBatch().draw(star3, 415,140); 
			break;
		case 2:
			stage.getSpriteBatch().draw(star1,265,140); 
			stage.getSpriteBatch().draw(star2, 340,140); 
			break;
		default:
			stage.getSpriteBatch().draw(star1,265,140); 
			break;		
		}
		
		
		
		stage.getSpriteBatch().end();
		
		
		
		stage.draw();		
		
		if(Gdx.input.isKeyPressed(Input.Keys.BACK)){
			Gdx.app.log("mainscreen", "presskey back");
			isPressKeyBack = true;
			//exit window
			exitDialog = new ExitDialog(stage, game.getActivity());
			//改变按钮状态
			buttonState(exitDialog.hasDialog);
			stage.addActor(exitDialog.makeup());
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
		


		
		resource =  new Texture(Gdx.files.internal("result.png"));
		background=new TextureRegion(resource, 0, 0, 800, 480);
		star1=new TextureRegion(resource, 800, 558,54,54 );
		star2=new TextureRegion(resource, 800, 558,54,54 );
		star3=new TextureRegion(resource, 800, 558,54,54 );
		

		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);

		
		
		//start button
		replay = new Button(new TextureRegion(resource, 800,0, 153, 93), new TextureRegion(resource, 800,93,153,93));
		replay.x=570;
		replay.y=246;
		replay.width=153f;
		replay.height=93f;
		
		
		

		shop = new Button(new TextureRegion(resource, 800,186,153,93),new TextureRegion(resource, 800,279,153,93));
		shop.x = 570;
		shop.y = 153;
		shop.width=153f;
		shop.height=93f;	
		

	
		
		exit = new Button(new TextureRegion(resource, 800,372, 153,93),new TextureRegion(resource, 800,465,153,93));
		exit.x=570;
		exit.y=60;
		exit.width=153f;
		exit.height=93f;
		
		
//		killnum = new Label(""+kill, new LabelStyle(font, Color.WHITE));
//		killnum.x = 280;
//		killnum.y = 255;
//		
//		lefthp = new Label(""+hp, new LabelStyle(font, Color.WHITE));
//		lefthp.x = 320;
//		lefthp.y = 205;
//		
//		price = new Label(""+pr, new LabelStyle(font, Color.WHITE));
//		price.x = 265;
//		price.y = 85;
		killnum = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		lefthp = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		price= new BitmapFont(Gdx.files.internal("font.fnt"), false);
		

		operator();
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(replay);
		stage.addActor(shop);
		stage.addActor(exit);
//		stage.addActor(killnum);
//		stage.addActor(lefthp);
//		stage.addActor(price);
		
		
	}
	
	private void operator(){
		Gdx.input.setInputProcessor(stage);
		replay.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getGameScreen());
			}});
		
		shop.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getShopScreen());
			}});
		
		
		exit.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
                //关闭程序
				game.setScreen(game.getLevelSelect1());
			}});
	}
	
	private void buttonState(boolean hasDialog){
		if(hasDialog){
			replay.touchable = false;
			shop.touchable = false;
			exit.touchable = false;
		}else{
			replay.touchable = true;
			shop.touchable = true;
			exit.touchable = true;
		}
	}
}
