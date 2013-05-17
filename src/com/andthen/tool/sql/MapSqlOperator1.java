package com.andthen.tool.sql;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;

import com.andthen.map.LevelMap1;

public class MapSqlOperator1 extends SqlOperatorBase{
	private static final String TABLE = "map1";

	public MapSqlOperator1(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<LevelMap1> queryMap(){
		ArrayList<LevelMap1> maps = new ArrayList<LevelMap1>();
		cursor = db.query(TABLE, null, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			LevelMap1 map = new LevelMap1();
			map.setLevel(cursor.getInt(cursor.getColumnIndex("level")));
			map.setIs_lock(cursor.getInt(cursor.getColumnIndex("is_lock")));
			map.setReq_star(cursor.getInt(cursor.getColumnIndex("req_star")));
			map.setX(cursor.getInt(cursor.getColumnIndex("x")));
			map.setY(cursor.getInt(cursor.getColumnIndex("y")));
			map.setXl(cursor.getInt(cursor.getColumnIndex("xl")));
			map.setYl(cursor.getInt(cursor.getColumnIndex("yl")));
			map.setW(cursor.getInt(cursor.getColumnIndex("w")));
			map.setH(cursor.getInt(cursor.getColumnIndex("h")));
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
