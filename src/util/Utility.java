package util;

/**
 * Utility methods.
 * 
 * @author Juan Ortiz
 */
public class Utility {

	/** Calculates the distance between 2 points. */
	public static int getDistance(int x1, int y1, int x2, int y2) {
		return (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	/**
	 * Utility method to handle resource loading failure
	 * 
	 * @param message
	 *            The message to display on failure
	 */
	public static void fail(String message) {
		// we're pretty dramatic here, if a resource isn't available
		// we dump the message and exit the game
		System.err.println(message);
		System.exit(0);
	}
}
