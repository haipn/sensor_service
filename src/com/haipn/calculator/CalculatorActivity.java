package com.haipn.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class CalculatorActivity extends Activity {
	private Button mBtnAdd;
	private LinearLayout mLlReceived;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);
		
		mBtnAdd = (Button) findViewById(R.id.btnAdd);
		mLlReceived = (LinearLayout) findViewById(R.id.llReceived);
		mBtnAdd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				EditText newAmount = new EditText(CalculatorActivity.this);
				mLlReceived.addView(newAmount);
			}
		});
	}
}
