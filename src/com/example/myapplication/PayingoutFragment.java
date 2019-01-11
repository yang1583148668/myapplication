package com.example.myapplication;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import android.R.anim;
import android.R.integer;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;





public class PayingoutFragment extends Fragment implements View.OnClickListener {
	
	private Button choiceDateButton;
//	private Button choiceTypeButton;
	private Button saveButton;
	private Context mContext;
	private EditText MoneyInput;
	private Spinner choiceTypeSpinner;
	private MyAdater _Adapter;
	private int mStartYear,mStartMon,mStartDay;
	private String[] mitemStrings;
	private int mCurrentChoiceType =0;
	private List<String> mList = new ArrayList<String>();
	
	public void PayingoutFragment(Context context) {
		
		mContext = context;
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container, Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.payingout,container,false);
		choiceDateButton = (Button)view.findViewById(R.id.choice_date);
//		choiceTypeButton = (Button)view.findViewById(R.id.choice_type);
		mitemStrings = getResources().getStringArray(R.array.paying_type);
		mList =Arrays.asList(mitemStrings);
		
		_Adapter= new MyAdater(getActivity(),mList);
		choiceTypeSpinner = (Spinner)view.findViewById(R.id.choice_type);
		choiceTypeSpinner.setAdapter(_Adapter);
		choiceTypeSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				mCurrentChoiceType = position;
				Log.i("yangbo2","mCu"+mCurrentChoiceType);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		saveButton= (Button)view.findViewById(R.id.save_button);
		MoneyInput =(EditText)view.findViewById(R.id.money_input);
		getCurrentDay();
		choiceDateButton.setText(getCurrentDaytoString());
		choiceDateButton.setOnClickListener(this);
		saveButton.setOnClickListener(this);
		return view;
		//return super.onCreateView(inflater, container, savedInstanceState);
	}

	private int getCurrentChoiceType() {
		return mCurrentChoiceType;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id==R.id.choice_date){
			showDialog();
		}else if(id==R.id.choice_type){
			
		}else if(id==R.id.save_button){
			
		}
	}
	
	
	private void showDialog(){
		
		Dialog dialog= new DatePickerDialog(getActivity(), mdateListener, mStartYear, mStartMon, mStartDay);
		dialog.show();
	}
	
	private DatePickerDialog.OnDateSetListener mdateListener = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
        	mStartDay=dayOfMonth;
        	mStartMon=monthOfYear;
        	mStartYear=year;
        	choiceDateButton.setText(getCurrentDaytoString());
        }
    };
    
    public PayingoutFragment() {
		// TODO Auto-generated constructor stub
	}
    private String getCurrentDaytoString() {
    	return String.valueOf(mStartYear)+" - "+String.valueOf(mStartMon+1)+" - "+String.valueOf(mStartDay);
	}
    private void getCurrentDay() {
    	final Calendar ca = Calendar.getInstance();
    	mStartYear= ca.get(Calendar.YEAR);
    	mStartMon = ca.get(Calendar.MONTH);
   	 	mStartDay = ca.get(Calendar.DAY_OF_MONTH);
	}
    
    
    
}
