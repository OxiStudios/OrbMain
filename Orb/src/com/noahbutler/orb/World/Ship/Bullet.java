package com.noahbutler.orb.World.Ship;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.Entity;
import com.noahbutler.orb.World.Ship.BulletTypes.Light.starterBullet;

public class Bullet extends Entity{
	
	public int damage = 0;
	
	private float x;
	private float y;
	
	int dx;
	int dy = 10;
	
	public Bullet(Vector2 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public void render(SpriteBatch b, Sprite sprite) {
		this.y -= dy;
		sprite.setX(x);
		sprite.setY(y);
		sprite.draw(b);
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	
	public void startContact(String isGround) {
		
	}
	
	private String convertDamageToString() {
		return "" + damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	//This is the same for every bullet, so we will not need to override it in the sub bullet classes.
	public String getCheckDeletable() {
		return "yes";
	}
	
	//returns the the damage of the bullet, and gets passed to the enemy class.
	public String getIsBullet(){
		return convertDamageToString();
	}
	
	public void setPosition(Vector2 vector) {
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public Bullet instantiateBullet(int index) {
		return null;
	}

}
