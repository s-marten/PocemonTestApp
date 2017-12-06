package ru.marten.pockemonapp.util;

import ru.marten.pockemonapp.model.Creature;

/**
 * Created by marten on 06.12.17.
 */

public class SimpleCache {

    private static volatile SimpleCache instance;

    private Creature activeCreature;

    public static SimpleCache getInstance() {
        SimpleCache result = instance;
        if (result == null) {
            synchronized (SimpleCache.class) {
                result = instance;
                if (result == null) {
                    instance = result = new SimpleCache();
                }
            }
        }
        return result;
    }

    public void setActiveCreature(Creature activeCreature) {
        this.activeCreature = activeCreature;
    }

    public Creature getActiveCreature() {
        if (activeCreature == null)
            return new Creature();

        return activeCreature;
    }

    public void saveCreature(Creature creature) {

    }
}
