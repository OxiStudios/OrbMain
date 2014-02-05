package com.noahbutler.orb.World.Ship;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.World.World;
import com.noahbutler.orb.World.Ship.Bullets.Bullet;

public class Gun {
	int bulletIndex;
	int barrelIndex;
	int baseIndex;
	
	public int x;
	public int y;
	
	public int barrelX;
	public int barrelY;
	
	Sprite base;
	Sprite barrel;
	Sprite bullet;
	
	private TextureAtlas bulletTexture;
	private TextureAtlas barrelTexture;
	private TextureAtlas baseTexture;
	
	public Array<Bullet> bullets;
	public int numBullets = 0;
	World world;
	float currentTime;
	float lastShotTime;
	public Gun(World world, int barrelSelectedIndex, int baseSelectedIndex) {
		this.world = world;
		currentTime = 0;
		lastShotTime = TimeUtils.nanoTime();
//		bulletIndex = 1;
//		barrelIndex = 1;
//		baseIndex   = 1;
//		
//		bullets = new Array<Bullet>();
//		
//		bulletTexture = new TextureAtlas();
//		bullet        = new Sprite(bulletTexture.createSprite("bullet" + bulletIndex));
//		bullet.setSize(16, 16);
//		
//		barrel = new Sprite(barrelTexture.createSprite("barrel" + barrelIndex));
//		barrel.setSize(16, 32);
//		barrel.setPosition(this.x + barrel.getWidth()/2, this.y + 10);
//		
//		base = new Sprite(baseTexture.createSprite("base" + baseIndex));
//		base.setSize(32,32);
//		base.setPosition(this.x, this.y);
	}
	
	public void render(SpriteBatch b) {
		
		//this is not correct yet.
		if(currentTime - lastShotTime >= OrbGame.saveFile.fireTime) {
			//world.canfire = true;
			lastShotTime = currentTime;
		}else {
			//world.canfire = false;
		}
		
		currentTime = TimeUtils.nanoTime();
	}

	public Array<Bullet> getBulletObjectList() {
		// TODO Auto-generated method stub
		return bullets;
	}

}
