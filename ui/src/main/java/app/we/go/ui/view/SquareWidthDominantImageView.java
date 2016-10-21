package app.we.go.ui.view;

/**
 * ImageView that will be square, maintaining its width.
 * Works if both its dimensions are set to
 * <code>matchParent</code>.
 *
 * Created by Aristides Papadopoulos (github:talosdev).
 */
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SquareWidthDominantImageView extends ImageView {


    public SquareWidthDominantImageView(Context context) {
        super(context);
    }

    public SquareWidthDominantImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

    }

    public SquareWidthDominantImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }

}
