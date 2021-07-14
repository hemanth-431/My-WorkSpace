package com.example.hashinclude;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class StartActivity extends AppCompatActivity {
   ImageView bag;
   LinearLayout texthome,menu;
   Animation bagnim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
bag=findViewById(R.id.bag);
menu=findViewById(R.id.menus);
bagnim= AnimationUtils.loadAnimation(this,R.anim.animaation);
bag.animate().translationY(-1500).setDuration(800).setStartDelay(300);
//menu.startAnimation(bagnim);

    }
}
