package org.ligson.user.controller;

import org.ligson.fwc.core.controller.CrudController;
import org.ligson.fwc.core.service.BaseService;
import org.ligson.user.entity.UserEntity;
import org.ligson.user.service.UserService;
import java.lang.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
* Created by ligson on 2017/8/11.
*/
@Controller
@RequestMapping("/user")
public class UserController extends CrudController<UserEntity, String> {

    @Autowired
    private UserService userService;

    @Override
    public BaseService<UserEntity, String> getService() {
        return userService;
    }

    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
