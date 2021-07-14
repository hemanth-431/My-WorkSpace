package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
ListView datalist;
List<String> lst;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        datalist=findViewById(R.id.list);
        lst=new ArrayList<>();
        db=openOrCreateDatabase("Club",MODE_PRIVATE,null);
        db.execSQL("Create table if not exists Dsc(name varchar(50),age integer);");
        Cursor c=db.rawQuery("select * from Dsc",null);
while (c.moveToNext())
{
    String s="Name: "+c.getString(0)+"\nAge:"+c.getString(1);
    lst.add(s);
}
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,lst);
datalist.setAdapter(arrayAdapter);
    }
}
