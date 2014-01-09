package com.noahbutler.orb;

import java.util.ArrayList;

/**
 * 
 * @author Noah Butler
 * 
 * This is where all the selection indexes are
 * stored. They will be used when the game screen
 * starts so it knows what sprites to load.
 * 
 * This class will also hold the achievements
 * and stats for the player.
 * 
 * The check methods for each achievement will be called
 * in the end game screen to show achievements that the 
 * player achieved during the previous game.
 *
 */

public class SaveFile {

	public int firstBulletSelectedIndex  = 0;
	public int secondBulletSelectedIndex = 0;
	public int shipSelectedIndex      = 0;
	public int gunTipSelectedIndex    = 0;
	public int gunBarrelSelectedIndex = 0;
	public int gunBaseSelectedIndex   = 0;
	
	public int score = 0;
	public int money = 0;
	public int level = 0;
	
	public SaveFile() {
		//try loading a saved file
		
	}
}
