package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.os.Bundle;

public class DynamicListView extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview);
        setTitle("동적 리스트 뷰 테스트");
    }
}
