package com.jinx.jinxboiii.Classes;

public class ChatRow {

    int chatMsgID, msgUserID;
    String chatMsg, msgUserFirstName, msgTime;

    public ChatRow(int chatMsgID, int msgUserID, String chatMsg, String msgUserFirstName, String msgTime){

        this.chatMsgID = chatMsgID;
        this.msgUserID = msgUserID;
        this.chatMsg = chatMsg;
        this.msgUserFirstName = msgUserFirstName;
        this.msgTime = msgTime;

    }

    public int getChatMsgID() {
        return chatMsgID;
    }

    public int getMsgUserID() {
        return msgUserID;
    }

    public String getChatMsg() {
        return chatMsg;
    }

    public String getMsgUserFirstName() {
        return msgUserFirstName;
    }

    public String getMsgTime() {
        return msgTime;
    }

}
