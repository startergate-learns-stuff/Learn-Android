package com.example.project2119;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    TextView tv;
    EditText etInput;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tv = findViewById(R.id.tv3);
        etInput = findViewById(R.id.etInput3);
        btn = findViewById(R.id.btnBack3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                String str = getIntent().getStringExtra("location") + ": " + getIntent().getStringExtra("title") + ' ' + etInput.getText().toString();
                intent.putExtra("review", str);

                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
