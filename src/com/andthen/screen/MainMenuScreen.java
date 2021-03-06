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


import android.app.Activity;

import com.andthen.main.AndThenGame;
import com.andthen.ui.ExitDialog;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class MainMenuScreen extends AbstractScreen {
	
	Button start;
	Button option;
	Button help;
	Button exit;
	Stage stage;
	Skin skin;
	Label lmain,loption,lhelp,lstart,lexit;
	Texture startImg1,startImg2,startImg3,tex;
	BitmapFont font;
	ExitDialog exitDialog;
	boolean isPressKeyBack = false;
	public MainMenuScreen (AndThenGame game) {
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
		FileHandle  png = Gdx.files.internal("button1_480.png");
		tex = new Texture(png);
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		NinePatch n1 = new NinePatch(tex, 7, 7, 9, 9); 
		
		
		//start button
		start = new Button(new Button.ButtonStyle(n1, n1, n1, 0,0,100,100));
		start.x=10;
		start.y=10;
		start.width=100f;
		start.height=32f;
		
		
		
		lstart = new Label("start", new LabelStyle(font, Color.WHITE));
		lstart.x=110;
		lstart.y=10;
		lstart.width=100f;
		lstart.height=32f;
		
		
		//option button
		option = new Button(new Button.ButtonStyle(n1, n1, n1, 0,0,100,100));

		
		option.x = 10;
		option.y = 70;
		option.width=100f;
		option.height=32f;	
		
		loption = new Label("option", new LabelStyle(font, Color.WHITE));
		loption.x=110;
		loption.y=70;
		loption.width=100f;
		loption.height=32f;
		
		help = new Button( new ButtonStyle(n1, n1, n1, 0f, 0f, 0f, 0f)); 
		help.x=10;
		help.y=108;
		help.width=100f;
		help.height=32f;

		
		lhelp = new Label("help", new LabelStyle(font, Color.WHITE));
		lhelp.x=110;
		lhelp.y=108;
		lhelp.width=100f;
		lhelp.height=32f;
		
		
		exit = new Button(new ButtonStyle(n1, n1, n1, 0f, 0f, 0f, 0f));
		exit.x=10;
		exit.y=146;
		exit.width=100f;
		exit.height=32f;
		
		
		lexit = new Label("exit", new LabelStyle(font, Color.WHITE));
		lexit.x=110;
		lexit.y=146;
		lexit.width=100f;
		lexit.height=32f;
	
		
		
		lmain = new Label("MainScreen", new LabelStyle(font, Color.WHITE));
//		lmain.setText("主菜单");
		lmain.width = 200f;
		lmain.height = 50f;
		lmain.x = 200;
		lmain.y = 200;
		
		operator();
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		stage.addActor(start);
		stage.addActor(option);
		stage.addActor(help);
		stage.addActor(exit);
		stage.addActor(lmain);
		stage.addActor(lhelp);
		stage.addActor(lexit);
		stage.addActor(loption);
		stage.addActor(lstart);
		
	}
	
	private void operator(){
		Gdx.input.setInputProcessor(stage);
		option.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getOptionScreen());
			}});
		
		help.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getHelpScreen());
			}});
		
		start.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(game.getLevelSelect1());
			}});
		
		exit.setClickListener(new ClickListener(){

			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
                //关闭程序
                game.getActivity().finish();
                android.os.Process.killProcess(android.os.Process.myPid());
			}});
	}
	
	private void buttonState(boolean hasDialog){
		if(hasDialog){
			start.touchable = false;
			option.touchable = false;
			help.touchable = false;
			exit.touchable = false;
		}else{
			start.touchable = true;
			option.touchable = true;
			help.touchable = true;
			exit.touchable = true;
		}
	}
}
