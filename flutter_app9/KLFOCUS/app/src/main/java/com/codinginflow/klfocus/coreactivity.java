package com.codinginflow.klfocus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class coreactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coreactivity);


        final Button addco = findViewById(R.id.coreaddcoordinator);
        final Button remco = findViewById(R.id.coreremovecoordinator);
        final Button viewatt = findViewById(R.id.coreviewattendence);
        final Button viewco = findViewById(R.id.coreviewcoordinator);
        final Button takeatt = findViewById(R.id.coretakeattendence);

        Intent intentOnSendMessage = getIntent();
        final String eventname = intentOnSendMessage.getStringExtra("eventname");



        addco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), coordinatorregister.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                startActivity(intentOnSendMessage);


                //startActivity(new Intent(admin.this,coordinatorregister.class));
            }
        });



        takeatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), takeattendance.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                intentOnSendMessage.putExtra("post","core");
                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,takeattendance.class));
            }
        });



        remco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOnSendMessage = new Intent(getApplicationContext(), coordinatorremove.class);
                intentOnSendMessage.putExtra("eventname",eventname);

                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,coord.class));
            }
        });



        viewco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), recyclerCoreTeam.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                intentOnSendMessage.putExtra("eventpos","coordinator");
                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,takeattendance.class));
            }
        });
    }
}
