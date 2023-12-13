package com.yola.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yola.common.utils.PageUtils;
import com.yola.mall.coupon.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 20:37:09
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

