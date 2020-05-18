package com.cxyzy.viewpager.showneighbour;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    protected static final String[] PAGE_TITLES = new String[]{"Page 1", "Page 2",
            "Page 3", "Page 4", "Page 5"};

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
    }

    private void initViewPager() {
        FlipViewPager mPager = findViewById(R.id.flipViewPager);
        mPager.setAdapter(new FlipFragmentAdapter(getSupportFragmentManager(),
                MainActivity.this, PAGE_TITLES));
        mPager.setAnimationEnabled(true);
        mPager.setFadeEnabled(true);
        mPager.setFadeFactor(0.6f);
    }

}
