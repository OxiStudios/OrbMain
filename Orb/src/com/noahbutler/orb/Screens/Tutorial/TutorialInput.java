package com.noahbutler.orb.Screens.Tutorial;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.noahbutler.orb.Screens.MasterScreen;

public class TutorialInput implements InputProcessor{
	
	private Vector2 startPosition;
	private Vector2 endPosition;
	private Stack previous;
	private Stack next;
	private TutorialScreens currentScreen;
	
	
	
	public TutorialInput(Stack previous, Stack next, TutorialScreens currentScreen) {
		this.previous = previous;
		this.next     = next;
		this.currentScreen = currentScreen;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		startPosition = new Vector2(screenX, screenY);
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		endPosition = new Vector2(screenX, screenY);
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		if(endPosition.x - startPosition.x > 0) {
			//get next pic
			currentScreen.setCurrentImage(currentScreen.getCurrentImageIndex() + 1);
		}else if(endPosition.x - startPosition.x < 0) {
			//get previous pic
			currentScreen.setCurrentImage(currentScreen.getCurrentImageIndex() - 1);
		}
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
