package com.jinx.jinxboiii;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jinx.jinxboiii.Classes.CustomViewPager;
import com.jinx.jinxboiii.Classes.MyUtils;

import java.util.ArrayList;
import java.util.List;


public class FragHolderFragment extends Fragment {

    private ViewPager mViewPager;
    private View mIndicator;
    private ImageView mHomeIcon, mExploreIcon, mMsgIcon, mProfileIcon;

    private CustomViewPager mMainActivityViewPager;

    public FragHolderFragment() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View rootview = inflater.inflate(R.layout.fragment_frag_holder, container, false);


        // Connecting view with code
        mViewPager = (ViewPager) rootview.findViewById(R.id.view_pager);
        mIndicator = (View) rootview.findViewById(R.id.indicator);
        mHomeIcon = (ImageView) rootview.findViewById(R.id.home_icon);
        mExploreIcon = (ImageView) rootview.findViewById(R.id.explore_icon);
        mMsgIcon = (ImageView) rootview.findViewById(R.id.msg_icon);
        mProfileIcon = (ImageView) rootview.findViewById(R.id.profile_icon);

        mMainActivityViewPager = ((MainActivity) getActivity()).mViewPager;

        setupViewPager(mViewPager);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                int width = MyUtils.getPixelsFromDp(getContext(),38);
                mIndicator.setTranslationX(((position + 1) * width) + (width * positionOffset));

            }

            @Override
            public void onPageSelected(int i) {

                // To stop the nested viewpager glitch
                if(i != 0){
                    mMainActivityViewPager.setCanScroll(false);
                }else {
                    mMainActivityViewPager.setCanScroll(true);
                }

                if(i == 0){
                    selectExploreIcon();
                }else if(i == 1){
                    unselectAllIcons();
                    mMsgIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_message_icon_selected));
                }else if(i == 2){
                    unselectAllIcons();
                    mProfileIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_person_icon_selected));
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        setClickListeners();

        return rootview;

    }

    public void setClickListeners(){

        mHomeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
                ((MainActivity)getActivity()).switchToHomeFrag();
            }
        });

        mExploreIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(0);
            }
        });

        mMsgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
            }
        });

        mProfileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(2);
            }
        });

    }

    public void setIndicatorTranslation(float translation){

        if(mIndicator != null)
            mIndicator.setTranslationX(translation);

    }

    private void unselectAllIcons(){

        if(getContext() != null){

            mHomeIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_home_icon_not_selected));
            mExploreIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_explore_not_selected_icon));
            mMsgIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_message_icon_not_selected));
            mProfileIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_person_icon_not_selected));

        }

    }

    public void selectExploreIcon(){

        unselectAllIcons();
        if(getContext() != null)
            mExploreIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_explore_selected_icon));

    }

    public void selectHomeIcon(){

        unselectAllIcons();
        if(getContext() != null)
            mHomeIcon.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_home_icon_selected));

    }

    public int getFragPos(){

        return mViewPager.getCurrentItem();

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
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        viewPagerAdapter.addFrag(new ExploreFragment());
        viewPagerAdapter.addFrag(new MessageFragment());
        viewPagerAdapter.addFrag(new ProfileFragment());

        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(3);

    }

}
