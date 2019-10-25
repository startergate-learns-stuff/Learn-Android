package com.example.a20191023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText inputArea;
    TextView outputArea;
    Button write, read;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputArea = findViewById(R.id.inputArea);
        outputArea = findViewById(R.id.outputArea);
        write = findViewById(R.id.write);
        read = findViewById(R.id.read);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 파일 입출력을 위해서는 FileInput(Output)Stream 클래스 사용
                try {
                    if (inputArea.getText().toString() == "") {
                        Toast.makeText(MainActivity.this, "입력된 내용이 없습니다.", Toast.LENGTH_LONG);
                    } else {
                        FileOutputStream outFs = openFileOutput("file.txt", MODE_PRIVATE);
                        String str = inputArea.getText().toString();
                        outFs.write(str.getBytes());
                        outFs.close();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // 버퍼가 처리하는 방식과 비슷
                    // 한 번에 읽어들일 수 있는 최대한의 byte 수 지정
                    // 작은 byte 단위로 나눠 읽어들일 경우
                    // 예상치 못한 글자 깨짐이 발생할 수 있다
                    FileInputStream inFs = openFileInput("file.txt");
                    byte[] txt = new byte[3000];
                    inFs.read(txt);
                    String str = new String(txt);
                    outputArea.setText(str);
                    inFs.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
