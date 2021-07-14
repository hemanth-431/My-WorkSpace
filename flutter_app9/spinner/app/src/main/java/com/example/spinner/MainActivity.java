package com.example.spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    EditText eddata;
    String textdata="";
    Button button;
    Spinner spinner;

    ValueEventListener listener;
    ArrayAdapter<String> adapter;
    ArrayList<String> spinnerdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference= FirebaseDatabase.getInstance().getReference("Events");
        spinner = findViewById(R.id.myspinner);

        button=findViewById(R.id.button);
        eddata=findViewById(R.id.editText2);


        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retrive();
                addartist();



            }
        }));



    }
    public  void addartist()
    {
        String name=eddata.getText().toString().trim();
        String gener=spinner.getSelectedItem().toString();
        if(!TextUtils.isEmpty(name))
        {
            String id=databaseReference.push().getKey();
            artists artists=new artists(id,name,gener);
            databaseReference.child(id).setValue(artists);

           // spinnerdata = new ArrayList<String>();
         //   adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,spinnerdata);
        //    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //    spinner1.setAdapter(adapter);  ---------------------------

        }
        else {
            Toast.makeText(this,"Yes",Toast.LENGTH_LONG).show();
        }


    }
    public void retrive()
    {
        listener=databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                spinnerdata = new ArrayList<String>();
            for(DataSnapshot item:dataSnapshot.getChildren()){

                String titlename = item.child("Events").getValue(String.class);
                if(titlename!=null) {
                    spinnerdata.add(titlename);
                }
//artists data= item.getValue(artists.class);
//spinnerdata.add(data.getName());
                    //String name=item.getValue(artists.class).getName();

                   //   spinnerdata.add(0,name);

                //    spinnerdata.add(item.getValue().toString());

            }
            //    spinnerdata = new ArrayList<String>();
                Spinner spinner1=(Spinner)findViewById(R.id.spinner);
                adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_dropdown_item,spinnerdata);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(adapter);
            adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
