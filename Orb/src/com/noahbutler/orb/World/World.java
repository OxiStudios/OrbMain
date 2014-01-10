package com.noahbutler.orb.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.World.Input.Input;
import com.noahbutler.orb.World.Orbs.EndlessOrbCreator;
import com.noahbutler.orb.World.Orbs.OrbCreator;
import com.noahbutler.orb.World.Orbs.OrbRenderer;
import com.noahbutler.orb.World.Orbs.Orbs;
import com.noahbutler.orb.World.Ship.Bullet;
import com.noahbutler.orb.World.Ship.MainShip;

/**
 * 
 * @author Noah Butler
 * 
 * Main class that brings all the
 * elements of the game together
 * 
 * Nice to have this so we dont have to
 * write it all in the game screen class.
 * This just get created in the game class
 * calls this render method inside of its 
 * render method.
 *
 */

public class World {
	
	private static final float SCALING_FACTOR = .05f;
	
	SpriteBatch mainBatch;
	OrthographicCamera camera;
	Physics physics;
	
	MainShip ship;
	private OrbCreator orbCreator;
	private EndlessOrbCreator endlessOrbCreator;
	private OrbRenderer orbRenderer;
	public Array<Orbs> orbs;
	private Backgrounds background;
	BitmapFont words;
	
	public boolean canfire;
	
	/**
	 * 
	 * @param endless
	 * 
	 */
	public World(boolean endless) {
		Gdx.input.setInputProcessor(new Input(this));
		
		camera     = new OrthographicCamera();
		mainBatch  = new SpriteBatch();
		physics    = new Physics(this.camera, this);
		
		background  = new Backgrounds();
		orbRenderer = new OrbRenderer();
		orbs        = new Array<Orbs>();
		words       = new BitmapFont();
		words.setColor(new Color(100,100,100,1));
		
		if(endless) {
			endlessOrbCreator = new EndlessOrbCreator(this);
		}else{
//			orbCreator = new OrbCreator(15, this); //not currently working. Because of the use of Random
		}
		
		createBounds();
		createNewPlayer();
	}
	
	
	
	public void render(float delta) {
		endlessOrbCreator.create();
		physics.step(delta);
		
		mainBatch.begin();
		ship.render(mainBatch);
		orbRenderer.render(mainBatch, orbs);
		words.draw(mainBatch, "Score: " + OrbGame.saveFile.score, Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		mainBatch.end();
		
		camera.update();
	}
	
	public void update() {
		
	}
	
	public void resize(int width, int height) {
		physics.resize(width, height);
	}
	
	public void dispose() {
		
	}
	
	//gets used in physics class
	public Array<Bullet> getBulletObjectList() {
		return ship.getBulletObjectList();
	}
	
	//gets used in Gun class
	public Array<Body> getBulletBodyList() {
		return physics.bulletBodies;
	}
	
	//gets used in OrbCreator
	public void addOrbToPhysicsWorld(Vector2 position, Orbs orb) {
		physics.addOrb(position, orb);
	}
	
	//get Used in Input
	public void addBulletToPhysicsBullet(Vector2 position, Bullet bullet) {
		physics.addBullet(position, bullet);
	}
	
	//gets Used as the bullet's position in Input
	public Vector2 getShipPosition() {
		return physics.getShipPosition();
	}
	
	public void addOrbForRendering(Orbs orb) {
		orbs.add(orb);
	}
	
	public void deleteOrbObj(Orbs orb) {
		orbs.removeValue(orb, true);
		orb.sprite = null;
		orb = null;
	}
	
	private void createNewPlayer() {
		ship = new MainShip(this);
		physics.addShip(ship);
	}
	
	//needs to be switched to ratios so it fits on all screens.
	private void createBounds() {
        physics.addBounds(new Vector2(0, -35), 20, 1, new Bounds());
        physics.addBounds(new Vector2(0, 35), 20, 1, new Bounds());
        physics.addBounds(new Vector2(-20 , 0), 1, 35, new Bounds());
        physics.addBounds(new Vector2(20, 0), 1, 35, new Bounds());
	}

}
