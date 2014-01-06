package com.noahbutler.orb.World.Ship;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.noahbutler.orb.World.Entity;

/**
 * 
 * @author Noah Butler
 * 
 * A lot needs to get worked on here
 *
 */
public class MainShip extends Entity{
	int shipIndex;
	float x;
	float y;
	
	int dx;
	
	Gun gun;
	
	public MainShip() {
		
	}
	
	public void render(SpriteBatch b) {
		
	}
	
	public void setPosition(Vector2 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public Array<Bullet> getBulletObjectList() {
		// TODO Auto-generated method stub
		return gun.getBulletObjectList();
	}

}
