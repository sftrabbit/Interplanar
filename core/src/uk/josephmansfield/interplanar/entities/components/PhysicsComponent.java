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
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.util.ArrayList;

public class PhysicsComponent extends Component {

	private Vector2 position;
	private ArrayList<FixtureDef> fixtureDefs = new ArrayList<FixtureDef>();

	public PhysicsComponent(Vector2 position, ArrayList<FixtureDef> fixtureDefs) {
		this.position = position;
		this.fixtureDefs.addAll(fixtureDefs);
	}

	public PhysicsComponent(Vector2 position, FixtureDef fixtureDef) {
		this.position = position;
		this.fixtureDefs.add(fixtureDef);
	}

	public void addToPhysicsWorld(World physicsWorld) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(position);

		Body body = physicsWorld.createBody(bodyDef);

		for (FixtureDef fixtureDef : fixtureDefs) {
			body.createFixture(fixtureDef);
		}
	}

}
