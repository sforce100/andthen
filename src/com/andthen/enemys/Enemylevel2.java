package com.andthen.enemys;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemylevel2 extends Enemy {

	public Enemylevel2(float x, float y, float z, float showtype) {
		super(x, y, z, showtype);
		// TODO Auto-generated constructor stub
		enemytexture=new TextureRegion(enemyresource,128,0,59,102);    
		
		height = 102* z;
		width = 59 * z;

		health = 40;
		damage=1;

	}

}
