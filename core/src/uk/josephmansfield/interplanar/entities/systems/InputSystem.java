package uk.josephmansfield.interplanar.entities.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import uk.josephmansfield.interplanar.entities.components.InputComponent;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;


public class InputSystem extends IteratingSystem {

	private ComponentMapper<InputComponent> componentMapper = ComponentMapper.getFor(InputComponent.class);
	private PlatformerInputProcessor inputProcessor;
	private PlatformerInputProcessor.InputState inputState;

	public InputSystem(PlatformerInputProcessor inputProcessor) {
		super(Family.getFor(InputComponent.class));

		this.inputProcessor = inputProcessor;
	}

	@Override
	public void update(float deltaTime) {
		inputState = inputProcessor.getInputState();
		super.update(deltaTime);
	}

	@Override
	public void processEntity(Entity entity, float deltaTime) {
		InputComponent inputComponent = componentMapper.get(entity);
		InputComponent.InputListener inputListener = inputComponent.getInputListener();
		inputListener.onInput(inputState);
	}
}
