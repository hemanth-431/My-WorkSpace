package com.codinginflow.klfocus;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterClass extends RecyclerView.Adapter<AdapterClass.MyViewHolder> {
    ArrayList<Deal> list;
    public AdapterClass(ArrayList<Deal> list)
    {
        this.list=list;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id,desc;
        ImageView image;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            id=itemView.findViewById(R.id.dealId);
            desc=itemView.findViewById(R.id.description);
            image=itemView.findViewById(R.id.image);
        }
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_holder,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Deal d=list.get(i);
        myViewHolder.id.setText(list.get(i).getName());
        myViewHolder.desc.setText(list.get(i).getTeam());
        //if(d.getDealImage()!=null){
        //    Picasso.get().load(d.getDealImage()).into(myViewHolder.image);
        //}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

