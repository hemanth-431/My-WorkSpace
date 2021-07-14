package com.example.dropdown;

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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    EditText eddata;
    String textdata="";
    Button button;

    ValueEventListener valueEventListener;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> spinnerdata;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseDatabase=FirebaseDatabase.getInstance();

        databaseReference=FirebaseDatabase.getInstance().getReference("art");
        spinner = findViewById(R.id.myspinner);
        button=findViewById(R.id.button);
        eddata=findViewById(R.id.editText2);

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
    }
    else {
        Toast.makeText(this,"Yes",Toast.LENGTH_LONG).show();
    }
}
    }
