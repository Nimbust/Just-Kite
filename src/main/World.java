package main;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import entity.Entity;
import entity.Position;
import entity.player.Player;
import graphic.Camera;
import graphic.ImageFactory;

/**
 * A World consists of the total space available to the player during the course
 * of completing a list of objectives as well as obsticles preventing the
 * completion.
 * 
 * @author Juan Ortiz
 */
public class World extends BasicGameState {

	/** The container for this instanced world. */
	protected GameContainer container;

	/** This {@link World}'s map, consisting of its terrain tiles. */
	public TiledMap map;

	/** The player's view of this world. */
	protected Camera camera;

	/** The main controller for this world. */
	public Player player;

	/** The identifier for this world. */
	public int id;

	/** The list of every {@link Entity} that exist in our game */
	public static ArrayList<Entity> entities = new ArrayList<Entity>();

	/** The world and/or level that the game is currently in. */
	public World(GameContainer container, int id) {
		this.id = id;
		this.container = container;

	}

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException, NullPointerException {
		this.container = container;
		container.setMouseCursor(ImageFactory.get().getSprite("CrosshairA.png "), 0, 0);

		// Create a camera, centred and with the player at the bottom
		this.player = new Player("FightStance.png", new Position(100, 100));
		this.camera = new Camera(this, player);
		entities.add(player);
		// this.map = new TiledMap(null);
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException {
		graphics.setBackground(Color.lightGray);
		container.setAlwaysRender(true);
		/** TODO Render score and weapon loadout. */

		// int cam_tile_x = (int) camera.getLeft() / map.getTileWidth();
		// int cam_offset_x = (int) camera.getLeft() % map.getTileWidth();
		// int cam_tile_y = (int) camera.getTop() / map.getTileHeight();
		// int cam_offset_y = (int) camera.getTop() % map.getTileHeight();
		// Render w+1 x h+1 tiles (where w and h are 12x9; add one tile extra
		// to account for the negative offset).
		// map.render(-cam_offset_x, -cam_offset_y, cam_tile_x, cam_tile_y,
		// getScreenTileWidth() + 1, getScreenTileHeight() + 1);

		for (Entity entity : entities) {
			entity.draw(graphics);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {

		game.mouseMoved(container.getInput().getMouseX(), container.getInput().getMouseY(),
				container.getInput().getMouseX(), container.getInput().getMouseY());
		// update camera for the player
		if (camera != null)
			camera.update(delta);

		// Game loop for all entities.
		for (Entity entity : entities) {
			entity.update(container, delta);
			entity.position().update(delta);
		}

	}

	/**
	 * Get the width of the screen in tiles, rounding up. For a width of 800
	 * pixels and a tilewidth of 72, this is 12.
	 */
	int getScreenTileWidth() {
		return (Main.CANVAS_WIDTH / map.getTileWidth()) + 1;
	}

	/**
	 * Get the height of the screen in tiles, rounding up. For a height of 600
	 * pixels and a tileheight of 72, this is 9.
	 */
	int getScreenTileHeight() {
		return (Main.CANVAS_HEIGHT / map.getTileHeight()) + 1;
	}

	@Override
	public int getID() {
		return id;
	}

}
