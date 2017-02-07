package app.we.go.ui.util;

import android.support.v4.app.Fragment;
import android.widget.EditText;
import android.widget.TextView;

public class TextViewUtils {

    public static void setTextFromArguments(TextView view, Fragment fragment, String key) {
        String s = fragment.getArguments().getString(key);
        if (s!=null) {
            view.setText(s);
        }
    }

    public static boolean checkAllNotNull(EditText... fields) {
        for (EditText editText : fields) {
            if (editText.getText().toString().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void setTextIfNotVoid(TextView aboutTextView, String aboutText) {
        if (aboutText != null && !aboutText.isEmpty()) {
            aboutTextView.setText(aboutText);
        }
    }
}
