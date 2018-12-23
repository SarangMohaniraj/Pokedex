package com.example.pokedex;

import android.media.MediaPlayer;

import java.io.Serializable;

public class Pokemon implements Serializable {

    String index;
    int pokemonImage;
    String name;
    int type1;
    int type2;
    String type1Tag;
    String type2Tag;
    String height;
    String weight;
    String description;
    int hp;
    int atk;
    int def;
    int speed;
    int spAtk;
    int spDef;
    int sound;


    public Pokemon(int index, int pokemonImage, String name, int type1, int type2, String height, double weight, String description, int hp, int atk,int def, int speed, int spAtk, int spDef, int sound){

        this.index = index+"";
        String newIndex = this.index;
        if(Integer.parseInt(newIndex) < 10)
            newIndex = "00"+newIndex;
        else if(Integer.parseInt(newIndex) < 100)
            newIndex = "0"+newIndex;
        this.index = "#"+newIndex;

        this.pokemonImage = pokemonImage;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.height = height;
        this.weight = weight + " lbs";
        this.description = description;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.speed = speed;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.sound = sound;

    }


    public String getIndex() {
        return index;
    }

    public int getPokemonImage() {
        return pokemonImage;
    }

    public String getName() {
        return name;
    }

    public int getType1() {
        return type1;
    }

    public int getType2() {
        return type2;
    }

    public String getType1Tag(){
        switch (type1) {
            case R.drawable.bug:
                type1Tag = "bug";
                break;
            case R.drawable.dark:
                type1Tag = "dark";
                break;
            case R.drawable.dragon:
                type1Tag = "dragon";
                break;
            case R.drawable.electric:
                type1Tag = "electric";
                break;
            case R.drawable.fairy:
                type1Tag = "fairy";
                break;
            case R.drawable.fighting:
                type1Tag = "fighting";
                break;
            case R.drawable.fire:
                type1Tag = "fire";
                break;
            case R.drawable.flying:
                type1Tag = "flying";
                break;
            case R.drawable.ghost:
                type1Tag = "ghost";
                break;
            case R.drawable.grass:
                type1Tag = "grass";
                break;
            case R.drawable.ground:
                type1Tag = "ground";
                break;
            case R.drawable.ice:
                type1Tag = "ice";
                break;
            case R.drawable.mystery:
                type1Tag = "mystery";
                break;
            case R.drawable.normal:
                type1Tag = "normal";
                break;
            case R.drawable.poison:
                type1Tag = "poison";
                break;
            case R.drawable.psychic:
                type1Tag = "psychic";
                break;
            case R.drawable.rock:
                type1Tag = "rock";
                break;
            case R.drawable.steel:
                type1Tag = "steel";
                break;
            case R.drawable.water:
                type1Tag = "water";
                break;
            default:
                type1Tag = "";
                break;
        }
        return type1Tag;
    }

    public String getType2Tag(){
        switch (type2) {
            case R.drawable.bug:
                type2Tag = "bug";
                break;
            case R.drawable.dark:
                type2Tag = "dark";
                break;
            case R.drawable.dragon:
                type2Tag = "dragon";
                break;
            case R.drawable.electric:
                type2Tag = "electric";
                break;
            case R.drawable.fairy:
                type2Tag = "fairy";
                break;
            case R.drawable.fighting:
                type2Tag = "fighting";
                break;
            case R.drawable.fire:
                type2Tag = "fire";
                break;
            case R.drawable.flying:
                type2Tag = "flying";
                break;
            case R.drawable.ghost:
                type2Tag = "ghost";
                break;
            case R.drawable.grass:
                type2Tag = "grass";
                break;
            case R.drawable.ground:
                type2Tag = "ground";
                break;
            case R.drawable.ice:
                type2Tag = "ice";
                break;
            case R.drawable.mystery:
                type2Tag = "mystery";
                break;
            case R.drawable.normal:
                type2Tag = "normal";
                break;
            case R.drawable.poison:
                type2Tag = "poison";
                break;
            case R.drawable.psychic:
                type2Tag = "psychic";
                break;
            case R.drawable.rock:
                type2Tag = "rock";
                break;
            case R.drawable.steel:
                type2Tag = "steel";
                break;
            case R.drawable.water:
                type2Tag = "water";
                break;
            default:
                type2Tag = "";
                break;

        }
        return type2Tag;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getSpeed() {
        return speed;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getDef() {
        return def;
    }

    public int getSound() {
        return sound;
    }
}
