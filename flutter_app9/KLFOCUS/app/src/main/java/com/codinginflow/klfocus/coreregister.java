package com.codinginflow.klfocus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class coreregister extends AppCompatActivity {

    EditText txtname,txtteam,txtpassword,txtid;
    Button btncore;
    DatabaseReference reff;
    core coree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coreregister);
        txtname=(EditText)findViewById(R.id.etUserName);
        txtteam=(EditText)findViewById(R.id.etUserEmail);
        txtpassword=(EditText)findViewById(R.id.etUserPassword);
        txtid=(EditText)findViewById(R.id.etAge);
        btncore=(Button)findViewById(R.id.btnCoreRegister);

        Intent intentOnSendMessage = getIntent();
        final String eventname = intentOnSendMessage.getStringExtra("eventname");

        coree=new core();
        reff= FirebaseDatabase.getInstance().getReference().child(eventname).child("core");

        btncore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coree.setId(txtid.getText().toString().trim());
                coree.setName(txtname.getText().toString().trim());
                coree.setPassword(txtpassword.getText().toString().trim());
                coree.setTeam(txtteam.getText().toString().trim());
                coree.setEvent(eventname);
                String id=txtid.getText().toString().trim();
                reff.child(id).setValue(coree);
                Toast.makeText(coreregister.this,"Core Member Added",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
