package com.example.scroll;
import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    Adapter cadapter;
    List<Model> models;
    Integer[] color=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//------------------------------
        models=new ArrayList<>();
        models.add(new Model(R.drawable.hemanthpic,"SAI THRILOK","ANDROID DEVELOPER"));
        models.add(new Model(R.drawable.hemanthpic,"Venkata Hemanth Bandla","ANDROID DEVELOPER"));

        cadapter=new Adapter(models,this);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(cadapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.colorPrimary),

        };

        color=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionoffset, int positionoffsetpixels) {
                if (position<(cadapter.getCount()-1)&&position<(color.length-1)){
                    viewPager.setBackgroundColor((Integer)argbEvaluator.evaluate(positionoffset,color[position],color[position]));
                }
                else {
                    viewPager.setBackgroundColor(color[color.length-1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}