package com.noahbutler.orb.World;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.JointEdge;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.noahbutler.orb.World.Orbs.Orbs;
import com.noahbutler.orb.World.Ship.Bullet;
import com.noahbutler.orb.World.Ship.MainShip;

public class Physics {
	
	private static final float BOX_STEP = 1/60f;
	private static final int  BOX_VELOCITY_ITERATIONS = 6;
	private static final int BOX_POSITION_ITERATIONS = 2;
	private float accumulator;

	public World world;
	private Box2DDebugRenderer debug;
	private OrthographicCamera camera;
	private static final float SCALING_FACTOR = .05f;
	
	public Array<Body> bulletBodies;
	public Array<Body> orbBodies;
	public Array<Body> bounds;
	
	private Array<Body> deletableBodies;
	private com.noahbutler.orb.World.World gameWorld;
	
	private Body shipBody;
	
	public Physics(OrthographicCamera camera, com.noahbutler.orb.World.World gameWorld) {
		this.gameWorld = gameWorld;
		this.camera = camera;
		createWorld();
	}
	
	private void createWorld() {
        Vector2 gravity = new Vector2(0, 0);
        world           = new World(gravity, true);
        debug           = new Box2DDebugRenderer();
        
        bulletBodies   = new Array<Body>();
        orbBodies      = new Array<Body>();
        bounds         = new Array<Body>();
        
        deletableBodies = new Array<Body>();
        
        createCollisionListener();
    }
	
	public void step(float delta) {
		float xAccel = -Gdx.input.getAccelerometerX(); //get the x position of the accelerometer
		shipBody.setLinearVelocity(xAccel * 10.0f, 0); //set a velocity for the ship body a according to the position of the accelerometer
		//update object
		updateObjects();
		//step and body deletion
		accumulator += delta;
		while(accumulator > BOX_STEP) {
			world.step(BOX_STEP, BOX_VELOCITY_ITERATIONS, BOX_POSITION_ITERATIONS);
			accumulator -= BOX_STEP;
		}
		//safe to remove
		removeDeadBodies();
		//so I can see the bodies
		debug.render(world, camera.combined);
	}
	
	public void addOrb(Vector2 position, Orbs orb) {

		//make the shape of the body of fixture could be made in constructor, same for every orb
		PolygonShape orbShape = new PolygonShape();
		orbShape.setAsBox(1.5f, 1.5f);
		
		//make a body to add to the world, could use the same object each time
		BodyDef orbBodyDef = new BodyDef();
		orbBodyDef.type = BodyType.DynamicBody;
		orbBodyDef.position.set(position);
		
		//add bodydef to a world body
		Body orbBody = world.createBody(orbBodyDef);
		
		//add fixture to orbFixture and shape to it
		FixtureDef orbFixture = new FixtureDef();
		orbFixture.shape = orbShape;
		
		//add fixture to the world body
		orbBody.createFixture(orbFixture);
		
		//add body to list for position updating and collision detection
		orbBodies.add(orbBody);
		
		//add speed
		orbBody.setLinearVelocity(0, -8.0f);
		
		//dispose uneeded shape
		orbShape.dispose();
		
		//add user data
		orbBody.setUserData(orb);
	}
	
	public void addBullet(Vector2 position, Bullet bullet) {
		
		//make the shape of the body of fixture could be made in constructor, same for every bullet
		PolygonShape bulletShape = new PolygonShape();
		bulletShape.setAsBox(.5f, .75f);
		
		//make a body to add to the world
		BodyDef bulletBodyDef = new BodyDef();
		bulletBodyDef.type = BodyType.DynamicBody; //not sure this is the right body type
		bulletBodyDef.position.set(position); //still need to convert correctly
		
		//add bodydef to a world body, this is where it will probably add to the arraylist
		Body bulletBody = world.createBody(bulletBodyDef);
		
		//make a fixture for the body and shape to it
		FixtureDef bulletFixture = new FixtureDef();
		bulletFixture.shape = bulletShape;
		
		//add fixture to the world body 
		bulletBody.createFixture(bulletFixture);
		
		//add speed
		bulletBody.setLinearVelocity(0.0f, 30.0f);
		
		//add body's userdata
		bulletBody.setUserData(bullet);
		
		//add body to list for position updating and collision detection
		bulletBodies.add(bulletBody);
		
		//delete uneeded shape
		bulletShape.dispose();
	}
	
