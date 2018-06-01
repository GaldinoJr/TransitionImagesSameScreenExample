
package com.example.nemes.transitionimagessamescreenexample.screens.main;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;

import com.example.nemes.transitionimagessamescreenexample.R;
import com.example.nemes.transitionimagessamescreenexample.domain.Categories;
import com.example.nemes.transitionimagessamescreenexample.screens.detail.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListMuscles.Listener {
    private RecyclerView list;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadControls();
    }

    private void loadControls() {
        list = (RecyclerView) findViewById(R.id.list);
        layoutManager = new GridLayoutManager(this, 3);
        list.setLayoutManager(layoutManager);
        AdapterListMuscles musclesAdapter = new AdapterListMuscles(LayoutInflater.from(this), Categories.getCategories());
        musclesAdapter.setListener(this);
        list.setAdapter(musclesAdapter);

    }

    @Override
    public void onItemClicked(int adapterPosition) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra("position", adapterPosition);
        //// TODO: 25/04/2017 Use ActivityOptionsCompat to support pre-lollipop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
            int lastVisibleItemPosition = layoutManager.findLastVisibleItemPosition();
            List<Pair<View, String>> pairs = new ArrayList<Pair<View, String>>();
            for (int i = firstVisibleItemPosition; i <= lastVisibleItemPosition; i++) {
                AdapterListMuscles.ViewHolder holderForAdapterPosition = (AdapterListMuscles.ViewHolder) list.findViewHolderForAdapterPosition(i);
                View itemView = holderForAdapterPosition.image;
                pairs.add(Pair.create(itemView, "tab_" + i));
            }
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs.toArray(new Pair[]{})).toBundle();
            startActivity(intent, bundle);
        } else {
            startActivity(intent);
        }
    }

}
