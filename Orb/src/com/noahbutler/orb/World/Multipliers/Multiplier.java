package com.noahbutler.orb.World.Multipliers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.noahbutler.orb.World.Entity;

public class Multiplier extends Entity{
	
	//the total amount of times the player has to click the multiplier
	//to get its maxium time
	public int clickAmount;
	//the multiplier level
	public int multiplier;
	//amount the player has currently clicked the multiplier
	public int amountClicked;
	//length that the multiplier should run for
	public int multipleLength;
	//when the multiplier should start
	public boolean isActive;
	//when the multiplier starts
	//needs to be assigned elsewhere
	private float startTime;
	//current system time
	private float currentTime;
	
	public Multiplier() {
		
	}
	
	public void render(float delta, SpriteBatch b) {
		if(isActive) {
			if(startTime - currentTime >= multipleLength) {
				//add multiplier here
				Gdx.app.log("multiplier", "there is a multiplier running atm");
			}
			
			//reset currentTime
			currentTime = TimeUtils.nanoTime();
		}
	}
}
