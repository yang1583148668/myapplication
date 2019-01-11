package com.example.myapplication;

import android.R.integer;
import android.R.transition;
import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SimpleCursorAdapter.ViewBinder;
import android.view.View;
import android.widget.Button;

public class AddRecordItemActivity extends FragmentActivity implements View.OnClickListener{
	
	private Button payoutButton;
	private Button incomeButton;
	private PayingoutFragment payingoutFragment;
	private IncomeFrament incomeFrament;
	private int PAYINGOUTTAB=1;
	private int INCOMETAB=2;
	
	
	
	@Override
	public void onCreate( Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.additem);
		payoutButton = (Button)findViewById(R.id.paying_out);
		incomeButton = (Button)findViewById(R.id.income);
		payoutButton.setOnClickListener(this);
		incomeButton.setOnClickListener(this);
		setSelect(PAYINGOUTTAB);
	}



	@Override
	public void onPointerCaptureChanged(boolean hasCapture) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		if(id==R.id.paying_out){
			setSelect(PAYINGOUTTAB);
		}else if(id==R.id.income){
			setSelect(INCOMETAB);
		}
	}
	
	
	private void setSelect(int tab) {
		FragmentManager fManager = getSupportFragmentManager();
		FragmentTransaction fTransaction= fManager.beginTransaction();
		hideFragment(fTransaction);
		if(tab==PAYINGOUTTAB){
			if(payingoutFragment==null){
				payingoutFragment = new PayingoutFragment();
				fTransaction.add(R.id.content, payingoutFragment);
			}
			fTransaction.show(payingoutFragment);
			
		}else if(tab==INCOMETAB){
			if(incomeFrament==null){
				incomeFrament = new IncomeFrament();
				fTransaction.add(R.id.content, incomeFrament);
			}
			fTransaction.show(incomeFrament);
		}
		fTransaction.commit();
	}
	
	private void hideFragment(FragmentTransaction transaction) {
		if(payingoutFragment!=null){
			transaction.hide(payingoutFragment);
		}
		if(incomeFrament!=null){
			transaction.hide(incomeFrament);
		}
	}
	

	

 }