	public void addShip(MainShip ship) {
		//starting position
		Vector2 position = new Vector2(0, -25);
		
		//make the shape of the body of fixture could be made in constructor, same for every bullet
		PolygonShape shipShape = new PolygonShape();
		shipShape.setAsBox(2f, 3f);
		
		//make a body to add to the world
		BodyDef shipBodyDef = new BodyDef();
		shipBodyDef.type = BodyType.DynamicBody; //not sure this is the right body type
		shipBodyDef.position.set(position); //still need to convert correctly
		
		//add bodydef to a world body
		shipBody = world.createBody(shipBodyDef);
		
		//make a fixture for the body and shape to it
		FixtureDef shipFixture = new FixtureDef();
		shipFixture.shape = shipShape;
		
		//add fixture to the world body
		shipBody.createFixture(shipFixture);
		shipShape.dispose();
		
		shipBody.setUserData(ship);
				
	}
	
	public void addBounds(Vector2 position, float xSize, float ySize, Bounds newBounds) {
		PolygonShape groundShape = new PolygonShape();
        groundShape.setAsBox(xSize, ySize);
        BodyDef groundBodyDef = new BodyDef();
        groundBodyDef.type = BodyType.StaticBody;
        groundBodyDef.position.set(position);
        Body groundBody = world.createBody(groundBodyDef);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = groundShape;
        groundBody.createFixture(fixtureDef);
        bounds.add(groundBody);
        
        groundBody.setUserData(newBounds);
        
        groundShape.dispose();
	}
	
	public void createCollisionListener() {
		world.setContactListener(new ContactListener() {
			
			@Override
			public void preSolve(Contact contact, Manifold oldManifold) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void postSolve(Contact contact, ContactImpulse impulse) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void endContact(Contact contact) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void beginContact(Contact contact) {
				// TODO Auto-generated method stub

				Body bodyA = contact.getFixtureA().getBody();
				Body bodyB = contact.getFixtureB().getBody();
				Entity eA = (Entity) bodyA.getUserData();
				Entity eB = (Entity) bodyB.getUserData();
				
				//bodyA might be an orb and bodyB might be a bullet
				eA.startContact(eB.getIsBullet());
				
				//bodyB might be an orb and bodyA might be a bullet
				eB.startContact(eA.getIsBullet());
				
				//might bodyA is a bullet or an orb
				if(eA.getCheckDeletable() == "yes") {
					//bodyA is a bullet or an orb
					deletableBodies.add(bodyA);
				}
				
				//might bodyB is a bullet or an orb
				if(eB.getCheckDeletable() == "yes") {
					//bodyB is a bullet or an orb
					deletableBodies.add(bodyB);
				}
				
				Gdx.app.log("Contact", "fixtureA has made contact with fixtureB");
			}
		});
	}
	
	private void removeDeadBodies() {
		for(int i = 0; i < deletableBodies.size; i++) {
			Body body = deletableBodies.get(i);
			if(!world.isLocked() && body != null) {
				removeBodySafely(body);
				deletableBodies.removeIndex(i);
			}
		}
	}
	
	private void removeBodySafely(Body body) {
		final ArrayList<JointEdge> list = body.getJointList();
		while(list.size() > 0) {
			world.destroyJoint(list.get(0).joint);
		}
		
		world.destroyBody(body);
	}
	
	private void updateObjects() {
		//bodies are the parents
		//update the objects with the bodies vector2
		
	}
	
	public void resize(int width, int height) {
        float cameraWidth = Gdx.graphics.getWidth() * SCALING_FACTOR;
        float cameraHeight = Gdx.graphics.getHeight() * SCALING_FACTOR;
        camera.setToOrtho(false, cameraWidth, cameraHeight);
        camera.position.set(0, 0, 0);
    }
	
	//Get position for bullet creation
	public Vector2 getShipPosition() {
		return new Vector2 (shipBody.getTransform().getPosition().x, shipBody.getTransform().getPosition().y + 4.0f);
	}
}
