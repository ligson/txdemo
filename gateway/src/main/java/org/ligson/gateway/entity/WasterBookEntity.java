package org.ligson.gateway.entity;

import org.ligson.fwc.core.entity.BasicEntity;

import java.io.Serializable;

/***
 * 系统流水
 */
public class WasterBookEntity extends BasicEntity implements Serializable {

    /***
     * id
     */
    private String id;

    /***
     * userId
     */
    private String userId;

    /***
     * amt
     */
    private Integer amt;

    /***
     * 状态:[1.成功,2.失败]
     */
    private Integer status;


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
     * 获取状态:[1.成功,2.失败]
     *
     * @return 获取状态:[1.成功,2.失败]
     */
    public Integer getStatus() {
        return status;
    }

    /***
     * 设置状态:[1.成功,2.失败]
     *
     * @param status 状态:[1.成功,2.失败]
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        return "WasterBookEntity{" +
                "id=" + id +

                ",userId=" + userId +

                ",amt=" + amt +

                ",status=" + status +
                '}';
    }
    //<!--用户自定义代码开始-->

    //<!--用户自定义代码结束-->
}
