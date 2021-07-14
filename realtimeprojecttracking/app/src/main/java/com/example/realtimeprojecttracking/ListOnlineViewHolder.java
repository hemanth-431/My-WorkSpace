package com.example.realtimeprojecttracking;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ListOnlineViewHolder extends RecyclerView.ViewHolder {
public TextView txtEmail;
    public ListOnlineViewHolder(@NonNull View itemView) {
        super(itemView);
        txtEmail=itemView.findViewById(R.id.txt_email);

    }
}
