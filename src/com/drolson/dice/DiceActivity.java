package com.drolson.dice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DiceActivity extends Activity {

	int redDice = 2;
	int whiteDice = 2;
	static final int maxValue = 5;
	
	DiceBoard redBoard;
	DiceBoard whiteBoard;
	
	public SeekBar sbRed;
	public SeekBar sbWhite;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
        
        sbRed = (SeekBar)this.findViewById(R.id.red_seek_bar);
        sbRed.setMax(maxValue);
        sbRed.setProgress(redDice);
        sbRed.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				//redDefault.setText(""+arg1);	
			}
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				redDice = arg0.getProgress();
				if (redDice == 0)
				{
					redDice = 1;
					sbRed.setProgress(redDice);
				}
				redBoard.setDiceCount(redDice);
				redBoard.invalidate();
			}});
        
        sbWhite = (SeekBar)this.findViewById(R.id.white_seek_bar);
        sbWhite.setProgress(whiteDice);
        sbWhite.setMax(maxValue);
        sbWhite.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				//whiteDefault.setText(""+arg1);	
			}
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				whiteDice = arg0.getProgress();
				whiteBoard.setDiceCount(whiteDice);
				whiteBoard.invalidate();
			}});
    }

    /*@Override
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
    }*/
    
}
