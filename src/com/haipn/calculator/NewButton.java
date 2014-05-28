package com.haipn.calculator;

import java.text.DecimalFormat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewButton extends LinearLayout {
	private TextView mTvValue;
	private TextView mTvCount;

	private double mValue;
	private int mCount;

	public NewButton(Context context) {
		super(context);
		View inflate = LayoutInflater.from(context).inflate(R.layout.new_button, null);
		mTvCount = (TextView) inflate.findViewById(R.id.tvCount);
		mTvValue = (TextView) inflate.findViewById(R.id.tvValue);
		this.addView(inflate, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		this.setClickable(true);
//		this.setOnClickListener( new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Log.d("haipn", "onclick listen");
//				
//			}
//		});
	}

	
	public void setValue(double value) {
		mValue = value;
		mTvValue.setText(new DecimalFormat("##.##").format(mValue) + "");
	}
	
	public double getValue() {
		return mValue;
	}
	
	public void setCount(int value) {
		mCount = value;
		mTvCount.setText(mCount + "");
	}
	
	public int getCount() {
		return mCount;
	}
	
}
