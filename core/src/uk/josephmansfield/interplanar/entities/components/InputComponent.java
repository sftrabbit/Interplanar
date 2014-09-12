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

package uk.josephmansfield.interplanar.entities.components;

import com.badlogic.ashley.core.Component;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;

public class InputComponent extends Component {

	private InputListener inputListener;

	public InputComponent(InputListener inputListener) {
		this.inputListener = inputListener;
	}

	public InputListener getInputListener() {
		return inputListener;
	}

	public static interface InputListener {
		public void onInput(PlatformerInputProcessor.InputState inputState);
	}
}
