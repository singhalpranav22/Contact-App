package com.pranav.contacttest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ParseException;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivMood, ivWeb, ivLocation, ivPhone;
    Button btnCreate;
    TextView tv;
    final int k = 1;

    String name = "", phone = "", email = "", address = "",mood="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ivMood = findViewById(R.id.ivmood);
        ivLocation = findViewById(R.id.ivLocation);
        ivWeb = findViewById(R.id.ivWeb);
        ivPhone = findViewById(R.id.ivPhone);
        ivMood.setVisibility(View.GONE);
        ivLocation.setVisibility(View.GONE);
        ivWeb.setVisibility(View.GONE);
        ivPhone.setVisibility(View.GONE);
        tv=findViewById(R.id.tvInfo);
        tv.setVisibility(View.GONE);

        btnCreate = findViewById(R.id.btnCreate);

        ivMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + email));
                startActivity(intent);

            }
        });

        ivLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
                startActivity(intent);
            }
        });


        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
                startActivity(intent);
            }
        });


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, com.pranav.contacttest.activity2.class);
                startActivityForResult(intent, k);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == k) {
            if (resultCode == RESULT_OK) {

                ivMood.setVisibility(View.VISIBLE);
                ivLocation.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                email = data.getStringExtra("email");
                address = data.getStringExtra("address");
                phone = data.getStringExtra("phone");
               mood=data.getStringExtra("mood");
                if (mood.equals("happy")) {
                    ivMood.setImageResource(R.drawable.ic_sentiment_satisfied_black_24dp);
                }

                if (mood.equals("ok")) {

                    ivMood.setImageResource(R.drawable.ic_sentiment_neutral_black_24dp);
                }

                if (mood.equals("sad")) {

                    ivMood.setImageResource(R.drawable.ic_sentiment_dissatisfied_black_24dp);
                }


            }

        }


    }
}
