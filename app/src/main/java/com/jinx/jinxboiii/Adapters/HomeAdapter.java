package com.jinx.jinxboiii.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jinx.jinxboiii.Activities.MessagingActivity;
import com.jinx.jinxboiii.Classes.HomePost;
import com.jinx.jinxboiii.Classes.MessageListRow;
import com.jinx.jinxboiii.Classes.MyUtils;
import com.jinx.jinxboiii.R;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter {

    private List<Integer> mPostIndicatorIdList = new ArrayList<>();
    private List<HomePost> mHomePostLists;
    private Context mContext;

    public HomeAdapter(List<HomePost> homePostLists, Context context) {

        this.mHomePostLists = homePostLists;
        this.mContext = context;
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {

        LinearLayout mIndicatorHolder;
        ImageView mImageView, mDp;
        View mProgress;


        public HomeViewHolder(View itemView) {
            super(itemView);

            this.mIndicatorHolder = (LinearLayout) itemView.findViewById(R.id.indicator_holder);
            this.mImageView = (ImageView) itemView.findViewById(R.id.image_view);
            this.mDp = (ImageView) itemView.findViewById(R.id.dp);
            this.mProgress = (View) itemView.findViewById(R.id.progress);

        }
    }

    @Override
    public int getItemViewType(int position) {

        switch (mHomePostLists.get(position).getPostType()) {
            case HomePost.TYPE_IMAGE_POST:
                return HomePost.TYPE_IMAGE_POST;
            case HomePost.TYPE_VIDEO_POST:
                return HomePost.TYPE_VIDEO_POST;
            default:
                return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_post_layout, parent, false);

        return new HomeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        HomePost homePost = mHomePostLists.get(listPosition);

        HomeViewHolder homeViewHolder = (HomeViewHolder) holder;


        if (homePost != null) {

            switch (homePost.getPostType()) {

                case HomePost.TYPE_IMAGE_POST:

                    imageHomePost(homeViewHolder, homePost);

                    break;

                case HomePost.TYPE_VIDEO_POST:

                    videoHomePost(homeViewHolder, homePost);

                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return mHomePostLists.size();
    }

    private void imageHomePost(HomeViewHolder viewHolder, HomePost homePost){

        Glide.with(mContext)
                .load(homePost.getPostContentUrl())
                .into(viewHolder.mImageView);

        Glide.with(mContext)
                .load("https://pbs.twimg.com/profile_images/1883301307/normal_usatt_400x400.jpg")
                .apply(RequestOptions.circleCropTransform())
                .into(viewHolder.mDp);

        addProgressIndicator(viewHolder.mIndicatorHolder, true);
        addProgressIndicator(viewHolder.mIndicatorHolder, true);
        addProgressIndicator(viewHolder.mIndicatorHolder, true);
        addProgressIndicator(viewHolder.mIndicatorHolder, false);
        addProgressIndicator(viewHolder.mIndicatorHolder, false);
        addProgressIndicator(viewHolder.mIndicatorHolder, false);


    }

    private void videoHomePost(HomeViewHolder viewHolder, HomePost homePost){


    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);

        ((HomeViewHolder) holder).mProgress.animate()
                .scaleX(1.0f)
                .setDuration(3000)
                .setInterpolator(new LinearInterpolator())
                .start();

    }

    private void addProgressIndicator(LinearLayout v, boolean filled){

        // New Linear layout
        LinearLayout holderLayout = new LinearLayout(mContext);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        p.weight = 1;
        holderLayout.setLayoutParams(p);
        holderLayout.setPadding(0,0,10,0);

        // New CardView
        CardView card = new CardView(mContext);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        card.setLayoutParams(params);
        card.setRadius(200);
        card.setCardElevation(0);
        if(filled){
            card.setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_white_bg));
        }else{
            card.setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_black_bg));
        }


        // New indicator view
        View view = new View(mContext);
        view.setLayoutParams(params);
        view.setBackground(ContextCompat.getDrawable(mContext, R.drawable.indicator_white_bg));
        view.setScaleX(0f);
        view.setPivotX(0f);

        // Adding all up
        card.addView(view);
        holderLayout.addView(card);
        v.addView(holderLayout);

    }

}