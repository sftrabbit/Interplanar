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

package uk.josephmansfield.interplanar;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class CollisionBody {

	private Vector2 position = new Vector2();
	private Vector2 dimensions = new Vector2();

	public CollisionBody(Rectangle boundingRectangle) {
		boundingRectangle.getPosition(position);
		dimensions.set(boundingRectangle.getWidth(), boundingRectangle.getHeight());
	}

	public void addToPhysicsWorld(World physicsWorld) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set(position);

		Body body = physicsWorld.createBody(bodyDef);

		PolygonShape shape = new PolygonShape();
		shape.set(new Vector2[] {
				new Vector2(0f, 0f),
				new Vector2(0f, dimensions.y),
				new Vector2(dimensions.x, dimensions.y),
				new Vector2(dimensions.x, 0f)
		});

		Fixture fixture = body.createFixture(shape, 1f);

		shape.dispose();
	}
}
