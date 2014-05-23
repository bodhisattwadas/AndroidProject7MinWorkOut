package com.example.minworkout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "exerciseDB";
    private static final String TABLE_CONTACTS = "statusTable";
    private static final String KEY_ID = "id";
    private static final String KEY_EXERCISE_NAME = "ex";
    
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

	public DatabaseHandler(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String CREATE_TABLE = "CREATE TABLE "+TABLE_CONTACTS+"( "+KEY_ID+" INTEGER PRIMARY KEY, "+
													   KEY_EXERCISE_NAME+" INTEGER)";
		db.execSQL(CREATE_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
 
        // Create tables again
        onCreate(db);
		
	}
	
	

}
