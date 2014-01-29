package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

/**
 * 
 * @author Noah Butler
 * 
 * This class stores all the methods
 * for making the different types of 
 * abilities the physics world
 *
 */

public class AbilityPhysicsCreator {
	
	//used to keep bodies for abilities together and in check
	private Array<Body> abilityBodies;
	//physics world to add the the bodies to
	private World world;
	
	public AbilityPhysicsCreator(Array<Body> abilityBodies, World world) {
		this.abilityBodies = abilityBodies;
		this.world         = world;
	}
	
	//shields the ship for a certain amount of seconds
	public void shipShieldAbility(Vector2 position, Ability ability) {
		
	}
	
	//makes a ring of blue fire go shooting out from the ship
	public void aoeFireShipAbility(Vector2 position, Ability ability) {
		
	}
	
	public void aoeShardsShipAbility(Vector2 position, Ability ability) {
		
	}
	

}
