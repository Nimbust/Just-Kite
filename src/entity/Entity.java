package entity;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import graphic.ImageFactory;

/**
 * An entity represents any element that appears in the game. The entity is
 * responsible for resolving collisions and movement based on a set of
 * properties defined either by subclass or externally.
 */
public abstract class Entity implements Comparable<Entity> {
	/** The current position (x,y) of this entity */
	private Position position;
	/** The sprite that represents this entity */
	protected Image image;

	/** The rectangle used for this entity during collisions resolution */
	private Rectangle me = new Rectangle(0, 0, 0, 0);
	/** The rectangle used for other entities during collision resolution */
	private Rectangle him = new Rectangle(0, 0, 0, 0);

	/** Map of input commands. */
	public Map<String, int[]> controls = new HashMap<String, int[]>();

	public Map<String, Animation> animations = new HashMap<String, Animation>();

	/** Return true if this entity is dead. */
	public boolean isDead = false;
	/** Return true if this entity is currently on a surface. */
	public boolean isOnSurface = false;

	/**
	 * Construct a entity based on a sprite image and a location.
	 * 
	 * @param ref
	 *            The reference to the image to be displayed for this entity
	 * @param x
	 *            The initial x location of this entity
	 * @param y
	 *            The initial y location of this entity
	 */
	public Entity(String image, Position position) {
		try {
			this.image = ImageFactory.get().getSprite(image);
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.position = position;
	}

	/**
	 * Draw this entity to the graphics context provided
	 * 
	 * @param g
	 *            The graphics context on which to draw
	 */
	public void draw(Graphics g) {
		image.drawCentered(position.getX(), position.getY());
	}

	/**
	 * Define commands to handle inputs
	 * 
	 * @param command
	 *            name of the command
	 * @param keys
	 *            keys or mouse input from {@link Input} class
	 */
	public void define(String command, int... keys) {
		controls.put(command, keys);
	}

	/**
	 * Check if a command is pressed
	 */
	// public boolean isPressed(String command) {
	// if (!controls.containsKey(command))
	// return false;
	//
	// int[] checked = controls.get(command);
	// Input input = world.container.getInput();
	// for (int i = 0; i < checked.length; i++) {
	// if (input.isKeyPressed(checked[i])) {
	// return true;
	// } else if (checked[i] == Input.MOUSE_LEFT_BUTTON
	// || checked[i] == Input.MOUSE_RIGHT_BUTTON) {
	// if (input.isMousePressed(checked[i])) {
	// return true;
	// }
	// }
	// }
	// return false;
	// }

	/**
	 * Do the action associated with this entity. This method will be called
	 * periodically based on game events
	 */
	public abstract void update(GameContainer container, int ticks);

	/**
	 * Check if this entity collised with another.
	 * 
	 * @param other
	 *            The other entity to check collision against
	 * @return True if the entities collide with each other
	 */
	public boolean intersects(Entity other) {
		return me.intersects(him);
	}

	/** @return This entity's current position. */
	public Position position() {
		return position;
	}

	@Override
	public String toString() {
		return "Entity: " + this.position.getX() + " , " + this.position.getY();

	}

}