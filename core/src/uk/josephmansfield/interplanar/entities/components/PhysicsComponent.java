package uk.josephmansfield.interplanar.entities.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.*;

public class PhysicsComponent extends Component {

	public PhysicsComponent(World physicsWorld) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(0f, 0f);

		World world;
		Body body = physicsWorld.createBody(bodyDef);

		PolygonShape square = new PolygonShape();
		square.setAsBox(8f, 8f);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = square;

		Fixture fixture = body.createFixture(fixtureDef);

		square.dispose();
	}

}
