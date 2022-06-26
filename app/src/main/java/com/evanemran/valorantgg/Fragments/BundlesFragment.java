package com.evanemran.valorantgg.Fragments;

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

import com.evanemran.valorantgg.Adapters.BuddiesAdapter;
import com.evanemran.valorantgg.Adapters.BundlesAdapter;
import com.evanemran.valorantgg.Listeners.ApiResponseListener;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Manager.RequestManager;
import com.evanemran.valorantgg.Models.BuddiesResponse;
import com.evanemran.valorantgg.Models.BundlesResponse;
import com.evanemran.valorantgg.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.List;

public class BundlesFragment extends Fragment {
    View view;
    RequestManager manager;
    RecyclerView recycler_maps;
    BundlesAdapter bundlesAdapter;
    ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bundles, container, false);

        recycler_maps = view.findViewById(R.id.recycler_maps);

        progressBar = (ProgressBar) view.findViewById(R.id.loader);
        Sprite doubleBounce = new Wave();
        progressBar.setIndeterminateDrawable(doubleBounce);

        manager = new RequestManager(getContext());
        manager.GetBundles(agentResponseListener);
        return view;
    }

    private final ApiResponseListener<List<BundlesResponse>> agentResponseListener = new ApiResponseListener<List<BundlesResponse>>() {
        @Override
        public void didFetch(List<BundlesResponse> response, String message) {
            recycler_maps.setHasFixedSize(true);
            recycler_maps.setLayoutManager(new GridLayoutManager(getContext(), 1));
            bundlesAdapter = new BundlesAdapter(getContext(), response, clickListener);
            recycler_maps.setAdapter(bundlesAdapter);
            progressBar.setVisibility(View.GONE);
            recycler_maps.setVisibility(View.VISIBLE);
        }

        @Override
        public void didError(String message) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    };

    private final ClickListener<BundlesResponse> clickListener = new ClickListener<BundlesResponse>() {
        @Override
        public void onClicked(BundlesResponse item) {
//            startActivity(new Intent(getActivity(), MapsActivity.class)
//            .putExtra("maps", item));
        }
    };
}
