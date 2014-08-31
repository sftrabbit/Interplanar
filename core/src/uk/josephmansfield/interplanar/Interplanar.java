package uk.josephmansfield.interplanar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class Interplanar extends ApplicationAdapter {

    private Engine entityEngine = new Engine();
    private Renderer renderer = new Renderer();
    private InputHandler inputHandler = new InputHandler();

	@Override
	public void create() {
        Gdx.input.setInputProcessor(inputHandler);
	}

    @Override
    public void resize(int width, int height) {
    }

	@Override
	public void render() {
        renderer.render();
	}

    @Override
    public void dispose() {
    }
}
