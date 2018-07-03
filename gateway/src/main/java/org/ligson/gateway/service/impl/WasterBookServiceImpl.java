package org.ligson.gateway.service.impl;

import com.codingapi.tx.annotation.ITxTransaction;
import com.codingapi.tx.annotation.TxTransaction;
import com.xb.fwc.api.vo.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.ligson.fwc.core.dao.BaseDao;
import org.ligson.fwc.core.service.impl.BaseServiceImpl;
import org.ligson.gateway.dao.WasterBookDao;
import org.ligson.gateway.entity.WasterBookEntity;
import org.ligson.gateway.service.WasterBookService;
import org.ligson.gateway.vo.OrderVo;
import org.ligson.gateway.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统流水服务实现
 */
@Service
@Slf4j
public class WasterBookServiceImpl extends BaseServiceImpl<WasterBookEntity, String> implements WasterBookService, ITxTransaction {
    @Autowired
    private WasterBookDao wasterBookDao;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    private RequestEntity vo2Entity(Object obj, String url) {
        try {
            return RequestEntity.post(new URI(url)).contentType(MediaType.APPLICATION_JSON_UTF8).body(obj);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public BaseDao<WasterBookEntity, String> getDao() {
        return wasterBookDao;
    }

    //<!--用户自定义代码开始-->
    @TxTransaction(isStart = true)
    @Transactional
    @Override
    public WebResult test() {
        List<ServiceInstance> list = discoveryClient.getInstances("order-service");
        WebResult webResult = new WebResult();
        if (CollectionUtils.isEmpty(list)) {
            webResult.setSuccess(false);
            webResult.setErrorMsg("订单服务未启动");
            return webResult;
        }
        OrderVo orderVo = new OrderVo();
        orderVo.setAmt(100);
        orderVo.setUserId("1");
        orderVo.setCreateTime(new Date());
        log.debug("开始调用订单服务");
        ResponseEntity<WebResult> resultResponseEntity = restTemplate.exchange(vo2Entity(orderVo, "http://order-service/order/add.json"), WebResult.class);
        assert resultResponseEntity.getStatusCode() == HttpStatus.OK;
        assert resultResponseEntity.getBody().isSuccess();
        Map<String, String> params = new HashMap<>();
        params.put("pk", "1");
        log.debug("开始查询用户服务");
        resultResponseEntity = restTemplate.exchange(vo2Entity("1", "http://user-service/user/get.json"), WebResult.class);
        assert resultResponseEntity.getStatusCode() == HttpStatus.OK;
        assert resultResponseEntity.getBody().isSuccess();
        UserVo userVo2 = resultResponseEntity.getBody().getData("entity", UserVo.class);
        UserVo userVo = new UserVo();
        userVo.setId("1");
        userVo.setAmt(orderVo.getAmt() + userVo2.getAmt());
        log.debug("开始修改用户服务");
        resultResponseEntity = restTemplate.exchange(vo2Entity(userVo, "http://user-service/user/update.json"), WebResult.class);
        assert resultResponseEntity.getStatusCode() == HttpStatus.OK;
        assert resultResponseEntity.getBody().isSuccess();
        WasterBookEntity wasterBookEntity = new WasterBookEntity();
        wasterBookEntity.setAmt(orderVo.getAmt());
        wasterBookEntity.setStatus(1);
        wasterBookEntity.setUserId("1");
        log.debug("开始保存流水");
        add(wasterBookEntity);
        System.out.println(100 / (2018 >> 12));
        return resultResponseEntity.getBody();
    }
    //<!--用户自定义代码结束-->
}
