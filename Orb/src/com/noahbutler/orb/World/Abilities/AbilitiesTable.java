package com.noahbutler.orb.World.Abilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.noahbutler.orb.World.World;

public class AbilitiesTable {
	
	public Table abilitiesTable;
	
	Table abilityOne;
	Table abilityTwo;
	
	TextButton extendAbilityTable;
	
	public AbilitiesTable(World world, int abilityOneSelectedIndex, int abilityTwoSelectedIndex) {
		
		abilitiesTable = new Table();
		
		abilityOne = new Table();
		abilityTwo = new Table();
		
		//will be a simple arrow graphic, this throws an error atm
		//extendAbilityTable = new TextButton();
		
		//abilitiesTable.setBounds(0, Gdx.graphics.getHeight() - abilitiesTable.getHeight(), (Gdx.graphics.getWidth()/4) + extendAbilityTable.getWidth(), Gdx.graphics.getHeight()/5);
		abilitiesTable.add(abilityOne).top().left();
		//abilitiesTable.add(extendAbilityTable);
		abilitiesTable.row();
		abilitiesTable.add(abilityTwo);
		
		world.addToMasterTable(abilitiesTable);
	}
	
	public void render(float delta) {
		abilitiesTable.act(delta);
	}
	
	public void showTable() {
		abilitiesTable.setX(0);
	}
	
	public void hideTable() {
		abilitiesTable.setX((abilitiesTable.getX()- abilitiesTable.getWidth()) + extendAbilityTable.getWidth());
		
	}
}
