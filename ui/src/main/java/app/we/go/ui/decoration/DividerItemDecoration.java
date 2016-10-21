package app.we.go.ui.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Draws a divider between elements. It does so by first applying a top offset, equal to the
 * height of the divider, to all elements after the first one and then drawing the divider
 * in that newly created space.
 *
 * Created by Aristides Papadopoulos (github:talosdev).
 */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    private Drawable divider;


    public DividerItemDecoration(Drawable divider) {
        this.divider = divider;
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildAdapterPosition(view) > 0) {
            outRect.top += divider.getIntrinsicHeight();
        }

    }

    /**
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

        int dividerLeft = parent.getPaddingLeft();
        int dividerRight = parent.getWidth() - parent.getPaddingRight();


        int childCount = parent.getChildCount();
        for (int i = 1; i < childCount; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            // note that child.getTop() doesn't take into account the offset we have included for
            // the divider, so we need to subtract it
            int dividerTop = child.getTop() - params.topMargin - divider.getIntrinsicHeight();
            int dividerBottom = dividerTop + divider.getIntrinsicHeight();

            divider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
            divider.draw(c);
        }
    }
}
