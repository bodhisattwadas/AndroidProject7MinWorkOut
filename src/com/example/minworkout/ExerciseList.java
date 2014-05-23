package com.example.minworkout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TableRow;

public class ExerciseList extends Activity {
	private TableRow[] tableRow = new TableRow[12];
	public final static String NUMBER_OF_ROW = "number";
	private ImageButton buttonLearn,buttonHome,buttonSettings,buttonLogs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_list);
		buttonHome = (ImageButton)findViewById(R.id.imageButton1);
		buttonLearn = (ImageButton)findViewById(R.id.imageButton2);
		buttonLogs = (ImageButton)findViewById(R.id.imageButton3);
		buttonSettings = (ImageButton)findViewById(R.id.imageButton4);
		getIntent();
		initTableRow();
		initTableRowOnClick();
		
		buttonSettings.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),Settings.class);
				startActivity(intent);
				
			}
		});
		buttonHome.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_exercise_list, menu);
		return true;
	}
	private void initTableRow(){
		tableRow[0] = (TableRow)findViewById(R.id.tableRow1);
		tableRow[1] = (TableRow)findViewById(R.id.tableRow2);
		tableRow[2] = (TableRow)findViewById(R.id.tableRow3);
		tableRow[3] = (TableRow)findViewById(R.id.tableRow4);
		tableRow[4] = (TableRow)findViewById(R.id.tableRow5);
		tableRow[5] = (TableRow)findViewById(R.id.tableRow6);
		tableRow[6] = (TableRow)findViewById(R.id.tableRow7);
		tableRow[7] = (TableRow)findViewById(R.id.tableRow8);
		tableRow[8] = (TableRow)findViewById(R.id.tableRow9);
		tableRow[9] = (TableRow)findViewById(R.id.tableRow10);
		tableRow[10] = (TableRow)findViewById(R.id.tableRow11);
		tableRow[11] = (TableRow)findViewById(R.id.tableRow12);
	}
	private void initTableRowOnClick(){
		tableRow[0].setOnClickListener(new MyTableRowOnclickListener(1));
		tableRow[1].setOnClickListener(new MyTableRowOnclickListener(2));
		tableRow[2].setOnClickListener(new MyTableRowOnclickListener(3));
		tableRow[3].setOnClickListener(new MyTableRowOnclickListener(4));
		tableRow[4].setOnClickListener(new MyTableRowOnclickListener(5));
		tableRow[5].setOnClickListener(new MyTableRowOnclickListener(6));
		tableRow[6].setOnClickListener(new MyTableRowOnclickListener(7));
		tableRow[7].setOnClickListener(new MyTableRowOnclickListener(8));
		tableRow[8].setOnClickListener(new MyTableRowOnclickListener(9));
		tableRow[9].setOnClickListener(new MyTableRowOnclickListener(10));
		tableRow[10].setOnClickListener(new MyTableRowOnclickListener(11));
		tableRow[11].setOnClickListener(new MyTableRowOnclickListener(12));
	}
	private class MyTableRowOnclickListener implements OnClickListener {
		private int i;
		public MyTableRowOnclickListener(int i) {
			this.i = i;
		}

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(getApplicationContext(),ExDescription.class);
			intent.putExtra(NUMBER_OF_ROW, Integer.toString(i));
			startActivity(intent);
			
		}
		
	}

}
