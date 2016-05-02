package com.example.sushant.customfragmentstatepageradapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by sushant on 2/5/16.
 */

// Uncomment these to try the new adapter!
//public class ExamplePagerAdapter extends FixedFragmentStatePagerAdapter {
public class Adapter extends FragmentStatePagerAdapter {

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    String[]question_labels = new String[] {
            "A",
            "B",
            "C"
    };

    String[] questions = new String[]{
            "AAAAAAAAAA",
            "BBBBBBBBBB",
            "CCCCCCCCCC"
    };

    // Uncomment these to try the new adapter!
    //@Override
    //public String getTag(int position) {
    //    return question_labels[position];
    //}

    @Override
    public Fragment getItem(int position) {
        return QFragment.newInstance(question_labels[position], questions[position]);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
