package com.drolson.dice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.NumberPicker;

public class SettingsActivity extends Activity {

//	SettingsActivity a = this;
	Intent rc = new Intent();
	public NumberPicker npRed;
	public NumberPicker npWhite;
	private int maxValue = 5;
	private int minValue = 0;
	int defaultRed = 0;
	int defaultWhite = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        
        Bundle state = this.getIntent().getExtras();
        defaultRed = state.getInt("red");
        defaultWhite = state.getInt("white");
        
        npRed = (NumberPicker)this.findViewById(R.id.red_number_picker);
        npRed.setMaxValue(maxValue);
        npRed.setMinValue(minValue);
        npRed.setValue(defaultRed);
        
        
        npWhite = (NumberPicker)this.findViewById(R.id.white_number_picker);
        npWhite.setMaxValue(maxValue);
        npWhite.setMinValue(minValue);
        npWhite.setValue(defaultWhite);
        
    }

    
}
