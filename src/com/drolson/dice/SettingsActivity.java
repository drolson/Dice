package com.drolson.dice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class SettingsActivity extends Activity {

//	SettingsActivity a = this;
	Intent rc = new Intent();
	public SeekBar sbRed;
	public SeekBar sbWhite;
	private int maxValue = 5;
	int defaultRed = 0;
	int defaultWhite = 0;
	TextView whiteDefault;
	TextView redDefault;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
       
        Bundle state = this.getIntent().getExtras();
        
        defaultRed = state.getInt("red");
        defaultWhite = state.getInt("white");
        rc.putExtra("red", defaultRed);
        rc.putExtra("white", defaultWhite);
        
        sbRed = (SeekBar)this.findViewById(R.id.red_seek_bar);
        sbRed.setMax(maxValue);
        sbRed.setProgress(defaultRed);
        redDefault = (TextView)this.findViewById(R.id.red_number_text);
        redDefault.setText(""+defaultRed);
        sbRed.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				redDefault.setText(""+arg1);	
			}
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				rc.putExtra("red", arg0.getProgress());
			}});
        

        sbWhite = (SeekBar)this.findViewById(R.id.white_seek_bar);
        sbWhite.setProgress(defaultWhite);
        sbWhite.setMax(maxValue);
        whiteDefault = (TextView)this.findViewById(R.id.white_number_text);
        whiteDefault.setText(""+defaultWhite);
        sbWhite.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			@Override
			public void onProgressChanged(SeekBar arg0, int arg1, boolean arg2) {
				whiteDefault.setText(""+arg1);	
			}
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {}
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {
				rc.putExtra("white", arg0.getProgress());
			}});
        
        this.setResult(0, rc);
    }
}
