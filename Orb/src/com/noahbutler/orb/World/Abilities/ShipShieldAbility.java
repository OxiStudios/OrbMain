package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.World;

public class ShipShieldAbility extends Ability{
	
	
	public ShipShieldAbility(World world) {
		super(world);
		// TODO Auto-generated constructor stub
		length = 4;
		coolDownTime = 10;
		isCooledDown = true;
		isCoolingDown = false;
		needsLocation = false;
		isReady = false;
	}
	
	public void runAbility() {
		Gdx.app.log("shield ability", "shield ability has started");
	}
}
