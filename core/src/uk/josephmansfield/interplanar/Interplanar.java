/*
 * Copyright (c) Joseph Mansfield
 *
 * This file is part of Interplanar.
 *
 * Interplanar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Interplanar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Interplanar.  If not, see <http://www.gnu.org/licenses/>.
 */

package uk.josephmansfield.interplanar;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import uk.josephmansfield.interplanar.entities.CharacterEntity;
import uk.josephmansfield.interplanar.entities.systems.InputSystem;
import uk.josephmansfield.interplanar.entities.systems.PhysicsSystem;
import uk.josephmansfield.interplanar.graphics.PixelatedRenderer;
import uk.josephmansfield.interplanar.graphics.Renderer;
import uk.josephmansfield.interplanar.graphics.SceneRenderer;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;

public class Interplanar extends ApplicationAdapter {

	private PlatformerInputProcessor inputProcessor;
	private World physicsWorld;
	private Engine entityEngine;
	private Renderer renderer;

	private ResizeListener resizeListener;

	public Interplanar(PlatformerInputProcessor inputProcessor) {
		this.inputProcessor = inputProcessor;
	}

	@Override
	public void create() {
		Gdx.input.setInputProcessor(inputProcessor);

		physicsWorld = new World(new Vector2(0, -30), true);

		entityEngine = new Engine();
		entityEngine.addEntity(new CharacterEntity(physicsWorld));
		entityEngine.addSystem(new PhysicsSystem(physicsWorld));
		entityEngine.addSystem(new InputSystem(inputProcessor));

		SceneRenderer sceneRenderer = new SceneRenderer(physicsWorld);
		renderer = new PixelatedRenderer(sceneRenderer);

		Level level = Level.fromMapPath("levels/level0.tmx");
		level.populatePhysicsWorld(physicsWorld);
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
