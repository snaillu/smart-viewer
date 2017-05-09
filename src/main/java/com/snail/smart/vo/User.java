package com.snail.smart.vo;

import java.util.Date;

/**
 * @author snail
 * @create 2017/04/25
 */
public class User {
    private String uid;
    private String username;
    private String nickname;
    private String email;
    private String qq;
    private String mobile_phone;
    private String phone_status;
    private String email_status;
    private Date lastlogin;
    private String has_room;
    private String groupid;
    private String is_own_room;
    private String sex;
    private String birthday;
    private String is_reg_by_third;
    private String gold1;
    private String score;
    private int follow;
    private int ios_gold_switch;
    private String gold;
    private String noble_gold;
    private String ident_status;
    private String token;
    private Date token_exp;


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getPhone_status() {
        return phone_status;
    }

    public void setPhone_status(String phone_status) {
        this.phone_status = phone_status;
    }

    public String getEmail_status() {
        return email_status;
    }

    public void setEmail_status(String email_status) {
        this.email_status = email_status;
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public String getHas_room() {
        return has_room;
    }

    public void setHas_room(String has_room) {
        this.has_room = has_room;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getIs_own_room() {
        return is_own_room;
    }

    public void setIs_own_room(String is_own_room) {
        this.is_own_room = is_own_room;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIs_reg_by_third() {
        return is_reg_by_third;
    }

    public void setIs_reg_by_third(String is_reg_by_third) {
        this.is_reg_by_third = is_reg_by_third;
    }

    public String getGold1() {
        return gold1;
    }

    public void setGold1(String gold1) {
        this.gold1 = gold1;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getFollow() {
        return follow;
    }

    public void setFollow(int follow) {
        this.follow = follow;
    }

    public int getIos_gold_switch() {
        return ios_gold_switch;
    }

    public void setIos_gold_switch(int ios_gold_switch) {
        this.ios_gold_switch = ios_gold_switch;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getNoble_gold() {
        return noble_gold;
    }

    public void setNoble_gold(String noble_gold) {
        this.noble_gold = noble_gold;
    }

    public String getIdent_status() {
        return ident_status;
    }

    public void setIdent_status(String ident_status) {
        this.ident_status = ident_status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getToken_exp() {
        return token_exp;
    }

    public void setToken_exp(Date token_exp) {
        this.token_exp = token_exp;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email=" + email +
                ", qq='" + qq + '\'' +
                ", mobile_phone='" + mobile_phone + '\'' +
                ", phone_status='" + phone_status + '\'' +
                ", email_status='" + email_status + '\'' +
                ", lastlogin=" + lastlogin +
                ", has_room='" + has_room + '\'' +
                ", groupid='" + groupid + '\'' +
                ", is_own_room='" + is_own_room + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", is_reg_by_third='" + is_reg_by_third + '\'' +
                ", gold1='" + gold1 + '\'' +
                ", score='" + score + '\'' +
                ", follow=" + follow +
                ", ios_gold_switch=" + ios_gold_switch +
                ", gold='" + gold + '\'' +
                ", noble_gold='" + noble_gold + '\'' +
                ", ident_status='" + ident_status + '\'' +
                ", token='" + token + '\'' +
                ", token_exp=" + token_exp +
                '}';
    }
}
