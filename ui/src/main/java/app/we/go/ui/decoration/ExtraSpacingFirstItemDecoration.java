package app.we.go.ui.decoration;

import android.graphics.Rect;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Aristides Papadopoulos (github:talosdev).
 */
public class ExtraSpacingFirstItemDecoration extends RecyclerView.ItemDecoration {


    private int extraSpacing;
    private int orientation;

    public ExtraSpacingFirstItemDecoration(int extraSpacing,
                                           int orientation) {
        this.extraSpacing = extraSpacing;
        this.orientation = orientation;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) == 0) {
            if (orientation == OrientationHelper.HORIZONTAL) {
                outRect.left += extraSpacing;
            } else {
                outRect.top += extraSpacing;
            }
        }
    }
}
