package uk.josephmansfield.interplanar;

public class KeyboardInputProcessor extends PlatformerInputAdapter {
	private InputState inputState = new InputState();

	@Override
	public InputState getInputState() {
		return inputState;
	}
}
