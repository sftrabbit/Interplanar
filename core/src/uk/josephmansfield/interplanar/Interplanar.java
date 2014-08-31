package uk.josephmansfield.interplanar;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Interplanar extends ApplicationAdapter {
	@Override
	public void create() {
	}

    @Override
    public void resize(int width, int height) {
    }

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}

    @Override
    public void dispose() {
    }
}
