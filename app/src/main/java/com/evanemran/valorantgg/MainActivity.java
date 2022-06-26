package com.evanemran.valorantgg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.evanemran.valorantgg.Adapters.DrawerAdapter;
import com.evanemran.valorantgg.Adapters.HomeAdapter;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Listeners.HomeClickListener;
import com.evanemran.valorantgg.Models.Grids;
import com.evanemran.valorantgg.Models.NavMenu;
import com.evanemran.valorantgg.Utility.Typewriter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeClickListener<Grids>, NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerview_home;
    List<Grids> gridsList = new ArrayList<>();
    HomeAdapter homeAdapter;
    DrawerLayout drawer;
    TextView version_name, textView_welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview_home = findViewById(R.id.recyclerview_home);
        version_name = findViewById(R.id.version_name);
        textView_welcome = findViewById(R.id.textView_welcome);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =new ActionBarDrawerToggle(
                this,drawer,toolbar,R.string.open_nav_drawer, R.string.close_nav_drawer
        );
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        setupHomeGrids();

        setupNavMenu();

        Typewriter writer = new Typewriter(textView_welcome, this);
        writer.setCharacterDelay(150);
        writer.animateText("Welcome! \n This is a beta version, more features will be added soon!");


    }

    private void setupNavMenu() {
        List<NavMenu> navMenus = new ArrayList<>();
        navMenus.add(NavMenu.HOME);
        navMenus.add(NavMenu.PROFILE);
        navMenus.add(NavMenu.VALORANT);
        navMenus.add(NavMenu.LANGUAGE);
        navMenus.add(NavMenu.SETTINGS);
        navMenus.add(NavMenu.ABOUT);
        RecyclerView recycler_nav = findViewById(R.id.recycler_nav);
        recycler_nav.setHasFixedSize(true);
        recycler_nav.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        DrawerAdapter drawerAdapter = new DrawerAdapter(this, navMenus, navMenuClickListener);
        recycler_nav.setAdapter(drawerAdapter);

        try {
            PackageInfo pInfo =
                    getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0);
            version_name.setText("Version: " + pInfo.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void setupHomeGrids() {
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

        recyclerview_home.setHasFixedSize(true);
        recyclerview_home.setLayoutManager(new GridLayoutManager(this, 4));
        homeAdapter = new HomeAdapter(this, gridsList, this, false, 0);
        recyclerview_home.setAdapter(homeAdapter);
    }

    @Override
    public void onClicked(Grids grids, int pos) {
        startActivity(new Intent(MainActivity.this, DetailsActivity.class)
                .putExtra("fragment", grids)
        .putExtra("pos", String.valueOf(pos)));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private final ClickListener<NavMenu> navMenuClickListener = new ClickListener<NavMenu>() {
        @Override
        public void onClicked(NavMenu item) {
            Toast.makeText(MainActivity.this, "Will be available soon!", Toast.LENGTH_SHORT).show();
        }
    };


}