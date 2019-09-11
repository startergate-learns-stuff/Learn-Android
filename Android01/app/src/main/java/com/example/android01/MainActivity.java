package com.example.android01;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // 1. xml에서 선언된 TextView를 연결해주기 위한 변수 선언
    TextView textView1, textView2, textView3, textView4, textView5;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 무언가를 바꾸고 싶다면 버튼 - 변수 연결
        textView1 = (TextView) findViewById(R.id.text1);
        textView2 = (TextView) findViewById(R.id.text2);
        textView3 = (TextView) findViewById(R.id.text3);
        textView4 = (TextView) findViewById(R.id.text4);
        textView5 = (TextView) findViewById(R.id.text5);
        btn = (Button) findViewById(R.id.click);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setRotation(180);
                textView2.setTextColor(Color.BLUE);
                textView3.setText(R.string.imanidiot);
                textView4.setText(R.string.printf);
                textView5.setSingleLine(false);
            }
        });
    }
}
