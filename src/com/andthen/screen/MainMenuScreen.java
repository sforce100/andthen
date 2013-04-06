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

import android.graphics.drawable.NinePatchDrawable;

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
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class MainMenuScreen implements Screen {
	Game game;
	Button start;
	Button option;
	Button help;
	Button exit;
	Stage stage;
	Skin skin;
	Label lmain;
	Texture startImg1,startImg2,startImg3,tex;
	BitmapFont font;
	public MainMenuScreen (Game game) {
		this.game = game;
		init();
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		skin.dispose();
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
		font = new BitmapFont(Gdx.files.internal("tem.fnt"), false);
//		skin = new Skin();
//		skin.add("start", new Texture("12.png"));
		startImg1 = new Texture(Gdx.files.internal("12.png"));
		startImg2 = new Texture(Gdx.files.internal("22.png"));
		startImg3 = new Texture(Gdx.files.internal("23.png"));
		 
		NinePatch path1 = new NinePatch(startImg1, 0, 0, 10, 10);
		NinePatch path2 = new NinePatch(startImg2, 0, 0, 10, 10);
		NinePatch path3 = new NinePatch(startImg3, 0, 0, 10, 10);
		 
		start = new Button(new Button.ButtonStyle(path1, path2, path3, 0,0,100,100));
//		start = new Button(new ButtonStyle(), "Start");
//		tex = new Texture(Gdx.files.internal("button1_480.png"));
//		NinePatch n1 = new NinePatch(tex, 7, 7, 9, 9); 
//		start = new Button( new ButtonStyle(n1, n1, n1, 0f, 0f, 0f, 0f)); 
		start.x=10;
		start.y=10;
		start.width=100f;
		start.height=32f;
		
		start.setClickListener(new ClickListener(){

			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				
			}});
		
		option = new Button(new ButtonStyle(), "Start");
		option.setClickListener(new ClickListener(){

			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				
			}});
		
		
		
		
		tex = new Texture(Gdx.files.internal("button1_480.png"));
		NinePatch n1 = new NinePatch(tex, 7, 7, 9, 9); 
		help = new Button( new ButtonStyle(n1, n1, n1, 0f, 0f, 0f, 0f)); 
		help.x=10;
		help.y=50;
		help.width=100f;
		help.height=32f;
		help.setClickListener(new ClickListener(){

			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new HelpScreen(game));
			}});
		exit = new Button(new ButtonStyle(), "Start");
		exit.setClickListener(new ClickListener(){

			@Override
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				
			}});
		
		lmain = new Label("主菜单", new LabelStyle(font, Color.WHITE), "主菜单");
//		lmain.setText("主菜单");
		lmain.width = 200f;
		lmain.height = 50f;
		lmain.x = 200;
		lmain.y = 200;
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		Gdx.input.setInputProcessor(stage);
		stage.addActor(start);
		stage.addActor(option);
		stage.addActor(help);
		stage.addActor(exit);
		stage.addActor(lmain);
	}
}
