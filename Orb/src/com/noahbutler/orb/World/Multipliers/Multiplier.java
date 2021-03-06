package com.noahbutler.orb.World.Multipliers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;
import com.noahbutler.orb.OrbGame;
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
	//multiplier timer thread
	private Thread timerThread;
	
	public Multiplier() {
		timerThread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(OrbGame.isRunning) {
					if(isActive) {
						if(startTime - currentTime >= multipleLength) {
							isActive = false;	
						}
						
						//multiplier stuff runs here
						Gdx.app.log("multiplier", "there is a multiplier running atm");
						//reset currentTime
						currentTime = TimeUtils.nanoTime();
					}
					try {
						timerThread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
	}
	
	public void render(float delta, SpriteBatch b) {
		//render the multiplier object here
	}
}
