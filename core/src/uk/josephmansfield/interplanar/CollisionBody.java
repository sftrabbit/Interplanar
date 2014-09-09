package uk.josephmansfield.interplanar;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class CollisionBody {

	private Rectangle boundingRectangle;

	public CollisionBody(Rectangle boundingRectangle) {
		this.boundingRectangle = boundingRectangle;
	}

	public void addToPhysicsWorld(World physicsWorld) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;

		Vector2 position = new Vector2();
		boundingRectangle.getPosition(position);
		bodyDef.position.set(position);

		Body body = physicsWorld.createBody(bodyDef);

		Vector2[] vertices = new Vector2[] {
				new Vector2(0f, 0f),
				new Vector2(0f, boundingRectangle.getHeight()),
				new Vector2(boundingRectangle.getWidth(), boundingRectangle.getHeight()),
				new Vector2(boundingRectangle.getWidth(), 0f)
		};

		PolygonShape shape = new PolygonShape();
		shape.set(vertices);

		Fixture fixture = body.createFixture(shape, 1f);

		shape.dispose();
	}
}
