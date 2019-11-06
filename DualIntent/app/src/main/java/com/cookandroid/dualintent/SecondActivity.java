package com.cookandroid.dualintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    TextView tv;
    EditText et;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2nd);

        tv = (TextView)findViewById(R.id.data);
        et = (EditText)findViewById(R.id.intent2nd);
        btn = (Button)findViewById(R.id.returnBtn);

        Intent inIntent = getIntent();
        int sum = inIntent.getIntExtra("sum", 0);

        tv.setText("Received from MainActivity: " + sum);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent(getApplicationContext(), MainActivity.class);
                String str = et.getText().toString();
                returnIntent.putExtra("outData", str);
                setResult(RESULT_OK, returnIntent);
                finish();

            }
        });
    }
}
