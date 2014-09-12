/*
 * Copyright (c) Joseph Mansfield
 *
 * This file is part of Interplanar.
 *
 * Interplanar is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Interplanar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Interplanar.  If not, see <http://www.gnu.org/licenses/>.
 */

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
