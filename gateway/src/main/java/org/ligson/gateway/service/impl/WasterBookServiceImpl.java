package org.ligson.gateway.service.impl;

import org.ligson.gateway.dao.WasterBookDao;
import org.ligson.gateway.entity.WasterBookEntity;
import org.ligson.gateway.service.WasterBookService;
import java.lang.String;
import org.ligson.fwc.core.dao.BaseDao;
import org.ligson.fwc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统流水服务实现
 */
@Service
public class WasterBookServiceImpl extends BaseServiceImpl<WasterBookEntity, String> implements WasterBookService {
    @Autowired
    private WasterBookDao wasterBookDao;

    @Override
    public BaseDao<WasterBookEntity, String> getDao() {
        return wasterBookDao;
    }
    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
