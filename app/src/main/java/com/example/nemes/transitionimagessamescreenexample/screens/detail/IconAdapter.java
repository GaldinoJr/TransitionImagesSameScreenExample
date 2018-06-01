package com.example.nemes.transitionimagessamescreenexample.screens.detail;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nemes.transitionimagessamescreenexample.R;
import com.example.nemes.transitionimagessamescreenexample.domain.Categories;
import com.viewpagerindicator.IconPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nemes on 01/06/2018.
 */

public class IconAdapter extends FragmentStatePagerAdapter implements IconPagerAdapter {
    private final Context context;

    public IconAdapter(Context context, FragmentManager manager) {
        super(manager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        return DetailPage.instantiate(context, DetailPage.class.getName());
    }

    @Override
    public int getIconResId(int index) {
        return Categories.getCategories().get(index).image;
    }

    @Override
    public int getCount() {
        return Categories.getCategories().size();
    }
}
