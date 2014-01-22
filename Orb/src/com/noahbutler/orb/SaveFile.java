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
	
	public int abilitySelected1 = 0;
	public int abilitySelected2 = 0;
	
	public int score = 0;
	public int money = 0;
	public int level = 0;
	public int xp    = 0;
	
	//level xp total
	public int level_1 = 25;
	public int level_2 = 75;
	public int level_3 = 140;
	public int level_4 = 220;
	public int level_5 = 350;
	public int level_6 = 470;
	public int level_7 = 600;
	public int level_8 = 810;
	public int level_9 = 1100;
	public int level_10= 1400;
	
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
	
	public int getLevel(int xp) {
		if(xp < level_1) {
			return 0;
		}else if(xp < level_2) {
			return 1;
		}else if(xp < level_3) {
			return 2;
		}else if(xp < level_4) {
			return 3;
		}else if(xp < level_5) {
			return 4;
		}else if(xp < level_6) {
			return 5;
		}else if(xp < level_7) {
			return 6;
		}else if(xp < level_8) {
			return 7;
		}else if(xp < level_9) {
			return 8;
		}else if(xp < level_10) {
			return 9;
		}else {
			return 10;
		}
	}
}
