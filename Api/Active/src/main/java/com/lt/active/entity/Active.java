package com.lt.active.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 活动表
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Active implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 活动标识
     */
         @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

        /**
     * 图片地址
     */
         private String activeImage;

        /**
     * 活动名称
     */
         private String activeName;

        /**
     * 跳转的目标地址
     */
         private String targeturl;

        /**
     * 创建时间
     */
         private Date createTime;

        /**
     * 修改时间
     */
         private Date modifiedTime;


}
