package com.cookandroid.diaryapp21;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    // 위젯의 배치 순서대로 변수 선언
    EditText year, month, day;
    Button writeMode, readMode;

    // inputDiary, writeOrInsert는 writeView에 속한 위젯들
    LinearLayout writeView;
    EditText inputDiary;
    Button writeOrInsert;

    // outputDiary는 readView에 속한 위젯들
    LinearLayout readView;
    TextView outputDiary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        year = (EditText)findViewById(R.id.year);
        month = (EditText)findViewById(R.id.month);
        day = (EditText)findViewById(R.id.day);

        writeMode = (Button)findViewById(R.id.writeMode);
        readMode = (Button)findViewById(R.id.readMode);

        writeView = (LinearLayout)findViewById(R.id.writeView);
        inputDiary = (EditText)findViewById(R.id.inputDiary);
        writeOrInsert = (Button)findViewById(R.id.writeOrInsert);

        readView = (LinearLayout)findViewById(R.id.readView);
        outputDiary = (TextView)findViewById(R.id.outputDiary);

        writeMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if(!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    // writeView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.VISIBLE);
                    readView.setVisibility(View.GONE);
                    String filePath = year.getText().toString() + month.getText().toString() + day.getText().toString() + ".txt";
                    try {
                        byte[] buf = new byte[65535];
                        FileInputStream inputStream = openFileInput(filePath);
                        inputStream.read(buf);
                        String str = new String(buf);
                        inputDiary.setText(str);
                        inputStream.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        writeOrInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String filePath = year.getText().toString() + month.getText().toString() + day.getText().toString() + ".txt";

                try {
                    FileOutputStream outputStream = openFileOutput(filePath, MODE_PRIVATE);
                    byte[] buf = inputDiary.getText().toString().getBytes();
                    if (buf.length == 0) {
                        Toast msg = Toast.makeText(MainActivity.this, "일기를 입력해주세요.", Toast.LENGTH_SHORT);
                        msg.show();
                        return;
                    }
                    outputStream.write(buf);
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        readMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 날짜가 충분하게 채워지지 않은 경우
                if(!isInputDate()) {
                    Toast.makeText(MainActivity.this, "년, 월, 일을 채워주세요", Toast.LENGTH_LONG).show();
                }
                else {
                    // readView만 화면에 표시되게 한다.
                    writeView.setVisibility(View.GONE);
                    readView.setVisibility(View.VISIBLE);
                    String filePath = year.getText().toString() + month.getText().toString() + day.getText().toString() + ".txt";
                    try {
                        byte[] buf = new byte[65535];
                        FileInputStream inputStream = openFileInput(filePath);
                        inputStream.read(buf);
                        String str = new String(buf);
                        outputDiary.setText(str);
                    } catch (FileNotFoundException e) {
                        Toast msg = Toast.makeText(MainActivity.this, "존재하지 않는 일기입니다.", Toast.LENGTH_SHORT);
                        msg.show();
                        outputDiary.setText("");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    boolean isInputDate(){
        // 년, 월, 일 EditText가 모두 작성된 경우에만 true 반환
        boolean a = year.getText().toString().equals("");
        boolean b = month.getText().toString().equals("");
        boolean c = day.getText().toString().equals("");
        return (!a) && (!b) && (!c);
    }
}