package com.andthen.main;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.andthen.tool.AssetTool;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class AndThenAndroid extends AndroidApplication {

	/** Called when the activity is first created. */
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//Ç¿ÖÆÎªºáÆÁ
		initialize(new AndThenGame(this), false);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
//		super.onBackPressed();
	}
	
}
