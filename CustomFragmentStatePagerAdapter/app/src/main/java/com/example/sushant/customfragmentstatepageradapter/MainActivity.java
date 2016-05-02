package com.example.sushant.customfragmentstatepageradapter;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private boolean ifFragmentSwitched;
    private Adapter mPagerAdapter;
    private ViewPager mPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        mPager = (ViewPager)findViewById(R.id.pager);
        mPagerAdapter = new Adapter(getSupportFragmentManager());

        if (savedInstanceState != null) {
            ifFragmentSwitched = savedInstanceState.getBoolean("ifFragmentSwitched");
        } else {
            ifFragmentSwitched = false;
        }

        updateAdapterData();
        mPager.setAdapter(mPagerAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("ifFragmentSwitched", ifFragmentSwitched);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            super.onBackPressed();
        }
        if (id == R.id.action_settings) {
            ifFragmentSwitched = !ifFragmentSwitched;
            updateAdapterData();
            // Force our view pager back to index 0 in order to detach the index 2 fragment and save its state.
            mPager.setCurrentItem(0);
            mPagerAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void updateAdapterData() {
        if (ifFragmentSwitched) {
            mPagerAdapter.question_labels[2] = "A";
            mPagerAdapter.questions[2] = "AAAAAAAAAA";
        } else {
            mPagerAdapter.question_labels[2] = "C";
            mPagerAdapter.questions[2] = "CCCCCCCCCC";
        }
    }
}
