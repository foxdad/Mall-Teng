package com.lt.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户的收获地址
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAddr implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 主键id
     */
         @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

        /**
     * 用户id
     */
         private String userId;

        /**
     * 用户的收获地址
     */
         private String userAddr;

        /**
     * 是否设置为默认地址 0不是 1是
     */
         private Integer status;

        /**
     * 创建时间
     */
         private Date createTime;

        /**
     * 修改时间
     */
         private Date modifiedTime;


}
