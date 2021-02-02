package com.lt.user.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author xiaohu
 * @since 2021-02-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserCart implements Serializable {

    private static final long serialVersionUID = 1L;

        /**
     * 购物车id
     */
         private String id;

        /**
     * 用户id
     */
         private String userId;

        /**
     * 商品id
     */
         private String commodityId;

        /**
     * 商品价格
     */
         private BigDecimal price;

        /**
     * 添加的商品数量
     */
         private Integer commodityCount;

        /**
     * 创建时间
     */
         private Date createTime;

        /**
     * 修改时间
     */
         private Date modifiedTime;


}
