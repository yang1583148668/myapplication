package com.example.myapplication;

import android.R.anim;
import android.R.integer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;

import java.util.Calendar;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.view.View.OnClickListener;
import android.view.View;
public class MainActivity extends Activity implements View.OnClickListener {
	
	private int mStartYear,mStartMon,mStartDay,mEndYear,mEndMon,mEndDay;
	
	final int DATE_CHOICE_DIALOG_START =1;
	final int DATE_CHOICE_DIALOG_END =2;
	private int mCurrentChoice;
	private Button StartButton;
	private Button EndButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartButton= (Button)findViewById(R.id.date_choice_start);
        EndButton= (Button)findViewById(R.id.date_choice_end);
        getDefaultStartAndEnd();
        StartButton.setText(getStartDay());
        EndButton.setText(getEndDay());
        StartButton.setOnClickListener(this);
        EndButton.setOnClickListener(this);
        
    }
    
    private void getDefaultStartAndEnd() {
    	 final Calendar ca = Calendar.getInstance();
    	 mEndYear = ca.get(Calendar.YEAR);
    	 mEndMon = ca.get(Calendar.MONTH);
    	 mEndDay = ca.get(Calendar.DAY_OF_MONTH);
    	 mStartYear= ca.get(Calendar.YEAR);
    	 mStartMon = ca.get(Calendar.MONTH);
    	 mStartDay = 1;
    	 Log.i("yangbo2","mStartYear"+mStartYear+"mStartMon"+mStartMon+"mStartDay"+mStartDay);
	}
    private String getStartDay() {
    	return String.valueOf(mStartYear)+" - "+String.valueOf(mStartMon+1)+" - "+String.valueOf(mStartDay);
	}
    private String getEndDay() {
    	return String.valueOf(mEndYear)+" - "+String.valueOf(mEndMon+1)+" - "+String.valueOf(mEndDay);
   	}

	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		int id = v.getId();
		switch (id) {
		case R.id.date_choice_start:
			mCurrentChoice= DATE_CHOICE_DIALOG_START;
			showDialog(DATE_CHOICE_DIALOG_START);
			break;
		case R.id.date_choice_end:
			mCurrentChoice=DATE_CHOICE_DIALOG_END;
			showDialog(DATE_CHOICE_DIALOG_END);
			break;
		default:
			break;
		}
	}
	
	private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
        if(mCurrentChoice==2){	
        	mEndYear = year;
       	 	mEndMon = monthOfYear;
       	 	mEndDay = dayOfMonth;
       	 	EndButton.setText(getEndDay());
       	 }else if(mCurrentChoice==1){
       		mStartYear = year;
       	 	mStartMon = monthOfYear;
       	 	mStartDay = dayOfMonth;
       	 	StartButton.setText(getStartDay());
       	 }
       	 
            
        }
    };
	@Override
	@Deprecated
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case DATE_CHOICE_DIALOG_START :
			return new DatePickerDialog(this, mdateListener, mStartYear, mStartMon, mStartDay);
			
		case DATE_CHOICE_DIALOG_END :
			return new DatePickerDialog(this, mdateListener, mEndYear, mEndMon, mEndDay);
			
		default:
			break;
		}
		return null;
	}
    
    
}
