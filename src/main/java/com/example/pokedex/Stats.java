package com.example.pokedex;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Stats extends AppCompatActivity {
    TextView name;
    TextView index;
    ImageView image;
    ImageView imageType1;
    ImageView imageType2;
    int imageResource;
    String pokemonName;
    int type1;
    int type2;
    int theme;
    String indexValue;
    ConstraintLayout layoutType1;
    ConstraintLayout layoutType2;
    ProgressBar hp;
    ProgressBar atk;
    ProgressBar def;
    ProgressBar speed;
    ProgressBar spAtk;
    ProgressBar spDef;
    TextView textViewHP;
    TextView textViewAtk;
    TextView textViewDef;
    TextView textViewSpeed;
    TextView textViewSpAtk;
    TextView textViewSpDef;
    TextView heightInfo;
    TextView weightInfo;
    TextView description;
    ImageButton sound;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);


        if (getIntent().hasExtra("name")) {
            type1 = getIntent().getIntExtra("type1", 0);
            type2 = getIntent().getIntExtra("type2", 0);
            switch (type1) {
                case R.drawable.bug:
                    theme = R.style.bug;
                    break;
                case R.drawable.dark:
                    theme = R.style.dark;
                    break;
                case R.drawable.dragon:
                    theme = R.style.dragon;
                    break;
                case R.drawable.electric:
                    theme = R.style.electric;
                    break;
                case R.drawable.fairy:
                    theme = R.style.fairy;
                    break;
                case R.drawable.fighting:
                    theme = R.style.fighting;
                    break;
                case R.drawable.fire:
                    theme = R.style.fire;
                    break;
                case R.drawable.flying:
                    theme = R.style.flying;
                    break;
                case R.drawable.ghost:
                    theme = R.style.ghost;
                    break;
                case R.drawable.grass:
                    theme = R.style.grass;
                    break;
                case R.drawable.ground:
                    theme = R.style.ground;
                    break;
                case R.drawable.ice:
                    theme = R.style.ice;
                    break;
                case R.drawable.mystery:
                    theme = R.style.mystery;
                    break;
                case R.drawable.normal:
                    theme = R.style.normal;
                    break;
                case R.drawable.poison:
                    theme = R.style.poison;
                    break;
                case R.drawable.psychic:
                    theme = R.style.psychic;
                    break;
                case R.drawable.rock:
                    theme = R.style.rock;
                    break;
                case R.drawable.steel:
                    theme = R.style.steel;
                    break;
                case R.drawable.water:
                    theme = R.style.water;
                    break;
            }
            setTheme(theme);
            setContentView(R.layout.activity_stats);

            layoutType1 = findViewById(R.id.id_backgroundType1);
            layoutType2 = findViewById(R.id.id_backgroundType2);

            if(type2 == 0)
                type2 = type1;

            if(type1 != type2){
                int type2Color = 0;
                switch (type2) {
                    case R.drawable.bug:
                        type2Color = R.color.bug;
                        break;
                    case R.drawable.dark:
                        type2Color = R.color.dark;
                        break;
                    case R.drawable.dragon:
                        type2Color = R.color.dragon;
                        break;
                    case R.drawable.electric:
                        type2Color = R.color.bug;
                        break;
                    case R.drawable.fairy:
                        type2Color = R.color.fairy;
                        break;
                    case R.drawable.fighting:
                        type2Color = R.color.fighting;
                        break;
                    case R.drawable.fire:
                        type2Color = R.color.fire;
                        break;
                    case R.drawable.flying:
                        type2Color = R.color.flying;
                        break;
                    case R.drawable.ghost:
                        type2Color = R.color.ghost;
                        break;
                    case R.drawable.grass:
                        type2Color = R.color.grass;
                        break;
                    case R.drawable.ground:
                        type2Color = R.color.ground;
                        break;
                    case R.drawable.ice:
                        type2Color = R.color.ice;
                        break;
                    case R.drawable.mystery:
                        type2Color = R.color.mystery;
                        break;
                    case R.drawable.normal:
                        type2Color = R.color.normal;
                        break;
                    case R.drawable.poison:
                        type2Color = R.color.poison;
                        break;
                    case R.drawable.psychic:
                        type2Color = R.color.psychic;
                        break;
                    case R.drawable.rock:
                        type2Color = R.color.rock;
                        break;
                    case R.drawable.steel:
                        type2Color = R.color.steel;
                        break;
                    case R.drawable.water:
                        type2Color = R.color.water;
                        break;
                }
                layoutType2.setBackgroundColor(type2Color);
            }



            FloatingActionButton fab = findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });

            name = findViewById(R.id.id_stats_name);
            image = findViewById(R.id.id_stats_image);
            imageType1 = findViewById(R.id.id_stats_type1);
            imageType2 = findViewById(R.id.id_stats_type2);
            index = findViewById(R.id.id_stats_index);


            imageResource = getIntent().getIntExtra("image", 0);
            pokemonName = getIntent().getStringExtra("name");
            type1 = getIntent().getIntExtra("type1", 0);
            type2 = getIntent().getIntExtra("type2", 0);
            indexValue = getIntent().getStringExtra("index");

            name.setText(pokemonName);
            image.setImageResource(imageResource);
            imageType1.setImageResource(type1);
            imageType2.setImageResource(type2);
            index.setText(indexValue);

            hp = findViewById(R.id.id_stats_hp);
            atk = findViewById(R.id.id_stats_attack);
            def = findViewById(R.id.id_stats_defense);
            speed = findViewById(R.id.id_stats_speed);
            spAtk = findViewById(R.id.id_stats_spAtk);
            spDef = findViewById(R.id.id_stats_spDef);
            textViewHP = findViewById(R.id.progress_hp);
            textViewAtk = findViewById(R.id.progress_atk);
            textViewDef = findViewById(R.id.progress_def);
            textViewSpeed = findViewById(R.id.progress_speed);
            textViewSpAtk = findViewById(R.id.progress_spAtk);
            textViewSpDef = findViewById(R.id.progress_spDef);
            heightInfo = findViewById(R.id.id_stats_heightInfo);
            weightInfo = findViewById(R.id.id_stats_weightInfo);
            description = findViewById(R.id.id_stats_description);
            sound = findViewById(R.id.id_stats_sound);

            hp.setProgress(getIntent().getIntExtra("hp",10));
            atk.setProgress(getIntent().getIntExtra("atk",5));
            def.setProgress(getIntent().getIntExtra("def",5));
            speed.setProgress(getIntent().getIntExtra("speed",5));
            spAtk.setProgress(getIntent().getIntExtra("spAtk",10));
            spDef.setProgress(getIntent().getIntExtra("spDef",20));
            textViewHP.setText(getIntent().getIntExtra("hp",10)+"");
            textViewAtk.setText(getIntent().getIntExtra("atk",5)+"");
            textViewDef.setText(getIntent().getIntExtra("def",5)+"");
            textViewSpeed.setText(getIntent().getIntExtra("speed",5)+"");
            textViewSpAtk.setText(getIntent().getIntExtra("spAtk",10)+"");
            textViewSpDef.setText(getIntent().getIntExtra("spDef",20)+"");

            heightInfo.setText(getIntent().getStringExtra("heightInfo"));
            weightInfo.setText(getIntent().getStringExtra("weightInfo"));
            description.setText(getIntent().getStringExtra("description"));

            mediaPlayer = MediaPlayer.create(this,getIntent().getIntExtra("sound",0));
            sound.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mediaPlayer.start();
                }
            });


        }



    }
}




