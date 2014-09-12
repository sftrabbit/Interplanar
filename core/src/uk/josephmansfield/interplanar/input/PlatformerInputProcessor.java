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
