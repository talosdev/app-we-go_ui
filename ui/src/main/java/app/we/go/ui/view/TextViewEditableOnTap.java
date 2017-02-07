package app.we.go.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
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
 * <p>
 * <p>
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

        inflateLayout(context);


        imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

        textView = (TextView) findViewById(R.id.text_view);
        editText = (EditText) findViewById(R.id.edit_text);


        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextViewEditableOnTap, defStyleAttr, 0);

        String text = "";
        int maxLines = -1;
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);

            if (attr == R.styleable.TextViewEditableOnTap_text) {
                text = a.getText(attr).toString();
            } else if (attr == R.styleable.TextViewEditableOnTap_maxLinesEdit) {
                maxLines = a.getInt(attr, -1);
            }
        }


        setText(text);
        if (maxLines > -1) {

            final int finalMaxLines = maxLines;
            editText.addTextChangedListener(new TextWatcher() {
                private String text;

                public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                }

                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                    text = arg0.toString();
                }

                public void afterTextChanged(Editable arg0) {
                    int lineCount = editText.getLineCount();
                    if (lineCount > finalMaxLines) {
                        editText.setText(text);
                    }
                }
            });

            editText.setOnKeyListener(new View.OnKeyListener() {

                public boolean onKey(View v, int keyCode, KeyEvent event) {

                    // if enter is pressed start calculating
                    if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                        int editTextLineCount = ((EditText) v).getLineCount();
                        if (editTextLineCount >= finalMaxLines)
                            return true;
                    }

                    return false;
                }
            });
        }


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

    protected void inflateLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.text_view_editable_on_tap, this, true);
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
         *
         * @param text
         */
        void onTextChanged(String text);
    }


}
