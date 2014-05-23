package com.example.minworkout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Exercise extends Activity {
	private String exerciseName = "";
	private String nextExerciseName = "";
	private ProgressBar progressBar;
	private int progressStatus = 0;
	private TextView textView;
	private Handler handler = new Handler();
	private TextView textViewExName,textViewNextExName;
	private MediaPlayer mPlayer;
	private int nextVoiceValue;
	public static final String EXERCISE_NUMBER = "com.example";
	private int value;
	private ImageView imageProgress, imageExercise;
	private MyTask myTask = new MyTask();
	public static MyTask BackgroundLoopTask;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise);
		Intent intent = getIntent();
		try{
			String str = intent.getStringExtra(ExerciseComplete.EXERCISE_NUMBER).toString();
			value = Integer.parseInt(str);
		}catch (NullPointerException e) {
			// TODO: handle exception
			value = 1;
		}
		
		progressBar = (ProgressBar)findViewById(R.id.progressBarToday);
		textView = (TextView) findViewById(R.id.textViewToday);
		
		textViewExName = (TextView)findViewById(R.id.textViewExName);
		textViewNextExName = (TextView)findViewById(R.id.textViewNextExName);
		imageProgress = (ImageView)findViewById(R.id.imageProgress);
		imageExercise = (ImageView)findViewById(R.id.imageExercise);
		
		//new MyTask().execute();
		BackgroundLoopTask = new MyTask();
	    BackgroundLoopTask.execute();

		switch(value){
		case 1:
			exerciseName = getResources().getString(R.string.exName01);
			nextExerciseName = getResources().getString(R.string.exName02);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_1));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im1));
			nextVoiceValue = R.raw.ali_nextupwallsits;
			break;
		case 2:
			exerciseName = getResources().getString(R.string.exName02);
			nextExerciseName = getResources().getString(R.string.exName03);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_2));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im2));
			nextVoiceValue = R.raw.ali_nextuppushups;
			break;
		case 3:
			exerciseName = getResources().getString(R.string.exName03);
			nextExerciseName = getResources().getString(R.string.exName04);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_3));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im3));
			nextVoiceValue = R.raw.ali_nextupabdominalcrunches;
			break;
		case 4:
			exerciseName = getResources().getString(R.string.exName04);
			nextExerciseName = getResources().getString(R.string.exName05);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_4));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im4));
			nextVoiceValue = R.raw.ali_nextupstepupsontoachair;
			break;
		case 5:
			exerciseName = getResources().getString(R.string.exName05);
			nextExerciseName = getResources().getString(R.string.exName06);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_5));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im5));
			nextVoiceValue = R.raw.ali_nextupsquats;
			break;
		case 6:
			exerciseName = getResources().getString(R.string.exName06);
			nextExerciseName = getResources().getString(R.string.exName07);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_6));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im6));
			nextVoiceValue = R.raw.ali_nextuptricepdipsonachair;
			break;
		case 7:
			exerciseName = getResources().getString(R.string.exName07);
			nextExerciseName = getResources().getString(R.string.exName08);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_7));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im7));
			nextVoiceValue = R.raw.ali_nextupplanks;
			break;
		case 8:
			exerciseName = getResources().getString(R.string.exName08);
			nextExerciseName = getResources().getString(R.string.exName09);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_8));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im8));
			nextVoiceValue = R.raw.ali_nextuphighkneesrunninginplace;
			break;
		case 9:
			exerciseName = getResources().getString(R.string.exName09);
			nextExerciseName = getResources().getString(R.string.exName010);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_9));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im9));
			nextVoiceValue = R.raw.ali_nextuplunges;
			break;
		case 10:
			exerciseName = getResources().getString(R.string.exName010);
			nextExerciseName = getResources().getString(R.string.exName011);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_10));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im10));
			nextVoiceValue = R.raw.ali_nextuppushupsandrotation;
			break;
		case 11:
			exerciseName = getResources().getString(R.string.exName011);
			nextExerciseName = getResources().getString(R.string.exName012);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_11));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im11));
			nextVoiceValue = R.raw.ali_nextupsideplanks;
			break;
		case 12:
			exerciseName = getResources().getString(R.string.exName012);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_12));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im12));
			nextExerciseName = "Finished";
			break;
			
		}
		textViewExName.setText(exerciseName);
		textViewNextExName.setText(nextExerciseName);
		
		
		
		
		/**
		Dialog dialog = new Dialog(context);
		dialog.setContentView(R.layout.custom_dialog);
		Button buttonReady = (Button)this.findViewById(R.id.start);
		Button buttonNotReady = (Button)this.findViewById(R.id.notReady);
		buttonNotReady.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent intent = new Intent();
				
			}
		});
		*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_exercise, menu);
		return true;
	}
	@Override
	public void onDestroy() {
		BackgroundLoopTask.cancel(true);
	    super.onDestroy();

	}
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		// mPlayer.stop();
		BackgroundLoopTask.cancel(true);
		super.onBackPressed();
	}


	private class MyTask extends AsyncTask<String, String, String>{
		

		@Override
		protected void onPostExecute(String result) {
			mPlayer = MediaPlayer.create(Exercise.this, nextVoiceValue);
			mPlayer.start();
			Intent intent = new Intent(getApplicationContext(),ExerciseComplete.class);
			intent.putExtra(Exercise.EXERCISE_NUMBER, Integer.toString(value));
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			super.onPostExecute(result);
		}

		@Override
		protected String doInBackground(String... params) {
			while (progressStatus < 30) {
				switch(progressStatus){
				case 10:
					mPlayer = MediaPlayer.create(Exercise.this, R.raw.ali_20secondsremaining);
					mPlayer.start();
					break;
				case 15:
					mPlayer = MediaPlayer.create(Exercise.this, R.raw.ali_15secondsremaining);
					mPlayer.start();
					break;
				case 20:
					mPlayer = MediaPlayer.create(Exercise.this, R.raw.ali_10secondsleft);
					mPlayer.start();
					break;
				}
				
		    progressStatus += 1;
		    handler.post(new Runnable() {
		    public void run() {
		       progressBar.setProgress(progressStatus);
		       textView.setText(Integer.toString(progressStatus));
		    }
		        });
		        try {
		           Thread.sleep(AllStringClass.timerGap);
		        } catch (InterruptedException e) {
		           e.printStackTrace();
		        }
		     }
		  
			return null;
		}
		
	}
	

}
