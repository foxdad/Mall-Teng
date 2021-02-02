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
 * 用户表
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 主键id
     */
         @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

        /**
     * 用户名
     */
         private String username;

        /**
     * 用户登录名
     */
         private String loginName;

        /**
     * 密码
     */
         private String password;

        /**
     * 用户状态
     */
         private Integer status;

        /**
     * 用户性别，0男，1女
     */
         private Integer sex;

        /**
     * 用户邮箱
     */
         private String userMail;

        /**
     * 用户手机号
     */
         private String userPhone;

        /**
     * 创建时间
     */
         private Date createTime;

        /**
     * 修改时间
     */
         private Date modifiedTime;


}
