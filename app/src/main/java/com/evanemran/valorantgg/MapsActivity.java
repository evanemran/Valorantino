package com.evanemran.valorantgg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.evanemran.valorantgg.Models.MapsResponse;
import com.squareup.picasso.Picasso;

public class MapsActivity extends AppCompatActivity {

    ImageView imageView_maps, imageView_map_splash;
    TextView textView_maps_name, textView_maps_coordinate;
    MapsResponse map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        imageView_maps = findViewById(R.id.imageView_maps);
        imageView_map_splash = findViewById(R.id.imageView_map_splash);
        textView_maps_name = findViewById(R.id.textView_maps_name);
        textView_maps_coordinate = findViewById(R.id.textView_maps_coordinate);

        map = (MapsResponse) getIntent().getSerializableExtra("maps");

        Picasso.get().load(map.displayIcon).into(imageView_map_splash);
        Picasso.get().load(map.splash).into(imageView_maps);
        textView_maps_name.setText(map.displayName);
        textView_maps_coordinate.setText(map.coordinates);
    }
}