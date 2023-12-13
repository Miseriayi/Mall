package com.yola.mall.coupon.dao;

import com.yola.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 20:37:09
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
