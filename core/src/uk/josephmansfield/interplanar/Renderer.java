package uk.josephmansfield.interplanar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Disposable;

public class Renderer implements Disposable {

    private FrameBuffer renderBuffer = null;
    private SpriteBatch pixelationBatch = null;

    private int screenWidth = 0;
    private int screenHeight = 0;

    public Renderer() {
        pixelationBatch = new SpriteBatch();
    }

    public void resize(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        Utils.dispose(renderBuffer);
        renderBuffer = new FrameBuffer(Pixmap.Format.RGB888, screenWidth / 4, screenHeight / 4, true);
        renderBuffer.getColorBufferTexture().setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderBuffer.begin();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderBuffer.end();

        renderPixelated();
    }

    @Override
    public void dispose() {
        pixelationBatch.dispose();
    }

    private void renderPixelated() {
        pixelationBatch.begin();
        pixelationBatch.draw(renderBuffer.getColorBufferTexture(), 0, 0, screenWidth, screenHeight, 0, 0, 1, 1);
        pixelationBatch.end();
    }
}
