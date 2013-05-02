package com.andthen.action;

import com.badlogic.gdx.math.Vector2;

public interface ShowType {
	
	public Vector2 show();
	
	public Vector2 hide();
	
//	public void fire();
	
	public int getState();

	public void setState(int state);
	
	public long getFirebegin() ;

	public void setFirebegin(long firebegin);

	
}
