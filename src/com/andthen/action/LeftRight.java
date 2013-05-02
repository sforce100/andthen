package com.andthen.action;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

public class LeftRight implements ShowType {

	float firstx, firsty;
	float nextx, nexty;
	float referlong;
	float perx, pery;
	float distance, high;
	Vector2 position = new Vector2();
	boolean highlimit;
	long firebegin;
	int state = 1; //show 1  fire 2 hide 3 run 4 die 5

	public LeftRight(float x, float y, float w) {
		firstx = x;
		firsty = y;
		nextx = x;
		nexty = y;
		referlong = w;

		perx = w * 5 / 640;
		pery = w / 64;
		distance = w * 100 / 64;
		high = w * 16 / 64;

		// test
//		 perx = 0.5f; pery = 1f;
//		 distance = 100; high = 16;

		highlimit = true;
	}

	public Vector2 show() {

		if (nexty > (firsty + high))
			highlimit = false;
		if (nexty < firsty)
			highlimit = true;

		if (highlimit)
			nexty += pery;
		else
			nexty -= pery;

		nextx += perx;

		if (nextx > firstx+distance) {
			state = 2;
			firebegin=TimeUtils.millis();
		}

		position.x = nextx;
		position.y = nexty;

		return position;

	}

	public Vector2 hide() {

		if (nexty > (firsty + high))
			highlimit = false;
		if (nexty < firsty)
			highlimit = true;

		if (highlimit)
			nexty += pery;
		else
			nexty -= pery;

		nextx -= perx;

		if (nextx < firstx) {
			state = 4;
		}

		position.x = nextx;
		position.y = nexty;

		return position;

	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getFirebegin() {
		return firebegin;
	}

	public void setFirebegin(long firebegin) {
		this.firebegin = firebegin;
	}

}
