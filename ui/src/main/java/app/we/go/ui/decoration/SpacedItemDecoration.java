package app.we.go.ui.decoration;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Aristides Papadopoulos (github:talosdev).
 */
public class SpacedItemDecoration extends RecyclerView.ItemDecoration {
    private final int spacing;
    private int cols;

    /**
     *
     * @param cols
     * @param spacing In pixels!!
     */
    public SpacedItemDecoration(int cols, int spacing) {
        this.cols = cols;
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        int pos = parent.getChildAdapterPosition(view);
        int itemCount = parent.getAdapter().getItemCount();

        outRect.left = spacing / 2;
        outRect.right = spacing / 2;
        outRect.top = spacing / 2;
        outRect.bottom = spacing / 2;


        if (pos % cols == 0) {
            outRect.left = spacing;
        }
        if ((pos + 1) % cols == 0) {
            outRect.right = spacing;
        }

    }

}
