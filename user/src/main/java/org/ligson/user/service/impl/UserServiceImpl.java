package org.ligson.user.service.impl;

import com.codingapi.tx.annotation.ITxTransaction;
import org.ligson.fwc.core.dao.BaseDao;
import org.ligson.fwc.core.service.impl.BaseServiceImpl;
import org.ligson.user.dao.UserDao;
import org.ligson.user.entity.UserEntity;
import org.ligson.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户表服务实现
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserEntity, String> implements UserService, ITxTransaction {
    @Autowired
    private UserDao userDao;

    @Override
    public BaseDao<UserEntity, String> getDao() {
        return userDao;
    }
    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
