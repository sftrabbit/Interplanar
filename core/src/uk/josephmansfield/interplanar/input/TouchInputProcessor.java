package uk.josephmansfield.interplanar.input;

import uk.josephmansfield.interplanar.Interplanar;

public class TouchInputProcessor extends PlatformerInputProcessor implements Interplanar.ResizeListener {
	private static final int STOP_ZONE_SIZE = 20;

	private int screenWidth;
	private int screenHeight;

	private boolean jumpTouched;
	private int jumpPointer;

	private boolean moveTouched;
	private int movePointer;
	private int moveOriginX;

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (!jumpTouched && screenX > screenWidth / 2) {
			jumpTouched = true;
			jumpPointer = pointer;

			inputState.jump = true;
		} else if (!moveTouched && screenX <= screenWidth) {
			moveTouched = true;
			movePointer = pointer;
			moveOriginX = screenX;

			inputState.movement = InputState.MovementDirection.MOVEMENT_NONE;
		}

		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		if (jumpTouched && pointer == jumpPointer) {
			jumpTouched = false;

			inputState.jump = false;
		} else if (moveTouched && pointer == movePointer) {
			moveTouched = false;

			inputState.movement = InputState.MovementDirection.MOVEMENT_NONE;
		}
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		if (moveTouched && pointer == movePointer) {
			if (screenX > moveOriginX + STOP_ZONE_SIZE) {
				inputState.movement = InputState.MovementDirection.MOVEMENT_RIGHT;
			} else if (screenX < moveOriginX - STOP_ZONE_SIZE) {
				inputState.movement = InputState.MovementDirection.MOVEMENT_LEFT;
			} else {
				inputState.movement = InputState.MovementDirection.MOVEMENT_NONE;
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
