package uk.josephmansfield.interplanar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class SceneRenderer implements Renderer {

    private Camera camera = new OrthographicCamera();
    private ShapeRenderer shapeRenderer = new ShapeRenderer();
    private Viewport viewport = null;

    private int width = 0;
    private int height = 0;

    public SceneRenderer() {
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
    }

    @Override
    public void dispose() {
    }
}
