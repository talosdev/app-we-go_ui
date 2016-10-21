package app.we.go.ui.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Aristides Papadopoulos (github:talosdev).
 */
public class SpacingItemDecoration extends RecyclerView.ItemDecoration {

    private int spacing;
    private int orientation;

    /**
     *
     * @param spacing in pixels
     * @param orientation One of {@link android.support.v7.widget.OrientationHelper#VERTICAL}
     *                 or {@link android.support.v7.widget.OrientationHelper#HORIZONTAL}
     */
    public SpacingItemDecoration(int spacing, int orientation) {
        this.spacing = spacing;
        this.orientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int pos = parent.getChildAdapterPosition(view);
        if (pos != 0) {
            if (orientation == OrientationHelper.VERTICAL) {
                outRect.top = spacing;
            } else {
                outRect.left = spacing;
            }
        }
    }

    /**
     * TODO move this to the custom ItemDecoration for previous events
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {

//            final int top = parent.getPaddingTop();
//            final int bottom = parent.getHeight() - parent.getPaddingBottom();
//
//            final int childCount = parent.getChildCount();
//            for (int i = 0; i < childCount; i++) {
//                final View child = parent.getChildAt(i);
//                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child
//                        .getLayoutParams();
//                final int left = child.getRight() + params.rightMargin;
//                final int right = left + mDivider.getIntrinsicHeight();
//                mDivider.setBounds(left, top, right, bottom);
//                mDivider.draw(c);
//            }
//        }


    }
}
