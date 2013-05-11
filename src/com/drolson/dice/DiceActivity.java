package com.drolson.dice;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class DiceActivity extends Activity {

	private int redDice = 2;
	private int whiteDice = 2;
	public static final int maxValue = 5;
	
	private DiceBoard redBoard;
	private DiceBoard whiteBoard;
	
	private SeekBar sbRed;
	private SeekBar sbWhite;
	
	private TextView whiteDefault;
	private TextView redDefault;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //initialize the redboard
        redBoard = new DiceBoard(this, 0);
        redBoard.setDiceCount(redDice);
        LinearLayout redB = (LinearLayout)this.findViewById(R.id.red_board);
        redB.addView(redBoard);
        redBoard.setOnClickListener(redBoard);
        
        //initialize the white board
        whiteBoard = new DiceBoard(this, 1);
        whiteBoard.setDiceCount(whiteDice);
        LinearLayout whiteB = (LinearLayout)this.findViewById(R.id.white_board);
        whiteB.addView(whiteBoard);
        whiteBoard.setOnClickListener(whiteBoard);
        
        //initialize the red dice seekbar
        sbRed = (SeekBar)this.findViewById(R.id.red_seek_bar);
        sbRed.setMax(maxValue);
        sbRed.setProgress(redDice);
        sbRed.setThumbOffset(0);
        sbRed.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				redDefault.setText(""+arg1);	
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
        
        //initialize the white dice seekbar
        sbWhite = (SeekBar)this.findViewById(R.id.white_seek_bar);
        sbWhite.setProgress(whiteDice);
        sbWhite.setMax(maxValue);
        sbWhite.setThumbOffset(0);
        sbWhite.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				whiteDefault.setText(""+arg1);	
			}
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				whiteDice = arg0.getProgress();
				whiteBoard.setDiceCount(whiteDice);
				whiteBoard.invalidate();
			}});
        
        
        //Default text that will be displayed on startup for the dice numbers on each red/white dice
        redDefault = (TextView)this.findViewById(R.id.red_number_text);
        redDefault.setText(""+redDice);
        
        whiteDefault = (TextView)this.findViewById(R.id.white_number_text);
        whiteDefault.setText(""+whiteDice);
    }  
}
