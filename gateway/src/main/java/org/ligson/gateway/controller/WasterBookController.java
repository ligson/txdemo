package org.ligson.gateway.controller;

import org.ligson.fwc.api.vo.WebResult;
import org.ligson.fwc.core.controller.CrudController;
import org.ligson.fwc.core.service.BaseService;
import org.ligson.gateway.entity.WasterBookEntity;
import org.ligson.gateway.service.WasterBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    @RequestMapping("/test")
    public WebResult test() {
        return wasterBookService.test();
    }
    //<!--用户自定义代码结束-->
}
