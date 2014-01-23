package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.Ship.Bullet;
import com.noahbutler.orb.World.Ship.BulletTypes.Light.starterBullet;

public class AbilityMaker {
	
	public AbilityMaker() {
		
	}
	
	public Ability instantiateAbility(int index, Vector2 position) {
		switch(index){
		case 0:
			return new StartAbility1(position);
			//break?
		default:
			return new StartAbility1(position);
			//break?
		}
	}
}
