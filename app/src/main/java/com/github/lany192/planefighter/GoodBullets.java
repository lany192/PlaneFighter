package com.github.lany192.planefighter;

import android.content.Context;
import android.graphics.Color;

public class GoodBullets extends MyFatherBullets {

	public GoodBullets(int bulletNUM, MyBigCir mainCir, float speed, Context c) {
		
		super(bulletNUM, speed);
		for (int i = 0; i < bulletNUM; i++) {
			double random1 = Math.random();
			double random2 = Math.random();
			double random6 = Math.random();
			double random3 = Math.random() / 5 + 0.5;
			boolean fromLeft = Math.random() < 0.5;
			float fromX = (float) (fromLeft ? -200 : screenWidth + 200);
			float fromY = (float) (random1 * (screenHeight + 2 * screenWidth) - screenWidth);
			miniCir[i] = new MiniCir(
					new float[]{fromX,
							fromY,
							(float) (mainCir.getX() + 200 * random2),
							(float) (mainCir.getY() + 200 * random6)},
					(float) (mSpeed * random3), c);
			miniCir[i].setColor(Color.parseColor("#FFBB33"));
			miniCir[i].setOnDeadListener(this);
		}
	}

	@Override
	protected void whenMyKnock(int i) {
		knockListener.onCirKnock(GameUtils.KnockFunction.REDUCE_SIZE);
		miniCir[i].setDead();
	}

	@Override
	protected void whenDead() {
		DEAD = true;
	}
}
