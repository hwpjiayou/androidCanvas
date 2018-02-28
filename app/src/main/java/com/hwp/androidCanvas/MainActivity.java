package com.hwp.androidCanvas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.hwp.androidCanvas.freedraw.ActivityChooser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MainAdapter adapter;
    private static HashMap<Integer,BaseActivity> item = new HashMap<>();

    static {
        try {
            item.put(0,WaveActivity.class.newInstance());
            item.put(1,ActivityChooser.class.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.main_listview);
        adapter = new MainAdapter();
        mListView.setAdapter(adapter);

    }


    private class MainAdapter extends BaseAdapter {

        private ViewHolder holder;

        public MainAdapter() {
        }

        @Override
        public int getCount() {
            return item.size();
        }

        @Override
        public Object getItem(int position) {
            return item.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                holder = new ViewHolder();
                LinearLayout v = new LinearLayout(MainActivity.this);
                holder.textView = new TextView(MainActivity.this);
                holder.textView.setPadding(0, 0, 0, 50);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                v.setLayoutParams(params);
                v.addView(holder.textView);
                convertView = holder.root = v;
                convertView.setTag(holder);
            }

            holder = (ViewHolder) convertView.getTag();
            holder.textView.setText(((BaseActivity)item.get(position)).getName());

            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this,item.get(position).getClass());
                    startActivity(intent);
                }
            });
            return convertView;
        }

        private class ViewHolder {
            TextView textView;
            View root;
        }


    }

}
