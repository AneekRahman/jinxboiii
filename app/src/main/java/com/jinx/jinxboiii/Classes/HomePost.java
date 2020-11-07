package com.jinx.jinxboiii.Classes;

public class HomePost {

    public static final int TYPE_VIDEO_POST = 0;
    public static final int TYPE_IMAGE_POST = 1;

    private int mPostType;
    private String mPostContentUrl;

    public HomePost(int postType, String postContentUrl){

        this.mPostType = postType;
        this.mPostContentUrl = postContentUrl;

    }

    public int getPostType() {
        return mPostType;
    }

    public String getPostContentUrl() {
        return mPostContentUrl;
    }
}
