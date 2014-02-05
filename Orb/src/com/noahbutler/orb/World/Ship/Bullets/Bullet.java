package com.noahbutler.orb.World.Ship.Bullets;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.Entity;
import com.noahbutler.orb.World.Ship.BulletTypes.Light.starterBullet;

public class Bullet extends Entity{
	
	public int damage = 0;
	
	private Vector2 vector;
	
	public Bullet(Vector2 vector) {
		this.vector = vector;
	}
	
	public void render(SpriteBatch b, Sprite sprite) {
		sprite.setPosition(vector.x, vector.y);
		sprite.draw(b);
	}
	
	public void startContact(String isGround) {
		
	}
	
	public String getDamageString() {
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
		return "yes";
	}
	
	public void setPosition(Vector2 vector) {
		this.vector = vector;
	}
	


}
