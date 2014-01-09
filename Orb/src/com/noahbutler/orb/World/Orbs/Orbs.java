package com.noahbutler.orb.World.Orbs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.World.Entity;
import com.noahbutler.orb.World.World;

public class Orbs extends Entity{
	
	private int type;
	private boolean canBeDeleted;
	private int health;
	
	//test texture
	private Texture texture;
	
	private float x;
	private float y;
	public Sprite sprite;
	private World world;
	public Orbs(int type, World world) {
		this.type = type;
		this.world = world;
		this.health = 100;
		texture = new Texture(Gdx.files.internal("data/orbs/orbtest64.png"));
		sprite = new Sprite(texture);
	}
	
	public void render(SpriteBatch b) {
		//gets the position of the body and sets the sprite in the middle of it
		sprite.setPosition(getPosition().x- sprite.getWidth()/2, getPosition().y - sprite.getHeight()/2);
		sprite.draw(b);
	}

	public int getType() {
		// TODO Auto-generated method stub
		return this.type;
	}
	
	public void startContact(String isBullet) {
		try{
			int BulletNum = Integer.parseInt(isBullet);
			//is a bullet
			if(BulletNum >= 1) {
				health -= 50;
			}else{
				health -= 100;
			}
			
			if(health <= 0) {
				//switch to dying sprite
				world.deleteOrbObj(this);
				OrbGame.saveFile.score += 1;
				Gdx.app.log("Score", "Score: " + OrbGame.saveFile.score);
			}
			Gdx.app.log("kill", "kill has been made");
		}catch(NumberFormatException nfe) {
			//not a bullet, ground or ship
		}
	}
	
	public String getCheckDeletable() {
		if(health <= 0) {
			return "yes";
		}
		return "no";
	}

}
