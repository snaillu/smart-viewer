package com.snail.smart.vo;


import com.snail.smart.annotation.MsgType;

/**
 * @author snail
 * @create 2017/04/28
 */
@MsgType(type = "登录消息")
public class LoginMsg {
    //{sid=70103, nrc=2093311136, it=0, nickname=, ill_ct=, userid=0, is_illegal=0, its=0, type=loginres, sessionid=0, cur_lev=0, best_dlev=0, ill_ts=0, roomgroup=0, username=, pg=0, ih=0, npv=0, now=0, live_stat=0, es=0, ps=0}
    private int sid;
    private String nrc;
    private String nickname;
    private int userid;
    private int is_illegal;
    private String type;
    private int cur_lev;
    private String username;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getIs_illegal() {
        return is_illegal;
    }

    public void setIs_illegal(int is_illegal) {
        this.is_illegal = is_illegal;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCur_lev() {
        return cur_lev;
    }

    public void setCur_lev(int cur_lev) {
        this.cur_lev = cur_lev;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "LoginMsg{" +
                "sid=" + sid +
                ", nrc='" + nrc + '\'' +
                ", nickname='" + nickname + '\'' +
                ", userid=" + userid +
                ", is_illegal=" + is_illegal +
                ", type='" + type + '\'' +
                ", cur_lev=" + cur_lev +
                ", username='" + username + '\'' +
                '}';
    }
}
