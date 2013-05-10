package com.drolson.dice;

import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;

public class DiceBoard extends View implements OnClickListener
{

	private static final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private Random rand = new Random();
	private int diceCount = 0;
	Rect rect = new Rect();
	static int [][] area = new int[5][4];
	public static ArrayList<Integer> dice = new ArrayList<Integer>();
	static boolean [] diceSelected = new boolean[5];
	int min;
	int random;
	boolean clickedDice = false;
	int clickedDiceNum = -1;
	
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
	    
    	paint.setColor(Color.GREEN);
    	for (int i = 0; i < diceSelected.length; i++)
    	{
    		if (diceSelected[i])
    		{
    			rect.left = area[i][0]-3;
    	   		rect.top = area[i][1]-3;
    	   		rect.right = area[i][2]+3;
    	   		rect.bottom = area[i][3]+3;
    	   		canvas.drawRect(rect, paint);
    		}
    	}
      		for (int i = 0; i < dice.size(); i++)
   		{
   			rect.left = area[i][0];
   			rect.top = area[i][1];
       		rect.right = area[i][2];
       		rect.bottom = area[i][3];
       		canvas.drawBitmap(getPicture(dice.get(i)), null, rect, paint);
   		}
   		clickedDice = false;
   		clear(); //clears all rect values that we saved
  
