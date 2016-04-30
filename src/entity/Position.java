package entity;

/**
 * Note that doubles are used for positions. This may seem strange given that
 * pixels locations are integers. However, using double means that an entity can
 * move a partial pixel. It doesn't of course mean that they will be display
 * half way through a pixel but allows us not lose accuracy as we move.
 * 
 * @author Juan P. Ortiz
 */

public class Position {
	/** The current x location of this entity */
	public double x;
	/** The current y location of this entity */
	public double y;
	/** The current horizontal velocity of this entity (pixels/second) */
	public double dx;
	/** The current vertical velocity of this entity (pixels/second) */
	public double dy;

	public Position(double x, double y) {
		this.x = x;
		this.y = y;
		this.dx = 0;
		this.dy = 0;
	}

	/**
	 * Request that this entity move itself based on a certain amount of time
	 * passing.
	 * 
	 * @param delta
	 *            The amount of time that has passed in milliseconds
	 */
	public void update(long delta) {

		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;
	}

	/**
	 * Moves this position by the argued amounts.
	 * 
	 * @param amountX
	 *            the amount to move the <code>x</code> coordinate.
	 * @param amountY
	 *            the amount to move the <code>y</code> coordinate.
	 * @return this position with the new coordinates.
	 */
	public Position move(int amountX, int amountY) {
		this.x += amountX;
		this.y += amountY;
		return this;
	}

	/**
	 * Moves this position to the given position.
	 * 
	 * @param x
	 *            the <code>x</code> coordinate.
	 * @param y
	 *            the <code>y</code> coordinate.
	 * @return this position with the new coordinates.
	 */
	public Position moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}

	@Override
	public Position clone() {
		return new Position(this.x, this.y);
	}

	/**
	 * Gets the x location of this entity
	 * 
	 * @return The x location of this entity
	 */
	public int getX() {
		return (int) x;
	}

	/**
	 * Sets the <code>x</code> coordinate.
	 * 
	 * @param x
	 *            : The <code>x</code> coordinate.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Get the y location of this entity
	 * 
	 * @return The y location of this entity
	 */
	public int getY() {
		return (int) y;
	}

	/**
	 * Sets the <code>y</code> coordinate.
	 * 
	 * @param x
	 *            : The <code>y</code> coordinate.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Checks if this position is within distance of another position.
	 * 
	 * @param position
	 *            the position to check the distance for.
	 * @param distance
	 *            the distance to check.
	 * @return true if this position is within the distance of another position.
	 */
	public boolean isWithinDistance(Position position, int distance) {
		return Math.abs(position.getX() - this.getX()) <= distance
				&& Math.abs(position.getY() - this.getY()) <= distance;
	}

	@Override
	public String toString() {
		return "Position : (" + (int) x + ", " + (int) y + ")";
	}

}
