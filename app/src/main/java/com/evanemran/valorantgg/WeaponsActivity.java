package com.evanemran.valorantgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.evanemran.valorantgg.Models.Weapons;
import com.squareup.picasso.Picasso;

public class WeaponsActivity extends AppCompatActivity {
    Weapons weapon;
    ImageView imageView_weapon;
    TextView textView_weapon_name, textView_weapon_category;
    TextView textView_fire_rate, textView_mag_size, textView_run_speed, textView_equip_time, textView_reload_time;
    TextView textView_accuracy_first, textView_shotgun_palette, textView_wall_penetration, textView_feature, textView_fire_mode;
    TextView textView_alt_fire, textView_zoom_multiplier, textView_ads_fire_rate, textView_burst_count, textView_ads_accuracy;
    RecyclerView recyclerview_damage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapons);

        findViews();

        weapon = (Weapons) getIntent().getSerializableExtra("weapon");

        try {
            Picasso.get().load(weapon.displayIcon).into(imageView_weapon);
            textView_weapon_name.setText(weapon.displayName);
            textView_weapon_category.setText(weapon.category);

            textView_fire_rate.setText(weapon.weaponStats.fireRate+"");
            textView_mag_size.setText(weapon.weaponStats.magazineSize+"");
            textView_run_speed.setText(weapon.weaponStats.runSpeedMultiplier+"");
            textView_equip_time.setText(weapon.weaponStats.equipTimeSeconds+" Sec");
            textView_reload_time.setText(weapon.weaponStats.reloadTimeSeconds+" Sec");

            textView_accuracy_first.setText(weapon.weaponStats.firstBulletAccuracy+"");
            textView_shotgun_palette.setText(weapon.weaponStats.shotgunPelletCount+"");
            textView_wall_penetration.setText(weapon.weaponStats.wallPenetration+"");
            textView_feature.setText(weapon.weaponStats.feature+"");
            textView_fire_mode.setText(weapon.weaponStats.fireMode+"");

            textView_alt_fire.setText(weapon.weaponStats.altFireType+"");
            textView_zoom_multiplier.setText(weapon.weaponStats.adsStats.zoomMultiplier+" X");
            textView_ads_fire_rate.setText(weapon.weaponStats.adsStats.fireRate+"");
            textView_burst_count.setText(weapon.weaponStats.adsStats.fireRate+"");
            textView_ads_accuracy.setText(weapon.weaponStats.adsStats.firstBulletAccuracy+"");
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private void findViews() {
        imageView_weapon = findViewById(R.id.imageView_weapon);
        textView_weapon_name = findViewById(R.id.textView_weapon_name);
        textView_weapon_category = findViewById(R.id.textView_weapon_category);
        textView_fire_rate = findViewById(R.id.textView_fire_rate);
        textView_mag_size = findViewById(R.id.textView_mag_size);
        textView_run_speed = findViewById(R.id.textView_run_speed);
        textView_equip_time = findViewById(R.id.textView_equip_time);
        textView_reload_time = findViewById(R.id.textView_reload_time);
        textView_accuracy_first = findViewById(R.id.textView_accuracy_first);
        textView_shotgun_palette = findViewById(R.id.textView_shotgun_palette);
        textView_wall_penetration = findViewById(R.id.textView_wall_penetration);
        textView_fire_mode = findViewById(R.id.textView_fire_mode);
        textView_feature = findViewById(R.id.textView_feature);
        textView_alt_fire = findViewById(R.id.textView_alt_fire);
        textView_zoom_multiplier = findViewById(R.id.textView_zoom_multiplier);
        textView_ads_fire_rate = findViewById(R.id.textView_ads_fire_rate);
        textView_burst_count = findViewById(R.id.textView_burst_count);
        textView_ads_accuracy = findViewById(R.id.textView_ads_accuracy);
    }
}