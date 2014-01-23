package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.math.Vector2;

public class StartAbility1 extends Ability{

	public StartAbility1(Vector2 position) {
		super(position);
		this.coolDownTime  = 10;
		this.isCooledDown  = true;
		this.isCoolingDown = false;
		this.needsLocation = false;
		this.hasLocation   = false;
	}
	
	public void startAbility() {
		//do ability shit
	}
	
	public void render(float delta) {
		if(!needsLocation) {
			if(isClicked) {
				startAbility();
			}
		}else{
			if(hasLocation && isClicked){
				isClicked = false;
				startAbility();
			}
		}
	}
	
	

}
