package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ResetActivity extends AppCompatActivity {
    TextView username;
    EditText pass,repass;
    Button confirm;
DBHelper DB;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        username=findViewById(R.id.username_reset_text);
        pass=findViewById(R.id.password_reset);
        repass=findViewById(R.id.repassword_reset);
        confirm=findViewById(R.id.btnconfirm);
DB=new DBHelper(this);
        Intent intent=getIntent();
        username.setText(intent.getStringExtra("username"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String password=pass.getText().toString();
                String repassword=repass.getText().toString();
                if(password.equals(repassword)) {


                    Boolean checkpasswordupdate = DB.updatepassword(user, password);
                    if (checkpasswordupdate == true) {
                        Intent intent = new Intent(getApplicationContext(), Location1Activity.class);
                        startActivity(intent);
                        Toast.makeText(ResetActivity.this, "Password Updated Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ResetActivity.this, "Password Not Updated", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(ResetActivity.this, "Password not Matching", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}