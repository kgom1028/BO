package com.kgom.binaryoptions.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.eftimoff.viewpagertransformers.CubeOutTransformer;
import com.kgom.binaryoptions.R;
import com.kgom.binaryoptions.doc.UserInfo;
import com.kgom.binaryoptions.fragments.TipsFragment;
import com.kgom.binaryoptions.providers.DepthPageTransformer;
import com.kgom.binaryoptions.views.ViewPagerCustomDuration;

/**
 * Created by KJS on 1/6/2017.
 */
public class TipsActivity extends  BaseActivity {
    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 10;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPagerCustomDuration mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPagerCustomDuration) findViewById(R.id.pager);
        mPager.setScrollDurationFactor(5);
       // mPager.setPageTransformer(true, new DepthPageTransformer());
        mPager.setPageTransformer(true, new CubeOutTransformer());
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active. An alternative approach is to have each
                // fragment expose actions itself (rather than the activity exposing actions),
                // but for simplicity, the activity provides the actions in this sample.
                invalidateOptionsMenu();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
       /* getMenuInflater().inflate(R.menu.activity_screen_slide, menu);

        menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem() > 0);

        // Add either a "next" or "finish" button to the action bar, depending on which page
        // is currently selected.
        MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
                (mPager.getCurrentItem() == mPagerAdapter.getCount() - 1)
                        ? R.string.action_finish
                        : R.string.action_next);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
        return true;*/
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       /* switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
                return true;

            case R.id.action_previous:
                // Go to the previous step in the wizard. If there is no previous step,
                // setCurrentItem will do nothing.
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                return true;

            case R.id.action_next:
                // Advance to the next step in the wizard. If there is no next step, setCurrentItem
                // will do nothing.
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                return true;
        }

        return super.onOptionsItemSelected(item);*/
        return false;
    }

    /**
     * A simple pager adapter that represents 5 {@link ScreenSlidePageFragment} objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TipsFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.back_icon:
                finish();
                break;
            case R.id.next_btn: {
               // mPager.setCurrentItem(mPager.getCurrentItem() + 1, true);
                int page = mPager.getCurrentItem();
                if (mPager.getCurrentItem() == 9) {
                    startActivity(new Intent(this, GetStartActivity.class));
                    break;
                }
                mPager.setCurrentItem(mPager.getCurrentItem() + 1, true);

            }
            break;
            case R.id.open_account: {
                 startActivity(new Intent(this, GetStartActivity.class));
            }
            break;

            case R.id.previous_btn:{
                mPager.setCurrentItem(mPager.getCurrentItem() - 1, true);
            }

                break;
        }


    }
}
