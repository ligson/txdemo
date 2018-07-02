package org.ligson.user.entity;

import org.ligson.fwc.core.entity.BasicEntity;

import java.io.Serializable;

/***
 * 用户表
 */
public class UserEntity extends BasicEntity implements Serializable {

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


    /***
     * 获取主键
     *
     * @return 获取主键
     */
    public String getId() {
        return id;
    }

    /***
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /***
     * 获取名称
     *
     * @return 获取名称
     */
    public String getName() {
        return name;
    }

    /***
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /***
     * 获取余额
     *
     * @return 获取余额
     */
    public Integer getAmt() {
        return amt;
    }

    /***
     * 设置余额
     *
     * @param amt 余额
     */
    public void setAmt(Integer amt) {
        this.amt = amt;
    }


    /***
     * 主键类型
     *
     * @return 主键类型
     */
    @Override
    public Class primaryKeyType() {
        return String.class;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +

                ",name=" + name +

                ",amt=" + amt +
                '}';
    }
    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
