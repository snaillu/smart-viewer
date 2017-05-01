package com.snail.smart.vo;

import com.snail.smart.annotation.MsgType;

/**
 * @author snail
 * @create 2017/04/28
 */
@MsgType(type = "房间礼物消息")
public class RoomGiftMsg {
    //{sid=3336870, sn=Kuma桑别欺负我吖, bgl=3, gc=1, ifs=0, type=spbc, drid=1333106, eid=143, gb=1, gn=火箭, rid=1863767, gfid=196, gid=0, dn=我的队友是鱼饵, gs=6, bid=30065_1493370789_3, es=1, cl2=0}
    private int sid;
    private String sn;
    private int bgl;
    private int gc;
    private int ifs;
    private String type;
    //有礼物的房间id
    private int drid;
    private int eid;
    private int gb;
    private String gn;
    private int rid;
    private int gfid;
    private String dn;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getBgl() {
        return bgl;
    }

    public void setBgl(int bgl) {
        this.bgl = bgl;
    }

    public int getGc() {
        return gc;
    }

    public void setGc(int gc) {
        this.gc = gc;
    }

    public int getIfs() {
        return ifs;
    }

    public void setIfs(int ifs) {
        this.ifs = ifs;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDrid() {
        return drid;
    }

    public void setDrid(int drid) {
        this.drid = drid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public String getGn() {
        return gn;
    }

    public void setGn(String gn) {
        this.gn = gn;
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

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    @Override
    public String toString() {
        return "RoomGiftMsg{" +
                "sid=" + sid +
                ", sn='" + sn + '\'' +
                ", bgl=" + bgl +
                ", gc=" + gc +
                ", ifs=" + ifs +
                ", type='" + type + '\'' +
                ", drid=" + drid +
                ", eid=" + eid +
                ", gb=" + gb +
                ", gn='" + gn + '\'' +
                ", rid=" + rid +
                ", gfid=" + gfid +
                ", dn='" + dn + '\'' +
                '}';
    }
}
