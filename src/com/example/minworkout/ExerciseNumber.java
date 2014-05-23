package com.example.minworkout;

public class ExerciseNumber {
	private int _id;
	private int _exerciseNumber;
	public ExerciseNumber(){
		
	}
	public ExerciseNumber(int id,int ex){
		this._id = id;
		this._exerciseNumber = ex;
	}
	
	
	public int getExerciseNumber(){
		return this._exerciseNumber;
	}
}
