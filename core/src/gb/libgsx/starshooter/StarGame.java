package gb.libgsx.starshooter;

import com.badlogic.gdx.Game;

import gb.libgsx.starshooter.screen.MenuScreen;

public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
