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
		initData(db);
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
		"total integer, sunandsteel integer, residue_bullet integer,"+
		"gun_cost integer, bullet_cost integer"+
		"name varchar2(10),"+
		"is_lock integer,"+
		"fill_time integer, x integer, y integer, w integer, h integer)");
		
		db.execSQL("CREATE TABLE armor (name varchar2(10), cost integer, defence integer, is_lock integer, residue integer)");
		db.execSQL("CREATE TABLE map1 (req_star integer, level integer, is_lock integer)");
		db.execSQL("CREATE TABLE map2 (level integer, num integer, is_lock integer, get_star integer, req_star integer,enemycount integer, enemysum integer, enemylevel integer)");

	    Log.e("Database","onCreate");
	}
	
	//初始化数据
	private void initData(SQLiteDatabase db){
		String sql7 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(70,70,70,70,70,70,70,70,'左轮',0,280,200,100,150) ";
		String sql1 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(80,80,80,80,80,80,80,80,'银鹰',1,180,200,100,150) ";
		String sql2 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(90,90,90,90,90,90,90,90,'awm',1,0,200,180,200) ";
		String sql3 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(100,100,100,100,100,100,100,100,'散弹',1,300,0,100,200) ";
		String sql4 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(110,110,110,110,110,110,110,110,'m4a1',1,200,0,100,200) ";
		String sql5 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(120,120,120,120,120,120,120,120,'95式',1,100,0,100,200) ";
		String sql6 = "insert into gun(damage,firerate,accuracy,total,sunandsteel,residue_bullet,gun_cost,bullet_cost,name,"+
				"is_lock,fill_time,x,y,w,h)values(130,130,130,130,130,130,130,130,'b31',1,0,0,100,200) ";
		
		db.execSQL(sql1);
		db.execSQL(sql2);
		db.execSQL(sql3);
		db.execSQL(sql4);
		db.execSQL(sql5);
		db.execSQL(sql6);
		db.execSQL(sql7);
		
		
		String a1 = "insert into armor(name, cost , defence, is_lock , residue) values('护具1',100,100,1,100)";
		String a2 = "insert into armor(name, cost , defence, is_lock , residue) values('护具2',200,200,1,200)";
		String a3 = "insert into armor(name, cost , defence, is_lock , residue) values('护具3',300,300,1,300)";
		
		db.execSQL(a1);
		db.execSQL(a2);
		db.execSQL(a3);
		
		
		String m1 = "insert into map1(req_star, level, is_lock) values(20, 1, 0)";
		String m2 = "insert into map1(req_star, level, is_lock) values(40, 2, 0)";
		String m3 = "insert into map1(req_star, level, is_lock) values(60, 3, 0)";
		String m4 = "insert into map1(req_star, level, is_lock) values(80, 4, 0)";
		String m5 = "insert into map1(req_star, level, is_lock) values(100, 5, 0)";
	
		db.execSQL(m1);
		db.execSQL(m2);
		db.execSQL(m3);
		db.execSQL(m4);
		db.execSQL(m5);
		
		String mm1 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,1,0,0,0,5,15,1)";
		String mm2 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,2,1,0,1,5,15,1)";
		String mm3 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,3,1,0,2,5,15,1)";
		String mm4 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,4,1,0,3,5,15,1)";
		String mm5 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,5,1,0,4,5,15,1)";
		String mm6 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,6,1,0,5,5,15,1)";
		String mm7 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,7,1,0,6,5,15,1)";
		String mm8 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,8,1,0,7,5,15,1)";
		String mm9 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,9,1,0,8,5,15,1)";
		String mm10 = "insert into map2(level, num, is_lock, get_star, req_star,enemycount, enemysum, enemylevel) values(1,10,1,0,10,5,15,1)";
		
		db.execSQL(mm1);
		db.execSQL(mm2);
		db.execSQL(mm3);
		db.execSQL(mm4);
		db.execSQL(mm5);
		db.execSQL(mm6);
		db.execSQL(mm7);
		db.execSQL(mm8);
		db.execSQL(mm9);
		db.execSQL(mm10);
	}
	
	private void dropTables(SQLiteDatabase db){
// example:
		db.execSQL("DROP TABLE IF EXISTS gun"); 
		db.execSQL("DROP TABLE IF EXISTS armor"); 
		db.execSQL("DROP TABLE IF EXISTS map");
	}
}
