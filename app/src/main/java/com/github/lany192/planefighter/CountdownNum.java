package com.github.lany192.planefighter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;

import java.util.Calendar;

public class CountdownNum {
	private float size;
	private Paint mPaint;
	private long startMillis;
	private int mSecond;
	private boolean gameOver = false;
	private Context mContext;
	private Rect bound;

	public CountdownNum(Context context) {
		
		mContext = context;
		size = MyUtils.spToPixels(context, 260f);
		mPaint = new Paint();
		mPaint.setAntiAlias(true);
		mPaint.setTextAlign(Align.RIGHT);
		mPaint.setTypeface(Typeface.
				createFromAsset(MyApp.getInstance().getAssets(), "fonts/Roboto-Thin.ttf"));
		mPaint.setTextSize(size);
		mPaint.setARGB(20, 0, 0, 0);
		Calendar c = Calendar.getInstance();
		startMillis = c.getTimeInMillis();
		bound = new Rect();
		mPaint.getTextBounds("9", 0, 1, bound);
	}

	public void draw(Canvas canvas) {
		Calendar nowC = Calendar.getInstance();
		if (!gameOver) {
			mSecond = (int) ((nowC.getTimeInMillis() - startMillis) / 1000);
		}
		canvas.drawText(String.valueOf(mSecond), MyUtils.getScreenWidth(),
				Math.abs(bound.top), mPaint);
	}

	public int getNowSecond() {
		Calendar nowC = Calendar.getInstance();
		return (int) ((nowC.getTimeInMillis() - startMillis) / 1000);
	}

	public void gameOver() {
		gameOver = true;
	}
}
