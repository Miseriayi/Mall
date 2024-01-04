package com.yola.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yola.common.utils.PageUtils;
import com.yola.mall.product.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 17:11:40
 */
public interface CategoryService extends IService<CategoryEntity> {

    PageUtils queryPage(Map<String, Object> params);

    public List<CategoryEntity> treeList();

    void deleteByIds(Long[] catIds);
}

