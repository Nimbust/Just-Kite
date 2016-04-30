package entity.player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

import entity.Entity;
import entity.MobileEntity;
import entity.Position;

public class Player extends MobileEntity {
	public final float TERMINAL_FALL_DY = .22f;

	public Player(String sprite, Position position) {
		super(sprite, position);
		this.defineControls();
		System.out.println(sprite);
	}

	/**
	 * Request that the ship move itself based on an elapsed ammount of time
	 * 
	 * @param delta
	 *            The time that has elapsed since last move (ms)
	 */
	public void move(long delta) {
		// if we're moving left and have reached the left hand side
		// of the screen, don't move
		if (position().getX() <= 0) {
			return;
		}
		// if we're moving right and have reached the right hand side
		// of the screen, don't move
		if (position().getY() >= 800) {
			return;
		}

		super.position().update(delta);
	}

	/** Defines player controls. Override it to change default controls */
	public void defineControls() {
		define("Jump", Input.KEY_SPACE);
		define("Right", Input.KEY_RIGHT, Input.KEY_D);
		define("Left", Input.KEY_LEFT, Input.KEY_A);
		define("Down", Input.KEY_DOWN);
		define("Up", Input.KEY_UP);
	}

	@Override
	public void update(GameContainer container, int ticks) {
		// Image orientates around mouse.
		double dx = container.getInput().getAbsoluteMouseX() - position().getX();
		double dy = container.getInput().getAbsoluteMouseY() - position().getY();
		double spriteAngle = Math.atan2(dy, dx);
		int cx = image.getWidth() / 2;
		int cy = image.getHeight() / 2;

		container.getGraphics().translate(cx + position().getX(), cy + position().getY());
		container.getGraphics().rotate(position().getX(), position().getY(), (float) spriteAngle);
		container.getGraphics().translate(-cx, -cy);

		/* Basic platformer controls. */
		if (container.getInput().isKeyDown(Input.KEY_A))
			this.position().x -= 0.12; // left
		if (container.getInput().isKeyDown(Input.KEY_D))
			this.position().x += 0.12; // right
		if (container.getInput().isKeyDown(Input.KEY_W))
			this.position().y -= 0.12;// up
		if (container.getInput().isKeyDown(Input.KEY_S))
			this.position().y += 0.12; // down

		/* Progressive mechanics. */
		if (container.getInput().isKeyPressed(Input.KEY_SPACE))
		{}

	}

	@Override
	public int compareTo(Entity o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
