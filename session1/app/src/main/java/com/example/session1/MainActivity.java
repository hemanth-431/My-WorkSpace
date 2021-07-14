package com.example.session1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText input,input5;
Button butt,button2,button3,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=findViewById(R.id.input2);
        input5=findViewById(R.id.input);

button2=findViewById(R.id.button2);
button3=findViewById(R.id.button3);
button4=findViewById(R.id.button4);

button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String s=input.getText().toString();
        String s2=input5.getText().toString();
        int result=0;
       try{ result=Integer.parseInt(s)-Integer.parseInt(s2);}catch (Exception e){}
        System.out.print(result);
        Toast.makeText(MainActivity.this,String.valueOf(result),Toast.LENGTH_LONG).show();
    }
});



    }
}
