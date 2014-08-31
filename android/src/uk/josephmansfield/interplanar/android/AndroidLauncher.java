package uk.josephmansfield.interplanar.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import uk.josephmansfield.interplanar.Interplanar;
import uk.josephmansfield.interplanar.TouchInputProcessor;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        config.useCompass = false;
        config.useAccelerometer = false;
        config.hideStatusBar = true;

        TouchInputProcessor touchInputProcessor = new TouchInputProcessor();
        Interplanar interplanar = new Interplanar(touchInputProcessor);
        interplanar.setResizeListener(touchInputProcessor);
		initialize(interplanar, config);
	}
}
