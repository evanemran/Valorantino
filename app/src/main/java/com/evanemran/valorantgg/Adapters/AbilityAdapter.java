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
import com.evanemran.valorantgg.Models.Ability;
import com.evanemran.valorantgg.Models.Datum;
import com.evanemran.valorantgg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AbilityAdapter extends RecyclerView.Adapter<AbilityViewHolder>{
    Context context;
    List<Ability> list;
    ClickListener<Ability> listener;

    public AbilityAdapter(Context context, List<Ability> list, ClickListener<Ability> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public AbilityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AbilityViewHolder(LayoutInflater.from(context).inflate(R.layout.list_ability, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull AbilityViewHolder holder, int position) {
        Picasso.get().load(list.get(position).displayIcon).into(holder.imageView_home);
        holder.textView_home.setText(list.get(position).displayName);
        holder.textView_ability_details.setText(list.get(position).description);
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

class AbilityViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    ImageView imageView_home;
    TextView textView_home, textView_ability_details;

    public AbilityViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_ability);
        imageView_home = itemView.findViewById(R.id.imageView_ability);
        textView_home = itemView.findViewById(R.id.textView_ability);
        textView_ability_details = itemView.findViewById(R.id.textView_ability_desc);
    }
}
