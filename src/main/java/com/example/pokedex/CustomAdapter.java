package com.example.pokedex;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> implements Filterable{


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemonImage;
        TextView name;
        ImageButton type1;
        ImageButton type2;
        TextView index;
        ConstraintLayout layout;

        public ViewHolder(View v) {
            super(v);
            pokemonImage = v.findViewById(R.id.id_pokemonImage);
            name = v.findViewById(R.id.id_name);
            type1 = v.findViewById(R.id.id_type1);
            type2 = v.findViewById(R.id.id_type2);
            index = v.findViewById(R.id.id_index);
            layout = v.findViewById(R.id.id_layout);
        }
    }

        int resource;
        List<Pokemon> indices;
        Context context;
        List<Pokemon> saveOriginalList;


    public CustomAdapter(int resource, List<Pokemon> indices){
        this.resource = resource;
        this.indices = indices;
        saveOriginalList = new ArrayList<>(indices);
    }


    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //View view = layoutInflater.inflate(R.layout.activity_index,null);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_index, viewGroup, false);
        context = view.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomAdapter.ViewHolder viewHolder, final int i) {


        viewHolder.index.setText(indices.get(i).getIndex());
        viewHolder.name.setText(indices.get(i).getName());
        viewHolder.pokemonImage.setImageResource(indices.get(i).getPokemonImage());
        viewHolder.type1.setImageResource(indices.get(i).getType1());
        viewHolder.type2.setImageResource(indices.get(i).getType2());




        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.lastClicked = i;
                if(v.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    MainActivity.cardView.setVisibility(View.VISIBLE);
                    MainActivity.heightInfo.setText(indices.get(i).getHeight());
                    MainActivity.weightInfo.setText(indices.get(i).getWeight());
                }
                else{
                    MainActivity.description.setVisibility(View.VISIBLE);
                    MainActivity.description.setText(indices.get(i).getDescription());
                }
            }
        });
        viewHolder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(context,Stats.class);
                intent.putExtra("name",indices.get(i).getName());
                intent.putExtra("image",indices.get(i).getPokemonImage());
                intent.putExtra("type1",indices.get(i).getType1());
                intent.putExtra("type2",indices.get(i).getType2());
                intent.putExtra("index",indices.get(i).getIndex());
                intent.putExtra("hp",indices.get(i).getHp());
                intent.putExtra("atk",indices.get(i).getAtk());
                intent.putExtra("def",indices.get(i).getDef());
                intent.putExtra("speed",indices.get(i).getSpeed());
                intent.putExtra("spAtk",indices.get(i).getSpAtk());
                intent.putExtra("spDef",indices.get(i).getSpDef());
                intent.putExtra("heightInfo",indices.get(i).getHeight());
                intent.putExtra("weightInfo",indices.get(i).getWeight());
                intent.putExtra("description", indices.get(i).getDescription());
                intent.putExtra("sound", indices.get(i).getSound());
                MainActivity.lastClicked = i;

                context.startActivity(intent);

                if(v.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    MainActivity.cardView.setVisibility(View.VISIBLE);
                    MainActivity.heightInfo.setText(indices.get(i).getHeight());
                    MainActivity.weightInfo.setText(indices.get(i).getWeight());
                }
                else{
                    MainActivity.description.setVisibility(View.VISIBLE);
                    MainActivity.description.setText(indices.get(i).getDescription());
                }

                return true;
            }
        });
        viewHolder.type1.setOnClickListener(new View.OnClickListener() { //imagebuttonlistener
            @Override
            public void onClick(View v) {  //imagebuttonlistener 1
                MainActivity.searchItem.expandActionView();
                MainActivity.searchView.setQuery(indices.get(i).getType1Tag(),false);
            }
        });
            viewHolder.type2.setOnClickListener(new View.OnClickListener() { //imagebuttonlistener
                @Override
                public void onClick(View v) {  //imagebuttonlistener 2
                    if(indices.get(i).getType2() != 0) {
                        MainActivity.searchItem.expandActionView();
                        MainActivity.searchView.setQuery(indices.get(i).getType2Tag(),false);
                    }
                    else{ //same as layout onclicklistener
                        MainActivity.lastClicked = i;
                        if(v.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                            MainActivity.cardView.setVisibility(View.VISIBLE);
                            MainActivity.heightInfo.setText(indices.get(i).getHeight());
                            MainActivity.weightInfo.setText(indices.get(i).getWeight());
                        }
                        else{
                            MainActivity.description.setVisibility(View.VISIBLE);
                            MainActivity.description.setText(indices.get(i).getDescription());
                        }
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return indices.size();
    }



    @Override
    public Filter getFilter() {
        return filter;
    }

    public Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Pokemon> filtered = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filtered.addAll(saveOriginalList);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Pokemon p: indices){
                    if(p.getName().toLowerCase().contains(filterPattern)){
                        filtered.add(p);
                    }
                    if(p.getType1Tag().toLowerCase().contains(filterPattern) && !filtered.contains(p)){
                        filtered.add(p);
                    }
                    if(p.getType2Tag().toLowerCase().contains(filterPattern) && !filtered.contains(p)){
                        filtered.add(p);
                    }

                }
            }
            FilterResults  results = new FilterResults();
            results.values = filtered;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            indices.clear();
            indices.addAll((List)(results.values));
            notifyDataSetChanged();
        }
    };



}