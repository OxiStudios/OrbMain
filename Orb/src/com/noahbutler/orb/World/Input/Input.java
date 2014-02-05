package com.noahbutler.orb.World.Input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.World;
import com.noahbutler.orb.World.Ship.Bullets.Bullet;

public class Input implements InputProcessor{
	
	private World world;

	public Input(World world) {
		this.world = world;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if(world.abilityOne.isClicked && world.abilityOne.needsLocation) {
			world.abilityOne.setPosition(new Vector2(screenX, screenY));
			world.abilityOne.hasLocation = true;
		}
		
		if(world.isBullet1){
			world.addBulletToPhysicsBullet(world.getShipPosition(), world.createBulletSelected1(world.getShipPosition()));			
		}else{
			world.addBulletToPhysicsBullet(world.getShipPosition(), world.createBulletSelected2(world.getShipPosition()));		
			}
		Gdx.app.log("Fired", "Bullet has been fired");	
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
