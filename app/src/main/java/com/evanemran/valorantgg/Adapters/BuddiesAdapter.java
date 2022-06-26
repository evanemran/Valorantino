package com.evanemran.valorantgg.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Models.BuddiesResponse;
import com.evanemran.valorantgg.Models.MapsResponse;
import com.evanemran.valorantgg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BuddiesAdapter extends RecyclerView.Adapter<BuddiesViewHolder>{
    Context context;
    List<BuddiesResponse> list;
    ClickListener<BuddiesResponse> listener;

    public BuddiesAdapter(Context context, List<BuddiesResponse> list, ClickListener<BuddiesResponse> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BuddiesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BuddiesViewHolder(LayoutInflater.from(context).inflate(R.layout.list_buddies, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BuddiesViewHolder holder, int position) {
        Picasso.get().load(list.get(position).displayIcon).into(holder.imageView_home);
        holder.textView_home.setText(list.get(position).displayName);
        holder.textView_charmlevel.setText(list.get(position).levels.get(0).charmLevel+"");
        holder.textView_charmname.setText(list.get(position).levels.get(0).displayName);
        if (list.get(position).isHiddenIfNotOwned){
            holder.button_hidden.setBackgroundResource(R.color.red);
            holder.button_hidden.setText("Hidden");
        }
        else{
            holder.button_hidden.setBackgroundResource(R.color.green);
            holder.button_hidden.setText("Open");
        }
        holder.textView_home.setSelected(true);
        holder.cardView_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(list.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class BuddiesViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    ImageView imageView_home;
    TextView textView_home, button_hidden, textView_charmlevel, textView_charmname;

    public BuddiesViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_agent);
        imageView_home = itemView.findViewById(R.id.imageView_agent);
        textView_home = itemView.findViewById(R.id.textView_displayName);
        button_hidden = itemView.findViewById(R.id.button_hidden);
        textView_charmlevel = itemView.findViewById(R.id.textView_charmlevel);
        textView_charmname = itemView.findViewById(R.id.textView_charmname);
    }
}
