package org.ligson.order.service.impl;

import org.ligson.order.dao.OrderDao;
import org.ligson.order.entity.OrderEntity;
import org.ligson.order.service.OrderService;
import java.lang.String;
import org.ligson.fwc.core.dao.BaseDao;
import org.ligson.fwc.core.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单表服务实现
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity, String> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public BaseDao<OrderEntity, String> getDao() {
        return orderDao;
    }
    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
