package com.example.sql;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    SQLiteDatabase db;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        db=openOrCreateDatabase("Club",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists Dsc(name varchar(50),age integer);");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  name=e1.getText().toString();
                int age=Integer.parseInt(e2.getText().toString());
                db.execSQL("insert into dsc values('"+name+"','"+age+"');");
                Toast.makeText(MainActivity.this, "Successfully Inserted",Toast.LENGTH_SHORT).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(i);
            }
        });
    }
}

