package com.codinginflow.klfocus;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class coordinatorremove extends AppCompatActivity {

    EditText txtremcoordinator;
    Button btnremcoordinator;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinatorremove);



        txtremcoordinator=(EditText)findViewById(R.id.adminremcore);
        btnremcoordinator=(Button)findViewById(R.id.btnremcoordinator);

        Intent intentOnSendMessage = getIntent();
        final String eventname = intentOnSendMessage.getStringExtra("eventname");

        reff= FirebaseDatabase.getInstance().getReference().child(eventname).child("coordinator");

        btnremcoordinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=txtremcoordinator.getText().toString().trim();
                reff.child(id).removeValue()
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // There has been an error fetching the config
                                //Log.w(TAG, "Error fetching config", e);
                                //applyRetrievedLengthLimit();
                                Toast.makeText(coordinatorremove.this,"Failed",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(coordinatorremove.this,"coordinator removed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });



    }
}
