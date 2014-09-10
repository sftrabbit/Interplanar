package uk.josephmansfield.interplanar.entities;


import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.World;
import uk.josephmansfield.interplanar.entities.components.PhysicsComponent;

public class CharacterEntity extends Entity {

	public CharacterEntity(World physicsWorld) {
		PhysicsComponent physicsComponent = new PhysicsComponent();
		physicsComponent.addToPhysicsWorld(physicsWorld);
		add(physicsComponent);
	}
}
