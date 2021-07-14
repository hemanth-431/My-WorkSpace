package com.codinginflow.klfocus;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class login extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Spinner spinner,spinner2;
    DatabaseReference ref;
    DatabaseReference databaseReference;
    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> spinnerDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        spinner=(Spinner)findViewById(R.id.login);
        spinner2=(Spinner)findViewById(R.id.login2);
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);

        databaseReference= FirebaseDatabase.getInstance().getReference("SpinnerData");


        spinnerDataList=new ArrayList<>();
        adapter=new ArrayAdapter<String>(login.this,
                android.R.layout.simple_spinner_dropdown_item,spinnerDataList);

        spinner2.setAdapter(adapter);
        retrieveData();


    }
    public void onClickLogin(View view)
    {

        final String strspinner=String.valueOf(spinner.getSelectedItem());
        final String strspinner2=String.valueOf(spinner2.getSelectedItem());
        final String strid=Name.getText().toString();
        final String strpass=Password.getText().toString();
        final ProgressDialog loading = ProgressDialog.show(this,"Logging In","Please wait");







        //ref = FirebaseDatabase.getInstance().getReference().child("core");

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference userNameRef = rootRef.child(strspinner2).child(strspinner).child(strid);
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!dataSnapshot.exists()) {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(),"No user found",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"User exists",Toast.LENGTH_SHORT).show();
                    userNameRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            core userProfile = dataSnapshot.getValue(core.class);
                            loading.dismiss();

                            if(strpass.equals(userProfile.getPassword()))
                            {
                                Toast.makeText(getApplicationContext(),"Password checked",Toast.LENGTH_SHORT).show();
                                if(strspinner.equals("admin")) {
                                    Intent intentOnSendMessage = new Intent(getApplicationContext(), admin.class);
                                    intentOnSendMessage.putExtra("eventname",userProfile.getEvent());
                                    startActivity(intentOnSendMessage);
                                    Toast.makeText(getApplicationContext(),"admin module",Toast.LENGTH_SHORT).show();

                                }
                                else if(strspinner.equals("core"))
                                {
                                    Toast.makeText(getApplicationContext(),"core module",Toast.LENGTH_SHORT).show();


                                    Intent intentOnSendMessage = new Intent(getApplicationContext(), coreactivity.class);
                                    intentOnSendMessage.putExtra("eventname",userProfile.getEvent());
                                    startActivity(intentOnSendMessage);



                                }
                                else if(strspinner.equals("coordinator"))
                                {
                                    Toast.makeText(getApplicationContext(),"coordinator module",Toast.LENGTH_SHORT).show();



                                    Intent intentOnSendMessage = new Intent(getApplicationContext(), coordinatoractivity.class);
                                    intentOnSendMessage.putExtra("eventname",userProfile.getEvent());
                                    startActivity(intentOnSendMessage);

                                }
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),"Incorrect Password",Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    //Intent intentOnSendMessage=new Intent(getApplicationContext(),admin.class);
                    //startActivity(intentOnSendMessage);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
            }
        };
        userNameRef.addListenerForSingleValueEvent(eventListener);





















    }
    public void retrieveData(){
        listener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot item:dataSnapshot.getChildren()){
                    spinnerDataList.add(item.getValue().toString());
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
