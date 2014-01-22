package com.noahbutler.orb.World.Input;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.Screens.MasterScreen;

public class AbilityButtonInput extends InputListener{

	public AbilityButtonInput() {

	}

	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		return true;
	}

	public void touchUp(InputEvent event, float x, float y, int pointer,
			int button) {

	}
}
