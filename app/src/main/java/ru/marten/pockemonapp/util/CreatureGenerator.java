package ru.marten.pockemonapp.util;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.util.Random;

import ru.marten.pockemonapp.R;
import ru.marten.pockemonapp.model.Creature;

/**
 * Created by marten on 05.12.17.
 */

public class CreatureGenerator {

    private static final int MIN_ABILITY_VALUE = 5;
    private static final int MAX_ABILITY_VALUE = 10;
    private static final int CREATURE_PICTURE_COUNT = 5;
    private static final int PROGRESS_MULTIPLIER = 10;

    public static Creature generateCreature(Context context) {
        Creature creature = new Creature();
        creature.setHealth(100);
        creature.setStrength(generateRandomAbility() * PROGRESS_MULTIPLIER);
        creature.setAgility(generateRandomAbility() * PROGRESS_MULTIPLIER);
        creature.setImageId(generateRandomImageId());

        return creature;
    }

    /*
    * generate random digit in range from 5 to 10
    *
    */
    private static int generateRandomAbility() {
        int digit = new Random().nextInt((MAX_ABILITY_VALUE - MIN_ABILITY_VALUE) + 1) + MIN_ABILITY_VALUE;
        return digit;
    }


    private static int generateRandomImageId() {
        return new Random().nextInt(CREATURE_PICTURE_COUNT - 1);
    }

    public static Drawable getCreatureImageById(int id, Context context) {
        switch (id) {
            case 0:
                return context.getResources().getDrawable(R.drawable.pocemon_1);
            case 1:
                return context.getResources().getDrawable(R.drawable.pocemon_2);
            case 2:
                return context.getResources().getDrawable(R.drawable.pocemon_3);
            case 3:
                return context.getResources().getDrawable(R.drawable.pocemon_4);
            case 4:
                return context.getResources().getDrawable(R.drawable.pocemon_5);
        }
        return null;
    }

    //generate some unic id.
    private static int generateId(Creature creature) {
        int id = creature.hashCode() - MAX_ABILITY_VALUE * MIN_ABILITY_VALUE / 10;
        return id;
    }

}
