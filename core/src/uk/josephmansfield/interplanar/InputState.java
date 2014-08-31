package uk.josephmansfield.interplanar;

public class InputState {
    public static enum MovementDirection {
        MOVEMENT_NONE,
        MOVEMENT_LEFT,
        MOVEMENT_RIGHT
    }

    public MovementDirection movementDirection = MovementDirection.MOVEMENT_NONE;
    public boolean jump = false;
}
