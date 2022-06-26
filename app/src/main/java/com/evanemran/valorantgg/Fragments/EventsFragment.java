package com.evanemran.valorantgg.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evanemran.valorantgg.Adapters.EventsAdapter;
import com.evanemran.valorantgg.Adapters.MapsAdapter;
import com.evanemran.valorantgg.Listeners.ApiResponseListener;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Manager.RequestManager;
import com.evanemran.valorantgg.MapsActivity;
import com.evanemran.valorantgg.Models.EventsResponse;
import com.evanemran.valorantgg.Models.MapsResponse;
import com.evanemran.valorantgg.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.List;

public class EventsFragment extends Fragment {
    View view;
    RequestManager manager;
    RecyclerView recycler_maps;
    EventsAdapter eventsAdapter;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_events, container, false);

        recycler_maps = view.findViewById(R.id.recycler_maps);

        progressBar = (ProgressBar) view.findViewById(R.id.loader);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);

        manager = new RequestManager(getContext());
        manager.GetEvents(agentResponseListener);
        return view;
    }

    private final ApiResponseListener<List<EventsResponse>> agentResponseListener = new ApiResponseListener<List<EventsResponse>>() {
        @Override
        public void didFetch(List<EventsResponse> response, String message) {
            recycler_maps.setHasFixedSize(true);
            recycler_maps.setLayoutManager(new GridLayoutManager(getContext(), 2));
            eventsAdapter = new EventsAdapter(getContext(), response, clickListener);
            recycler_maps.setAdapter(eventsAdapter);
            progressBar.setVisibility(View.GONE);
            recycler_maps.setVisibility(View.VISIBLE);
        }

        @Override
        public void didError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private final ClickListener<EventsResponse> clickListener = new ClickListener<EventsResponse>() {
        @Override
        public void onClicked(EventsResponse item) {
//            startActivity(new Intent(getActivity(), MapsActivity.class)
//            .putExtra("maps", item));
        }
    };
}
