package org.ligson.user.service.impl;

import com.codingapi.tx.annotation.TxTransaction;
import lombok.extern.slf4j.Slf4j;
import org.ligson.fwc.core.dao.BaseDao;
import org.ligson.fwc.core.service.impl.BaseServiceImpl;
import org.ligson.user.dao.UserDao;
import org.ligson.user.entity.UserEntity;
import org.ligson.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户表服务实现
 */
@Service
@Slf4j
public class UserServiceImpl extends BaseServiceImpl<UserEntity, String> implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public BaseDao<UserEntity, String> getDao() {
        return userDao;
    }
    //<!--用户自定义代码开始-->

    @Override
    @Transactional
    @TxTransaction
    public void update(UserEntity userEntity) {
        super.update(userEntity);
        log.debug("修改");
    }

    //<!--用户自定义代码结束-->
}
