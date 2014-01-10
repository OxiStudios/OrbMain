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
	
	public boolean kill_CEO;
	public boolean kill_Killionare;
	public boolean kill_OohKillEm;
	public boolean level_TheNewGuy;
	public boolean level_SoISeeYouLikeToKillThings;
	public boolean boss_DefeatBoss1;
	public boolean boss_DefeatBoss2;
	public boolean boss_DefeatBoss3;
	public boolean boss_DefeatBoss4;
	public boolean play_YouPlayedHowLong;
	public boolean play_NotRPG;
	public boolean area_IntoTheVoid;
	public boolean area_TheyCameFromWithin;

	public int kills_made;
	public int level_reached;
	public int boss_reached;
	public int play_time;
	public int area_unlocked;
	
	//can fire every .5 seconds
	//this will be different for each bullet
	//and their level takes off a percent of 
	//the time.
	public float fireTime = 500000000;
	
	public SaveFile() {
		//try loading a saved file
		
	}
	
	public void save() {
		
	}
}
