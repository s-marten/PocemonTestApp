package ru.marten.pockemonapp.model;

import io.realm.RealmObject;

/**
 * Created by marten on 05.12.17.
 */

public class Ball extends RealmObject {

    private String ID;

    private Creature caughtCreature;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setCaughtCreature(Creature caughtCreature) {
        this.caughtCreature = caughtCreature;
    }

    public Creature getCaughtCreature() {
        return caughtCreature;
    }

}
