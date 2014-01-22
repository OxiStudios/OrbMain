package com.noahbutler.orb.Screens.Tutorial;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class BasicGamePlayTutorial extends TutorialScreens{
	
	private TextureAtlas basicGamePlayTutorialPicture;
	Array<Sprite> pics;
	int currentIndex;
	Sprite currentImage;
	
	SpriteBatch b;
	
	public BasicGamePlayTutorial(TextureAtlas basicGamePlayTutorialPicture) {
		this.basicGamePlayTutorialPicture = basicGamePlayTutorialPicture;
		
	}
	
	public int getCurrentImageIndex() {
		return currentIndex;
	}
	
	public void setCurrentImage(int i) {
		if(i > 5) {
			currentIndex = 0;
		}else if( i < 0) {
			currentIndex = 5;
		}else{
			currentIndex = i;
		}
		
		currentImage.set(pics.get(currentIndex));
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		
		b.begin();
		currentImage.draw(b);
		b.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		if(pics == null) {
			pics = new Array<Sprite>();
			for(int i = 0; i < 6; i++) {
				pics.add(basicGamePlayTutorialPicture.createSprite("tutbasic" + i));
			}
		}
		
		if(b == null) {
			b = new SpriteBatch();
		}
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		basicGamePlayTutorialPicture.dispose();
	}

}
