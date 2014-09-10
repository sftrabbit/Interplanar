package uk.josephmansfield.interplanar.input;

import com.badlogic.gdx.InputAdapter;

public abstract class PlatformerInputProcessor extends InputAdapter {
	protected InputState inputState = new InputState();

	public abstract InputState getInputState();

	public static class InputState {
		public static enum MovementDirection {
			MOVEMENT_NONE,
			MOVEMENT_LEFT,
			MOVEMENT_RIGHT
		}

		public MovementDirection movement = MovementDirection.MOVEMENT_NONE;
		public boolean jump = false;
		public boolean debug = false;
	}
}
