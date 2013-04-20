package com.andthen.tool.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class GameSqlHelper extends SQLiteOpenHelper {
	private static final String DB_Name = "andthen";
	public static final String TB_NAME="users";
	public static final String ID="ID";
	public static final String USERNAME="username";
	public static final String PASSWORD="password";
	

	public GameSqlHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	public GameSqlHelper(Context context, String name,
			CursorFactory factory) {
		this(context, name, factory,1);
		// TODO Auto-generated constructor stub
	}
	public GameSqlHelper(Context context) {
		this(context, DB_Name, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		createTables(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		 dropTables(db);
		 onCreate(db); 
		 Log.e("Database","onUpgrade"); 
		
	}
	
	private void createTables(SQLiteDatabase db){
// example:
//		db.execSQL("CREATE TABLE "+
//		TB_NAME+"("+
//		ID+" integer primary key,"+
//		USERNAME+" varchar(20),"+
//		PASSWORD+" varchar(20)"+
//		")");
		db.execSQL("CREATE TABLE "+
		"gun ("+
		"id integer primary key,"+
		"damage integer,"+ 
		"firerate integer,"+
		"accuracy integer,"+
		"total integer, sunandsteel, integer, residue_bullet integer,"+
		"gun_cost integer, bullet_cost integer"+
		"name varchar2(10),"+
		"lock integer,"+
		"fill_time integer)");
		
		db.execSQL("CREATE TABLE armor (name varchar2(10), cost integer, defence integer, lock integer)");

	    Log.e("Database","onCreate");
	}
	
	private void initData(){
		
	}
	
	
	private void dropTables(SQLiteDatabase db){
// example:
		db.execSQL("DROP TABLE IF EXISTS gun"); 
		db.execSQL("DROP TABLE IF EXISTS armor"); 
	}
}
