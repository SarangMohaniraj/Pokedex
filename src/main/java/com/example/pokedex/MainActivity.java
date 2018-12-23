package com.example.pokedex;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.AnimationDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    static RecyclerView rv;
    ArrayList<Pokemon> indices;
    CustomAdapter adapter;
    static Toolbar toolbar;
    static MenuItem searchItem;
    static SearchView searchView;
    String restoreQuery;
    static CardView cardView;
    static TextView height;
    static TextView heightInfo;
    static TextView weight;
    static TextView weightInfo;
    static TextView description;
    static int lastClicked = -1;
    ImageButton infoButton;
    ConstraintLayout constraintLayout;
    static ConstraintLayout dim;

    int TYPE_BUG = R.drawable.bug;
    int TYPE_DARK = R.drawable.dark;
    int TYPE_DRAGON = R.drawable.dragon;
    int TYPE_ELECTRIC = R.drawable.electric;
    int TYPE_FAIRY = R.drawable.fairy;
    int TYPE_FIGHTING = R.drawable.fighting;
    int TYPE_FIRE = R.drawable.fire;
    int TYPE_FLYING = R.drawable.flying;
    int TYPE_GHOST = R.drawable.ghost;
    int TYPE_GRASS = R.drawable.grass;
    int TYPE_ICE = R.drawable.ice;
    int TYPE_MYSTERY = R.drawable.mystery;
    int TYPE_NORMAL = R.drawable.normal;
    int TYPE_POISON = R.drawable.poison;
    int TYPE_PSYCHIC = R.drawable.psychic;
    int TYPE_ROCK = R.drawable.rock;
    int TYPE_STEEL = R.drawable.steel;
    int TYPE_WATER = R.drawable.water;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = findViewById(R.id.id_layout_main);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2500);
        animationDrawable.setExitFadeDuration(5000);
        animationDrawable.start();
        dim = findViewById(R.id.id_dim);

        rv = findViewById(R.id.id_recyclerview);
        indices = new ArrayList<>();
        toolbar = findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);
        infoButton = findViewById(R.id.id_button_info);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dim.setVisibility(View.VISIBLE);
                startActivity(new Intent(MainActivity.this,PopUp.class));
            }
        });

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            cardView = findViewById(R.id.id_cardVisible);
            height = findViewById(R.id.id_height);
            heightInfo = findViewById(R.id.id_heightInfo);
            weight = findViewById(R.id.id_weight);
            weightInfo = findViewById(R.id.id_weightInfo);
            cardView.setVisibility(View.INVISIBLE);

        }
        else{
            description = findViewById(R.id.id_description);
            description.setVisibility(View.INVISIBLE);
        }



        indices.add(new Pokemon(1, R.drawable.bulbasaur, "Bulbasaur", TYPE_GRASS, TYPE_POISON,"2' 4\"",15.2,"Bulbasaur is a cute pokemon who is very balanced between attack and defense. However, as a starter pokemon, Bulbasaur is bland. There are better starters than Bulbasaur.",45,49,49,45,65,65,R.raw.bulbasaur));
        indices.add(new Pokemon(2, R.drawable.ivysaur, "Ivysaur", TYPE_GRASS, TYPE_POISON,"3' 3\"",28.7,"Ivysaur is pretty intense in the TV series, but he is really balanced and not too interesting. Spice it up a bit more. If you didn't notice, it looks like his bulb is sprouting, so eventually can he get energy from photosynthesis????",60,62,63,60,80,80, R.raw.ivysaur));
        indices.add(new Pokemon(3, R.drawable.venusaur, "Venusaur", TYPE_GRASS, TYPE_POISON,"6' 7\"",100.0,"Bulbasaur and Ivysaur are very cute, but Venusaur is outright ugly. I don't know what happened to him but he grew 30 years while evolving. Looks aside, he still packs a serious punch.", 80,82,83,80,100,100, R.raw.venusaur));
        indices.add(new Pokemon(4, R.drawable.charmander, "Charmander", TYPE_FIRE, 0,"2' 0\"",18.7,"Charmander is aggressive user's go-to starter pokemon. Although his health isn't too great, you don't need it when he is incredibly powerful. Let's just hope the flame on his tail doesn't run out...", 39,52,43,65,60,50,R.raw.charmander));
        indices.add(new Pokemon(5, R.drawable.charmeleon, "Charmeleon", TYPE_FIRE, 0,"3' 7\"",41.9,"Charmeleon looks like your typical edgy teenager... but he still is pretty serious and you do not want to mess with him! His speed is just insane! His claws are almost fully developed as well.", 58,64,58,80,80,65, R.raw.charmeleon));
        indices.add(new Pokemon(6, R.drawable.charizard, "Charizard", TYPE_FIRE, TYPE_FLYING,"5' 7\"",199.5,"WHAT!!!! HE HAS WINGS AND HE CAN BREATHE FIRE!!!! HOW IS HE NOT OP!!! and how is he only 5'7\"... you would imagine a dragon to be bigger, but he just looks big when he is flexing... uhh I mean spreading his wings.", 78,84,78,100,109,85,R.raw.charizard));
        indices.add(new Pokemon(7, R.drawable.squirtle, "Squirtle", TYPE_WATER, 0,"1' 8\"",19.8,"Squirtle is hands down the cutest starter AND he balls up into a Mario Kart type shell now that is SICK. He must win a lot of pokemon contests because he is so CUTE!!! He can almost just fit right in your pocket!", 44,48,65,43,50,64, R.raw.squirtle));
        indices.add(new Pokemon(8, R.drawable.wartortle, "Wartortle", TYPE_WATER, 0,"3' 3\"",49.6,"Wartortle has a pretty strange name, but don't let it fool you! He looks a short girl when she is mad... but how can he look so cute AND so vicious", 59, 63, 80, 58, 65, 80,R.raw.wartortle));
        indices.add(new Pokemon(9, R.drawable.blastoise, "Blastoise", TYPE_WATER,0 ,"5' 3\"",188.5,"Blastoise is a matured version of his previous evolutions. He can kick some serious butt, so don't mess with him. Somehow, he grew almost four times his weight...", 79, 83, 100, 78, 85, 105, R.raw.blastoise));


        adapter = new CustomAdapter(R.layout.activity_index, indices);
        rv.setHasFixedSize(true);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());



    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("query", searchView.getQuery().toString());
        outState.putSerializable("list",indices);
        outState.putInt("last",lastClicked);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreQuery = savedInstanceState.getString("query");
        indices = (ArrayList<Pokemon>)savedInstanceState.getSerializable("list");
        lastClicked = savedInstanceState.getInt("last");

        if(lastClicked != -1 ){
            rv.scrollToPosition(lastClicked); //in order for the programmatic click, the item in the recyclerview has to be rendered (it has to be in view)
            rv.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if(rv.findViewHolderForAdapterPosition(lastClicked) != null) {
                        rv.findViewHolderForAdapterPosition(lastClicked).itemView.performClick(); //programmatically click item
                    }
                }
            },1); //needs to delay it because it cannot work unless the new layout is calculated
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);

        searchItem = menu.findItem(R.id.action_search);
        searchView= (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        if(restoreQuery != null && !restoreQuery.isEmpty()){
            searchItem.expandActionView();
            searchView.setQuery(restoreQuery, false);
            searchView.clearFocus();
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        searchView.setQuery("",true);

    }




}

