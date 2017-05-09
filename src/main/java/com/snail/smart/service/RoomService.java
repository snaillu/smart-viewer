package com.snail.smart.service;

import com.snail.smart.vo.Room;
import com.snail.smart.vo.RoomParam;
import com.snail.smart.vo.ServiceResponse;

import java.util.List;

/**
 * @author snail
 * @create 2017/04/21
 */
public interface RoomService {
    public ServiceResponse<List<Room>> queryAllLiveRoom(RoomParam param);

    public void queryRoomDetail(RoomParam param);
}
