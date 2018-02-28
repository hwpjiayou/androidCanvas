package com.hwp.androidCanvas;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by hwp on 2018/2/27.
 */

public abstract class BaseActivity extends AppCompatActivity {


    public static String name;

    public abstract String getName();


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
