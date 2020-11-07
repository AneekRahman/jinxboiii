package com.jinx.jinxboiii;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jinx.jinxboiii.Adapters.HomeAdapter;
import com.jinx.jinxboiii.Adapters.MessageListAdapter;
import com.jinx.jinxboiii.Classes.HomePost;
import com.jinx.jinxboiii.Classes.MessageListRow;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    // Declaring views
    private RecyclerView mRecyclerView;

    // Declaring recyclerview stuff
    private RecyclerView.LayoutManager mLayoutManager;
    private List<HomePost> mPostList;
    private HomeAdapter mAdapter;

    public HomeFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_home, container, false);



        mRecyclerView = (RecyclerView) rootview.findViewById(R.id.recycler);

        setUpRecycler();

        testPosts();

        return rootview;

    }

    private void setUpRecycler(){

        // Assign recyclerview stuff
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mPostList = new ArrayList<>();
        mAdapter = new HomeAdapter(mPostList, getContext());

        // Setting up the recyclerview
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // Adding pager behavior
        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);

    }

    private void testPosts(){

        mPostList.clear();

        HomePost post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://www.shutterstock.com/blog/wp-content/uploads/sites/5/2017/08/facebook-cover-photo-header.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://i.pinimg.com/originals/73/46/59/7346590e31ba88e3a966abfe08d4a303.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "http://www.wallpapermaiden.com/wallpaper/20711/download/1080x1920/gigi-hadid-sunglasses-model-red-lipstick-long-hair.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://www.hiamag.com/sites/default/files/profile/%20%D8%A7%D8%B1%D8%AA%D8%B4%D9%8A%D9%84.jpg");
        mPostList.add(post);

        post = new HomePost(HomePost.TYPE_IMAGE_POST, "https://images.unsplash.com/photo-1537941032657-672864703060?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=4e25dea0cf8dd7808c7bfbdecc6a02a1&dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb");
        mPostList.add(post);

        mAdapter.notifyDataSetChanged();

    }


}
