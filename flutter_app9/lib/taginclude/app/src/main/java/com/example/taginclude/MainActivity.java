package com.example.taginclude;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
CardView c,d,e,f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

c=findViewById(R.id.web);
d=findViewById(R.id.web1);
e=findViewById(R.id.web2);
f=findViewById(R.id.app);

c.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intentOnSendMessage=new Intent(getApplicationContext(),Events.class);
        startActivity(intentOnSendMessage);
    }
});
d.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intentOnSendMessage=new Intent(getApplicationContext(),events2.class);
        startActivity(intentOnSendMessage);
    }
});
e.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intentOnSendMessage=new Intent(getApplicationContext(),event3.class);
        startActivity(intentOnSendMessage);
    }
});
f.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intentOnSendMessage=new Intent(getApplicationContext(),gallary.class);
        startActivity(intentOnSendMessage);
    }
});


    }
}
