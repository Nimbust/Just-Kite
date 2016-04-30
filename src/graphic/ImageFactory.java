package graphic;

import java.util.HashMap;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * A resource manager for sprites in the game. Its often quite important how and
 * where you get your game resources from. In most cases it makes sense to have
 * a central resource loader that goes away, gets your resources and caches them
 * for future use.
 * <p>
 * [singleton]
 * <p>
 */
public class ImageFactory {
	/** The single instance of this class */
	private static ImageFactory single = new ImageFactory();

	/**
	 * Get the single instance of this class
	 * 
	 * @return The single instance of this class
	 */
	public static ImageFactory get() {
		return single;
	}

	/** The cached image map, from reference to image instance */
	private HashMap<String, Image> images = new HashMap<String, Image>();

	/**
	 * Retrieve a sprite from the store
	 * 
	 * @param ref
	 *            The reference to the image to use for the sprite
	 * @return A sprite instance containing an accelerate image of the request
	 *         reference
	 * @throws SlickException
	 */
	public Image getSprite(String ref) throws SlickException {
		// if we've already got the sprite in the cache
		// then just return the existing version
		if (images.get(ref) != null) {
			return images.get(ref);
		}
		// create a sprite, add it the cache then return it
		Image image = new Image("data/sprites/" + ref);
		images.put(ref, image);

		return image;
	}
}