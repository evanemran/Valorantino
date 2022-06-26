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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.evanemran.valorantgg.Adapters.AgentAdapter;
import com.evanemran.valorantgg.Adapters.WeaponsAdapter;
import com.evanemran.valorantgg.AgentDetailsActivity;
import com.evanemran.valorantgg.Listeners.ApiResponseListener;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Manager.RequestManager;
import com.evanemran.valorantgg.Models.Datum;
import com.evanemran.valorantgg.Models.Weapons;
import com.evanemran.valorantgg.R;
import com.evanemran.valorantgg.WeaponsActivity;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.List;

public class WeaponsFragment extends Fragment {
    View view;
    RequestManager manager;
    RecyclerView recycler_weapons;
    WeaponsAdapter weaponsAdapter;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_weapons, container, false);

        recycler_weapons = view.findViewById(R.id.recycler_weapons);

        progressBar = (ProgressBar) view.findViewById(R.id.loader);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);

        manager = new RequestManager(getContext());
        manager.GetWeapons(agentResponseListener);
        return view;
    }

    private final ApiResponseListener<List<Weapons>> agentResponseListener = new ApiResponseListener<List<Weapons>>() {
        @Override
        public void didFetch(List<Weapons> response, String message) {
            recycler_weapons.setHasFixedSize(true);
            recycler_weapons.setLayoutManager(new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL));
            weaponsAdapter = new WeaponsAdapter(getContext(), response, clickListener);
            recycler_weapons.setAdapter(weaponsAdapter);
            progressBar.setVisibility(View.GONE);
            recycler_weapons.setVisibility(View.VISIBLE);
        }

        @Override
        public void didError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private final ClickListener<Weapons> clickListener = new ClickListener<Weapons>() {
        @Override
        public void onClicked(Weapons item) {
            startActivity(new Intent(getActivity(), WeaponsActivity.class)
            .putExtra("weapon", item));
        }
    };
}
