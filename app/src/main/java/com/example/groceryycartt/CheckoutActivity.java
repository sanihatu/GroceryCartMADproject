package com.example.groceryycartt;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckoutActivity extends AppCompatActivity {

    EditText edname,edaddress,adpincode,adcontact;
    TextView total;
    Button btnBooking;
    ImageButton back;
    String contactNumber,PinCode;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        edname=findViewById(R.id.fullnamebook);
        edaddress=findViewById(R.id.addressbook);
        adpincode=findViewById(R.id.pincodebook);
        adcontact=findViewById(R.id.contactnobook);
        btnBooking=findViewById(R.id.ordernowbook);
        total=findViewById(R.id.totalamtcheck);
        DBHelper db=new DBHelper(this);

        Intent intent=getIntent();
        String TotalAmount=intent.getStringExtra("price");
        total.setText(TotalAmount);
        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String Name = edname.getText().toString();
                String Address = edaddress.getText().toString();
                String pincode = adpincode.getText().toString();
                String phone = adcontact.getText().toString();
                boolean checkPhone = validatephone(phone);
                boolean checkPincode = validatepincode(pincode);
                if (TextUtils.isEmpty(Name) || TextUtils.isEmpty(Address) || TextUtils.isEmpty(pincode) || TextUtils.isEmpty(phone)) {
                    Toast.makeText(CheckoutActivity.this, "Enter all Details", Toast.LENGTH_SHORT).show();
                }else{
                    if (checkPincode == true && checkPhone == true) {
                        String shopname = sharedPreferences.getString("shopname", "").toString();
                        db.addOrder(username, shopname, Name, Address, pincode, phone, Integer.parseInt(TotalAmount));
                        startActivity(new Intent(CheckoutActivity.this, progressActivity.class));
                    } else if (checkPincode == false) {
                        Toast.makeText(CheckoutActivity.this, "Length of Pincode should be 6", Toast.LENGTH_SHORT).show();

                    } else if (checkPhone == false) {
                        Toast.makeText(CheckoutActivity.this, "Length of Contact should be 10", Toast.LENGTH_SHORT).show();
                    }
            }
        }
        });
        back=findViewById(R.id.backcheckout);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), OrdersActivity.class));
            }
        });
    }
    boolean validatephone(String phone){
        Pattern p=Pattern.compile("[0-9]{10}");
        Matcher m=p.matcher(phone);
        return  m.matches();
    }
    boolean validatepincode(String pincode){
        Pattern p=Pattern.compile("[0-9]{6}");
        Matcher m=p.matcher(pincode);
        return  m.matches();
    }
}