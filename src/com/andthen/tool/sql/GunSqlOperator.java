package com.andthen.tool.sql;

import java.util.ArrayList;

import com.andthen.guns.Gun;

import android.content.ContentValues;
import android.content.Context;

public class GunSqlOperator extends SqlOperatorBase{
	
	private static final String TABLE = "gun";
	
	public GunSqlOperator(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Gun> queryGun(){
		ArrayList<Gun> guns=new ArrayList<Gun>();
		cursor = db.query(TABLE, null, null, null, null, null, null);
		cursor.moveToFirst();
		while(!cursor.isAfterLast()){
			Gun gun = new Gun();
			gun.setDamage(cursor.getInt(cursor.getColumnIndex("damage")));
			gun.setAccuracy(cursor.getInt(cursor.getColumnIndex("accuracy")));
			gun.setFirerate(cursor.getInt(cursor.getColumnIndex("firerate")));
			gun.setMagazines(cursor.getInt(cursor.getColumnIndex("sunandsteel")));
			gun.setReloadtime(cursor.getInt(cursor.getColumnIndex("fill_time")));
			gun.setMaxsize(cursor.getInt(cursor.getColumnIndex("total")));
			gun.setMaxleft(cursor.getInt(cursor.getColumnIndex("residue_bullet")));
			gun.setName(cursor.getString(cursor.getColumnIndex("name")));
			gun.setGun_cost(cursor.getInt(cursor.getColumnIndex("gun_cost")));
			gun.setX(cursor.getInt(cursor.getColumnIndex("x")));
			gun.setY(cursor.getInt(cursor.getColumnIndex("y")));
			gun.setSx(cursor.getInt(cursor.getColumnIndex("sx")));
			gun.setSy(cursor.getInt(cursor.getColumnIndex("sy")));
			gun.setW(cursor.getInt(cursor.getColumnIndex("w")));
			gun.setH(cursor.getInt(cursor.getColumnIndex("h")));
			gun.setSw(cursor.getInt(cursor.getColumnIndex("sw")));
			gun.setSh(cursor.getInt(cursor.getColumnIndex("sh")));
			gun.setState(cursor.getInt(cursor.getColumnIndex("state")));
			
			guns.add(gun);
			cursor.moveToNext();
		}
		return guns;
	}
	
	public boolean unlock(String name){
		ContentValues args = new ContentValues();
		args.put("is_lock", 0);
		return db.update(TABLE, args, "name ="+name, null) > 0;
	}
	
	public boolean updateBullet(String name,int num){
		
		ContentValues args = new ContentValues();
		args.put("maxleft", num);
		return db.update(TABLE, args, "name ="+name, null) > 0;
	}

}

