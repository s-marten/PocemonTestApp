package ru.marten.pockemonapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ru.marten.pockemonapp.R;
import ru.marten.pockemonapp.model.Creature;
import ru.marten.pockemonapp.util.CreatureGenerator;

/**
 * Created by marten on 06.12.17.
 */

public class CreatureAdapter extends RecyclerView.Adapter<CreatureAdapter.CreatureViewHolder> {

    List<Creature> creatureList = new ArrayList<>();
    Context context;

    public CreatureAdapter(Context context) {
        this.context = context;
        Realm realm = Realm.getInstance(context);
        realm.beginTransaction();
        RealmResults<Creature> results = realm.allObjects(Creature.class);
        realm.commitTransaction();
        if (results != null)
        creatureList.addAll(results);
    }



    @Override
    public CreatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_creature_vh
                , parent, false);

        return new CreatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CreatureViewHolder holder, int position) {
        Creature creature = creatureList.get(position);
        holder.icon.setImageDrawable(CreatureGenerator.
                getCreatureImageById(creature.getImageId(), context));
    }

    @Override
    public int getItemCount() {
        return creatureList.size();
    }

    public class CreatureViewHolder extends RecyclerView.ViewHolder{

        ImageView icon;

        public CreatureViewHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon_creature);

        }
    }
}
