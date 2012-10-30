package com.CMPUT301F12T07.crowdsource;

import java.sql.Date;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class AddTask extends Activity {

	private Button calendar;
	private int year;
	private int month;
	private int day;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        
        initializeDates();
        initializeListeners();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_add_task, menu);
        return true;
    }
    
    private void initializeDates() {
    	final Calendar cal = Calendar.getInstance();
    	
    	year = cal.get(Calendar.YEAR);
    	month = cal.get(Calendar.MONTH);
    	day = cal.get(Calendar.DAY_OF_MONTH);
    }
    
    private void initializeListeners() {
    	calendar = (Button) findViewById(R.id.calendar);
    	
    	calendar.setOnClickListener(new OnClickListener() {
    		
			@Override
			public void onClick(View v) {
				DatePickerDialog c = new DatePickerDialog(v.getContext(), mDateSetListener, year, month,  day);
				c.show();
			}
    		
    	});
    }
    
    
    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
	    public void onDateSet(DatePicker v, int inyear, int inmonth, int inday) {
	    	year = inyear;
	        month = inmonth;
	        day = inday;
	        
	        Toast.makeText(v.getContext(), "Date set to: " + (month+1) + "/" + day + "/" + year, Toast.LENGTH_SHORT).show();
	    }
    };
    

}