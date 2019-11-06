package com.example.muksijukintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button theOne, theTwo, checkIn, checkOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theOne = findViewById(R.id.theOne);
        theTwo = findViewById(R.id.theTwo);
        checkIn = findViewById(R.id.checkIn);
        checkOut = findViewById(R.id.checkOut);

        theOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 묵시적(암시적) 인텐트를 사용
                Intent theOneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0629496881"));
                startActivity(theOneIntent);
            }
        });

        theTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri theTwoUri = Uri.parse("http://donote.co");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, theTwoUri);
                startActivity(webIntent);
            }
        });

        checkIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri inUri = Uri.parse("https://maps.google.com/maps?q=" + 37.554264 + "," + 126.913598);
                Intent inIntent = new Intent(Intent.ACTION_VIEW, inUri);
                startActivity(inIntent);
            }
        });

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent outIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(outIntent);
            }
        });
    }
}
