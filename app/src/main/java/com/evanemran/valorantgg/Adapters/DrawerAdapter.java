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
import com.evanemran.valorantgg.Models.Grids;
import com.evanemran.valorantgg.Models.NavMenu;
import com.evanemran.valorantgg.R;

import java.util.List;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerViewHolder>{
    Context context;
    List<NavMenu> list;
    ClickListener<NavMenu> listener;

    public DrawerAdapter(Context context, List<NavMenu> list, ClickListener<NavMenu> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DrawerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DrawerViewHolder(LayoutInflater.from(context).inflate(R.layout.list_drawer, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DrawerViewHolder holder, int position) {
        holder.textView_drawer.setText(list.get(position).getStringId());
        holder.imageView_drawer.setImageResource(list.get(position).getIcon());
        holder.drawer_container.setOnClickListener(new View.OnClickListener() {
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
class DrawerViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_drawer;
    TextView textView_drawer;
    CardView drawer_container;

    public DrawerViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView_drawer = itemView.findViewById(R.id.imageView_drawer);
        textView_drawer = itemView.findViewById(R.id.textView_drawer);
        drawer_container = itemView.findViewById(R.id.drawer_container);
    }
}
