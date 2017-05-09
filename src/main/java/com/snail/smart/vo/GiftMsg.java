package com.snail.smart.vo;

import com.snail.smart.annotation.MsgType;


/**
 * @author snail
 * @create 2017/04/27
 */
@MsgType(type = "赠送礼物消息")
public class GiftMsg {
    private int uid;
    private int dw;
    //礼物个数
    private int hits;
    private String nn;
    private String type;
    private int rid;
    private int gfid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getDw() {
        return dw;
    }

    public void setDw(int dw) {
        this.dw = dw;
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

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getGfid() {
        return gfid;
    }

    public void setGfid(int gfid) {
        this.gfid = gfid;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "GiftMsg{" +
                "uid=" + uid +
                ", dw=" + dw +
                ", hits=" + hits +
                ", nn='" + nn + '\'' +
                ", type='" + type + '\'' +
                ", rid=" + rid +
                ", gfid=" + gfid +
                '}';
    }
}
