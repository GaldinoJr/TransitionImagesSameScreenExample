package com.example.nemes.transitionimagessamescreenexample.screens.detail;

import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.ImageView;

import com.example.nemes.transitionimagessamescreenexample.R;
import com.example.nemes.transitionimagessamescreenexample.util.MyAnimationUtils;
import com.viewpagerindicator.PageIndicator;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // inside your activity (if you did not enable transitions in your theme)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AppBarLayout appBarLayout = findViewById(R.id.app_bar);
        final ImageView ivFilter = findViewById(R.id.iv_filter);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset)-appBarLayout.getTotalScrollRange() == 0)
                {
                    //  Collapsed
                    MyAnimationUtils.translateShow(ivFilter,getApplicationContext());
                }
                else
                {
                    //Expanded
                    MyAnimationUtils.translateHide(ivFilter,getApplicationContext(),80);
                }
            }
        });

        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new IconAdapter(this, getSupportFragmentManager()));
        PageIndicator indicator = (PageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);
        pager.setCurrentItem(getIntent().getIntExtra("position", 0), false);
        supportPostponeEnterTransition();
        pager.post(new Runnable() {
            @Override
            public void run() {
                supportStartPostponedEnterTransition();
            }
        });
    }
}
