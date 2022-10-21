package com.github.lany192.planefighter;

import android.content.Context;
import android.graphics.Color;

public class TrackedBullets extends MyFatherBullets {

	public TrackedBullets(int bulletNUM, MyBigCir mainCir, float speed, Context c) {
		
		super(bulletNUM, speed);
		for (int i = 0; i < bulletNUM; i++) {
			double random1 = Math.random();
			double random2 = Math.random();
			double random6 = Math.random();
			double randomSpeed = speed * (Math.random() * 0.3 + 0.75);//From 85% - 115%
			boolean fromLeft = Math.random() < 0.5;
			float fromX = (float) (fromLeft ? -300 : screenWidth + 300);
			float fromY = (float) (random1 * (screenHeight + 2 * screenWidth) - screenWidth);
			miniCir[i] = new MiniCir(
					new float[]{fromX,
							fromY,
							(float) (mainCir.getX() + MyUtils.getScreenWidth() / 4 * random2),
							(float) (mainCir.getY() + MyUtils.getScreenHeight() / 4 * random6)},
					(float) randomSpeed, c);
			miniCir[i].setColor(Color.parseColor("#AA66CC"));
			miniCir[i].setOnDeadListener(this);
		}
	}

	@Override
	protected void whenMyKnock(int i) {
		knockListener.onCirKnock(GameUtils.KnockFunction.ADD_SIZE);
		miniCir[i].setDead();
	}

	@Override
	protected void whenDead() {
		DEAD = true;
		deadListener.onCirDead(this);
	}

}
