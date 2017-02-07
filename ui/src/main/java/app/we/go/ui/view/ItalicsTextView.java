package app.we.go.ui.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Workaround for the Android bug with italics in text view being cut-off (first and last character)
 *
 * Created by Aristides Papadopoulos (github:talosdev).
 */
public class ItalicsTextView extends TextView {
    public ItalicsTextView(Context context) {
        super(context);
    }

    public ItalicsTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ItalicsTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ItalicsTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void setItalicsText(CharSequence seq) {

    }


    @Override
    public void setText(CharSequence text, BufferType type) {
        String hairText = "\u200A" + text.toString() + "\u200A";
        super.setText(hairText, type);
    }
}
