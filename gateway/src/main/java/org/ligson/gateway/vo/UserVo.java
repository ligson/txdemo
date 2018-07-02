package org.ligson.gateway.vo;

import lombok.Data;

@Data
public class UserVo {

    /***
     * 主键
     */
    private String id;

    /***
     * 名称
     */
    private String name;

    /***
     * 余额
     */
    private Integer amt;

}
