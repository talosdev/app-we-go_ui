package app.we.go.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Aristides Papadopoulos (github:talosdev).
 */


public class ButtonTogglingTextWatcher implements TextWatcher {

    private final EditText[] editTexts;
    private final View button;

    public ButtonTogglingTextWatcher(View button, EditText... editTexts) {
        this.editTexts = editTexts;
        this.button = button;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        boolean allNonEmpty = true;
        for (EditText editText : editTexts) {
            if (editText.getText().length() == 0) {
                allNonEmpty = false;
                break;
            }
        }
        button.setEnabled(allNonEmpty);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
