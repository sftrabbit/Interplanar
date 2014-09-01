package uk.josephmansfield.interplanar;

import com.badlogic.gdx.utils.Disposable;

public class Utils {
	public static void dispose(Disposable disposable) {
		if (disposable != null) {
			disposable.dispose();
		}
	}
}
