package com.snail.smart.vo;

import java.util.Map;

/**
 * @author snail
 * @create 2017/04/27
 */
public class GiftMsg {
    private int uid;
    private int dw;
    private String nn;
    private String type;
    private int rid;
    private int gfid;

    public GiftMsg(Map<String,Object> content){
        uid = Integer.parseInt((String) content.get("uid"));
        dw = (Integer) content.get("dw");
        nn = (String) content.get("nn");
        type = (String) content.get("type");
        rid = Integer.parseInt((String) content.get("rid"));
        gfid = (Integer) content.get("gfid");
    }

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

    @Override
    public String toString() {
        return "GiftMsg{" +
                "uid=" + uid +
                ", dw=" + dw +
                ", nn='" + nn + '\'' +
                ", type='" + type + '\'' +
                ", rid=" + rid +
                ", gfid=" + gfid +
                '}';
    }
}
