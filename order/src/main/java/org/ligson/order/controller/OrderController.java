package org.ligson.order.controller;

import org.ligson.fwc.core.controller.CrudController;
import org.ligson.fwc.core.service.BaseService;
import org.ligson.order.entity.OrderEntity;
import org.ligson.order.service.OrderService;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Created by ligson on 2017/8/11.
*/
@Controller
@RequestMapping("/order")
public class OrderController extends CrudController<OrderEntity, String> {

    @Autowired
    private OrderService orderService;

    @Override
    public BaseService<OrderEntity, String> getService() {
        return orderService;
    }

    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
