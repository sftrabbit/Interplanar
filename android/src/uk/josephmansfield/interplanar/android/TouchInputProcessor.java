package uk.josephmansfield.interplanar.android;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class TouchInputProcessor extends InputAdapter {
    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("TAG", "DOWN: (" + screenX + ", " + screenY + ")");
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        Gdx.app.log("TAG", "UP: (" + screenX + ", " + screenY + ")");
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Gdx.app.log("TAG", "DRAG: (" + screenX + ", " + screenY + ")");
        return true;
    }
}
