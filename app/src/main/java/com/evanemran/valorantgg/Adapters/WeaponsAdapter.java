package com.evanemran.valorantgg.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Models.Datum;
import com.evanemran.valorantgg.Models.Weapons;
import com.evanemran.valorantgg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WeaponsAdapter extends RecyclerView.Adapter<WeaponsViewHolder>{
    Context context;
    List<Weapons> list;
    ClickListener<Weapons> listener;

    public WeaponsAdapter(Context context, List<Weapons> list, ClickListener<Weapons> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public WeaponsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WeaponsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_weapons, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeaponsViewHolder holder, int position) {
        Picasso.get().load(list.get(position).displayIcon).into(holder.imageView_home);
        holder.textView_home.setText(list.get(position).displayName);
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

class WeaponsViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    ImageView imageView_home;
    TextView textView_home;

    public WeaponsViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_agent);
        imageView_home = itemView.findViewById(R.id.imageView_agent);
        textView_home = itemView.findViewById(R.id.textView_agent);
    }
}
