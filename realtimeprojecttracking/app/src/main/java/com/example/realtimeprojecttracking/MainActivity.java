package com.example.realtimeprojecttracking;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.maps.GoogleMap;
import com.google.firebase.database.DatabaseReference;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
//Button butto;
//private final static int LOGIN_PERMISSION=1000;
private GoogleMap mMap;
    private DatabaseReference databaseReference;

   // private LocationListener locationListener;
  //  private LocationManager locationManager;
    private final long MIN_TIME = 1000;
    private final long MIN_DIST = 5;

 //   private EditText editTextLatitude;
 //   private EditText editTextLongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    /*    butto=findViewById(R.id.button);
        butto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<AuthUI.IdpConfig> providers = Arrays.asList(
                        new AuthUI.IdpConfig.EmailBuilder().build());
startActivityForResult(
        AuthUI.getInstance().createSignInIntentBuilder().setAvailableProviders(providers).build(),LOGIN_PERMISSION
);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == LOGIN_PERMISSION){
            startNewActivity(resultCode,data);
        }
    }

    private void startNewActivity(int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
Intent i=new Intent(MainActivity.this,ListOnline.class);
startActivity(i);
finish();
        }else {
            Toast.makeText(MainActivity.this,"Login Failed!!",Toast.LENGTH_LONG).show();
        }


     */
    }
}
