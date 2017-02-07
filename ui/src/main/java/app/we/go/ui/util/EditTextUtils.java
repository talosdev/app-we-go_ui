package app.we.go.ui.util;

import android.util.Patterns;
import android.widget.EditText;

public class EditTextUtils {

    public static boolean areAllNonEmpty(EditText... fields) {
        for (EditText editText : fields) {
            if (editText.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static boolean areSameText(EditText editText1, EditText editText2) {
        String s1 = editText1.getText().toString();
        String s2 = editText2.getText().toString();
        return !s1.isEmpty() && !s2.isEmpty() && s1.equals(s2);
    }

    public static boolean isValidEmail(EditText editText) {
        String s = editText.getText().toString();
        return Patterns.EMAIL_ADDRESS.matcher(s).matches();
    }

    public static boolean hasMinimumLength(EditText editText, int minLength) {
        String s = editText.getText().toString();
        return s.length() >= minLength;
    }
}
