package com.noahbutler.orb.World.Bosses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.noahbutler.orb.World.Entity;
import com.noahbutler.orb.World.World;

public class Boss1 extends Entity{
	private int type;
	private boolean canBeDeleted;
	private int health;
	
	private Texture texture;
	
	private int shield;
	private int weakness;
	private World world;
	public Sprite sprite;
	
	public Boss1(int type, World world) {
		this.type = type;
		this.world = world;
		this.health = 100;
		texture = new Texture(Gdx.files.internal(""));
		sprite = new Sprite(texture);
	}
	
	public void render(SpriteBatch b) {
		sprite.setPosition(getPosition().x- sprite.getWidth()/2, getPosition().y- sprite.getHeight()/2);
		sprite.draw(b);
	}
	
	public int getType(){
		return this.type;
	}
	
	

}
