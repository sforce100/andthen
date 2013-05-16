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


import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class PauseScreen extends AbstractScreen {
	
	Button replay;
	Button operate;
	Button exit;
	Button goon;
	
	Stage stage;
	Skin skin;

	Texture startImg1,startImg2,startImg3,tex;
	BitmapFont font;
	ExitDialog exitDialog;
	boolean isPressKeyBack = false;
	
	private Texture resource ;
	private TextureRegion background;

	
	
	
	public PauseScreen (AndThenGame game) {
		super(game);
		init();
		
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

		
		resource =  new Texture(Gdx.files.internal("pause.png"));
		background=new TextureRegion(resource, 0, 0, 800, 480);
		

		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);

		
		
		//start button
		goon = new Button(new TextureRegion(resource, 0,480, 302,68), new TextureRegion(resource, 0,548,302,68));
		goon.x=244;
		goon.y=303;
		goon.width=302f;
		goon.height=68f;
		
		
		replay = new Button(new TextureRegion(resource, 302,480, 302,68), new TextureRegion(resource, 302,548,302,68));
		replay.x=244;
		replay.y=235;
		replay.width=302f;
		replay.height=68f;
		
		
		

		operate = new Button(new TextureRegion(resource, 604,480,302,68),new TextureRegion(resource, 604,548,302,68));
		operate.x = 244;
		operate.y = 177;
		operate.width=302f;
		operate.height=68f;	
		

	
		
		exit = new Button(new TextureRegion(resource, 0,616, 302,68),new TextureRegion(resource, 0,684,302,68));
		exit.x=244;
		exit.y=109;
		exit.width=302f;
		exit.height=68f;
		

		operator();
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(replay);
		stage.addActor(operate);
		stage.addActor(goon);
		stage.addActor(exit);
		
	}
	
	private void operator(){
		Gdx.input.setInputProcessor(stage);
		replay.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getGameScreen());
			}});
		
		operate.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getShopScreen());
			}});
		
		goon.setClickListener(new ClickListener(){

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
			operate.touchable = false;
			goon.touchable = false;
			exit.touchable = false;
		}else{
			replay.touchable = true;
			operate.touchable = true;
			goon.touchable = true;
			exit.touchable = true;
		}
	}
}
