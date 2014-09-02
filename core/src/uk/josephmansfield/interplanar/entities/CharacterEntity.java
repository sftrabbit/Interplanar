package uk.josephmansfield.interplanar.entities;


import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.physics.box2d.World;
import uk.josephmansfield.interplanar.entities.components.PhysicsComponent;

public class CharacterEntity extends Entity {

	public CharacterEntity(World physicsWorld) {
		add(new PhysicsComponent(physicsWorld));
	}

}
