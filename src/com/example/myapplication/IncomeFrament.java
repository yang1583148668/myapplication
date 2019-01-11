package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class IncomeFrament extends Fragment implements View.OnClickListener{
	private Button choiceDateButton;
	private Button choiceTypeButton;
	private Button saveButton;
	private Context mContext;
	private EditText MoneyInput;
	
	
@Override
public View onCreateView(LayoutInflater inflater,
		@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view = inflater.inflate(R.layout.income,container,false);
	choiceDateButton = (Button)view.findViewById(R.id.choice_date);
	choiceTypeButton = (Button)view.findViewById(R.id.choice_type);
	saveButton= (Button)view.findViewById(R.id.save_button);
	MoneyInput =(EditText)view.findViewById(R.id.money_input);
	choiceDateButton.setOnClickListener(this);
	choiceTypeButton.setOnClickListener(this);
	saveButton.setOnClickListener(this);
	return view;
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	
}

}
