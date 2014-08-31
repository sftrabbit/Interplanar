package uk.josephmansfield.interplanar;

import com.badlogic.gdx.Gdx;
import uk.josephmansfield.interplanar.PlatformerInputAdapter;

public class TouchInputProcessor extends PlatformerInputAdapter implements Interplanar.ResizeListener {
    private InputState inputState = new InputState();
    private int screenWidth = 0;
    private int screenHeight = 0;

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        inputState.jump = true;
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        inputState.jump = false;
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public InputState getInputState() {
        return inputState;
    }

    @Override
    public void onResize(int width, int height) {
        screenWidth = width;
        screenHeight = height;
    }
}
