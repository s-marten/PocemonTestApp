package ru.marten.pockemonapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.marten.pockemonapp.model.Ball;
import ru.marten.pockemonapp.model.Creature;
import ru.marten.pockemonapp.view.GameFragment;
import ru.marten.pockemonapp.view.HomeFragment;
import ru.marten.pockemonapp.view.StackActivity;

public class MainActivity extends AppCompatActivity implements StackActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        showMainScreen();
    }


    @Override
    public void showMainScreen() {
        fragmentManager.beginTransaction()
                .replace(R.id.stack, new HomeFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showGameScreen() {
        fragmentManager.beginTransaction()
                .replace(R.id.stack, new GameFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1)
            fragmentManager.popBackStack();
        else
            finish();
    }
}
