package com.evanemran.valorantgg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.evanemran.valorantgg.Adapters.AbilityAdapter;
import com.evanemran.valorantgg.Adapters.SliderAdapter;
import com.evanemran.valorantgg.Listeners.ClickListener;
import com.evanemran.valorantgg.Models.Ability;
import com.evanemran.valorantgg.Models.Datum;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AgentDetailsActivity extends AppCompatActivity {

    Datum datum;
    RelativeLayout layout_agent;
    ImageView imageView_agent_detail, imageView_role;
    TextView textView_agent_desc, textView_agent_role, textView_agent_tags, textView_agent_name;
    RecyclerView recycler_ability;
    AbilityAdapter abilityAdapter;
    Button button_audio;
    SliderAdapter sliderAdapter;
    SliderView imageView_agent;
    List<String> imageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_details);

        layout_agent = findViewById(R.id.layout_agent);
        imageView_agent_detail = findViewById(R.id.imageView_agent_detail);
        imageView_agent = findViewById(R.id.imageView_agent);
        textView_agent_desc = findViewById(R.id.textView_agent_desc);
        imageView_role = findViewById(R.id.imageView_role);
        textView_agent_role = findViewById(R.id.textView_agent_role);
        recycler_ability = findViewById(R.id.recycler_ability);
        textView_agent_tags = findViewById(R.id.textView_agent_tags);
        button_audio = findViewById(R.id.button_audio);
        textView_agent_name = findViewById(R.id.textView_agent_name);

        datum = (Datum) getIntent().getSerializableExtra("datum");

//        Picasso.get().load(datum.background).into(imageView_agent_detail);
//        Picasso.get().load(datum.bustPortrait).into(imageView_agent);
        Picasso.get().load(datum.role.displayIcon).into(imageView_role);

        imageUrls.add(datum.displayIcon);
        imageUrls.add(datum.bustPortrait);
        imageUrls.add(datum.fullPortrait);
        sliderAdapter = new SliderAdapter(this, imageUrls);
        imageView_agent.setSliderAdapter(sliderAdapter);
        imageView_agent.setIndicatorAnimation(IndicatorAnimationType.WORM);
        imageView_agent.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        imageView_agent.startAutoCycle();

        textView_agent_desc.setText(datum.description);
        textView_agent_role.setText(datum.role.displayName+": "+datum.role.description);
        if (datum.characterTags != null){
            textView_agent_tags.setText("Tag: " + datum.characterTags.get(0));
        }
        textView_agent_name.setText(datum.displayName);

        button_audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player = new MediaPlayer();
                try {
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(datum.voiceLine.mediaList.get(0).wave);
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(AgentDetailsActivity.this, "Couldn't play audio!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        recycler_ability.setHasFixedSize(true);
        recycler_ability.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        abilityAdapter = new AbilityAdapter(this, datum.abilities, abilityClickListener);
        recycler_ability.setAdapter(abilityAdapter);



    }

    private final ClickListener<Ability> abilityClickListener = new ClickListener<Ability>() {
        @Override
        public void onClicked(Ability item) {

        }
    };
}