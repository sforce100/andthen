package com.andthen.screen;

import java.util.ArrayList;
import java.util.Iterator;

import com.andthen.guns.Gun;
import com.andthen.main.AndThenGame;
import com.andthen.model.Armor;
import com.andthen.tool.TempTexture;
import com.andthen.tool.sql.GunSqlOperator;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ClickListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.tablelayout.Table;

public class ShopScreen extends AbstractScreen{

	Button back, next, weapon, assist, select_left, select_rigth;
	Stage stage;
	Label lmain;
	BitmapFont font;
	GunSqlOperator go;
	ArrayList<Gun> gl;
	ArrayList<Button> main_requirment, assist_requirment;

	Texture tg, ta;
	Table wg, wa;
	
	int current_select = 0; //当前选中装备
	Boolean is_main; //是否主武器
	
	public ShopScreen(AndThenGame game){
		super(game);
	}
	
	public void dispose() {
		// TODO Auto-generated method stub
		stage.dispose();
		go.closeUserHelper();
	}

	public void hide() {
		// TODO Auto-generated method stub
		
	}

	public void pause() {
		// TODO Auto-generated method stub
		
	}

	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0f,0f,0f,0f);
		stage.act(Gdx.graphics.getDeltaTime());
		
		stage.getSpriteBatch().begin();
		stage.getSpriteBatch().draw(game.getBackground(), 0, 0); // 绘制背景
		stage.getSpriteBatch().end();
		
		stage.draw();	
	}

	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	public void resume() {
		// TODO Auto-generated method stub
		
	}

	public void show() {
		// TODO Auto-generated method stub
		init();
		Gdx.input.setInputProcessor(stage);		
	}
	
	private void init(){
		
		stage=new Stage(Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true);
		
		tg = new Texture(Gdx.files.internal("gunui.png"));
		ta = new Texture(Gdx.files.internal("ui.png"));
		
		go = new GunSqlOperator(game.getActivity().getApplicationContext());
		gl = go.queryGun();
		
		font = new BitmapFont(Gdx.files.internal("font.fnt"), false);

		back = new Button(game.getBack1(), game.getBack2());
		back.x = 10;
		back.y = 10;
		back.width = 70;
		back.height = 70;
		back.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new LevelSelect2(game));
			}
		});
		
		next = new  Button(game.getNext1(), game.getNext2());
		next.x = Gdx.graphics.getWidth()-110;
		next.y = 10;
		next.width = 70;
		next.height = 70;
		next.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				game.setScreen(new GameScreen(game));
			}
		});
		
		lmain = new Label("ShopScreen", new LabelStyle(font, Color.WHITE));
		lmain.width = 200f;
		lmain.height = 50f;
		lmain.x = 200;
		lmain.y = 200;
		
		//左右选中装备
		select_left = new Button(new TextureRegion(game.getBack2()));
		select_left.x = 10;
		select_left.y = Gdx.graphics.getHeight()/2;
		select_left.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				if(is_main){
					if(current_select < main_requirment.size() - 1){
						stage.addActor(main_requirment.get(current_select));//middle
						stage.addActor(main_requirment.get(current_select-1));//left
						if(current_select < main_requirment.size() - 2){
							stage.addActor(main_requirment.get(current_select+1));
						}
					}
				}else{
					if(current_select < assist_requirment.size() - 1){
						stage.addActor(assist_requirment.get(current_select));//middle
						stage.addActor(assist_requirment.get(current_select-1));//left
						if(current_select < assist_requirment.size() - 2){
							stage.addActor(assist_requirment.get(current_select+1));
						}
					}
				}
			}
		});
		
		
		select_rigth = new Button(new TextureRegion(game.getNext2()));
		select_rigth.x = Gdx.graphics.getWidth()-110;
		select_rigth.y = Gdx.graphics.getHeight()/2;
		select_rigth.setClickListener(new ClickListener() {
			
			public void click(Actor arg0, float arg1, float arg2) {
				// TODO Auto-generated method stub
				if(is_main){
					if(current_select > 0){
						stage.addActor(main_requirment.get(current_select));//middle
						stage.addActor(main_requirment.get(current_select-1));//left
						if(current_select < 1){
							stage.addActor(main_requirment.get(current_select+1));
						}
					}
				}else{
					if(current_select < 0){
						stage.addActor(assist_requirment.get(current_select));//middle
						stage.addActor(assist_requirment.get(current_select-1));//left
						if(current_select < 1){
							stage.addActor(assist_requirment.get(current_select+1));
						}
					}
				}
			}
		});
		//武器
		weapon = new Button(new TextureRegion(tg,0,1792,96,96));
		weapon.x = Gdx.graphics.getWidth()/3;
		weapon.y = Gdx.graphics.getHeight()-100;
	
