package app.we.go.ui.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class KeyboardUtils {
    public static void hideKeyboard(Context context, View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static void onLoseFocusHideKeyboard(final Context context, final View view) {
        View.OnFocusChangeListener focusChangeListener = new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if (v.equals(view) && !hasFocus) {
                    hideKeyboard(context, view);
                }
            }
        };
        view.setOnFocusChangeListener(focusChangeListener);
    }
}