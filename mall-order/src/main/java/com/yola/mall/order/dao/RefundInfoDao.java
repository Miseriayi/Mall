package com.yola.mall.order.dao;

import com.yola.mall.order.entity.RefundInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 退款信息
 * 
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 21:04:02
 */
@Mapper
public interface RefundInfoDao extends BaseMapper<RefundInfoEntity> {
	
}
