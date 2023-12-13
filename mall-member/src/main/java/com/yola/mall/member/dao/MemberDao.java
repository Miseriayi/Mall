package com.yola.mall.member.dao;

import com.yola.mall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 20:52:18
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
