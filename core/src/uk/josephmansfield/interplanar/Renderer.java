package uk.josephmansfield.interplanar;


import com.badlogic.gdx.utils.Disposable;

public interface Renderer extends Disposable {
    public void resize(int screenWidth, int screenHeight);
    public void render();
}
