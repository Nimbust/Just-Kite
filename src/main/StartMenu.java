package main;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 * The start menu for our platformer.
 * 
 * @author Juan Ortiz
 */
public class StartMenu extends BasicGameState {

	/** The index of the selected option */
	private int selected;

	@Override
	public void init(GameContainer container, StateBasedGame game) throws SlickException {
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
		g.setColor(Color.white);
		g.drawString(Main.NAME, 350, 100);

		for (Menu m : Menu.values()) {
			g.drawString(m.name(), 100, 200 + (m.ordinal() * 30));
			if (selected == m.ordinal()) {
				// Change the size of the rectangle based on the length of the
				// name of the option
				g.drawRect(95, 190 + (m.ordinal() * 30), m.name().length() * 12, 30);
			}
		}

	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int ticks) throws SlickException {
		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			selected++;
			if (selected >= Menu.values().length) {
				selected = 0;
			}
		}
		if (input.isKeyPressed(Input.KEY_UP)) {
			selected--;
			if (selected < 0) {
				selected = Menu.values().length - 1;
			}
		}
		if (input.isKeyPressed(Input.KEY_ENTER)) {
			System.out.println("Selected: " + selected);
			switch (selected) {
			case 0:
				game.enterState(1);
				break;
			case 3:
				System.exit(0);
			default:
				return;
			}
		}

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	/** A list of menu options. */
	private enum Menu {
		/** Starts a new instance of the game */
		START_GAME,
		/** Opens the options submenu for graphical */
		OPTIONS,
		/** View the list of achievements completed */
		ACHIEVEMENTS,
		/** Exits the application. */
		EXIT;
	}
}
