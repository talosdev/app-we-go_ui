package app.we.go.ui.util;

import android.graphics.Color;

/**
 * Created by Aristides Papadopoulos (github:talosdev).
 */

public class ColorUtils {

    static int blendColors(int from, int to, float ratio) {
        final float inverseRation = 1f - ratio;
        final float r = Color.red(from) * ratio + Color.red(to) * inverseRation;
        final float g = Color.green(from) * ratio + Color.green(to) * inverseRation;
        final float b = Color.blue(from) * ratio + Color.blue(to) * inverseRation;
        return Color.rgb((int) r, (int) g, (int) b);
    }
}
