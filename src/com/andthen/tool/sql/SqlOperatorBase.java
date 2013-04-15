package com.andthen.tool.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class SqlOperatorBase {
	
	GameSqlHelper sqlHelper;
	SQLiteDatabase db;
	ContentValues cv;
	Cursor cursor;
	
	public SqlOperatorBase(Context context){
		sqlHelper = new GameSqlHelper(context);	
	}
	
	public void closeUserHelper(){
		if(sqlHelper!=null) sqlHelper.close();
		if(db!=null)db.close();
		if(cursor!=null)cursor.close();
	}
	
}
