package com.andthen.main;

import android.app.Activity;
import android.content.SharedPreferences;

import com.andthen.actor.AnimalActor;
import com.andthen.actor.ProgressBar;
import com.andthen.model.GameOption;
import com.andthen.screen.GameScreen;
import com.andthen.screen.HelpScreen;
import com.andthen.screen.LevelSelect1;
import com.andthen.screen.LevelSelect2;
import com.andthen.screen.Loading;
import com.andthen.screen.MainMenuScreen;
import com.andthen.screen.OptionScreen;
import com.andthen.screen.ShopScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class AndThenGame extends Game {
	
	private Activity activity;
	private GameOption gameOption;
	
	private MainMenuScreen menuScreen;
	private GameScreen gameScreen;
	private HelpScreen helpScreen;
	private OptionScreen optionScreen;
	private LevelSelect1 levelSelect1;
	private LevelSelect2 levelSelect2;
	private ShopScreen shopScreen;
	
	private SharedPreferences sp;
	
	public AndThenGame(Activity activity){
		this.activity = activity;
		sp = activity.getPreferences(Activity.MODE_PRIVATE);
		gameOption = new GameOption();
	}
	@Override
	public void create() {
		// TODO Auto-generated method stub
		initScreen();
		setScreen(new Loading(this));
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
	}
	
	
	private void initScreen(){
		menuScreen = new MainMenuScreen(this);
		gameOption = new GameOption();
		gameScreen = new GameScreen(this);
		helpScreen = new HelpScreen(this);
		optionScreen = new OptionScreen(this);
		levelSelect1 = new LevelSelect1(this);
		levelSelect2 = new LevelSelect2(this);
		shopScreen = new ShopScreen(this);
	}
	
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public MainMenuScreen getMenuScreen() {
		return menuScreen;
	}
	public void setMenuScreen(MainMenuScreen menuScreen) {
		this.menuScreen = menuScreen;
	}
	public GameOption getGameOption() {
		return gameOption;
	}
	public void setGameOption(GameOption gameOption) {
		this.gameOption = gameOption;
	}
	public GameScreen getGameScreen() {
		return gameScreen;
	}
	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	public HelpScreen getHelpScreen() {
		return helpScreen;
	}
	public void setHelpScreen(HelpScreen helpScreen) {
		this.helpScreen = helpScreen;
	}
	public OptionScreen getOptionScreen() {
		return optionScreen;
	}
	public void setOptionScreen(OptionScreen optionScreen) {
		this.optionScreen = optionScreen;
	}
	public LevelSelect1 getLevelSelect1() {
		return levelSelect1;
	}
	public void setLevelSelect1(LevelSelect1 levelSelect1) {
		this.levelSelect1 = levelSelect1;
	}
	public LevelSelect2 getLevelSelect2() {
		return levelSelect2;
	}
	public void setLevelSelect2(LevelSelect2 levelSelect2) {
		this.levelSelect2 = levelSelect2;
	}
	public ShopScreen getShopScreen() {
		return shopScreen;
	}
	public void setShopScreen(ShopScreen shopScreen) {
		this.shopScreen = shopScreen;
	}
}