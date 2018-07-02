package org.ligson.order.entity;

import org.ligson.fwc.core.entity.BasicEntity;

import java.io.Serializable;
import java.util.Date;

/***
 * 订单表
 */
public class OrderEntity extends BasicEntity implements Serializable {

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


    /***
     * 获取id
     *
     * @return 获取id
     */
    public String getId() {
        return id;
    }

    /***
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /***
     * 获取amt
     *
     * @return 获取amt
     */
    public Integer getAmt() {
        return amt;
    }

    /***
     * 设置amt
     *
     * @param amt amt
     */
    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    /***
     * 获取createTime
     *
     * @return 获取createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /***
     * 设置createTime
     *
     * @param createTime createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /***
     * 获取userId
     *
     * @return 获取userId
     */
    public String getUserId() {
        return userId;
    }

    /***
     * 设置userId
     *
     * @param userId userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
        return "OrderEntity{" +
                "id=" + id +

                ",amt=" + amt +

                ",createTime=" + createTime +

                ",userId=" + userId +
                '}';
    }
    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
