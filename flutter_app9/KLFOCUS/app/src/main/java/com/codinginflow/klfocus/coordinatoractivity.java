package com.codinginflow.klfocus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class coordinatoractivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatoractivity);


        final Button takeatt = findViewById(R.id.coordinatortakeattendence);

        Intent intentOnSendMessage = getIntent();
        final String eventname = intentOnSendMessage.getStringExtra("eventname");

        takeatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), takeattendance.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                intentOnSendMessage.putExtra("post","coordinator");
                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,takeattendance.class));
            }
        });

    }
}
