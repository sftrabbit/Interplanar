package uk.josephmansfield.interplanar.desktop;

import com.badlogic.gdx.Graphics;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import uk.josephmansfield.interplanar.Interplanar;
import uk.josephmansfield.interplanar.input.KeyboardInputProcessor;

public class DesktopLauncher {
	private static final int MARGIN = 40;
	private static final int LARGE_WIDTH = 1200;
	private static final int LARGE_HEIGHT = 720;
	private static final int LARGE_BREAKPOINT_WIDTH = LARGE_WIDTH + MARGIN;
	private static final int LARGE_BREAKPOINT_HEIGHT = LARGE_HEIGHT + MARGIN;
	private static final int SMALL_WIDTH = 800;
	private static final int SMALL_HEIGHT = 480;
	private static final int SMALL_BREAKPOINT_WIDTH = SMALL_WIDTH + MARGIN;
	private static final int SMALL_BREAKPOINT_HEIGHT = SMALL_HEIGHT + MARGIN;

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.resizable = false;

		Graphics.DisplayMode currentDisplayMode = LwjglApplicationConfiguration.getDesktopDisplayMode();

		if (currentDisplayMode.width > LARGE_BREAKPOINT_WIDTH && currentDisplayMode.height > LARGE_BREAKPOINT_HEIGHT) {
			config.width = LARGE_WIDTH;
			config.height = LARGE_HEIGHT;
		} else if (currentDisplayMode.width > SMALL_BREAKPOINT_WIDTH && currentDisplayMode.height > SMALL_BREAKPOINT_HEIGHT) {
			config.width = SMALL_WIDTH;
			config.height = SMALL_HEIGHT;
		} else {
			// Everything smaller than the small breakpoint will be fullscreen by default
			config.width = currentDisplayMode.width;
			config.height = currentDisplayMode.height;
			config.fullscreen = true;
		}

		new LwjglApplication(new Interplanar(new KeyboardInputProcessor()), config);
	}
}
