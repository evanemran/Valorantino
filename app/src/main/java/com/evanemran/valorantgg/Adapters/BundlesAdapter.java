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
import com.evanemran.valorantgg.Models.BuddiesResponse;
import com.evanemran.valorantgg.Models.BundlesResponse;
import com.evanemran.valorantgg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BundlesAdapter extends RecyclerView.Adapter<BundlesViewHolder>{
    Context context;
    List<BundlesResponse> list;
    ClickListener<BundlesResponse> listener;

    public BundlesAdapter(Context context, List<BundlesResponse> list, ClickListener<BundlesResponse> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public BundlesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BundlesViewHolder(LayoutInflater.from(context).inflate(R.layout.list_bundles, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BundlesViewHolder holder, int position) {
        Picasso.get().load(list.get(position).verticalPromoImage).into(holder.imageView_home);
        try{
            holder.textView_home.setText(list.get(position).displayName);
            holder.textView_displayName_sub.setText(String.valueOf(list.get(position).displayNameSubText) + "");
            holder.textView_displayName_desc.setText(list.get(position).description);
            holder.textView_home.setSelected(true);
            holder.textView_displayName_sub.setSelected(true);
            holder.textView_home.setSelected(true);
        }catch (Exception e){
            e.printStackTrace();
        }
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

class BundlesViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    ImageView imageView_home;
    TextView textView_home, textView_displayName_sub, textView_displayName_desc;

    public BundlesViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_agent);
        imageView_home = itemView.findViewById(R.id.imageView_agent);
        textView_home = itemView.findViewById(R.id.textView_displayName);
        textView_displayName_sub = itemView.findViewById(R.id.textView_displayName_sub);
        textView_displayName_desc = itemView.findViewById(R.id.textView_displayName_desc);
    }
}
