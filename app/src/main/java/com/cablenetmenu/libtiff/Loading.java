package com.cablenetmenu.libtiff.cablenetmenu;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Loading extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        imageView = (ImageView)findViewById(R.id.imageView);
        if (imageView == null) throw new AssertionError();
        imageView.setBackgroundResource(R.drawable.animation_loading);

        anim = (AnimationDrawable)imageView.getBackground();
        anim.start();

        Thread launchThread = new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    sleep(500);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();

                }catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        };
        launchThread.start();
    }
}
