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

package uk.josephmansfield.interplanar.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import uk.josephmansfield.interplanar.entities.components.InputComponent;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;


public class InputSystem extends IteratingSystem {

	private ComponentMapper<InputComponent> componentMapper = ComponentMapper.getFor(InputComponent.class);
	private PlatformerInputProcessor inputProcessor;
	private PlatformerInputProcessor.InputState inputState;

	public InputSystem(PlatformerInputProcessor inputProcessor) {
		super(Family.getFor(InputComponent.class));

		this.inputProcessor = inputProcessor;
	}

	@Override
	public void update(float deltaTime) {
		inputState = inputProcessor.getInputState();
		super.update(deltaTime);
	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
		InputComponent inputComponent = componentMapper.get(entity);
		InputComponent.InputListener inputListener = inputComponent.getInputListener();
		inputListener.onInput(inputState);
	}
}
