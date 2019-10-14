package com.example.chapter07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// 메뉴를 포함시키기 위해 Java 코딩에서 필요한 것
// 1. onCreateOptionsMenu() 메소드 ~ 오버라이딩
// 2. onOptionsItemSelected() 메소드 ~ 오버라이딩
public class MainActivity extends AppCompatActivity {

    // 메뉴의 각 기능들을 선택했을 때 연동될 수 있도록...
    LinearLayout menuLayout;
    TextView menuTextView;
    Button menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuLayout = (LinearLayout)findViewById(R.id.baseLayout);
        menuTextView = (TextView)findViewById(R.id.textView);
        menuButton = (Button)findViewById(R.id.button);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        // 인플레이터 (Inflater)
        // 정적으로 존재하는 xml 파일을 Java 코드에서 사용
        // MenuInflater, LayoutInflater 등등등이 존재

        MenuInflater mInf = getMenuInflater();

        // inflate ~ 부풀리기 (menu xml 파일을 연결해 줌)
        mInf.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        // switch case 문을 사용하여 메뉴들의 기능을 부여
        // switch(item.getItemId())
        switch (item.getItemId()) {
            case R.id.setBackgroundBlack:
                menuLayout.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.setBackgroundPurple:
                menuLayout.setBackgroundColor(Color.rgb(221,221, 225));
                return true;
            case R.id.changeTextView:
                menuTextView.setText("TextView Changed.");
                return true;
            case R.id.changeButton:
                menuButton.setRotation(90);
                // Toast
                Toast msg = Toast.makeText(MainActivity.this, "버튼 메뉴가 눌렸음",
                        Toast.LENGTH_LONG);
                msg.show();
                return true;
            default:
                return false;
        }
    }
}

//// MainActivity 기본 형태 복사본
//public class MainActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//}