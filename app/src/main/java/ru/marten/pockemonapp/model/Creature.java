package ru.marten.pockemonapp.model;

import android.graphics.drawable.Drawable;

import io.realm.RealmObject;

/**
 * Created by marten on 05.12.17.
 */

public class Creature extends RealmObject {


    private String name;

    private int health;

    private int strength;

    private int agility;

    private int imageId;


    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
