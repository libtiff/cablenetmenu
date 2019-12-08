package com.cablenetmenu.libtiff.cablenetmenu;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private static final int MAKE_CALL_PERMISSION_REQUEST_CODE = 1;
    //
    private AdView mAdView;

    // Permissions
    private static final int REQUEST_CALL_PHONE = 1;
    private static final int REQUEST_READ_APN_SETTINGS= 1;
    private static final int REQUEST_ACCESS_NETWORK_STATE= 1;

    private static String[] PERMISSIONS_APP= {
            Manifest.permission.CALL_PHONE,Manifest.permission.ACCESS_NETWORK_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-9082725429338291~9699329161");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ImageButton btnvoice = (ImageButton)findViewById(R.id.voice);
        ImageButton btnsms = (ImageButton)findViewById(R.id.sms);
        ImageButton btndata = (ImageButton)findViewById(R.id.data);
        ImageButton btnbonus = (ImageButton)findViewById(R.id.bonus);
        ImageButton btnapn = (ImageButton)findViewById(R.id.apn);
        ImageButton btncallfw = (ImageButton)findViewById(R.id.callfw);
        ImageButton btndcallfw = (ImageButton)findViewById(R.id.dcallfwd);
        ImageButton btntoolkit = (ImageButton)findViewById(R.id.toolkit);
        final TextView txtnum = (TextView)findViewById(R.id.txtnum);


        btnvoice.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    callIntent.setData(Uri.parse("tel:*101*1%23"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_APP, REQUEST_CALL_PHONE);
                }
                else {
                    startActivity(callIntent);
                }


            }
        });

        btnsms.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:*101*2%23"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_APP, REQUEST_CALL_PHONE);
                }
                else {
                    startActivity(callIntent);
                }
            }
        });
        btndata.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:*101*3%23"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_APP, REQUEST_CALL_PHONE);
                }
                else {
                    startActivity(callIntent);
                }
            }
        });
        btnbonus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:*101*4%23"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_APP, REQUEST_CALL_PHONE);
                }
                else {
                    startActivity(callIntent);
                }
            }
        });
        btnapn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(Settings.ACTION_APN_SETTINGS);
                startActivity(intent);
            }
        });
        btncallfw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String num =  txtnum.getText().toString();
                if (num != null && !num.isEmpty()) {
                    num = "tel:" + "*21*" + txtnum.getText().toString();
                    callIntent.setData(Uri.parse(num + "%23"));
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // We don't have permission so prompt the user
                        ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_APP, REQUEST_CALL_PHONE);
                    }
                    else {
                        startActivity(callIntent);
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext() , "Telephone number is empty , please type the number you wish to callforward to the box above!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btndcallfw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                String num = "tel:" + "%23" + "%23" + "21" + "%23";
                callIntent.setData(Uri.parse(num));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    ActivityCompat.requestPermissions(MainActivity.this, PERMISSIONS_APP, REQUEST_CALL_PHONE);
                }
                else {
                    startActivity(callIntent);
                }
            }
        });
        btntoolkit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.android.stk");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });
    }

}
