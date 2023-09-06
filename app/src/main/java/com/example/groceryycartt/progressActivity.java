package com.example.groceryycartt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class progressActivity extends AppCompatActivity {
    ProgressBar prog;
    TextView Cancel;
    int count=0;
    AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        prog=findViewById(R.id.progressBar);
        Cancel=findViewById(R.id.cancel);
        builder=new AlertDialog.Builder(this);
        DBHelper db= new DBHelper(this);
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                count++;
                prog.setProgress(count);

                if(count==100){

                    timer.cancel();
                    Intent intent=new Intent(progressActivity.this,OrderSuccessfull.class);
                    startActivity(intent);
                }

            }
//            Cancel.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    timer.cancel();
//                    builder.setTitle("Alert!!")
//                            .setMessage("Do you want to cancel the order?")
//                            .setCancelable(true)
//                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    timer.cancel();
//                                    startActivity(new Intent(progressActivity.this, OrdersActivity.class));
//                                }
//                            })
//                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.cancel();
//                                }
//                            })
//                            .show();
//
//                }
//            });
        };
        timer.schedule(timerTask,100,100);
        Cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    timer.cancel();
                    builder.setTitle("Alert!!")
                            .setMessage("Do you want to cancel the order?")
                            .setCancelable(true)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                                    String username = sharedPreferences.getString("username", "").toString();
                                    db.removeOrders(username);

                                    timer.cancel();
                                    startActivity(new Intent(progressActivity.this, OrdersActivity.class));
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                    timer.cancel();
                                    Intent intent=new Intent(progressActivity.this,OrderSuccessfull.class);
                                    startActivity(intent);
                                }
                            })
                            .show();

                }
            });
    }
}