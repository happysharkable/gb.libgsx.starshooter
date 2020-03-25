package gb.libgsx.starshooter.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import gb.libgsx.starshooter.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture img;
    private Vector2 pos;
    private Vector2 v;
    private Vector2 direction;
    private Vector2 normalVector;
    private float toX;
    private float toY;
    private int rotation;
    private int speed = 2;

    @Override
    public void show() {
        super.show();
        img = new Texture("red_bug.png");
        pos = new Vector2();
        v = new Vector2(0f, 0f);
        direction = new Vector2(0f, 0f);
        normalVector = new Vector2(0f, 1f);
        rotation = 0;
    }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        toX = screenX - img.getWidth() / 2f;
        toY = Gdx.graphics.getHeight() - screenY - img.getHeight() / 2f;
        v.set(direction.set(toX - pos.x, toY - pos.y).nor());
        rotation = 360 - (int)direction.angle(normalVector);
        return false;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode >= 7 && keycode <= 16)
            speed = keycode - 7;

        return false;
    }

    private void update(float delta) {
        if ((int)toX == Math.round(pos.x) && (int)toY == Math.round(pos.y))
            v.set(0f, 0f);

        pos.add(v.cpy().scl(speed));
    }

    private void draw() {
        Gdx.gl.glClearColor(0.1f, 0.6f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(new TextureRegion(img), pos.x, pos.y, img.getWidth() / 2f, img.getHeight() / 2f, img.getWidth(), img.getHeight(), 1, 1, rotation);
        batch.end();
    }

}

