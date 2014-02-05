package com.noahbutler.orb.World;

import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.Ship.BulletTypes.Light.starterBullet;
import com.noahbutler.orb.World.Ship.Bullets.Bullet;

public class BulletMaker {
	public Bullet instantiateBullet(int index, Vector2 position) {
		switch(index){
		case 0:
			return new starterBullet(position);
			//break?
		default:
			return new starterBullet(position);
			//break?
		}
	}

}
