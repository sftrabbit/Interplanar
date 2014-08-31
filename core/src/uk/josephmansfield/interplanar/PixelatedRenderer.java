package uk.josephmansfield.interplanar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

public class PixelatedRenderer implements Renderer {

    private static final int SCALE = 4;

    private SceneRenderer renderer = null;
    private FrameBuffer renderBuffer = null;
    private SpriteBatch pixelationBatch = null;

    private int width = 0;
    private int height = 0;

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
