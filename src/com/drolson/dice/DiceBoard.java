package com.drolson.dice;

import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.View.OnClickListener;

public class DiceBoard extends View implements OnClickListener
{

	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Random rand = new Random();
	private int diceCount = 0;
	Rect rect;
	int min;
	
	Bitmap b1;
	Bitmap b2;
	Bitmap b3;
	Bitmap b4;
	Bitmap b5;
	Bitmap b6;
	
	public DiceBoard(Context context, int color) 
	{
		super(context);
		
		if (color == 0)
		{
			b1 = BitmapFactory.decodeResource(getResources(), R.drawable.red1);
			b2 = BitmapFactory.decodeResource(getResources(), R.drawable.red2);
			b3 = BitmapFactory.decodeResource(getResources(), R.drawable.red3);
			b4 = BitmapFactory.decodeResource(getResources(), R.drawable.red4);
			b5 = BitmapFactory.decodeResource(getResources(), R.drawable.red5);
			b6 = BitmapFactory.decodeResource(getResources(), R.drawable.red6);
		}
		else if (color == 1)
		{
			b1 = BitmapFactory.decodeResource(getResources(), R.drawable.white1);
			b2 = BitmapFactory.decodeResource(getResources(), R.drawable.white2);
			b3 = BitmapFactory.decodeResource(getResources(), R.drawable.white3);
			b4 = BitmapFactory.decodeResource(getResources(), R.drawable.white4);
			b5 = BitmapFactory.decodeResource(getResources(), R.drawable.white5);
			b6 = BitmapFactory.decodeResource(getResources(), R.drawable.white6);
		}	
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) 
	{
	    super.onDraw(canvas);
	    
	    int margin;
	    int centerH = (int)(this.getHeight()*.5);	   
	    int centerW = (int)(this.getWidth()*.5);
	    
	    int centerW1 = (int)(this.getWidth()*.33);
	    int centerW2 = (int)(this.getWidth()*.66);
	    
	    int centerH1 = (int)(this.getHeight()*.25);
    	int centerH2 = (int)(this.getHeight()*.75);
    	
    	int centerH13 = (int)(this.getHeight()*.25);
    	int centerH23 = (int)(this.getHeight()*.5);
    	int centerH33 = (int)(this.getHeight()*.75);
	    
	    switch (diceCount)
	    {
	    case 1:
	    	min = Math.min(this.getHeight(), this.getWidth());
		    margin = (int)(min*.3);
		    
	    	rect = new Rect(centerW-margin, centerH-margin, centerW+margin, centerH+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	break;
	    case 2:
	    	 min = Math.min(this.getHeight(), this.getWidth()/2);
	    	 margin = (int)(min*.3);
	    	 rect = new Rect(centerW1-margin, centerH-margin, centerW1+margin, centerH+margin);
	    	 canvas.drawBitmap(getPicture(), null, rect, paint);
	    	 rect = new Rect(centerW2-margin, centerH-margin, centerW2+margin, centerH+margin);
	    	 canvas.drawBitmap(getPicture(), null, rect, paint);
	    	break;
	    case 3:
	    	min = Math.min(this.getHeight()/2,  this.getWidth()/2);
	    	margin = (int)(min*.3);
	    	
	    	rect = new Rect(centerW1-margin, centerH1-margin, centerW1+margin, centerH1+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	rect = new Rect(centerW2-margin, centerH1-margin, centerW2+margin, centerH1+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	rect = new Rect(centerW-margin, centerH2-margin, centerW+margin, centerH2+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	break;
	    case 4:
	    	min = Math.min(this.getHeight()/2,  this.getWidth()/2);
	    	margin = (int)(min*.3);
	    	
	    	rect = new Rect(centerW1-margin, centerH1-margin, centerW1+margin, centerH1+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	rect = new Rect(centerW2-margin, centerH1-margin, centerW2+margin, centerH1+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	
	    	rect = new Rect(centerW1-margin, centerH2-margin, centerW1+margin, centerH2+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	rect = new Rect(centerW2-margin, centerH2-margin, centerW2+margin, centerH2+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	break;
	    case 5:
	    	min = Math.min(this.getHeight()/3, this.getWidth()/2);
	    	margin = (int)(min*.3);
	    	
	    	rect = new Rect(centerW1-margin, centerH13-margin, centerW1+margin, centerH13+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	rect = new Rect(centerW2-margin, centerH13-margin, centerW2+margin, centerH13+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	
	    	rect = new Rect(centerW-margin, centerH23-margin, centerW+margin, centerH23+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	
	    	rect = new Rect(centerW1-margin, centerH33-margin, centerW1+margin, centerH33+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);
	    	rect = new Rect(centerW2-margin, centerH33-margin, centerW2+margin, centerH33+margin);
	    	canvas.drawBitmap(getPicture(), null, rect, paint);

	    	break;
	    default:
	    	break;
	    }
	}

	@Override
	public void onClick(View arg0) 
	{
		this.invalidate();
	}

	public void setDiceCount(int num)
	{
		diceCount = num;
	}
	
	public Bitmap getPicture()
	{
		int i = rand.nextInt(6)+1;
		switch(i)
		{
		case 1:
			return b1;
		case 2:
			return b2;
		case 3:
			return b3;
		case 4:
			return b4;
		case 5:
			return b5;
		case 6:
			return b6;
		default:
			return null;
		}
	}
}
