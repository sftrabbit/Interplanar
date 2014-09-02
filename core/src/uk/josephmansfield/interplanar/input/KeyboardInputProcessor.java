package uk.josephmansfield.interplanar.input;

import com.badlogic.gdx.Input;

public class KeyboardInputProcessor extends PlatformerInputAdapter {

	private boolean leftPressed = false;
	private boolean rightPressed = false;
	private boolean lastPressedLeft = false;

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.SPACE) {
			inputState.jumpRequested = true;
		} else if (keycode == Input.Keys.A) {
			leftPressed = true;
			lastPressedLeft = true;
		} else if (keycode == Input.Keys.D) {
			rightPressed = true;
			lastPressedLeft = false;
		}

		setMovementRequested();

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Input.Keys.SPACE) {
			inputState.jumpRequested = false;
		} else if (keycode == Input.Keys.A) {
			leftPressed = false;
		} else if (keycode == Input.Keys.D) {
			rightPressed = false;
		}

		setMovementRequested();

		return true;
	}

	@Override
	public InputState getInputState() {
		return inputState;
	}

	private void setMovementRequested() {
		if (leftPressed && rightPressed) {
			if (lastPressedLeft) {
				inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_LEFT;
			} else {
				inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_RIGHT;
			}
		} else if (leftPressed) {
			inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_LEFT;
		} else if (rightPressed) {
			inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_RIGHT;
		} else {
			inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_NONE;
		}
	}
}
