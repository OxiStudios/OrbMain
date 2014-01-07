package com.noahbutler.orb.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

/**
 * 
 * @author Noah Butler
 * 
 * Start contact takes a String
 * if the string can be parse to an int
 * that object got hit by a bullet
 * 
 * get check deletable returns a string
 * if it is yes the body that is assoc. with
 * that object will get deleted
 * 
 * getBullet is used to pass to start Contact
 * a bullet returns a "1" everything else returns
 * "not a bullet" this is so if the ship or an orb
 * hits something that is not a bullet the player
 * doesn't get points but the orb blows up
 * 
 * setPosition is used to update the sprite of the 
 * current entity with the position of is assoc. body
 */

public class Entity {
	
	static final float SCALING_FACTOR = .05f;
	Vector2 position;
	
	float offsetX = (Gdx.graphics.getWidth() / 2) * SCALING_FACTOR;
	float offsetY = (Gdx.graphics.getHeight() / 2) * SCALING_FACTOR;
	
	public Entity() {
		position = new Vector2();
	}
	
	public void startContact(String isBullet) {
		
	}
	
	public String getCheckDeletable() {
		//"not bullet or orb so don't delete"
		return "no";
	}
	
	public String getIsBullet() {
		return "notBullet";
	}
	//sets the bottom left corner of the sprite to the middle of the body
	public void setPosition(Vector2 vector) {
		position.x = (vector.x + offsetX) / SCALING_FACTOR;
		position.y = (vector.y + offsetY) / SCALING_FACTOR;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
}
