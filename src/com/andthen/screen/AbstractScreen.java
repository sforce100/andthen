package com.andthen.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public abstract class AbstractScreen implements Screen{
	protected Game game;
	public AbstractScreen(Game game){
		this.game = game;
	}
}
