package entity;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;

public class MobileEntity extends Entity {

	/** speed vector (x,y) **/
	public Vector2f speed = new Vector2f(0, 0);

	/** acceleration vector (x,y) **/
	public Vector2f acceleration = new Vector2f(0, 0);

	public Vector2f friction = new Vector2f(0.5f, 0.5f);

	/** height of a slope a PhysicsEntity can run up */
	public int slopeHeight = 1;

	public static final float GRAVITY = .02f;

	public MobileEntity(String sprite, Position position) {
		super(sprite, position);
	}

	@Override
	public void update(GameContainer container, int ticks) {
		// set acceleration to nothing
		acceleration.x = 0;
	}

	/**
	 * Increases this entity's vertical speed, based on its gravity (gravity)
	 * 
	 * @return void
	 */
	void applyGravity() {
		// increase velocity/speed based on gravity
		this.position().dy += GRAVITY;
	}

	/**
	 * Slows this entity down, according to its friction (friction.x,
	 * friction.y)
	 * 
	 * @param mx
	 *            Include horizontal movement
	 * @param vertical
	 *            Include vertical movement
	 * @return void
	 */
	// TODO Include vertical friction.
	public void friction(boolean horizontal, boolean vertical) {
		// if we should use friction, horizontally
		if (horizontal) {
			// speed > 0, then slow down
			if (position().dx > 0) {
				position().dx -= friction.x;
				// if we go below 0, stop.
				if (position().dx < 0) {
					position().dx = 0;
				}
			}
			// speed < 0, then "speed up" (in a sense)
			if (position().dx < 0) {
				position().dx += friction.x;
				// if we go above 0, stop.
				if (position().dx > 0) {
					position().dx = 0;
				}
			}
		}

	}

	@Override
	public int compareTo(Entity o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
