package com.example.project2119;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView tv, question;
    EditText etInput;
    Button btn, btnBack;
    String new_reviews = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tv = findViewById(R.id.tv2);
        question = findViewById(R.id.question2);
        etInput = findViewById(R.id.etInput2);
        btn = findViewById(R.id.btn2);
        btnBack = findViewById(R.id.btnBack2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                intent.putExtra("location", getIntent().getStringExtra("location"));
                intent.putExtra("title", etInput.getText().toString());

                startActivityForResult(intent, 0);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("review", new_reviews);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(getApplicationContext(), "리뷰 길이: " + data.getStringExtra("review").length() + " " + "리뷰를 더 추가하려면 원하는 장소를 입력하고 NEXT를 누르세요", Toast.LENGTH_LONG).show();

        new_reviews += '\n' + data.getStringExtra("review");

        btnBack.setVisibility(View.VISIBLE);
    }
}
