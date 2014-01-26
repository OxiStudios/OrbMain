package com.noahbutler.orb.World.UIOverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.World.World;

public class UIOverlay {
	
	Table statsDisplayTable;
	private World world;
	
	Label level;
	Label money;
	Label score;
	LabelStyle style;
	BitmapFont font;
	
	public UIOverlay(World world) {
		this.world = world;
		
		statsDisplayTable = new Table();
		statsDisplayTable.setBounds(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()/5);
		
		font  = new BitmapFont();
		style = new LabelStyle(font, new Color(100, 100, 100, 100));
		
		level = new Label("" + OrbGame.saveFile.getLevel(OrbGame.saveFile.xp), style);
		money = new Label("" + OrbGame.saveFile.money, style);
		score = new Label("" + OrbGame.saveFile.score, style);
		
		statsDisplayTable.add(level);
		statsDisplayTable.add(money);
		statsDisplayTable.add(score);
		
		this.world.addToMasterTable(statsDisplayTable);
		
	}
	
	public void render(float delta) {
		//update numbers
		level.act(delta);
		money.act(delta);
		score.act(delta);
		statsDisplayTable.act(delta);
	}
}
