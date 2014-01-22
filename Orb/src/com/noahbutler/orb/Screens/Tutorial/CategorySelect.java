package com.noahbutler.orb.Screens.Tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.utils.Array;
import com.noahbutler.orb.OrbGame;
import com.noahbutler.orb.Screens.MasterScreen;
import com.noahbutler.orb.Screens.ButtonListeners.MainMenuButtonListener;

public class CategorySelect extends MasterScreen {

	private OrbGame game;

	// might make one big texture atlas
	private TextureAtlas categoryButtons;
	private Array<ImageButton> imageButtons;
	private Array<ImageButtonStyle> imageButtonsStyle;
	private Skin skin;

	private Texture background;

	private Table buttonTable;

	private SpriteBatch b;

	String log = "CS";

	public CategorySelect(OrbGame game) {
		this.game = game;

		Gdx.app.log("CS", "Started...");
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		b.begin();
		buttonTable.draw(b, 1);
		buttonTable.debug();

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Gdx.app.log(log, "showns");

		if (categoryButtons == null) {
			categoryButtons = new TextureAtlas(
					Gdx.files
							.internal("data/categoryButtons/categoryButtons.pack"));
		}

		if (b == null) {
			b = new SpriteBatch();
		}

		if (skin == null) {
			skin = new Skin();
		}

		// make skin
		for (int i = 0; i < 6 * 2; i++) {
			skin.add("skin" + i,
					new Sprite(categoryButtons.createSprite("button" + i)));
		}

		if (imageButtonsStyle == null) {
			imageButtonsStyle = new Array<ImageButtonStyle>();
		}

		// make image button styles
		for (int i = 0; i < 6; i++) {
			imageButtonsStyle.add(new ImageButtonStyle());
		}

		for (int i = 0; i < 6; i++) {
			switch (i) {
			case 0:
				imageButtonsStyle.get(i).imageUp = skin.newDrawable("skin" + i);
				imageButtonsStyle.get(i).imageDown = skin.newDrawable("skin"
						+ (i + 1));
				break;
			case 1:
				imageButtonsStyle.get(i).imageUp = skin.newDrawable("skin"
						+ (i + 1));
				imageButtonsStyle.get(i).imageDown = skin.newDrawable("skin"
						+ (i + 2));
				break;
			case 2:
				imageButtonsStyle.get(i).imageUp = skin.newDrawable("skin"
						+ (i + 2));
				imageButtonsStyle.get(i).imageDown = skin.newDrawable("skin"
						+ (i + 3));
				break;
			case 3:
				imageButtonsStyle.get(i).imageUp = skin.newDrawable("skin"
						+ (i + 3));
				imageButtonsStyle.get(i).imageDown = skin.newDrawable("skin"
						+ (i + 4));
				break;
			default:
				break;
			}
		}

		if (imageButtons == null) {
			imageButtons = new Array<ImageButton>();
		}

		// add styles and listeners to buttons
		for (int i = 0; i < 6; i++) {
			imageButtons.add(new ImageButton(imageButtonsStyle.get(i)));
			//this might need to get changed
			//imageButtons.get(i).addListener(new MainMenuButtonListener(i, screens.get(i), game));
			//needs to be after you create the image button
			imageButtons.get(i).setSize(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 3);
		}

		if (background == null) {
			// background = new
			// Texture(Gdx.files.internal("data/mainMenu/background.png"));
		}

		if (buttonTable == null) {
			buttonTable = new Table();
		}

		// add buttons to table
		buttonTable.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		buttonTable.setPosition(0, 0);
		//two per row
		buttonTable.add(imageButtons.get(0)).left();
		buttonTable.add(imageButtons.get(1)).right();
		buttonTable.row();
		buttonTable.add(imageButtons.get(2)).left();
		buttonTable.add(imageButtons.get(3)).right();
		buttonTable.row();
		buttonTable.add(imageButtons.get(4)).left();
		buttonTable.add(imageButtons.get(5)).right();

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		b.dispose();
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
