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

import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.gdx.physics.box2d.World;

public class PhysicsSystem extends EntitySystem {

	private World physicsWorld;

	public PhysicsSystem(World physicsWorld) {
		this.physicsWorld = physicsWorld;
	}

	@Override
	public void update(float deltaTime) {
		physicsWorld.step(deltaTime, 6, 2);
	}
}
