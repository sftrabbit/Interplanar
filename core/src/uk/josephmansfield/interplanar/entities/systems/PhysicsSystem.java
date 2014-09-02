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
