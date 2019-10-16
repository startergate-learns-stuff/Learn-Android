package com.example.chapter07;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

// 실습 1. 메뉴를 포함시키기 위해 Java 코딩에서 필요한 것
// 1. onCreateOptionsMenu() 메소드 ~ 오버라이딩
// 2. onOptionsItemSelected() 메소드 ~ 오버라이딩

// 실습 2. 컨텍스트 메뉴 만들기
// 1. onCreate() 내부에서 registerForContext() 메소드로 위젯 등록
// 2. onCreateOptionsMenu() 메소드 ~ 오버라이딩
// 3. onOptionsItemSelected() 메소드 ~ 오버라이딩
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

        // 실습 2의 1. 버튼을 컨섹스트 메뉴가 작동할 수 있도록 등록
        registerForContextMenu(menuButton);
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

    // 실습 2의 2. onCreateContextMenu() 메소드 오버라이딩
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        // 자동 완성된 메소드에 아래의 코드 추가
        MenuInflater contextMInf = getMenuInflater();
        if (v == menuButton) contextMInf.inflate(R.menu.btn_menu, menu);
    }

    // 실습 2의 2. onContextItemSelected()

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        Toast msg;
        switch (item.getItemId()) {
            case R.id.btnMenu1:
                msg = Toast.makeText(MainActivity.this, "살려드렸습니다", Toast.LENGTH_SHORT);
                msg.show();
                return true;
            case R.id.btnMenu2:
                msg = Toast.makeText(MainActivity.this, "죽여드렸습니다", Toast.LENGTH_SHORT);
                msg.show();
                return true;
            case R.id.btnMenu31:
                msg = Toast.makeText(MainActivity.this, "흐에", Toast.LENGTH_SHORT);
                msg.show();
                return true;
            case R.id.btnMenu32:
                msg = Toast.makeText(MainActivity.this, "헤에", Toast.LENGTH_SHORT);
                msg.show();
                return true;
            case R.id.btnMenu33:
                msg = Toast.makeText(MainActivity.this, "후에", Toast.LENGTH_SHORT);
                msg.show();
                return true;
        }
        return false;
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