package uk.josephmansfield.interplanar.android;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import uk.josephmansfield.interplanar.Interplanar;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        config.useCompass = false;
        config.useAccelerometer = false;
        config.hideStatusBar = true;

		initialize(new Interplanar(new TouchInputProcessor()), config);
	}
}
