package app.we.go.ui.util;

import android.content.res.Resources;

/**
 * Created by Aristides Papadopoulos (github:talosdev).
 */

public class DimensUtils {

    public static int pxToDp(int px) {
        return (int) (px / Resources.getSystem().getDisplayMetrics().density);
    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int dpToPx(float dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getDensity() {
        return (int) Resources.getSystem().getDisplayMetrics().density;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }
}
