package uk.josephmansfield.interplanar;

import com.badlogic.gdx.InputAdapter;

public abstract class PlatformerInputAdapter extends InputAdapter {
	protected InputState inputState = new InputState();

	public abstract InputState getInputState();

	public static class InputState {
		public static enum MovementDirection {
			MOVEMENT_NONE,
			MOVEMENT_LEFT,
			MOVEMENT_RIGHT
		}

		public MovementDirection requestedMovement = MovementDirection.MOVEMENT_NONE;
		public boolean jumpRequested = false;
	}
}
