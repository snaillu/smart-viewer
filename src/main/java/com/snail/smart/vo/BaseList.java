package com.snail.smart.vo;

/**
 * @author snail
 * @create 2017/04/21
 */
public class BaseList extends Base {
    public int offset;
    public int limit;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
