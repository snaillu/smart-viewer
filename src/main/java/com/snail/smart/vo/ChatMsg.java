package com.snail.smart.vo;

import com.snail.smart.annotation.MsgType;

import java.util.Map;

/**
 * @author snail
 * @create 2017/04/27
 */
@MsgType(type = "聊天消息")
public class ChatMsg {
    private int uid;
    private String nn;
    private String type;
    private String txt;
    private int rid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "ChatMsg{" +
                "uid=" + uid +
                ", nn='" + nn + '\'' +
                ", type='" + type + '\'' +
                ", txt='" + txt + '\'' +
                ", rid=" + rid +
                '}';
    }
}
