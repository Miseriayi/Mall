package com.yola.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yola.common.utils.PageUtils;
import com.yola.mall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 17:11:40
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    // 新创建一个方法，用于根据分类id查询属性分页数据
    PageUtils queryPage(Map<String, Object> params, Long cateId);
}

