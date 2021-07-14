package com.example.realtimeprojecttracking;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListOnline extends AppCompatActivity {
DatabaseReference onlineRef,currentRef,counterRef;
FirebaseRecyclerAdapter<User,ListOnlineViewHolder> adapter;

//view
    RecyclerView listOnline;
    RecyclerView.LayoutManager layoutManager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_online);

        listOnline=findViewById(R.id.listOnline);
        listOnline.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        listOnline.setLayoutManager(layoutManager);

        Toolbar toolbar=findViewById(R.id.toolbar);
        toolbar.setTitle("EDMP Presence System");
      setSupportActionBar(toolbar);

      onlineRef= FirebaseDatabase.getInstance().getReference().child(".info/connected");
      counterRef=FirebaseDatabase.getInstance().getReference("lastOnline");
      currentRef=FirebaseDatabase.getInstance().getReference("lastOnline").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
      setupSystem();
      updatelist();

    }

    private void updatelist() {
        FirebaseRecyclerOptions<User> firebaseRecyclerOptions = new FirebaseRecyclerOptions.Builder<User>()
                .setQuery(currentRef, User.class)
                .build();

        adapter=new FirebaseRecyclerAdapter<User, ListOnlineViewHolder>(firebaseRecyclerOptions) {
            @Override
            protected void onBindViewHolder(@NonNull ListOnlineViewHolder holder, int position, @NonNull User model) {
holder.txtEmail.setText(model.getEmail());
            }

            @NonNull
            @Override
            public ListOnlineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
        adapter.notifyDataSetChanged();
        listOnline.setAdapter(adapter);
                /*FirebaseRecyclerAdapter<User, ListOnlineViewHolder>(
                User.class,
                R.layout.user_layout,
                ListOnlineViewHolder.class,
                counterRef
        ) {
            @Override
            protected void onBindViewHolder(@NonNull ListOnlineViewHolder holder, int position, @NonNull User model) {
             holder.txtEmail.setText(model.getEmail());

            }


            @NonNull
            @Override
            public ListOnlineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };
        adapter.notifyDataSetChanged();
        listOnline.setAdapter(adapter);

                 */
    }

    private void setupSystem() {
        onlineRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.getValue(Boolean.class)){
                    currentRef.onDisconnect().removeValue(); // delete old value
counterRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(new User(FirebaseAuth.getInstance().getCurrentUser().getEmail(),"Online"));
adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        counterRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    User user=postSnapshot.getValue(User.class);
                    Log.d("LOG",""+user.getEmail()+" is "+user.getStatus());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_json:
                counterRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(new User(FirebaseAuth.getInstance().getCurrentUser().getEmail(),"Online"));
            break;
            case R.id.actionLogout:
                currentRef.removeValue();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
