package com.evanemran.valorantgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.evanemran.valorantgg.Adapters.HomeAdapter;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Listeners.HomeClickListener;
import com.evanemran.valorantgg.Models.Grids;

import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity implements HomeClickListener<Grids> {
    Fragment fragment;
    Grids grids;
    FrameLayout fragment_container;
    RecyclerView recycler_top_menu;
    List<Grids> gridsList = new ArrayList<>();
    HomeAdapter homeAdapter;
    String position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        fragment_container = findViewById(R.id.fragment_container);
        recycler_top_menu = findViewById(R.id.recycler_top_menu);

        grids = (Grids) getIntent().getSerializableExtra("fragment");
        position = getIntent().getStringExtra("pos");

        setupTopMenu();

        if (grids!=null){
            setTitle(grids.getStringId());
            fragment = grids.getFragment();
            setFragment(fragment);
        }
    }

    private void setupTopMenu() {
        gridsList.add(Grids.AGENT);
        gridsList.add(Grids.WEAPONS);
        gridsList.add(Grids.MAPS);
        gridsList.add(Grids.EVENTS);
        gridsList.add(Grids.BUDDIES);
        gridsList.add(Grids.BUNDLES);
        gridsList.add(Grids.TIERS);
        gridsList.add(Grids.SPRAYS);
        gridsList.add(Grids.SEASONS);
        gridsList.add(Grids.GEAR);
        gridsList.add(Grids.CURRENCY);
        gridsList.add(Grids.MODES);
        gridsList.add(Grids.PLAYERCARD);
        gridsList.add(Grids.PLAYERTITLE);
        gridsList.add(Grids.THEME);
        gridsList.add(Grids.CEREMONY);

        recycler_top_menu.setHasFixedSize(true);
        recycler_top_menu.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        homeAdapter = new HomeAdapter(this, gridsList, this, true, Integer.parseInt(position));
        recycler_top_menu.setAdapter(homeAdapter);

    }

    private void setFragment(Fragment fragment) {
        if (fragment.isAdded()){
            return;
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, "Valorant GG");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override
    public void onClicked(Grids grids, int pos) {
        setTitle(grids.getStringId());
        fragment = grids.getFragment();
        setFragment(fragment);
    }
}