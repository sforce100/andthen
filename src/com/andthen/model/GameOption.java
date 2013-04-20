package com.andthen.model;

public class GameOption {
	
	private boolean isMusicEnabled;
	private float musicLength;
	
	public GameOption(){
		
	}
	
	private void init(){
		isMusicEnabled = true;
		musicLength = 0.5f;
	}
	
	public boolean isMusicEnabled() {
		return isMusicEnabled;
	}
	public void setMusicEnabled(boolean isMusicEnabled) {
		this.isMusicEnabled = isMusicEnabled;
	}
	public float getMusicLength() {
		return musicLength;
	}
	public void setMusicLength(float musicLength) {
		this.musicLength = musicLength;
	}
	
	
}