//		weapon.width = 96;
//		weapon.height = 96;
				
		assist = new Button(new TextureRegion(tg,96,1792,96,96));
		assist.x = Gdx.graphics.getWidth()/2;
		assist.y = Gdx.graphics.getHeight()-100;
//		assist.width = 96;
//		assist.height = 96;
		
		//button group
//		wg = new Table();
//		Iterator<Gun> ig = gl.iterator();
//		while(ig.hasNext()){
//			Gun g = ig.next();
//			wg.add(new Button(new TextureRegion(tg, g.getSx(), g.getSy(), g.getSw(), g.getSh())));
//		}
//		wg.originX = 0;
//		wg.originY = Gdx.graphics.getHeight()-200;
//		wg.width = Gdx.graphics.getWidth();
//		wg.height = Gdx.graphics.getHeight() - 300;
				
		
		stage.addActor(back);
		stage.addActor(next);
		stage.addActor(lmain);
		stage.addActor(weapon);
		stage.addActor(assist);
		stage.addActor(select_left);
		stage.addActor(select_rigth);
//		stage.addActor(wg);
		
		//gun		
		int k = 10;
		int kk = (Gdx.graphics.getWidth()-k*6)/5;
		int yy = Gdx.graphics.getHeight()-100;
//		for(int i=1; i<6; i++){
//			Button b = new Button(new TextureRegion(game.getUiresource(), 374, 0, 138,141), new TextureRegion(game.getUiresource(), 512, 0, 138,141));
//			if(i>5){
//				b.x = kk*(i-6)+k;
//			}else{
//				b.x = kk*(i-1)+k;
//			}
//			
//			b.y = (i>5 ? yy-kk*2 : yy-kk);
//			b.width = kk;
//			b.height = kk;
//			final String txt = "select level   "+i;
//			final String tempI = i+"";
//			b.setClickListener(new ClickListener() {
//				
//				public void click(Actor arg0, float arg1, float arg2) {
//					// TODO Auto-generated method stub
//					lmain.setText(txt);
//					game.getGameSource().setGunName(tempI);
//				}
//			});
//			stage.addActor(b);
//		}
	}

	public void initRequiment(ArrayList<Gun> guns, ArrayList<Armor> armors){
		main_requirment = new ArrayList<Button>();
		assist_requirment = new ArrayList<Button>();
		Iterator<Gun> ig = guns.iterator();
		while (ig.hasNext()) {
			Gun g = ig.next();
			Button b = new Button(new TextureRegion(tg,g.getSx(), g.getSy(), g.getSw(), g.getSh()));
			b.setClickListener(new ClickListener() {	
				public void click(Actor arg0, float arg1, float arg2) {
					// TODO Auto-generated method stub
					
				}
			});
			if(g.getState() == 1){
				main_requirment.add(b);
			}else{
				assist_requirment.add(b);
			}			
		}
		
		Iterator<Armor> ia = armors.iterator();
		while (ia.hasNext()) {
			Armor a = ia.next();
			Button b = new Button(new TextureRegion(ta,a.getSx(), a.getSy(), a.getSw(), a.getSh()));
			b.setClickListener(new ClickListener() {
				
				public void click(Actor arg0, float arg1, float arg2) {
					// TODO Auto-generated method stub
					
				}
			});
			assist_requirment.add(b);
		}
	}
	
	
}
