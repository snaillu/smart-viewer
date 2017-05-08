package com.snail.smart.enums;

/**
 * @author snail
 * @create 2017/05/08
 */
public enum  GiftTypeEnum {
    ROCKET(196,"火箭"),
    PLANE(195,"火箭"),
    CARD(750,"办卡"),
    CHICKEN(789,"热辣鸡小萌"),
    GOOD(192,"赞"),
    FISH(191,"100鱼丸"),
    SONG(714,"怂");

    GiftTypeEnum(int id, String msg){
        this.id = id;
        this.msg = msg;
    }

    private int id;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getGiftName(int id){
        String name = "礼物";
        for(GiftTypeEnum typeEnum:GiftTypeEnum.values()){
            if(typeEnum.getId()==id){
                name = typeEnum.getMsg();
                break;
            }
        }

        return name;
    }
}
