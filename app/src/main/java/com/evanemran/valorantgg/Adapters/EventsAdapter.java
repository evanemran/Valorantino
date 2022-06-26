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
import com.evanemran.valorantgg.Models.EventsResponse;
import com.evanemran.valorantgg.Models.MapsResponse;
import com.evanemran.valorantgg.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsViewHolder>{
    Context context;
    List<EventsResponse> list;
    ClickListener<EventsResponse> listener;

    public EventsAdapter(Context context, List<EventsResponse> list, ClickListener<EventsResponse> listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EventsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EventsViewHolder(LayoutInflater.from(context).inflate(R.layout.list_events, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EventsViewHolder holder, int position) {
        holder.textView_event.setText(list.get(position).displayName);
        holder.textView_event.setSelected(true);
        holder.textView_event_desc.setText(list.get(position).shortDisplayName);
        holder.textView_event_desc.setSelected(true);
        holder.textView_start.setText(list.get(position).startTime);
        holder.textView_end.setText(list.get(position).endTime);
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

class EventsViewHolder extends RecyclerView.ViewHolder {

    CardView cardView_home;
    TextView textView_event, textView_event_desc, textView_start, textView_end;

    public EventsViewHolder(@NonNull View itemView) {
        super(itemView);

        cardView_home = itemView.findViewById(R.id.cardView_agent);
        textView_event = itemView.findViewById(R.id.textView_event);
        textView_event_desc = itemView.findViewById(R.id.textView_event_desc);
        textView_start = itemView.findViewById(R.id.textView_start);
        textView_end = itemView.findViewById(R.id.textView_end);
    }
}
