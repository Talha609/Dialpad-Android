package com.example.mohdtalha.phone;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;
    String n = "";
    TextView tv;
    ImageView del, call;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, str, hash, blnk;
    TelephonyManager mTelephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().hide();
        tv = findViewById(R.id.tv);
        blnk = findViewById(R.id.blnk);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        str = findViewById(R.id.str);
        hash = findViewById(R.id.hash);
        del = findViewById(R.id.del);
        call = findViewById(R.id.call);
        blnk.setVisibility(View.INVISIBLE);
        if (n.length() == 0) {
            del.setVisibility(View.INVISIBLE);
        }
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "0";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "1";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "2";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "3";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "4";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "5";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "6";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "7";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "8";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "9";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        str.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "*";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n = n + "#";
                tv.setText(n);
                del.setVisibility(View.VISIBLE);
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    int l = n.length();
                    n = n.substring(0, l - 1);
                    tv.setText(n);
                } catch (Exception e) {
                }
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    String phoneNumber = String.format("tel: %s", n);
                    Uri call = Uri.parse(phoneNumber);
                    Intent dialIntent = new Intent(Intent.ACTION_CALL);
                    dialIntent.setData(call);
                    if (dialIntent.resolveActivity(getPackageManager()) != null) {
                        checkForPhonePermission();
                        startActivity(dialIntent);
                    } else {
                        Toast.makeText(MainActivity.this, "Can't resolve app for ACTION_DIAL Intent.", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e)
                {

                }

            }
        });
    }
    private void checkForPhonePermission () {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //Log.d(TAG, getString(R.string.permission_not_granted));
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);
        } else {
            // Permission already granted.
        }

    }
    public void onRequestPermissionsResult(int requestCode,String permissions[],int[] grantResults)
    {
        switch (requestCode)
        {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE:
                {
                if (permissions[0].equalsIgnoreCase
                        (Manifest.permission.CALL_PHONE)
                        && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    // Permission was granted.
                } else {
                    // Permission denied. Stop the app.
                    // Disable the call button
                    call.setVisibility(View.INVISIBLE);
                }
            }
        }
    }
}