package uk.josephmansfield.interplanar.input;

import uk.josephmansfield.interplanar.Interplanar;

public class TouchInputProcessor extends PlatformerInputAdapter implements Interplanar.ResizeListener {
	private static final int STOP_ZONE_SIZE = 20;

	private int screenWidth = 0;
	private int screenHeight = 0;

	private boolean jumpTouched = false;
	private int jumpPointer = 0;

	private boolean moveTouched = false;
	private int movePointer = 0;
	private int moveOriginX = 0;

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (!jumpTouched && screenX > screenWidth / 2) {
			jumpTouched = true;
			jumpPointer = pointer;

			inputState.jumpRequested = true;
		} else if (!moveTouched && screenX <= screenWidth) {
			moveTouched = true;
			movePointer = pointer;
			moveOriginX = screenX;

			inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_NONE;
		}

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (jumpTouched && pointer == jumpPointer) {
			jumpTouched = false;

			inputState.jumpRequested = false;
		} else if (moveTouched && pointer == movePointer) {
			moveTouched = false;

			inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_NONE;
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (moveTouched && pointer == movePointer) {
			if (screenX > moveOriginX + STOP_ZONE_SIZE) {
				inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_RIGHT;
			} else if (screenX < moveOriginX - STOP_ZONE_SIZE) {
				inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_LEFT;
			} else {
				inputState.requestedMovement = InputState.MovementDirection.MOVEMENT_NONE;
			}
		}
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
