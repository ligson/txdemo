package org.ligson.gateway.vo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderVo {
    /***
     * id
     */
    private String id;

    /***
     * amt
     */
    private Integer amt;

    /***
     * createTime
     */
    private Date createTime;

    /***
     * userId
     */
    private String userId;
}
