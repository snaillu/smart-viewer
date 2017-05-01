package com.snail.smart.vo;

import com.snail.smart.annotation.MsgType;

/**
 * @author snail
 * @create 2017/04/28
 */
@MsgType(type = "进入房间消息")
public class UserEnterMsg {
    //{uid=46523564, ic=avanew/face/201611/27/23/d4d5221fd93af4d80928a4ca407b3ac1, level=26, el=, rid=318624, nn=锦衣卫丶财哥, type=uenter, rni=0}
    private int uid;
    private int level;
    private int rid;
    private String nn;
    private String type;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
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

    @Override
    public String toString() {
        return "UserEnterMsg{" +
                "uid=" + uid +
                ", level=" + level +
                ", rid=" + rid +
                ", nn='" + nn + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
