package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.World;
import com.noahbutler.orb.World.Ship.Bullet;
import com.noahbutler.orb.World.Ship.BulletTypes.Light.starterBullet;

public class AbilityMaker {
	
	private World world;

	public AbilityMaker(World world) {
		this.world = world;
	}
	
	public Ability instantiateAbility(int index) {
		switch(index){
		case 0:
			return new StartAbility1(world);
			//break?
		default:
			return new StartAbility1(world);
			//break?
		}
	}
}
