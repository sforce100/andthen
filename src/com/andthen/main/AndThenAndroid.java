package com.andthen.main;

import android.os.Bundle;

import com.andthen.tool.AssetTool;
import com.badlogic.gdx.backends.android.AndroidApplication;

public class AndThenAndroid extends AndroidApplication {

	/** Called when the activity is first created. */
	@Override
	public void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initialize(new AndThenActivity(), false);
	}
	
}
