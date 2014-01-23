package com.noahbutler.orb.World.Input;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.noahbutler.orb.World.Abilities.Ability;

public class AbilityButtonInput extends InputListener{

	private Ability ability;

	public AbilityButtonInput(Ability ability) {
		this.ability = ability;
	}

	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		if(ability.isCooledDown) {
			ability.isClicked = true;
		}
		return true;
	}

	public void touchUp(InputEvent event, float x, float y, int pointer,
			int button) {
		if(!ability.needsLocation) {
			ability.isClicked = false;			
		}
	}
}
