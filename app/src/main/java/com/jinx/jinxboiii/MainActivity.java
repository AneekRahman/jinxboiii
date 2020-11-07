package com.jinx.jinxboiii;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jinx.jinxboiii.Classes.CustomViewPager;
import com.jinx.jinxboiii.Classes.MyUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public CustomViewPager mViewPager;
    private HomeFragment mHomeFragment;
    private FragHolderFragment mFragHolderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting view with code
        mViewPager = (CustomViewPager) findViewById(R.id.view_pager);


        // Transparent status bar
        MyUtils.transpStatusBar(this);
        // Hidden system bars
        MyUtils.showHideSystem(this, true);

        setupViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                int width = MyUtils.getPixelsFromDp(getApplicationContext(),38);
                if(position != 1)
                    mFragHolderFragment.setIndicatorTranslation((position * width) + (width * positionOffset));

            }

            @Override
            public void onPageSelected(int i) {

                if(i == 0){
                    // Home fragment selected
                    MyUtils.showHideSystem(MainActivity.this, true);
                    mFragHolderFragment.selectHomeIcon();
                }else{
                    // Frag Holder fragment selected
                    MyUtils.showHideSystem(MainActivity.this, false);
                    mFragHolderFragment.selectExploreIcon();
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public void switchToHomeFrag(){

        mViewPager.setCurrentItem(0);

    }

    // The viewpager class constructor
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment) {
            mFragmentList.add(fragment);
        }

    }

    // Viewpager setup method
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mHomeFragment = new HomeFragment();
        mFragHolderFragment = new FragHolderFragment();

        viewPagerAdapter.addFrag(mHomeFragment);
        viewPagerAdapter.addFrag(mFragHolderFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mViewPager.getCurrentItem() == 0){
            // Hidden system bars
            MyUtils.showHideSystem(this, true);
        }
    }
}
