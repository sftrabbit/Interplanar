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

package uk.josephmansfield.interplanar.graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SceneRenderer implements Renderer {

	private Camera camera = new OrthographicCamera();
	private ShapeRenderer shapeRenderer = new ShapeRenderer();
	private Viewport viewport;

	private World physicsWorld;
	private Box2DDebugRenderer physicsRenderer;

	private int width;
	private int height;

	public SceneRenderer(World physicsWorld) {
		this.physicsWorld = physicsWorld;

		this.physicsRenderer = new Box2DDebugRenderer();
	}

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;

		if (viewport == null) {
			viewport = new FitViewport(width, height, camera);
		}
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		viewport.update(width, height);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setProjectionMatrix(camera.combined);
		shapeRenderer.line(0, 0, 5f, 5f);
		shapeRenderer.end();

		physicsRenderer.render(physicsWorld, camera.combined);
	}

	@Override
	public void dispose() {
		physicsRenderer.dispose();
	}
}
