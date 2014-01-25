package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class StartAbility1 extends Ability{
	
	Sprite sprite;

	public StartAbility1(Vector2 position) {
		super(position);
		this.length        = 3;
		this.coolDownTime  = 10;
		this.isCooledDown  = true;
		this.isCoolingDown = false;
		this.needsLocation = false;
		this.hasLocation   = false;
		
		this.sprite = new Sprite();
	}
	
	public void runAbility(SpriteBatch b) {
		//gets called over and over until the ability is done.
	}
}
