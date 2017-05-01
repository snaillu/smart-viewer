package com.snail.smart.vo;

import com.snail.smart.annotation.MsgType;

/**
 * @author snail
 * @create 2017/04/27
 */
@MsgType(type = "抢红包消息")
public class RedPacketMsg {
    //{dnk=超级的大蜗牛, rpt=0, sid=865336, pnm=赞, cnt=3, rid=11017, snk=脑浆炖大肠, did=104954726, type=gpbc}
    private String dnk;
    private int sid;
    private String pnm;
    private int cnt;
    private int rid;
    private String snk;
    private int did;
    private String type;

    public String getDnk() {
        return dnk;
    }

    public void setDnk(String dnk) {
        this.dnk = dnk;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPnm() {
        return pnm;
    }

    public void setPnm(String pnm) {
        this.pnm = pnm;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getSnk() {
        return snk;
    }

    public void setSnk(String snk) {
        this.snk = snk;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
