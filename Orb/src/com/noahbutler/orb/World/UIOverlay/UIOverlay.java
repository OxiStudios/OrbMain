package com.noahbutler.orb.World.UIOverlay;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.World.World;

public class UIOverlay {
	
	int currentLevel;
	Table statsDisplayTable;
	private World world;
	
	public UIOverlay(World world) {
		this.world = world;
		currentLevel = OrbGame.saveFile.getLevel(OrbGame.saveFile.xp);
		
		statsDisplayTable = new Table();
		
	}
	
	public void render(SpriteBatch b) {
		
	}
	

}
