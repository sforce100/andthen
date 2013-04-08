package com.andthen.tool;

import com.badlogic.gdx.assets.AssetManager;

public class AssetTool extends AssetManager{
	
	private AssetTool(){};
	
	private static final AssetTool asset = new AssetTool();
	
	public static AssetTool getInstance(){
		return asset;
	} 
}
