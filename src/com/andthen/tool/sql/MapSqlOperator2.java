package com.andthen.tool.sql;

import java.util.ArrayList;

import com.andthen.map.LevelMap2;

import android.content.ContentValues;
import android.content.Context;

public class MapSqlOperator2 extends SqlOperatorBase{
	
	private static final String TABLE = "map2";

	public MapSqlOperator2(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<LevelMap2> queryMap(){
		ArrayList<LevelMap2> maps = new ArrayList<LevelMap2>();
		cursor = db.query(TABLE, null, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			LevelMap2 map = new LevelMap2();
			map.setLevel(cursor.getInt(cursor.getColumnIndex("level")));
			map.setNum(cursor.getInt(cursor.getColumnIndex("num")));
			map.setIs_lock(cursor.getInt(cursor.getColumnIndex("is_lock")));
			map.setReq_star(cursor.getInt(cursor.getColumnIndex("req_star")));
			map.setGet_star(cursor.getInt(cursor.getColumnIndex("get_star")));
			maps.add(map);
			cursor.moveToNext();
		}
		return maps;
	}
	
	public boolean unlock(int level, int num){
		ContentValues args = new ContentValues();
		args.put("is_lock", 0);
		return db.update(TABLE, args, "level="+level+"num="+num, null) >0;
	}
	
	public boolean setStart(int level, int num, int star){
		ContentValues args = new ContentValues();
		args.put("get_star", star);
		return db.update(TABLE, args, "level="+level+"num="+num, null) >0;
	}

}
