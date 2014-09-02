package uk.josephmansfield.interplanar.input;

import com.badlogic.gdx.Input;

public class KeyboardInputProcessor extends PlatformerInputProcessor {

	private boolean leftPressed;
	private boolean rightPressed;
	private boolean lastPressedLeft;

	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Input.Keys.SPACE) {
			inputState.jump = true;
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
			inputState.jump = false;
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
				inputState.movement = InputState.MovementDirection.MOVEMENT_LEFT;
			} else {
				inputState.movement = InputState.MovementDirection.MOVEMENT_RIGHT;
			}
		} else if (leftPressed) {
			inputState.movement = InputState.MovementDirection.MOVEMENT_LEFT;
		} else if (rightPressed) {
			inputState.movement = InputState.MovementDirection.MOVEMENT_RIGHT;
		} else {
			inputState.movement = InputState.MovementDirection.MOVEMENT_NONE;
		}
	}
}
