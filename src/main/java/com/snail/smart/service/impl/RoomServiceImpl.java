package com.snail.smart.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.snail.smart.enums.DouYuApiEnum;
import com.snail.smart.service.RoomService;
import com.snail.smart.utils.HttpUtils;
import com.snail.smart.vo.Room;
import com.snail.smart.vo.RoomParam;
import com.snail.smart.vo.ServiceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author snail
 * @create 2017/04/21
 */
@Service("roomService")
public class RoomServiceImpl extends BaseService implements RoomService {
    private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    public ServiceResponse<List<Room>> queryAllLiveRoom(RoomParam param) {
        ServiceResponse result = new ServiceResponse();

        DouYuApiEnum api = DouYuApiEnum.ALL_LIVE;
        logger.info("{}: param={}",api.getMsg(),param);
        String apiResult = HttpUtils.get(getApiUrl(api,param));
        logger.info("{}: result={}",api.getMsg(),apiResult);
        JSONObject json = JSON.parseObject(apiResult);
        int code = json.getInteger("error");
        if(code==0){
            JSONArray array = json.getJSONArray("data");
            List<Room> roomList = JSON.parseArray(array.toJSONString(),Room.class);
            result.setResult(roomList);
        }else {
            result = ServiceResponse.failResponse();
        }

        return result;
    }
}
