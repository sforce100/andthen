package com.andthen.tool.sql;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;

import com.andthen.map.LevelMap;
import com.andthen.model.Armor;


public class ArmorSqlOperator extends SqlOperatorBase{
	
	private static final String TABLE = "armor";

	public ArmorSqlOperator(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Armor> queryArmor(){
		ArrayList<Armor> armors = new ArrayList<Armor>();
		cursor = db.query(TABLE, null, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Armor arm = new Armor();
			arm.setCost(cursor.getInt(cursor.getColumnIndex("cost")));
			arm.setDefence(cursor.getInt(cursor.getColumnIndex("defence")));
			arm.setIs_lock(cursor.getInt(cursor.getColumnIndex("is_lock")));
			arm.setName(cursor.getString(cursor.getColumnIndex("name")));
			arm.setResidue(cursor.getInt(cursor.getColumnIndex("residue")));
			armors.add(arm);
		}
		return armors;
	}
	
	public boolean unlock(String name){
		ContentValues args = new ContentValues();
		args.put("is_lock", 0);
		return db.update(TABLE, args, "name="+name, null) >0;
	}
	
	public boolean lock(String name){
		ContentValues args = new ContentValues();
		args.put("is_lock", 1);
		return db.update(TABLE, args, "name="+name, null) >0;
	}
	
	//更新剩余护甲血量
	public boolean residueUpdate(String name, int residue){
		ContentValues args = new ContentValues();
		if(residue>0){
			args.put("residue", residue); 
		}else{
			args.put("is_lock", 0);
		}
		return db.update(TABLE, args, "name="+name, null) >0;
	}

}