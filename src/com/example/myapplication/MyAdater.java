package com.example.myapplication;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdater extends BaseAdapter {
	
	private Context mContext;
	private List<String> mList ;
	
	public MyAdater(Context context, List<String> list) {
		// TODO Auto-generated constructor stub
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=LayoutInflater.from(mContext);
		convertView=inflater.inflate(R.layout.spinner_item, null);
		TextView _TextView1 =(TextView) convertView.findViewById(R.id.textview1);
		if(convertView!=null){
			_TextView1.setText(mList.get(position));
		}
		return convertView;
	}

}
