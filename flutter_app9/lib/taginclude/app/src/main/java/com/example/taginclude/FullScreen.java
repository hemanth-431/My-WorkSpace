package com.example.taginclude;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;

public class FullScreen extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        imageView=(ImageView)findViewById(R.id.image_view);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle("Gallary");
        Intent i=getIntent();
        int position=i.getExtras().getInt("id");
        imageAdapter imageAdapter=new imageAdapter(this);
imageView.setImageResource(imageAdapter.imagearray[position]);

    }
}
