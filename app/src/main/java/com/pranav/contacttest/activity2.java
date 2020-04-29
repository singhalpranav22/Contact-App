package com.pranav.contacttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class activity2 extends AppCompatActivity implements View.OnClickListener {

    EditText edName,edPhone,edAddress,edEmail;
    ImageView ivHappy,ivOk,ivSad;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        edName=findViewById(R.id.edName);
        edPhone=findViewById(R.id.edPhone);
        edAddress=findViewById(R.id.edAddress);
        edEmail=findViewById(R.id.edEmail);
        ivHappy=findViewById(R.id.ivHappy);
        ivOk=findViewById(R.id.ivOk);
        ivSad=findViewById(R.id.ivSad);

        ivSad.setOnClickListener(this);
        ivHappy.setOnClickListener(this);
        ivOk.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        if(edName.getText().toString().isEmpty() || edPhone.getText().toString().isEmpty() || edEmail.getText().toString().isEmpty() || edAddress.getText().toString().isEmpty())
        {
            Toast.makeText(this, "Enter all the Fields !", Toast.LENGTH_SHORT).show();
        }

        else
        {
            Intent intent=new Intent();
            intent.putExtra("name",edName.getText().toString().trim());
            intent.putExtra("phone",edPhone.getText().toString().trim());
            intent.putExtra("email",edEmail.getText().toString().trim());
            intent.putExtra("address",edAddress.getText().toString().trim());

            if(v.getId()==R.id.ivHappy)
            {
                intent.putExtra("mood","happy");
            }
            else if(v.getId()==R.id.ivOk)
            {
                intent.putExtra("mood","ok");
            }

            else
            {
                intent.putExtra("mood","sad");
            }

            setResult(RESULT_OK,intent);
             activity2.this.finish();
        }
    }
}
