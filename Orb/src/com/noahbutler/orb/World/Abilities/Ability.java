package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.noahbutler.orb.World.Entity;

public class Ability extends Entity {
	
	//one second in nanosecond
	private static final int NANO = 1000000000;
	//string for logs
	private String log = "ability";
	
	//how long the ability is active for.
	public int length;
	//the amount of time it takes the ability to recharge
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
	//everything is green if this returns true
	public boolean isReady;
	//when the ability is started and will be used for cooling down start time
	public float startTime;
	//float that will keep track of the current time
	public float currentTime = 0;
	//float that will keep track of the current time for cooling down
	public float currentTimeCoolDown = 0;
	
	public Ability(Vector2 position){
		this.setPosition(position);
	}
	
	public void render(float delta, SpriteBatch b) {
		
		//checks if the ability is cooling down
		if(isCoolingDown) {
			isCooledDown = false;
			if(currentTimeCoolDown - startTime >= (coolDownTime * NANO)) {
				isCoolingDown = false;
				isCooledDown   = true;
				Gdx.app.log(log, "ability is cooled down");
			}
			
			currentTimeCoolDown = TimeUtils.nanoTime();
		}
		
		if(!needsLocation) {
			if(isClicked) {
				Gdx.app.log(log, "ability doesn't need a location and is clicked");
				isReady       = true;
				isCoolingDown = true;
				
			}
		}else{
			if(hasLocation && isClicked){
				Gdx.app.log(log, "ability needs a location, has a location, and is clicked");
				isClicked     = false;
				isReady       = true;
				isCoolingDown = true;
			}
		}
		//stopAbility will make this false
		if(isReady) {
			Gdx.app.log(log, "ability is starting");
			startAbility(b);
		}
	}
	
	//keeps track of the ability and how long it has been going for
	public void startAbility(SpriteBatch b){
		this.startTime = TimeUtils.nanoTime();
		
		//if this is true the ability has gone on for the length that it should
		//the ability must be stopped then.
		if(currentTime - startTime >= (length * NANO)) {
			stopAbility();
		}
		runAbility(b);
		currentTime = TimeUtils.nanoTime();
	}
	
	//gets called when the current ability is done
	public void stopAbility() {
		Gdx.app.log(log, "ability has been stopped");
		isReady = false;
	}
	
	//gets called when the ability is in affect over and over again
	public void runAbility(SpriteBatch b) {
		Gdx.app.log(log, "ability should be running at this point");
	}
}
