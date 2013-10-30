package com.example.myfirstproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
	int myInt = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final int myOtherInt = 300;
		
		LinearLayout root = new LinearLayout(this);
		root.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		root.setOrientation(LinearLayout.VERTICAL);
		
		TextView tv = new TextView(this);
		tv.setText("Hello");
		
		WindowManager w = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		
		//IBinder wmbinder = ServiceManager.getService(  );
		
		
		root.addView(tv);
		
		
		setContentView(root);
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		
		
		
		builder.setTitle("Do you want to do this?")
		.setMessage("Her is the msg")
		.setPositiveButton("", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				
			}
		});
		
		
		
		/*
		
		
		
		
		
		
		Log.d("demo", "onCreate()");

		Button btn = (Button) findViewById(R.id.myOkButton);

		btn.setOnClickListener(this);

		btn = (Button) findViewById(R.id.buttonCancel);
		btn.setOnClickListener(this);
		
		findViewById(R.id.buttonOther).setOnClickListener(this);
		
		SeekBar sb = (SeekBar) findViewById(R.id.seekBar1);
		sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				Log.d("demo", progress + "");				
			}
		});
*/
		
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("demo", "onResume()");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("demo", "onStart()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void myOnClick(View v) {
		
		Log.d("demo", "clicked !! myOnClick");
		
	}
	
	@Override
	public void onClick(View v) {
		
		
		switch (v.getId()) {
		case R.id.myOkButton:
			Log.d("demo", "OK");
			break;
		case R.id.buttonCancel:
			Log.d("demo", "Cancel");
			break;
		case R.id.buttonOther:
			Log.d("demo", "Other");
			LinearLayout root = ((LinearLayout)findViewById(R.id.linearLayout02));
			Button btn = new Button(this);
			btn.setText("New Button");
			btn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Log.d("demo", "New Button Clicked !!!");
				}
			});
			root.addView(btn);
			
			Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show();
			
			
			

			break;
			
		default:
			break;
		}
	}

}
