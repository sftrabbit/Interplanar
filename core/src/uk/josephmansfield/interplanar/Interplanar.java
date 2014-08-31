package uk.josephmansfield.interplanar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.MathUtils;

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
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
        entityEngine.update(deltaTime);
        renderer.render();
	}

    @Override
    public void dispose() {
    }
}
