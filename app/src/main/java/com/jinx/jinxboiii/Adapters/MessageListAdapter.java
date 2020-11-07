package com.jinx.jinxboiii.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jinx.jinxboiii.Activities.MessagingActivity;
import com.jinx.jinxboiii.Classes.MessageListRow;
import com.jinx.jinxboiii.R;

import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter {

    private List<MessageListRow> mMessageLists;
    Context mContext;

    public MessageListAdapter(List<MessageListRow> messageListRows, Context context) {

        this.mMessageLists = messageListRows;
        this.mContext = context;
    }

    public static class MessageRowViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout mMainLinearLayout;


        public MessageRowViewHolder(View itemView) {
            super(itemView);

            this.mMainLinearLayout = (RelativeLayout) itemView.findViewById(R.id.main_layout);

        }
    }

    @Override
    public int getItemViewType(int position) {

        switch (mMessageLists.get(position).getMsgRowType()) {
            case MessageListRow.TYPE_MSG_RECEIVED_NOT_SEEN:
                return MessageListRow.TYPE_MSG_RECEIVED_NOT_SEEN;
            case MessageListRow.TYPE_MSG_RECEIVED_SEEN:
                return MessageListRow.TYPE_MSG_RECEIVED_SEEN;
            case MessageListRow.TYPE_MSG_SENT_NOT_SEEN:
                return MessageListRow.TYPE_MSG_SENT_NOT_SEEN;
            case MessageListRow.TYPE_MSG_SENT_SEEN:
                return MessageListRow.TYPE_MSG_SENT_SEEN;
            default:
                return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_row_layout, parent, false);

        return new MessageRowViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int listPosition) {

        MessageListRow messageRow = mMessageLists.get(listPosition);

        MessageRowViewHolder messageViewHolder = (MessageRowViewHolder) holder;


        messageViewHolder.mMainLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mContext.startActivity(new Intent(mContext, MessagingActivity.class));

            }
        });


        if (messageRow != null) {

            switch (messageRow.getMsgRowType()) {

                case MessageListRow.TYPE_MSG_RECEIVED_NOT_SEEN:

                    messageReceivedNotSeen(messageViewHolder, messageRow);

                    break;

                case MessageListRow.TYPE_MSG_RECEIVED_SEEN:

                    messageReceivedSeen(messageViewHolder, messageRow);

                    break;

                case MessageListRow.TYPE_MSG_SENT_NOT_SEEN:

                    messageSentNotSeen(messageViewHolder, messageRow);

                    break;

                case MessageListRow.TYPE_MSG_SENT_SEEN:

                    messageSentSeen(messageViewHolder, messageRow);

                    break;

            }
        }
    }

    @Override
    public int getItemCount() {
        return mMessageLists.size();
    }

    private void messageReceivedNotSeen(MessageRowViewHolder viewHolder, MessageListRow messageRow){

        //viewHolder.msgYouTextView.setVisibility(View.GONE);


    }

    private void messageReceivedSeen(MessageRowViewHolder viewHolder, MessageListRow messageRow){

        //viewHolder.msgYouTextView.setVisibility(View.GONE);


    }

    private void messageSentNotSeen(MessageRowViewHolder viewHolder, MessageListRow messageRow){

        //viewHolder.msgYouTextView.setVisibility(View.VISIBLE);


    }

    private void messageSentSeen(MessageRowViewHolder viewHolder, MessageListRow messageRow){

        //viewHolder.msgYouTextView.setVisibility(View.VISIBLE);



    }


}