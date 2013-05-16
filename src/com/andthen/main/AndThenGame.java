package com.andthen.main;

import android.app.Activity;
import android.content.SharedPreferences;

import com.andthen.model.GameOption;
import com.andthen.model.GameSource;
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
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
	
	private Texture uiresource ;
	private TextureRegion back1, next1, back2, next2;
	
	//记录选择地图和枪支等
	private GameSource gameSource; 
	
	public AndThenGame(Activity activity){
		this.activity = activity;
		sp = activity.getPreferences(Activity.MODE_PRIVATE);
		gameOption = new GameOption();
	}
	public void create() {
		// TODO Auto-generated method stub
		initScreen();
		initUiSource();
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
	
	private void initUiSource(){
		uiresource = new Texture(Gdx.files.internal("ui.png"));
		next1 = new TextureRegion(uiresource, 200, 89, 86, 89);
		next2 = new TextureRegion(uiresource, 286, 89, 86, 89);
		back1 = new TextureRegion(uiresource, 200, 0, 86, 89);
		back2 = new TextureRegion(uiresource, 286, 0, 86, 89);
		
		gameSource = new GameSource();
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
	public TextureRegion getBack1() {
		return back1;
	}
	public void setBack1(TextureRegion back1) {
		this.back1 = back1;
	}
	public TextureRegion getNext1() {
		return next1;
	}
	public void setNext1(TextureRegion next1) {
		this.next1 = next1;
	}
	public TextureRegion getBack2() {
		return back2;
	}
	public void setBack2(TextureRegion back2) {
		this.back2 = back2;
	}
	public TextureRegion getNext2() {
		return next2;
	}
	public void setNext2(TextureRegion next2) {
		this.next2 = next2;
	}
	public Texture getUiresource() {
		return uiresource;
	}
	public void setUiresource(Texture uiresource) {
		this.uiresource = uiresource;
	}
	public GameSource getGameSource() {
		return gameSource;
	}
	public void setGameSource(GameSource gameSource) {
		this.gameSource = gameSource;
	}

}