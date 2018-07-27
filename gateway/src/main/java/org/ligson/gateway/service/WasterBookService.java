package org.ligson.gateway.service;

import org.ligson.fwc.api.vo.WebResult;
import org.ligson.fwc.core.service.BaseService;
import org.ligson.gateway.entity.WasterBookEntity;

/**
 * 系统流水服务
 */
public interface WasterBookService extends BaseService<WasterBookEntity, String> {

    //<!--用户自定义代码开始-->
    WebResult test();

    //<!--用户自定义代码结束-->
}
