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
 * 用户登录日志表
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserLog implements Serializable {

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
     * 用户登录ip
     */
         private String userIp;

        /**
     * 登录时间
     */
         private Date createTime;


}
