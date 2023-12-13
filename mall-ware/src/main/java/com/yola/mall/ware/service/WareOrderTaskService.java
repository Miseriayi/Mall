package com.yola.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yola.common.utils.PageUtils;
import com.yola.mall.ware.entity.WareOrderTaskEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 21:29:08
 */
public interface WareOrderTaskService extends IService<WareOrderTaskEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

