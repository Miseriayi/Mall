package com.yola.mall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yola.common.utils.PageUtils;
import com.yola.common.utils.Query;

import com.yola.mall.product.dao.AttrGroupDao;
import com.yola.mall.product.entity.AttrGroupEntity;
import com.yola.mall.product.service.AttrGroupService;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements AttrGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<AttrGroupEntity> page = this.page(
                new Query<AttrGroupEntity>().getPage(params),
                new QueryWrapper<AttrGroupEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Long cateId) {
        if(cateId == 0){
            // Query实体操作，调用getPage使用params参数返回一个IPage对象
            IPage<AttrGroupEntity> page = this.page(
                    new Query<AttrGroupEntity>().getPage(params),
                    new QueryWrapper<AttrGroupEntity>()
            );
            // 用Ipage实例化一个PageUtils类，里面包装好了我们需要的分页信息和数据
            return new PageUtils(page);
        }else{
            // 如果我们有cateId的话，需要三级分类查询
            // select * from pms_attr_group where catelog_id =?
            // and ( group_id = key or group_name like key )
            String key = (String) params.get("key");
            QueryWrapper<AttrGroupEntity> attrGroupEntityQueryWrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id",cateId);
            if(!StringUtils.isEmptyOrWhitespaceOnly(key)){
                attrGroupEntityQueryWrapper.and(
                        // 此处的obj实际上是wrapper，这里使用lambda就是使用了匿名对象的功能。可以自动判断类型为wrapper
                        (obj)->{
                            // 要么key的值等于分组id，要么与分组名模糊匹配
                            obj.eq("attr_group_id",key).or().like("attr_group_name",key);
                        }
                );
                IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params), attrGroupEntityQueryWrapper);
                return new PageUtils(page);
            }

        }
        return null;

    }

}