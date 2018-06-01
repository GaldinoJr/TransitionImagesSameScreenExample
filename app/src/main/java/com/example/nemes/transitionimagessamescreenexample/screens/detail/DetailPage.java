package com.example.nemes.transitionimagessamescreenexample.screens.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nemes.transitionimagessamescreenexample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nemes on 01/06/2018.
 */

public class DetailPage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.detail_page, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView list = (RecyclerView) view.findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new Adapter(LayoutInflater.from(getContext()), new ArrayList<Item>() {
            {
                for (int i = 0; i < 30; i++) {
                    add(new Item("detail:" + i));
                }
            }
        }));
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }

    public static class Item {
        public final String title;

        private Item(String title) {
            this.title = title;
        }
    }

    public static class Adapter extends RecyclerView.Adapter<ViewHolder> {
        private LayoutInflater inflater;
        private final List<Item> items;

        public Adapter(LayoutInflater inflater, List<Item> items) {
            this.inflater = inflater;
            this.items = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(inflater.inflate(R.layout.detail_list_item, parent, false));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title.setText(items.get(position).title);
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
