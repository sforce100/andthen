package com.andthen.tool;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;

public class TempTexture {
	static BitmapFont font;
	static Texture tex;
	public static NinePatch getButtonTexture(){
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);
		tex = new Texture(Gdx.files.internal("button1_480.png"));
		NinePatch n1 = new NinePatch(tex, 7, 7, 9, 9);
		return n1; 
	}
}
