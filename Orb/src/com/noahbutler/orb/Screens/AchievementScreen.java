package com.noahbutler.orb.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.noahbutler.orb.OrbGame;

/**
 * 
 * @author Noah Butler
 * 
 *         This screen will display each a achievement
 * 
 *         A gray and black image for the the achievements the player has not
 *         unlocked yet and a colored one for the achievements that the player
 *         has unlocked
 * 
 */

public class AchievementScreen extends MasterScreen {
	
	public AchievementScreen() {
		Gdx.app.log(log, "Loading Achievements...");
	}

	public boolean kill_CEO_goal() {
		if (OrbGame.saveFile.kills_made >= 100) {
			OrbGame.saveFile.kill_CEO = true;
		}else{
			OrbGame.saveFile.kill_CEO = false;
		}
		return OrbGame.saveFile.kill_CEO;
	}

	@SuppressWarnings("null")
	public boolean kill_Killionare_goal() {
		if ((int) kills_made >= 500) {
			return kill_CEO;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean kill_OohKillEm_goal() {
		if ((int) kills_made == 1000) {
			return kill_CEO;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean level_TheNewGuy_goal() {
		if ((int) level_reached == 5) {
			return level_TheNewGuy;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean level_SoISeeYouLikeToKillThings_goal() {
		if ((int) level_reached == 10) {
			return level_SoISeeYouLikeToKillThings;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean boss_DefeatBoss1_goal() {
		if ((int) boss_reached == 1) {
			return boss_DefeatBoss1;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean boss_DefeatBoss2_goal() {
		if ((int) boss_reached == 2) {
			return boss_DefeatBoss1;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean boss_DefeatBoss3_goal() {
		if ((int) boss_reached == 3) {
			return boss_DefeatBoss1;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean boss_DefeatBoss4_goal() {
		if ((int) boss_reached == 4) {
			return boss_DefeatBoss1;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean play_YouPlayedHowLong_goal() {
		if ((int) play_time == 10) {
			return play_YouPlayedHowLong;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean play_NotRPG_goal() {
		if ((int) play_time == 25) {
			return play_NotRPG;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean area_IntoTheVoid_goal() {
		if ((int) area_unlocked == 1) {
			return area_IntoTheVoid;
		}
		return (Boolean) null;
	}

	@SuppressWarnings("null")
	public boolean area_TheyCameFromWithin_goal() {
		if ((int) area_unlocked == 2) {
			return area_TheyCameFromWithin;
		}
		return (Boolean) null;
	}

	// maybe instead of having a int for the area_unlockded, perhaps a char
	// saying what area is unlocked?

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.app.log(log, "showns");

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

	}

}
