package ru.marten.pockemonapp.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.marten.pockemonapp.R;
import ru.marten.pockemonapp.adapter.CreatureAdapter;
import ru.marten.pockemonapp.model.Creature;
import ru.marten.pockemonapp.util.CreatureGenerator;
import ru.marten.pockemonapp.util.SimpleCache;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.progress_health)
    ProgressBar progressHealth;
    @BindView(R.id.progress_strength)
    ProgressBar progressStrength;
    @BindView(R.id.progress_agility)
    ProgressBar progressAgility;
    @BindView(R.id.active_creature)
    ImageView imgActiveCreature;
    @BindView(R.id.creature_rview)
    RecyclerView recyclerView;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CreatureAdapter adapter = new CreatureAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        showCreatureData();
    }

    private void showCreatureData() {
        Creature creature = CreatureGenerator.generateCreature(getContext());
        progressHealth.setProgress(creature.getHealth());
        progressStrength.setProgress(creature.getStrength());
        progressAgility.setProgress(creature.getAgility());
        imgActiveCreature.setImageDrawable(CreatureGenerator.
                getCreatureImageById(creature.getImageId(), getContext()));
        SimpleCache.getInstance().setActiveCreature(creature);

    }

    @Nullable
    @OnClick(R.id.active_creature)
    public void startGame() {
        stackActivity.showGameScreen();
    }
}
