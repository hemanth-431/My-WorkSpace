package com.codinginflow.klfocus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);


        final Button addcore = findViewById(R.id.adminaddcore);
        final Button remcore = findViewById(R.id.adminremovecore);
        final Button addco = findViewById(R.id.adminaddcoordinator);
        final Button remco = findViewById(R.id.adminremovecoordinator);
        final Button viewatt = findViewById(R.id.adminviewattendence);
        final Button viewcore = findViewById(R.id.adminviewcore);
        final Button viewco = findViewById(R.id.adminviewcoordinator);
        final Button takeatt = findViewById(R.id.admintakeattendence);

        Intent intentOnSendMessage = getIntent();
        final String eventname = intentOnSendMessage.getStringExtra("eventname");

        addcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOnSendMessage = new Intent(getApplicationContext(), coreregister.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                startActivity(intentOnSendMessage);



                //startActivity(new Intent(admin.this,coreregister.class));
            }
        });

        addco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), coordinatorregister.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                startActivity(intentOnSendMessage);


                //startActivity(new Intent(admin.this,coordinatorregister.class));
            }
        });

        remcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOnSendMessage = new Intent(getApplicationContext(), coreremove.class);
                intentOnSendMessage.putExtra("eventname",eventname);

                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,coreremove.class));
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


        takeatt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), takeattendance.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                intentOnSendMessage.putExtra("post","admin");
                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,takeattendance.class));
            }
        });


        viewcore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intentOnSendMessage = new Intent(getApplicationContext(), recyclerCoreTeam.class);
                intentOnSendMessage.putExtra("eventname",eventname);
                intentOnSendMessage.putExtra("eventpos","core");
                startActivity(intentOnSendMessage);

                //startActivity(new Intent(admin.this,takeattendance.class));
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
