package com.noahbutler.orb.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.noahbutler.orb.World.World;

/**
 * 
 * @author Noah Butler
 * 
 * This is the main game screen that runs the game
 * it will take some parameters like what level to 
 * load/ boss to load, save file for getting the
 * correct sprite indexes and player level and what not.
 *
 */

public class OrbGameScreen extends MasterScreen{
	
	World world;

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		world.render(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		world.resize(width, height);
	}

	@Override
	public void show() {
		if(world == null){
			//needs boolean endless
			world = new World(true);
		}
		
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
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		world.dispose();
	}

}
