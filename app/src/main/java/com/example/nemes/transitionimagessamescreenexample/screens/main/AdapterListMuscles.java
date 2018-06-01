package com.example.nemes.transitionimagessamescreenexample.screens.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nemes.transitionimagessamescreenexample.R;
import com.example.nemes.transitionimagessamescreenexample.domain.Categories;

import java.util.List;

/**
 * Created by nemes on 01/06/2018.
 */

public class AdapterListMuscles extends RecyclerView.Adapter<AdapterListMuscles.ViewHolder>
{

    private LayoutInflater inflater;
    private final List<Categories.Category> items;
    private AdapterListMuscles.Listener mListener;

    public interface Listener{
        void onItemClicked(int adapterPosition);
    }

    public AdapterListMuscles(LayoutInflater inflater, List<Categories.Category> items) {
        this.inflater = inflater;
        this.items = items;
    }


    public void setListener(Listener mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.title.setText(items.get(position).title);
        holder.image.setImageResource(items.get(position).image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition == RecyclerView.NO_POSITION) {
                    return;
                }
                mListener.onItemClicked(adapterPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        public final ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
