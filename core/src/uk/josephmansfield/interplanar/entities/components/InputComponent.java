package uk.josephmansfield.interplanar.entities.components;

import com.badlogic.ashley.core.Component;
import uk.josephmansfield.interplanar.input.PlatformerInputProcessor;

public class InputComponent extends Component {

	private InputListener inputListener;

	public InputComponent(InputListener inputListener) {
		this.inputListener = inputListener;
	}

	public InputListener getInputListener() {
		return inputListener;
	}

	public static interface InputListener {
		public void onInput(PlatformerInputProcessor.InputState inputState);
	}
}
