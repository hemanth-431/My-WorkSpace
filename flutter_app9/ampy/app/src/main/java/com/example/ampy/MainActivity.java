package com.example.ampy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    CardView g;
    CardView ab;
    CardView t;
    CardView n;
    CardView c;
    CardView r;
    ViewFlipper v1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        g=findViewById(R.id.g);
        ab=findViewById(R.id.ab);
        t=findViewById(R.id.t);
        n=findViewById(R.id.n);
        c=findViewById(R.id.c);
        r=findViewById(R.id.r);

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MainActivity.this,GActivity.class));
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AbActivity.class));

            }
        });

        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TActivity.class));

            }
        });

        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NActivity.class));

            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CActivity.class));

            }
        });
         r.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this,RActivity.class));

             }
         });

        int images[]= {R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4};

        v1=findViewById(R.id.v1);
       /*for (int i=0; i<images.length; i++){
            flipperImages(images[i]);
        } */
        for(int image:images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView=new ImageView(this );
        imageView.setBackgroundResource(image);
        v1.addView(imageView);
        v1.setFlipInterval(2000);
        v1.setAutoStart(true);
        v1.setInAnimation(this,android.R.anim.slide_in_left);
        v1.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
