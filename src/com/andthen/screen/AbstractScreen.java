package com.andthen.screen;

import com.andthen.main.AndThenGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen{
	protected AndThenGame game; 
	public AbstractScreen(AndThenGame game){
		this.game = game;
	}
}
