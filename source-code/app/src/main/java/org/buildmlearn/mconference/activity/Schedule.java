package org.buildmlearn.mconference.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.BaseAdapter;

import org.buildmlearn.mconference.R;
import org.buildmlearn.mconference.adapters.TabAdapter;
import org.buildmlearn.mconference.schedule.DayFragment;

public class Schedule extends BaseActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int noOfDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_schedule, frameLayout);

        noOfDays = 3;

        toolbar = (Toolbar) findViewById(R.id.schedule_toolbar);
        setSupportActionBar(toolbar);

        super.setUpNavDrawer(toolbar);

        viewPager = (ViewPager) findViewById(R.id.schedule_viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.schedule_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());

        for(int i=1; i<=noOfDays; i++)
            adapter.addFragment(new DayFragment(), "Day " + i);
        viewPager.setAdapter(adapter);
    }
}
