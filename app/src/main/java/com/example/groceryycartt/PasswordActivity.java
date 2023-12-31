package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {
    EditText username;
    Button reset;
    DBHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        username=findViewById(R.id.username_reset);
        reset=findViewById(R.id.btnreset);
        DB=new DBHelper(this);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                Boolean checkuser=DB.checkusername(user);
                if(checkuser==true){
                    Intent intent=new Intent(getApplicationContext(),ResetActivity.class);
                    intent.putExtra("username",user);
                    startActivity(intent);
                }else{
                    Toast.makeText(PasswordActivity.this, "user does not exist", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}