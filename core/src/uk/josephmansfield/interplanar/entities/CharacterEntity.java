package uk.josephmansfield.interplanar.entities;


import com.badlogic.ashley.core.Component;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import uk.josephmansfield.interplanar.entities.components.InputComponent;
import uk.josephmansfield.interplanar.entities.components.PhysicsComponent;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;

public class CharacterEntity extends Entity {

	public CharacterEntity(World physicsWorld) {
		Vector2 position = new Vector2();

		PolygonShape square = new PolygonShape();
		square.setAsBox(8f, 8f);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = square;

		PhysicsComponent physicsComponent = new PhysicsComponent(position, fixtureDef);
		physicsComponent.addToPhysicsWorld(physicsWorld);
		add(physicsComponent);

		square.dispose();

		add(new InputComponent(new InputComponent.InputListener() {
			@Override
			public void onInput(PlatformerInputProcessor.InputState inputState) {
				Gdx.app.log("TAG", "Input received!");
			}
		}));
	}
}
