package main;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import util.Stopwatch;

/** @author Juan P. Ortiz */

public final class Main extends StateBasedGame {

	public static final int CANVAS_WIDTH = 800; // width and height of the game
	public static final int CANVAS_HEIGHT = 600;
	public final static String NAME = "Just Kite";

	public Main(String name) {
		super(name);
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		this.addState(new StartMenu());
		this.addState(new World(container, 1));
	}

	public static void main(String[] args) {
		try {
			Stopwatch timer = new Stopwatch().reset();
			AppGameContainer app = new AppGameContainer(new Main(NAME + ": BETA"));
			app.setDisplayMode(CANVAS_WIDTH, CANVAS_HEIGHT, false);
			app.setIcon("/data/sprites/JIcon.png");
			app.start();
			app.setTargetFrameRate(60);
			System.out.println(NAME + "is ready.".concat(" [took " + timer.elapsed() + " ms]"));
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}
