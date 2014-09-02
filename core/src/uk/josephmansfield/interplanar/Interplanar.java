package uk.josephmansfield.interplanar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import uk.josephmansfield.interplanar.graphics.PixelatedRenderer;
import uk.josephmansfield.interplanar.graphics.Renderer;
import uk.josephmansfield.interplanar.graphics.SceneRenderer;
import uk.josephmansfield.interplanar.input.PlatformerInputAdapter;

public class Interplanar extends ApplicationAdapter {

	private Engine entityEngine = new Engine();
	private PlatformerInputAdapter inputProcessor = null;
	private Renderer renderer = null;
	private ResizeListener resizeListener = null;

	private PlatformerInputAdapter.InputState.MovementDirection movementDirection = PlatformerInputAdapter.InputState.MovementDirection.MOVEMENT_NONE;
	private boolean jumping = false;

	public Interplanar(PlatformerInputAdapter inputProcessor) {
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

		notifyResizeListener(width, height);
	}

	@Override
	public void render() {
		float deltaTime = Math.min(Gdx.graphics.getDeltaTime(), 1 / 60f);
		entityEngine.update(deltaTime);
		renderer.render();
	}

	@Override
	public void dispose() {
		renderer.dispose();
	}

	public void setResizeListener(ResizeListener resizeListener) {
		this.resizeListener = resizeListener;
	}

	private void notifyResizeListener(int width, int height) {
		if (resizeListener != null) {
			resizeListener.onResize(width, height);
		}
	}

	public static interface ResizeListener {
		public void onResize(int width, int height);
	}
}