      	switch (diceCount)
	    {
	    case 1:
	    	min = Math.min(this.getHeight(), this.getWidth());
		    margin = (int)(min*.3);
			    	//rect = new Rect(centerW-margin, centerH-margin, centerW+margin, centerH+margin);
		    area[0][0] = rect.left = centerW-margin;
		    area[0][1] = rect.top = centerH-margin;
		    area[0][2] = rect.right = centerW+margin;
		    area[0][3] = rect.bottom = centerH+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	break;
	    case 2:
	    	 min = Math.min(this.getHeight(), this.getWidth()/2);
	    	 margin = (int)(min*.3);
	    	 //rect = new Rect(centerW1-margin, centerH-margin, centerW1+margin, centerH+margin);
	    	 area[0][0] = rect.left = centerW1-margin;
	    	 area[0][1] = rect.top = centerH-margin;
	    	 area[0][2] = rect.right = centerW1+margin;
	    	 area[0][3] = rect.bottom = centerH+margin;
	    	 canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	 //rect = new Rect(centerW2-margin, centerH-margin, centerW2+margin, centerH+margin);
	    	 area[1][0] = rect.left = centerW2-margin;
	    	 area[1][1] = rect.top = centerH-margin;
	    	 area[1][2] = rect.right = centerW2+margin;
	    	 area[1][3] = rect.bottom = centerH+margin;
	    	 canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	break;
	    case 3:
	    	min = Math.min(this.getHeight()/2,  this.getWidth()/2);
	    	margin = (int)(min*.3);
	    	
	    	//rect = new Rect(centerW1-margin, centerH1-margin, centerW1+margin, centerH1+margin);
	    	area[0][0] = rect.left = centerW1-margin;
	    	area[0][1] = rect.top = centerH1-margin;
	    	area[0][2] = rect.right = centerW1+margin;
	    	area[0][3] = rect.bottom = centerH1+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	//rect = new Rect(centerW2-margin, centerH1-margin, centerW2+margin, centerH1+margin);
	    	area[1][0] = rect.left = centerW2-margin;
	    	area[1][1] = rect.top = centerH1-margin;
	    	area[1][2] = rect.right = centerW2+margin;
	    	area[1][3] = rect.bottom = centerH1+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	//rect = new Rect(centerW-margin, centerH2-margin, centerW+margin, centerH2+margin);
	    	area[2][0] = rect.left = centerW-margin;
	    	area[2][1] = rect.top = centerH2-margin;
	    	area[2][2] = rect.right = centerW+margin;
	    	area[2][3] = rect.bottom = centerH2+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	break;
	    case 4:
	    	min = Math.min(this.getHeight()/2,  this.getWidth()/2);
	    	margin = (int)(min*.3);
	    	
	    	//rect = new Rect(centerW1-margin, centerH1-margin, centerW1+margin, centerH1+margin);
	    	area[0][0] = rect.left = centerW1-margin;
	    	area[0][1] = rect.top = centerH1-margin;
	    	area[0][2] = rect.right = centerW1+margin;
	    	area[0][3] = rect.bottom = centerH1+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	//rect = new Rect(centerW2-margin, centerH1-margin, centerW2+margin, centerH1+margin);
	    	area[1][0] = rect.left = centerW2-margin;
	    	area[1][1] = rect.top = centerH1-margin;
	    	area[1][2] = rect.right = centerW2+margin;
	    	area[1][3] = rect.bottom = centerH1+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	
	    	//rect = new Rect(centerW1-margin, centerH2-margin, centerW1+margin, centerH2+margin);
	    	area[2][0] = rect.left = centerW1-margin;
	    	area[2][1] = rect.top = centerH2-margin;
	    	area[2][2] = rect.right = centerW1+margin;
	    	area[2][3] = rect.bottom = centerH2+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	//rect = new Rect(centerW2-margin, centerH2-margin, centerW2+margin, centerH2+margin);
	    	area[3][0] = rect.left = centerW2-margin;
	    	area[3][1] = rect.top = centerH2-margin;
	    	area[3][2] = rect.right = centerW2+margin;
	    	area[3][3] = rect.bottom = centerH2+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	break;
	    case 5:
	    	min = Math.min(this.getHeight()/3, this.getWidth()/2);
	    	margin = (int)(min*.3);
	    	
	    	//rect = new Rect(centerW1-margin, centerH13-margin, centerW1+margin, centerH13+margin);
	    	area[0][0] = rect.left = centerW1-margin;
	    	area[0][1] = rect.top = centerH13-margin;
	    	area[0][2] = rect.right = centerW1+margin;
	    	area[0][3] = rect.bottom = centerH13+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	//rect = new Rect(centerW2-margin, centerH13-margin, centerW2+margin, centerH13+margin);
	    	area[1][0] = rect.left = centerW2-margin;
	    	area[1][1] = rect.top = centerH13-margin;
	    	area[1][2] = rect.right = centerW2+margin;
	    	area[1][3] = rect.bottom = centerH13+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	
	    	//rect = new Rect(centerW-margin, centerH23-margin, centerW+margin, centerH23+margin);
	    	area[2][0] = rect.left = centerW-margin;
	    	area[2][1] = rect.top = centerH23-margin;
	    	area[2][2] = rect.right = centerW+margin;
	    	area[2][3] = rect.bottom = centerH23+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	
	    	//rect = new Rect(centerW1-margin, centerH33-margin, centerW1+margin, centerH33+margin);
	    	area[3][0] = rect.left = centerW1-margin;
	    	area[3][1] = rect.top = centerH33-margin;
	    	area[3][2] = rect.right = centerW1+margin;
	    	area[3][3] = rect.bottom = centerH33+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
	    	//rect = new Rect(centerW2-margin, centerH33-margin, centerW2+margin, centerH33+margin);
	    	area[4][0] = rect.left = centerW2-margin;
	    	area[4][1] = rect.top = centerH33-margin;
	    	area[4][2] = rect.right = centerW2+margin;
	    	area[4][3] = rect.bottom = centerH33+margin;
	    	canvas.drawBitmap(getPicture(-1), null, rect, paint);
			    	break;
	    default:
	    	break;
	    }
    }
	
	
	@Override
	public void onClick(View arg0) 
	{
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent me)
	{
		float x = me.getX();
		float y = me.getY();
		//System.out.println(me.getX());
		//System.out.println(me.getY());
		if (me.getAction() == MotionEvent.ACTION_UP)
		{
			for (int i = 0; i < area.length; i++)
			{
				if (x >= area[i][0] && x <= area[i][2] && y >= area[i][1] && y <= area[i][3])
				{
					if (diceSelected[i])
						diceSelected[i] = false;
					else
						diceSelected[i] = true;
					clickedDice = true;
					System.out.println("Clicked a dice");
				}
			}
			this.invalidate();
		}
		
		return true;
	}

	public void setDiceCount(int num)
	{
		diceCount = num;
	}
	
	public Bitmap getPicture(int i)
	{
		if (i < 0)
		{
			random = rand.nextInt(6)+1;
			dice.add(random);
		}
		else
			random = i;
			
		switch(random)
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
	
	private static void clear()
	{
		for (int i = 0; i < area.length; i++)
		{
			for (int j = 0; j < area[0].length; j++)
				area[i][j] = -1;
		}
		dice.clear();
	}
}
