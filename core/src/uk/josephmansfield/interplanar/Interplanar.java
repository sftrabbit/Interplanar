package uk.josephmansfield.interplanar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import uk.josephmansfield.interplanar.entities.CharacterEntity;
import uk.josephmansfield.interplanar.entities.systems.PhysicsSystem;
import uk.josephmansfield.interplanar.graphics.PixelatedRenderer;
import uk.josephmansfield.interplanar.graphics.Renderer;
import uk.josephmansfield.interplanar.graphics.SceneRenderer;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;

public class Interplanar extends ApplicationAdapter {

	private Engine entityEngine = new Engine();
	private PlatformerInputProcessor inputProcessor = null;
	private World physicsWorld = null;
	private Renderer renderer = null;

	private ResizeListener resizeListener = null;

	public Interplanar(PlatformerInputProcessor inputProcessor) {
		this.inputProcessor = inputProcessor;
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(inputProcessor);

		physicsWorld = new World(new Vector2(0, -30), true);

		SceneRenderer sceneRenderer = new SceneRenderer(physicsWorld);
		renderer = new PixelatedRenderer(sceneRenderer);

		entityEngine.addEntity(new CharacterEntity(physicsWorld));
		entityEngine.addSystem(new PhysicsSystem(physicsWorld));
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
		physicsWorld.dispose();
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
