package com.codinginflow.swipeviewpager;

import android.animation.ArgbEvaluator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] color=null;
    ArgbEvaluator argbEvaluator=new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models=new ArrayList<>();
        models.add(new Model(R.drawable.saithrilok,"SAI THRILOK","ANDROID DEVELOPER"));
        models.add(new Model(R.drawable.hemanthpic,"Venkata Hemanth Bandla","ANDROID DEVELOPER"));
        models.add(new Model(R.drawable.shraddhakapoor,"SHRADDHA KAPOOR","ACTRESS"));
        models.add(new Model(R.drawable.praneeth,"PRANEETH","WEB DEVELOPER"));
        adapter=new Adapter(models,this);
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp={
                getResources().getColor(R.color.color1),

        };

        color=colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionoffset, int positionoffsetpixels) {
                if (position<(adapter.getCount()-1)&&position<(color.length-1)){
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
