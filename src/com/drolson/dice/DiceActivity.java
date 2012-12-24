package com.drolson.dice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class DiceActivity extends Activity {

	int redDice = 2;
	int whiteDice = 0;
	
	DiceBoard redBoard;
	DiceBoard whiteBoard;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);
        
        redBoard = new DiceBoard(this, 0);
        redBoard.setDiceCount(redDice);
        LinearLayout redB = (LinearLayout)this.findViewById(R.id.red_board);
        redB.addView(redBoard);
        redBoard.setOnClickListener(redBoard);
        
        whiteBoard = new DiceBoard(this, 1);
        whiteBoard.setDiceCount(whiteDice);
        LinearLayout whiteB = (LinearLayout)this.findViewById(R.id.white_board);
        whiteB.addView(whiteBoard);
        whiteBoard.setOnClickListener(whiteBoard);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	super.onOptionsItemSelected(item);
    	switch (item.getItemId()) 
    	{
	        case R.id.settings:
	        	Intent intent = new Intent(this, SettingsActivity.class);
	        	intent.putExtra("red", redDice);
	        	intent.putExtra("white", whiteDice);
	        	startActivityForResult(intent, 0);

	        	return true;
	        default:
	        	return super.onOptionsItemSelected(item);
    	}
    }
    
    @Override
    public void onActivityResult(int request, int result, Intent i)
    {
    	if (result == request) //then we can continue on
    	{
    		redDice = i.getExtras().getInt("red");
    		redBoard.setDiceCount(redDice);
    		redBoard.invalidate();
    		
    		whiteDice = i.getExtras().getInt("white");
    		whiteBoard.setDiceCount(whiteDice);
    		whiteBoard.invalidate();
    	}
    }
    
}
