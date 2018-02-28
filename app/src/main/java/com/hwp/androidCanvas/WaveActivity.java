package com.hwp.androidCanvas;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.hwp.canvas.library.wave.WaveView;


/**
 * Created by hwp on 2018/2/27.
 */

public class WaveActivity extends BaseActivity {

    private static WaveActivity instance;
    private WaveView waveView;
    private int i=80;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        waveView = (WaveView) findViewById(R.id.wave_view);
        handler.sendEmptyMessage(0);
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Log.d("hwp","===="+i);
            if (i==0){
                i++;
            }else if(i<=80){
                i--;
            }
            waveView.setProgress(i);
            handler.sendEmptyMessageDelayed(0,2000);
        }
    };

    @Override
    public String getName() {
        return "Wave view--canvas花波浪";
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
        handler = null;
    }
}
