package com.haipn.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalculatorActivity extends Activity {
	private Button mBtnAdd;
	private LinearLayout mLlReceived;
	private EditText mEdtAmount;
	private TextView mTvGiveChange;
	
	class Watcher implements TextWatcher {

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void afterTextChanged(Editable s) {
			
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);

		mBtnAdd = (Button) findViewById(R.id.btnAdd);
		mLlReceived = (LinearLayout) findViewById(R.id.llReceived);
		mEdtAmount = (EditText) findViewById(R.id.edtAmount);
		mEdtAmount.setInputType(InputType.TYPE_CLASS_NUMBER
				| InputType.TYPE_NUMBER_FLAG_SIGNED
				| InputType.TYPE_NUMBER_FLAG_DECIMAL);
		mTvGiveChange = (TextView) findViewById(R.id.tvGiveChange);
		mBtnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EditText newAmount = new EditText(CalculatorActivity.this);
				newAmount.setInputType(InputType.TYPE_CLASS_NUMBER
						| InputType.TYPE_NUMBER_FLAG_SIGNED
						| InputType.TYPE_NUMBER_FLAG_DECIMAL);
				mLlReceived.addView(newAmount);
				newAmount.requestFocus();
				newAmount.addTextChangedListener(new )
			}
		});
	}
}
