package com.haipn.calculator;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CalculatorActivity extends FragmentActivity implements
		MyAlertDialogFragment.OnInputAmountListener {
	private Button mBtnAdd;
	private LinearLayout mLlReceived;
	private EditText mEdtAmount;
	private TextView mTvGiveChange;
	private double mValue;

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
			try {
				mValue = Double.valueOf(mEdtAmount.getText().toString());
				mTvGiveChange.setText(new DecimalFormat("##.##").format(mValue)
						+ "");
				if (mValue < 0) {
					mTvGiveChange.setTextColor(getResources().getColor(
							R.color.red));
				} else {
					mTvGiveChange.setTextColor(getResources().getColor(
							android.R.color.black));
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		mTvGiveChange.setText("");
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.showSoftInput(mEdtAmount, InputMethodManager.SHOW_IMPLICIT);
		mEdtAmount.addTextChangedListener(new Watcher());
		mBtnAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				DialogFragment dlgFrag = new MyAlertDialogFragment();
				dlgFrag.show(getSupportFragmentManager(), "dialog");
				// newAmount.requestFocus();
				// InputMethodManager imm = (InputMethodManager)
				// getSystemService(Context.INPUT_METHOD_SERVICE);
				// imm.showSoftInput(newAmount,
				// InputMethodManager.SHOW_IMPLICIT);
				// newAmount.addTextChangedListener(new Watcher());
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action buttons
		switch (item.getItemId()) {
		case R.id.del_all:
			// create intent to perform web search for this planet
			mLlReceived.removeAllViews();
			mTvGiveChange.setText("");
			mEdtAmount.setText("");
			mValue = 0;
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onInputAmount(double input) {
		Button newButton = new Button(this);
		newButton.setText(input + "");
		newButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Double value = Double
						.valueOf(((Button) v).getText().toString());
				mValue -= value;
				mTvGiveChange.setText(new DecimalFormat("##.##").format(mValue)
						+ "");
				if (mValue < 0) {
					mTvGiveChange.setTextColor(getResources().getColor(
							R.color.red));
				} else {
					mTvGiveChange.setTextColor(getResources().getColor(
							android.R.color.black));
				}
			}
		});
		mLlReceived.addView(newButton);
		refreshAmount(input);
	}

	private void refreshAmount(double value) {
		mValue -= value;
		mTvGiveChange.setText(new DecimalFormat("##.##").format(mValue) + "");
		if (mValue < 0) {
			mTvGiveChange.setTextColor(getResources().getColor(R.color.red));
		} else {
			mTvGiveChange.setTextColor(getResources().getColor(
					android.R.color.black));
		}
	}
}
