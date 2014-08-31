package uk.josephmansfield.interplanar;

import uk.josephmansfield.interplanar.PlatformerInputAdapter;

public class TouchInputProcessor extends PlatformerInputAdapter {
    private InputState inputState = new InputState();

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
}
