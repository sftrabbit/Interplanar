package uk.josephmansfield.interplanar;


import com.badlogic.gdx.utils.Disposable;

public interface Renderer extends Disposable {
    public void resize(int width, int height);
    public void render();
}
