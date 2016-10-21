package app.we.go.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import app.we.go.ui.R;

/**
 * Custom component that consists of a {@link TextView} that becomes editable (switched to a
 * {@link EditText} when tapped.
 * Delivers a notification (through the {@link TextChangedListener} to the client classes if the
 * text has actually been changed.
 *
 *
 * Created by Aristides Papadopoulos (github:talosdev).
 */
public class TextViewEditableOnTap extends RelativeLayout {

    private final TextView textView;
    private final EditText editText;

    private TextChangedListener listener;

    private final InputMethodManager imm;

    public TextViewEditableOnTap(Context context) {
        this(context, null);
    }

    public TextViewEditableOnTap(Context context, AttributeSet attrs) {
      this(context, attrs, 0);
    }

    public TextViewEditableOnTap(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.text_view_editable_on_tap, this, true);


        imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextViewEditableOnTap, defStyleAttr, 0);

        String text = "";
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);

            if (attr == R.styleable.TextViewEditableOnTap_text) {
                text = a.getText(attr).toString();
            }
        }

            setText(text);

            a.recycle();

        editText.setOnFocusChangeListener(new OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    String oldText = textView.getText().toString();
                    String newText = editText.getText().toString();

                    if (!newText.equals("")) {
                        textView.setText(newText);
                    }

                    editText.setVisibility(View.INVISIBLE);
                    textView.setVisibility(View.VISIBLE);

                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    if (!oldText.equals(newText) && !newText.equals("") && listener != null) {
                        listener.onTextChanged(newText);
                    }
                }
            }
        });

        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.VISIBLE);
                editText.requestFocus();

                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }




    public void setText(String text) {
        textView.setText(text);
        editText.setText(text);
    }


    public void setTextChangedListener(TextChangedListener listener) {
        this.listener = listener;
    }

    public interface TextChangedListener {

        /**
         * Only called when the text has actually changed.
         * @param text
         */
        void onTextChanged(String text);
    }


}
