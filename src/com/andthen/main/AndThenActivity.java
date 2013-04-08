package com.andthen.main;

import com.andthen.actor.AnimalActor;
import com.andthen.actor.ProgressBar;
import com.andthen.screen.Loading;
import com.andthen.screen.MainMenuScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class AndThenActivity extends Game {

	@Override
	public void create() {
		// TODO Auto-generated method stub
		setScreen(new Loading(this));
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
	
	
}