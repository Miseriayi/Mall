package com.yola.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yola.common.utils.PageUtils;
import com.yola.mall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 20:37:09
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

