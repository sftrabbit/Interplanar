package uk.josephmansfield.interplanar;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;

public abstract class PlatformerInputAdapter extends InputAdapter {
    public abstract InputState getInputState();
}
