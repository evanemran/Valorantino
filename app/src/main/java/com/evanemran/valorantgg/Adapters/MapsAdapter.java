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
import com.evanemran.valorantgg.Models.MapsResponse;
import com.evanemran.valorantgg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MapsAdapter extends RecyclerView.Adapter<MapsViewHolder>{
    Context context;
    List<MapsResponse> list;
    ClickListener<MapsResponse> listener;

    public MapsAdapter(Context context, List<MapsResponse> list, ClickListener<MapsResponse> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MapsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MapsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_maps, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MapsViewHolder holder, int position) {
        Picasso.get().load(list.get(position).splash).into(holder.imageView_home);
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

class MapsViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    ImageView imageView_home;
    TextView textView_home;

    public MapsViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_agent);
        imageView_home = itemView.findViewById(R.id.imageView_agent);
        textView_home = itemView.findViewById(R.id.textView_agent);
    }
}
