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
	private int color;
	
	Bitmap r1;
	Bitmap r2;
	Bitmap r3;
	Bitmap r4;
	Bitmap r5;
	Bitmap r6;
	
	Bitmap w1;
	Bitmap w2;
	Bitmap w3;
	Bitmap w4;
	Bitmap w5;
	Bitmap w6;
	
	public DiceBoard(Context context, int color) 
	{
		super(context);
		
		this.color = color;
		
		if (color == 0)
		{
			r1 = BitmapFactory.decodeResource(getResources(), R.drawable.red1);
			r2 = BitmapFactory.decodeResource(getResources(), R.drawable.red2);
			r3 = BitmapFactory.decodeResource(getResources(), R.drawable.red3);
			r4 = BitmapFactory.decodeResource(getResources(), R.drawable.red4);
			r5 = BitmapFactory.decodeResource(getResources(), R.drawable.red5);
			r6 = BitmapFactory.decodeResource(getResources(), R.drawable.red6);
		}
		else if (color == 1)
		{
			w1 = BitmapFactory.decodeResource(getResources(), R.drawable.white1);
			w2 = BitmapFactory.decodeResource(getResources(), R.drawable.white2);
			w3 = BitmapFactory.decodeResource(getResources(), R.drawable.white3);
			w4 = BitmapFactory.decodeResource(getResources(), R.drawable.white4);
			w5 = BitmapFactory.decodeResource(getResources(), R.drawable.white5);
			w6 = BitmapFactory.decodeResource(getResources(), R.drawable.white6);
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) 
	{
	    super.onDraw(canvas);
	    int temp;
	    int count = -1;
	    if (color == 0)
		    for (int i = 0; i < diceCount; i++)
		    {
		    	temp = rand.nextInt(6) + 1;
		    	switch (temp)
		    	{
		    	case 1:
		    		canvas.drawBitmap(r1, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 2:
		    		canvas.drawBitmap(r2, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 3:
		    		canvas.drawBitmap(r3, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 4:
		    		canvas.drawBitmap(r4, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 5:
		    		canvas.drawBitmap(r5, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 6:
		    		canvas.drawBitmap(r6, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	}
		    	count++;
		    }
	    else if (color == 1)
		    for (int i = 0; i < diceCount; i++)
		    {
		    	temp = rand.nextInt(6) + 1;
		    	
		    	switch (temp)
		    	{
		    	case 1:
		    		//canvas.drawBitmap(w1, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		canvas.drawBitmap(w1, null, new Rect(0, 200, 200, 400), paint);
		    		break;
		    	case 2:
		    		canvas.drawBitmap(w2, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 3:
		    		canvas.drawBitmap(w3, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 4:
		    		canvas.drawBitmap(w4, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 5:
		    		canvas.drawBitmap(w5, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	case 6:
		    		canvas.drawBitmap(w6, 200+200*((count+1)%2), 200*((count+1)/2), paint);
		    		break;
		    	}
		    	count++;
		    }
	}

	@Override
	public void onClick(View arg0) 
	{
		System.out.println("we got to here to invalidate and generate new numbers");
		this.invalidate();
	}

	public void setDiceCount(int num)
	{
		diceCount = num;
	}
}
