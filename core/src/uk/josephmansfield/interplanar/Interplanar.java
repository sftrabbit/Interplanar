package uk.josephmansfield.interplanar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class Interplanar extends ApplicationAdapter {

    private Engine entityEngine = new Engine();
    private InputProcessor inputProcessor = null;
    private Renderer renderer = null;

    public Interplanar(InputProcessor inputProcessor) {
        this.inputProcessor = inputProcessor;
    }

	@Override
	public void create() {
        renderer = new PixelatedRenderer(new SceneRenderer());
        Gdx.input.setInputProcessor(inputProcessor);
	}

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);
    }

	@Override
	public void render() {
        float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1/60f);
        entityEngine.update(deltaTime);
        renderer.render();
	}

    @Override
    public void dispose() {
        renderer.dispose();
    }
}
