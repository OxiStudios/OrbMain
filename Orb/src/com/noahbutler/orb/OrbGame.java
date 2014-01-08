package com.noahbutler.orb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.utils.Array;
import com.noahbutler.orb.Screens.AchievementScreen;
import com.noahbutler.orb.Screens.GunUpgradeScreen;
import com.noahbutler.orb.Screens.MainMenuScreen;
import com.noahbutler.orb.Screens.MasterScreen;
import com.noahbutler.orb.Screens.OptionScreen;
import com.noahbutler.orb.Screens.OrbGameScreen;
import com.noahbutler.orb.Screens.ShipUpgradeScreen;
import com.noahbutler.orb.Screens.TutorialScreen;
import com.noahbutler.orb.Screens.LevelSelection.LevelDesertSelection;
import com.noahbutler.orb.Screens.LevelSelection.LevelPlanetSelection;
import com.noahbutler.orb.Screens.LevelSelection.LevelSelectScreen;
import com.noahbutler.orb.Screens.LevelSelection.LevelSpaceSelection;

/**
 * 
 * @author Noah Butler
 * 
 * This is the main Game class that runs everything
 * To break the different parts of the game up like
 * the menus and game we use screens, the screen of the
 * game can be switched whenever we please by calling
 * OrbGame.setScreen()
 * 
 * In android this class in most related to the Activity Class
 *
 */

public class OrbGame extends Game {
	
	private MainMenuScreen mainMenuScreen;
	private TutorialScreen tutorialScreen;
	private AchievementScreen achievementScreen;
	private OrbGameScreen gameScreen;
	private LevelSelectScreen levelSelectScreen;
	private OptionScreen optionScreen;
	
	private LevelDesertSelection levelDesertSelectionScreen;
	private LevelPlanetSelection levelPlanetSelectionScreen;
	private LevelSpaceSelection levelSpaceSelectionScreen;
	
	private ShipUpgradeScreen shipUpgradeScreen;
	private GunUpgradeScreen gunUpgradeScreen;
	
	private Array<MasterScreen> screens;
	private Array<MasterScreen> levelScreens;
	
	private MainAssetLoader assetLoader;
	
	@Override
	public void create() {
		screens      = new Array<MasterScreen>();
		levelScreens = new Array<MasterScreen>();
		
		gameScreen = new OrbGameScreen();
		
		levelDesertSelectionScreen = new LevelDesertSelection();
		levelPlanetSelectionScreen = new LevelPlanetSelection();
		levelSpaceSelectionScreen  = new LevelSpaceSelection();
		
		achievementScreen = new AchievementScreen();
		tutorialScreen    = new TutorialScreen();
		optionScreen      = new OptionScreen();
		
		shipUpgradeScreen = new ShipUpgradeScreen();
		gunUpgradeScreen  = new GunUpgradeScreen();
		
		screens.add(levelSelectScreen);
		screens.add(optionScreen);
		screens.add(tutorialScreen);
		screens.add(achievementScreen);
		
		levelScreens.add(levelDesertSelectionScreen);
		levelScreens.add(levelPlanetSelectionScreen);
		levelScreens.add(levelSpaceSelectionScreen);
		
		levelSelectScreen = new LevelSelectScreen(this, levelScreens);
		mainMenuScreen = new MainMenuScreen(this, screens);
		
		assetLoader = new MainAssetLoader();
		
		//set screen for testing for now, this
		//will get changed to loading screen
		//when the game is done.
		setScreen(gameScreen);
	}

	@Override
	public void dispose() {
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	public MainAssetLoader getAssetLoader() {
		return this.assetLoader;
	}
}
