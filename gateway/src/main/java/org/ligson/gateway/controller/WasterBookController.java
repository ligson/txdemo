package org.ligson.gateway.controller;

import org.ligson.fwc.core.controller.CrudController;
import org.ligson.fwc.core.service.BaseService;
import org.ligson.gateway.entity.WasterBookEntity;
import org.ligson.gateway.service.WasterBookService;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Created by ligson on 2017/8/11.
*/
@Controller
@RequestMapping("/wasterBook")
public class WasterBookController extends CrudController<WasterBookEntity, String> {

    @Autowired
    private WasterBookService wasterBookService;

    @Override
    public BaseService<WasterBookEntity, String> getService() {
        return wasterBookService;
    }

    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}