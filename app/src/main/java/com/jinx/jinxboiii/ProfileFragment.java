package com.jinx.jinxboiii;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class ProfileFragment extends Fragment {

    ImageView mDp, mBack;

    public ProfileFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_profile, container, false);

        mDp = (ImageView) rootview.findViewById(R.id.dp);
        mBack = (ImageView) rootview.findViewById(R.id.back_dp);



        Glide.with(getContext())
                .load("https://sguru.org/wp-content/uploads/2017/06/cool-anonymous-profile-pictures-1699946_orig.jpg")
                .apply(RequestOptions.centerCropTransform())
                .into(mDp);

        Glide.with(getContext())
                .load("https://i.ytimg.com/vi/rymsJAOnciM/maxresdefault.jpg")
                .apply(RequestOptions.centerCropTransform())
                .into(mBack);


        return rootview;

    }

}
