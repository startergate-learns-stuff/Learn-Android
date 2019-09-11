package com.example.baseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 1. xml 코드 (화면)에 추가시킨 버튼을 java에서 받아오기 위한 객체 변수 선언
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. xml 파일에서 만든 버튼 객체를 연결
        button = (Button) findViewById(R.id.button);

        // 3. 버튼이 지원하는 기능 활용한 코드 작성
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: when user click button.
                Toast.makeText(getApplicationContext(),"김남수", Toast.LENGTH_LONG).show();
            }
        });
    }
}
