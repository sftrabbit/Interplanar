package uk.josephmansfield.interplanar;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public abstract class PlatformerInputAdapter extends InputAdapter {
    public abstract InputState getInputState();

    public static class InputState {
        public static enum MovementDirection {
            MOVEMENT_NONE,
            MOVEMENT_LEFT,
            MOVEMENT_RIGHT
        }

        public MovementDirection movementDirection = MovementDirection.MOVEMENT_NONE;
        public boolean jump = false;
    }
}
