package com.andthen.showtype;

import com.badlogic.gdx.math.Vector2;

public class RightLeft implements ShowType {

	float firstx, firsty;
	float nextx, nexty;
	float referlong;
	int perx = 1, pery = 2;
	int distance = 100, high = 16;
	Vector2 position = new Vector2();
	boolean highlimit;
	int state = 1; // show 1 hide 2 fire 3 run 4

	public RightLeft(float x, float y, float w) {
		firstx = x;
		firsty = y;
		nextx = x;
		nexty = y;
		referlong = w;
		highlimit = true;
	}

	public Vector2 show() {

		if (nexty > (firsty + high))
			highlimit = false;
		if (nexty < firsty)
			highlimit = true;

		if (highlimit)
			nexty += 4;
		else
			nexty -= 4;

		nextx -= 2;

		if (nextx < firstx-distance) {
			state = 2;
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
			nexty += 4;
		else
			nexty -= 4;

		nextx += 2;

		if (nextx > firstx) {
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

}
