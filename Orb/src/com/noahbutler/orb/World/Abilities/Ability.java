package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.math.Vector2;
import com.noahbutler.orb.World.Entity;

public class Ability extends Entity {
	
	public int length;
	public int coolDownTime;
	//checks if coolDownTime is done, and if it is, change to normal button and make clickable.
	public boolean isCooledDown;
	//checks if it is coolingDown;
	public boolean isCoolingDown;
	//checks if the ability needs a location
	public boolean needsLocation;
	//checks to see if the ability is ready for location
	public boolean isClicked;
	//position is set and animation is ready to take place.
	public boolean hasLocation;
	
	public Ability(Vector2 position){
		this.setPosition(position);
	}
	
	public void render(float delta) {
		if(isCoolingDown) {
			isCooledDown = false;
		}
	}
	
	public void startAbility(){
		
	}
}
