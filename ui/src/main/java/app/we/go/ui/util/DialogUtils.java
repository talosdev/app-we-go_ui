package app.we.go.ui.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.StringRes;

public class DialogUtils {


    public static ProgressDialog createProgressDialog(Context context,
                                                      @StringRes int titleRes,
                                                      @StringRes int messageRes) {

        return ProgressDialog.show(context,
                context.getResources().getString(titleRes),
                context.getResources().getString(messageRes));

    }

    public static void dismissNullSafe(ProgressDialog dialog) {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}
