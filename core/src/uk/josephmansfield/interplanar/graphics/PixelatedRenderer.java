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
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import uk.josephmansfield.interplanar.Utils;

public class PixelatedRenderer implements Renderer {

	private static final int SCALE = 4;

	private SceneRenderer renderer;
	private FrameBuffer renderBuffer;
	private SpriteBatch pixelationBatch;

	private int width;
	private int height;

	public PixelatedRenderer(SceneRenderer renderer) {
		this.renderer = renderer;
		pixelationBatch = new SpriteBatch();
	}

	@Override
	public void resize(int width, int height) {
		this.width = width;
		this.height = height;

		Utils.dispose(renderBuffer);
		renderBuffer = new FrameBuffer(Pixmap.Format.RGB888, width / SCALE, height / SCALE, true);
		renderBuffer.getColorBufferTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

		renderer.resize(width / SCALE, height / SCALE);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		renderBuffer.begin();
		renderer.render();
		renderBuffer.end();

		pixelationBatch.begin();
		pixelationBatch.draw(renderBuffer.getColorBufferTexture(), 0, 0, width, height, 0, 0, 1, 1);
		pixelationBatch.end();
	}

	@Override
	public void dispose() {
		renderer.dispose();
		renderBuffer.dispose();
		pixelationBatch.dispose();
	}
}
