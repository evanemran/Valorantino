package com.evanemran.valorantgg.Adapters;

import android.content.Context;
import android.graphics.PorterDuff;
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
import com.evanemran.valorantgg.Listeners.HomeClickListener;
import com.evanemran.valorantgg.Models.Grids;
import com.evanemran.valorantgg.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder>{
    Context context;
    List<Grids> list;
    HomeClickListener<Grids> listener;
    boolean isTopMenu;
    private int selectedPos = 0;

    public HomeAdapter(Context context, List<Grids> list, HomeClickListener<Grids> listener, boolean isTopMenu, int selectedPos) {
        this.context = context;
        this.list = list;
        this.listener = listener;
        this.isTopMenu = isTopMenu;
        this.selectedPos = selectedPos;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (isTopMenu){
            return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_top, parent, false));
        }
        else return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.imageView_home.setImageResource(list.get(position).getIcon());
        holder.textView_home.setText(list.get(position).getStringId());
        if (isTopMenu){
            holder.cardView_home.setCardBackgroundColor(selectedPos == holder.getAdapterPosition() ? holder.itemView.getResources().getColor(R.color.mist, null) : holder.itemView.getResources().getColor(R.color.black, null));
            holder.textView_home.setTextColor(selectedPos == holder.getAdapterPosition() ? holder.itemView.getResources().getColor(R.color.white, null) : holder.itemView.getResources().getColor(R.color.sand, null));
            if (selectedPos != holder.getAdapterPosition()){
                holder.imageView_home.setColorFilter(ContextCompat.getColor(context, R.color.sand), PorterDuff.Mode.MULTIPLY);
            }
            else{
                holder.imageView_home.setColorFilter(null);
            }
        }
        holder.textView_home.setSelected(true);
        holder.cardView_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClicked(list.get(holder.getAdapterPosition()), holder.getAdapterPosition());
                notifyItemChanged(selectedPos);
                selectedPos = holder.getAdapterPosition();
                notifyItemChanged(selectedPos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class HomeViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    ImageView imageView_home;
    TextView textView_home;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_home);
        imageView_home = itemView.findViewById(R.id.imageView_home);
        textView_home = itemView.findViewById(R.id.textView_home);
    }
}
