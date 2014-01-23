package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StartAbility1 extends Ability{
	
	Sprite sprite;

	public StartAbility1(Vector2 position) {
		super(position);
		this.coolDownTime  = 10;
		this.isCooledDown  = true;
		this.isCoolingDown = false;
		this.needsLocation = false;
		this.hasLocation   = false;
		
		this.sprite = new Sprite();
	}
	
	public void startAbility(SpriteBatch b) {
		//do ability shit
	}
	
	public void render(float delta, SpriteBatch b) {
		
	}
	
	

}
