package com.andthen.enemys;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class Enemylevel1 extends Enemy {

	public Enemylevel1(float x, float y, float z, float showtype) {
		super(x, y, z, showtype);


		enemytexture=new TextureRegion(enemyresource,65,0,63,102);    
		
		height = 102* z;
		width = 63 * z;

		health = 60;
		damage=10;


	}
	

}
