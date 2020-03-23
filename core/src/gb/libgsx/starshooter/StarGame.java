package gb.libgsx.starshooter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StarGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture background;
	TextureRegion region;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		background = new Texture("space_bcgrnd.gif");
		background.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
		//region = new TextureRegion(img, 10, 10, 150, 150);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.5f, 0.7f, 0.8f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.setColor(0.1f, 0.3f, 0.6f, 0.5f);
		batch.draw(background, 0, 0, background.getHeight(), background.getWidth(), Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
		//batch.draw(img, 0, 0);
		//batch.draw(region, 200, 200);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
