package ru.marten.pockemonapp.view;


import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.OnLongClick;
import io.realm.Realm;
import ru.marten.pockemonapp.R;
import ru.marten.pockemonapp.model.Creature;
import ru.marten.pockemonapp.util.CreatureGenerator;
import ru.marten.pockemonapp.util.SimpleCache;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends BaseFragment implements View.OnLongClickListener, View.OnDragListener{

    @BindView(R.id.img_creature_to_catch)
    ImageView imageCreature;
    @BindView(R.id.img_pockeball)
    ImageView imagePockeball;

    private Creature creatureToCatch;

    public GameFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        creatureToCatch = SimpleCache.getInstance().getActiveCreature();
        imageCreature.setImageDrawable(CreatureGenerator.getCreatureImageById(creatureToCatch.getImageId(), getContext()));
        imageCreature.setOnDragListener(this);
        imagePockeball.setOnLongClickListener(this);

    }


    @Override
    public boolean onDrag(View view, DragEvent dragEvent) {

        switch (dragEvent.getAction()) {
            case DragEvent.ACTION_DROP:
                if (view.getId() == imageCreature.getId()) {
                    showSuccessDialog();
                }
                break;
        }


        return true;
    }

    @Override
    public boolean onLongClick(View view) {
        View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(view);
        view.startDrag(null, shadowBuilder, view, 0);
        return true;
    }

    private void showSuccessDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.title_catch)
                .setMessage(R.string.message_catch)
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Realm realm = Realm.getInstance(getContext());
                                realm.beginTransaction();
                                realm.copyToRealm(creatureToCatch);
                                realm.commitTransaction();
                                stackActivity.showMainScreen();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
