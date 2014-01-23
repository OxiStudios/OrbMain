package com.noahbutler.orb.World.Multipliers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.noahbutler.orb.World.Entity;

public class Multiplier extends Entity{
	
	public int clickAmount;
	public int multiplier;
	public int amountClicked;
	
	public boolean isActive;
	
	float systemTime;
	
	public Multiplier() {
		systemTime = TimeUtils.nanoTime();
	}
	
	public void render(float delta, SpriteBatch b) {
		
	}
}
