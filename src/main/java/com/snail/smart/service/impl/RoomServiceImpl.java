package com.snail.smart.service.impl;

import com.snail.smart.enums.DouYuApiEnum;
import com.snail.smart.service.RoomService;
import com.snail.smart.utils.HttpUtils;
import com.snail.smart.vo.RoomParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author snail
 * @create 2017/04/21
 */
@Service("roomService")
public class RoomServiceImpl extends BaseService implements RoomService {
    private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);

    public void queryAllLiveRoom(RoomParam param) {
        DouYuApiEnum api = DouYuApiEnum.ALL_LIVE;
        logger.info("{}: param={}",api.getMsg(),param);
        String result = HttpUtils.get(getApiUrl(api,param));
        logger.info("{}: result={}",api.getMsg(),result);
    }
}
