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
		} else if (keycode == Input.Keys.F5) {
			inputState.debug = true;
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
		} else if (keycode == Input.Keys.F5) {
			inputState.debug = false;
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
