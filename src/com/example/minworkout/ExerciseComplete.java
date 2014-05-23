package com.example.minworkout;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ExerciseComplete extends Activity {
	private ProgressBar progressBar;
	private int progressStatus = 0;
	private TextView textView;
	private Handler handler = new Handler();
	private TextView textViewNextExName;
	private String nextExerciseName = "";
	public static final String EXERCISE_NUMBER = "com.example";
	private int value;
	private ImageView imageProgress, imageExercise;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_complete);
		Intent intent = getIntent();
		value = Integer.parseInt(intent.getStringExtra(Exercise.EXERCISE_NUMBER).toString());
		progressBar = (ProgressBar)findViewById(R.id.progressBarToday);
		textView = (TextView) findViewById(R.id.textViewToday);
		textViewNextExName = (TextView)findViewById(R.id.textViewNextExName);
		imageProgress = (ImageView)findViewById(R.id.imageProgress);
		imageExercise = (ImageView)findViewById(R.id.imageExercise);
		
		
		switch(value){
		case 1:
			nextExerciseName = getResources().getString(R.string.exName02);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_2));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im2));
			break;
		case 2:
			nextExerciseName = getResources().getString(R.string.exName03);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_3));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im3));
			break;
		case 3:
			nextExerciseName = getResources().getString(R.string.exName04);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_4));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im4));
			break;
		case 4:
			nextExerciseName = getResources().getString(R.string.exName05);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_5));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im5));
			break;
		case 5:
			nextExerciseName = getResources().getString(R.string.exName06);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_6));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im6));
			break;
		case 6:
			nextExerciseName = getResources().getString(R.string.exName07);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_7));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im7));
			break;
		case 7:
			nextExerciseName = getResources().getString(R.string.exName08);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_8));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im8));
			break;
		case 8:
			nextExerciseName = getResources().getString(R.string.exName09);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_9));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im9));
			break;
		case 9:
			nextExerciseName = getResources().getString(R.string.exName010);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_10));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im10));
			break;
		case 10:
			nextExerciseName = getResources().getString(R.string.exName011);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_11));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im11));
			break;
		case 11:
			nextExerciseName = getResources().getString(R.string.exName012);
			imageProgress.setImageDrawable(getResources().getDrawable(R.drawable.prog_12));
			imageExercise.setImageDrawable(getResources().getDrawable(R.drawable.im12));
			break;
		case 12:
			nextExerciseName = "Finished";
			break;
			
		}
		textViewNextExName.setText(nextExerciseName);
		
		new MyTask().execute();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_exercise_complete, menu);
		return true;
	}
	
	
	private class MyTask extends AsyncTask<String, String, String>{
		

		@Override
		protected void onPostExecute(String result) {
			Intent intent = new Intent(getApplicationContext(),Exercise.class);
			value++;
			intent.putExtra(ExerciseComplete.EXERCISE_NUMBER, Integer.toString(value));
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			
			super.onPostExecute(result);
		}

		@Override
		protected String doInBackground(String... params) {
			while (progressStatus < 10) {
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
