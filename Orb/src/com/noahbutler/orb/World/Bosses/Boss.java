package com.noahbutler.orb.World.Bosses;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.World.Entity;
import com.noahbutler.orb.World.World;

public class Boss extends Entity {
	private int type;
	private boolean canBeDeleted;
	private int health;

	private Texture texture;

	private int shield;
	private int weakness;
	private World world;
	public Sprite sprite;

	public class Boss1 extends Boss {

		public Boss1(int type, World world) {
			super(type, world);
			// TODO Auto-generated constructor stub
		}

	}

	public Boss(int type, World world) {
		this.type = type;
		this.world = world;
		this.health = 100;
		texture = new Texture(Gdx.files.internal(""));
		sprite = new Sprite(texture);
	}

	public void render(SpriteBatch b) {
		sprite.setPosition(getPosition().x - sprite.getWidth() / 2,
				getPosition().y - sprite.getHeight() / 2);
		sprite.draw(b);
	}

	public int getType() {
		return this.type;
	}

	public void bulletToBoss(String isBullet) {
		try {
			int BulletNum = Integer.parseInt(isBullet);
			if (BulletNum >= 1) {
				health -= 90;
			}
			if (BulletNum >= 2) {
				health -= 80;
			}
			if (BulletNum >= 3) {
				health -= 70;
			}
			if (BulletNum >= 4) {
				health -= 60;
			}
			if (BulletNum >= 5) {
				health -= 50;
			}
			if (BulletNum >= 6) {
				health -= 40;
			}
			if (BulletNum >= 7) {
				health -= 30;
			}
			if (BulletNum >= 8) {
				health -= 20;
			}
			if (BulletNum >= 9) {
				health -= 10;
			} else {
				health -= 100;
			}
			if (health <= 0) {
				OrbGame.saveFile.score += 1;
				Gdx.app.log("Score", "Score: " + OrbGame.saveFile.score);
			}
			Gdx.app.log("Boss Killed", "You have defeated the boss");
		} catch (NumberFormatException nfe) {
			// not a bullet, ground, or ship
		}

	}

	public String getCheckDeletable() {
		if (health <= 0) {
			return "yes";
		}
		return "no";
	}
}
