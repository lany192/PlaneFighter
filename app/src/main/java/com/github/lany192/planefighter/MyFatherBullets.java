package com.github.lany192.planefighter;

import android.graphics.Canvas;

public abstract class MyFatherBullets implements OnDeadListener {
	protected OnKnockListener knockListener;
	protected MiniCir[] miniCir;
	protected int bulletNUM = 20;
	protected double screenHeight;
	protected double screenWidth;
	protected float mSpeed;
	protected boolean DEAD = false;
	protected int cirDeadNUM = 0;
	protected MyBigCir mMainCir;
	protected OnDeadListener deadListener;

	public MyFatherBullets(int bulletNUM, float speed) {
		
		mSpeed = speed;
		screenHeight = MyUtils.getScreenHeight();
		screenWidth = MyUtils.getScreenWidth();
		this.bulletNUM = bulletNUM;
		miniCir = new MiniCir[bulletNUM];
	}

	public void draw(Canvas canvas) {
		if (!DEAD) {
			for (int i = 0; i < bulletNUM; i++) {
				miniCir[i].draw(canvas);
				if (miniCir[i].isKnocked(mMainCir.getX(), mMainCir.getY(), mMainCir.getRadius())) {
					whenMyKnock(i);
				}
			}
			if (cirDeadNUM == bulletNUM) {
				whenDead();
			}
		}

	}


	protected abstract void whenDead();

	protected abstract void whenMyKnock(int i);

	public boolean isDead() {
		return DEAD;
	}

	public void setSpeed(float speed) {
		this.mSpeed = speed;
	}

	public void setBulletNum(int num) {
		bulletNUM = num;
	}

	public void setKnockListener(OnKnockListener listener, MyBigCir mainCir) {
		knockListener = listener;
		mMainCir = mainCir;
	}

	public void setOnDeadListener(OnDeadListener listener) {
		deadListener = listener;
	}

	@Override
	public void onCirDead(MiniCir miniCir) {

        cirDeadNUM++;
	}

	@Override
	public void onCirDead(MyFatherBullets bullets) {


    }
}
