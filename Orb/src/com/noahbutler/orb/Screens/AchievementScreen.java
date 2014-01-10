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
		} else {
			OrbGame.saveFile.kill_CEO = false;
		}
		return OrbGame.saveFile.kill_CEO;
	}

	public boolean kill_Killionare_goal() {
		if (OrbGame.saveFile.kills_made >= 500) {
			OrbGame.saveFile.kill_Killionare = true;
		} else {
			OrbGame.saveFile.kill_Killionare = false;
		}
		return OrbGame.saveFile.kill_Killionare;
	}

	public boolean kill_OohKillEm_goal() {
		if (OrbGame.saveFile.kills_made >= 1000) {
			OrbGame.saveFile.kill_OohKillEm = true;
		} else {
			OrbGame.saveFile.kill_OohKillEm = false;
		}
		return OrbGame.saveFile.kill_OohKillEm;
	}

	public boolean level_TheNewGuy_goal() {
		if (OrbGame.saveFile.level_reached >= 5) {
			OrbGame.saveFile.level_TheNewGuy = true;
		} else {
			OrbGame.saveFile.level_TheNewGuy = false;
		}
		return OrbGame.saveFile.level_TheNewGuy;
	}

	public boolean level_SoISeeYouLikeToKillThings_goal() {
		if (OrbGame.saveFile.level_reached >= 10) {
			OrbGame.saveFile.level_SoISeeYouLikeToKillThings = true;
		} else {
			OrbGame.saveFile.level_SoISeeYouLikeToKillThings = false;
		}
		return OrbGame.saveFile.level_SoISeeYouLikeToKillThings;
	}

	public boolean boss_DefeatBoss1_goal() {
		if (OrbGame.saveFile.boss_reached >= 1) {
			OrbGame.saveFile.boss_DefeatBoss1 = true;
			;
		} else {
			OrbGame.saveFile.boss_DefeatBoss1 = false;
		}
		return OrbGame.saveFile.boss_DefeatBoss1;
	}

	public boolean boss_DefeatBoss2_goal() {
		if (OrbGame.saveFile.boss_reached >= 2) {
			OrbGame.saveFile.boss_DefeatBoss2 = true;
		} else {
			OrbGame.saveFile.boss_DefeatBoss2 = false;
		}
		return OrbGame.saveFile.boss_DefeatBoss2;
	}

	public boolean boss_DefeatBoss3_goal() {
		if (OrbGame.saveFile.boss_reached >= 3) {
			OrbGame.saveFile.boss_DefeatBoss3 = true;
		} else {
			OrbGame.saveFile.boss_DefeatBoss3 = false;
		}
		return OrbGame.saveFile.boss_DefeatBoss3;
	}

	public boolean boss_DefeatBoss4_goal() {
		if (OrbGame.saveFile.boss_reached >= 4) {
			OrbGame.saveFile.boss_DefeatBoss4 = true;
		} else {
			OrbGame.saveFile.boss_DefeatBoss4 = false;
		}
		return OrbGame.saveFile.boss_DefeatBoss4;
	}

	public boolean play_YouPlayedHowLong_goal() {
		if (OrbGame.saveFile.play_time >= 10) {
			OrbGame.saveFile.play_YouPlayedHowLong = true;
		} else {
			OrbGame.saveFile.play_YouPlayedHowLong = false;
		}
		return OrbGame.saveFile.play_YouPlayedHowLong;
	}

	public boolean play_NotRPG_goal() {
		if (OrbGame.saveFile.play_time >= 25) {
			OrbGame.saveFile.play_NotRPG = true;
		} else {
			OrbGame.saveFile.play_NotRPG = false;
		}
		return OrbGame.saveFile.play_NotRPG;
	}

	public boolean area_IntoTheVoid_goal() {
		if (OrbGame.saveFile.area_unlocked >= 1) {
			OrbGame.saveFile.area_IntoTheVoid = true;
		} else {
			OrbGame.saveFile.area_IntoTheVoid = false;
		}
		return OrbGame.saveFile.area_IntoTheVoid;
	}

	public boolean area_TheyCameFromWithin_goal() {
		if (OrbGame.saveFile.area_unlocked >= 2) {
			OrbGame.saveFile.area_TheyCameFromWithin = true;
		} else {
			OrbGame.saveFile.area_TheyCameFromWithin = false;
		}
		return OrbGame.saveFile.area_TheyCameFromWithin;
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
