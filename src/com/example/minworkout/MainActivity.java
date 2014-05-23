package com.example.minworkout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

@SuppressLint("SetJavaScriptEnabled")
@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
public class MainActivity extends Activity {
	//private WebView webView ;
	private ImageButton buttonLearn,buttonSettings,buttonLogs;
	private Button buttonStart;
	private Context context;
	private ImageView imageView;
	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getIntent();
		context = this;
		buttonLearn = (ImageButton)findViewById(R.id.imageButton2);
		buttonLogs = (ImageButton)findViewById(R.id.imageButton3);
		buttonSettings = (ImageButton)findViewById(R.id.imageButton4);
		imageView = (ImageView)findViewById(R.id.imageView6);
		
		buttonStart = (Button)findViewById(R.id.buttonRound);
		
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				startActivity(new Intent(getApplicationContext(),VoiceOver.class));
				
			}
		});
		buttonLogs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),Logs.class);
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
		buttonSettings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),Settings.class);
				startActivity(intent);
				
			}
		});
		buttonStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				final Dialog dialog = new Dialog(context);
				dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
				dialog.setContentView(R.layout.custom_dialog);
				final Button buttonReady = (Button)dialog.findViewById(R.id.start);
				final Button buttonNotReady = (Button)dialog.findViewById(R.id.notReady);
				buttonReady.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(getApplicationContext(),Exercise.class);
						startActivity(intent);
						dialog.dismiss();
						
					}
				});
				buttonNotReady.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});
				dialog.show();
			}
		});
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	

}
