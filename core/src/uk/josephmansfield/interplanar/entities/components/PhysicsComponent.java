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
