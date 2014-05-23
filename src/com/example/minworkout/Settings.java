package com.example.minworkout;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Settings extends Activity {
	private ImageButton buttonLearn,buttonHome,buttonSettings,buttonLogs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		getIntent();
		buttonHome = (ImageButton)findViewById(R.id.imageButton1);
		buttonLearn = (ImageButton)findViewById(R.id.imageButton2);
		buttonLogs = (ImageButton)findViewById(R.id.imageButton3);
		buttonSettings = (ImageButton)findViewById(R.id.imageButton4);
		
		buttonHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				
			}
		});
		buttonLearn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ExerciseList.class);
				startActivity(intent);
				
			}
		});
		buttonLogs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),Logs.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_settings, menu);
		return true;
	}

}
