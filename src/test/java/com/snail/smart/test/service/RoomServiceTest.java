package com.snail.smart.test.service;

import com.snail.smart.service.RoomService;
import com.snail.smart.test.base.BaseTest;
import com.snail.smart.vo.Room;
import com.snail.smart.vo.RoomParam;
import com.snail.smart.vo.ServiceResponse;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author snail
 * @create 2017/04/24
 */
public class RoomServiceTest extends BaseTest {

    @Resource(name = "roomService")
    private RoomService roomService;

    @Test
    public void getAllLiveRoom(){
        RoomParam param = new RoomParam();
        param.setLimit(10);
        param.setOffset(0);

        ServiceResponse<List<Room>> result = roomService.queryAllLiveRoom(param);
        logger.info("getAllLiveRoom result={}",result);
    }

    @Test
    public void queryRoomDetail(){
        roomService.queryRoomDetail(null);
    }
}
