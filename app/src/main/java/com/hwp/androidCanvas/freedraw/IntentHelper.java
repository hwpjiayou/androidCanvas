package com.hwp.androidCanvas.freedraw;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by hwp on 30/05/2017.
 */

class IntentHelper {

    public static void openUrl(Context context, String url) {
        try {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));

            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
