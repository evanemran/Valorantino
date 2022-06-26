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

import com.evanemran.valorantgg.Adapters.AgentAdapter;
import com.evanemran.valorantgg.AgentDetailsActivity;
import com.evanemran.valorantgg.Listeners.ApiResponseListener;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Manager.RequestManager;
import com.evanemran.valorantgg.Models.Datum;
import com.evanemran.valorantgg.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.List;

public class AgentsFragment extends Fragment {
    View view;
    RequestManager manager;
    RecyclerView recycler_agents;
    AgentAdapter agentAdapter;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_agents, container, false);

        recycler_agents = view.findViewById(R.id.recycler_agents);

        progressBar = (ProgressBar) view.findViewById(R.id.loader);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);

        manager = new RequestManager(getContext());
        manager.GetAgents(agentResponseListener);
        return view;
    }

    private final ApiResponseListener<List<Datum>> agentResponseListener = new ApiResponseListener<List<Datum>>() {
        @Override
        public void didFetch(List<Datum> response, String message) {
            recycler_agents.setHasFixedSize(true);
            recycler_agents.setLayoutManager(new GridLayoutManager(getContext(), 4));
            agentAdapter = new AgentAdapter(getContext(), response, clickListener);
            recycler_agents.setAdapter(agentAdapter);
            progressBar.setVisibility(View.GONE);
            recycler_agents.setVisibility(View.VISIBLE);
        }

        @Override
        public void didError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private final ClickListener<Datum> clickListener = new ClickListener<Datum>() {
        @Override
        public void onClicked(Datum item) {
            startActivity(new Intent(getActivity(), AgentDetailsActivity.class)
            .putExtra("datum", item));
        }
    };
}
