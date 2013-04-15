package com.andthen.screen;


import com.andthen.map.GameMap;
import com.andthen.map.MapMode;
import com.andthen.main.AndThenGame;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameScreen extends AbstractScreen {

	private Stage stage;
	private GameMap gamemap;
	private MapModel mm;

	public GameScreen(AndThenGame game) {
		super(game);

		// TODO Auto-generated constructor stub
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(float arg0) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		GL10 gl = Gdx.app.getGraphics().getGL10();
		gl.glClearColor(1, 1, 1, 0);
		stage.act(Gdx.graphics.getDeltaTime());
		gamemap.render();
		stage.draw();

	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		// 
		mm=new MapModel();
		stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(),
				true);
		
		//�����һ��  ����ǰ��screenѡ��� ��ͼ   �����һ����Ӧ��mapmodel�ķ���
		
		//�����һ��  ����ǰ��screenѡ��� �������   �����һ����Ӧ��player�ķ���
		
		
		Gdx.input.setInputProcessor(stage);
		gamemap=new GameMap(stage,mm);      //������̨ �� ��ͼ����
	
		
		
		

	}

}
