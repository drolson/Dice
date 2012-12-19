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
		
		System.out.println("height   " + this.getHeight());
	}
	
	@Override
	protected void onDraw(Canvas canvas) 
	{
	    super.onDraw(canvas);
	    int temp;
	    //int count = -1;
	    
	    int width = this.getWidth() - 150; /* 150 for the margins */
	    width = width/2; /* divide by two case we will have 2 per row*/
	    
	    int height = this.getHeight() - (50 + 50*((diceCount)/2)); /* 200 cause we have a possibility of having 3 rows for margins */
	    height = height / 3; /* divide by 3 in case we have 3 rown */
	    
	    int size = Math.min(height, width);
	    
		for (int i = 0; i < diceCount; i++)
		{
		   	temp = rand.nextInt(6) + 1;
		   	rect = new Rect(50+size*((i)%2), 50+size*((i)/2), 50+size+size*((i)%2), 50+size+size*((i)/2));
		   	switch (temp)
		   	{
		   	case 1:
		   		//canvas.drawBitmap(b1, 50+size*((count+1)%2), size*((count+1)/2), paint);
		   		canvas.drawBitmap(b1, null, rect, paint);
		   		break;
		   	case 2:
		   		canvas.drawBitmap(b2, null, rect, paint);
		   		break;
		   	case 3:
		   		canvas.drawBitmap(b3, null, rect, paint);
		   		break;
		   	case 4:
		   		canvas.drawBitmap(b4, null, rect, paint);
		   		break;
		   	case 5:
		   		canvas.drawBitmap(b5, null, rect, paint);
		   		break;
		   	case 6:
		   		canvas.drawBitmap(b6, null, rect, paint);
		   		break;
		 	}
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
