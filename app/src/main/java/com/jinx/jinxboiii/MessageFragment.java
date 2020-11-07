package com.jinx.jinxboiii;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.jinx.jinxboiii.Adapters.MessageListAdapter;
import com.jinx.jinxboiii.Classes.MessageListRow;
import com.jinx.jinxboiii.Classes.MyUtils;

import java.util.ArrayList;
import java.util.List;


public class MessageFragment extends Fragment {

    private LinearLayout mRecyclerHolder;
    private RecyclerView mRecyclerView;

    // Declaring recyclerview stuff
    private RecyclerView.LayoutManager mLayoutManager;
    private List<MessageListRow> mMessageList;
    private MessageListAdapter mAdapter;

    public MessageFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_message, container, false);

        mRecyclerHolder = (LinearLayout) rootview.findViewById(R.id.recycler_holder);
        mRecyclerView = (RecyclerView) rootview.findViewById(R.id.recycler);

        mRecyclerHolder.setPadding(0, 0, 0, MyUtils.getNavBarHeight(getContext()));

        setUpRecycler();

        addTestRows();

        return rootview;

    }

    private void setUpRecycler(){

        // Assign recyclerview stuff
        mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mMessageList = new ArrayList<>();
        mAdapter = new MessageListAdapter(mMessageList, getContext());

        // Setting up the recyclerview
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setFocusable(false);
        mRecyclerView.setNestedScrollingEnabled(false);

    }

    private void addTestRows(){

        MessageListRow messageListRow = new MessageListRow(
                MessageListRow.TYPE_MSG_RECEIVED_NOT_SEEN,
                0,
                "@a_cute_little_shit",
                "https://i.pinimg.com/originals/38/27/93/382793603c50e317592d9d0a38298079.jpg",
                "Hey, bruv, im cute *_*", "8:32AM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(
                MessageListRow.TYPE_MSG_RECEIVED_SEEN,
                0,
                "@now_isTheTimeBoi",
                "https://www.namepros.com/data/avatars/l/1005/1005619.jpg?1512502886",
                "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(
                MessageListRow.TYPE_MSG_SENT_NOT_SEEN,
                0,
                "@the_duchess",
                "https://pbs.twimg.com/profile_images/942198472949735424/7HFx0AGJ_400x400.jpg",
                "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(
                MessageListRow.TYPE_MSG_SENT_SEEN,
                0,
                "@big_teefs",
                "https://static-cdn.jtvnw.net/jtv_user_pictures/214b9277-73d7-48f5-9b5a-ddc36d68a9fe-profile_image-300x300.png",
                "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        messageListRow = new MessageListRow(
                MessageListRow.TYPE_MSG_SENT_SEEN,
                0,
                "@too_good_for_you_boo_so_i_dont_give_aSHIT",
                "https://i.pinimg.com/236x/90/3f/9c/903f9c823b179ffdc7c82abe87873c4a--panda-art-cute-panda.jpg",
                "Demmo message bixxxes", "6:09PM");
        mMessageList.add(messageListRow);

        for (int i = 0; i < 10; i++){

            messageListRow = new MessageListRow(
                    MessageListRow.TYPE_MSG_SENT_SEEN,
                    0,
                    "@._Mewooo_.",
                    "https://i.pinimg.com/236x/90/3f/9c/903f9c823b179ffdc7c82abe87873c4a--panda-art-cute-panda.jpg",
                    "Demmo message bixxxes", "6:09PM");
            mMessageList.add(messageListRow);


        }

        mAdapter.notifyDataSetChanged();

    }

}
