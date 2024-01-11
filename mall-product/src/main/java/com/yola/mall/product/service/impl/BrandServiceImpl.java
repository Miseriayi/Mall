package com.yola.mall.product.service.impl;

import com.mysql.cj.util.StringUtils;
import com.yola.mall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yola.common.utils.PageUtils;
import com.yola.common.utils.Query;

import com.yola.mall.product.dao.BrandDao;
import com.yola.mall.product.entity.BrandEntity;
import com.yola.mall.product.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void updateDetails(BrandEntity brand) {
        // 保证冗余字段数据一致
        // 1. 先更新自己的数据
        this.updateById(brand);
        // 2. 对名字进行判断,若不为空，说明品牌名会修改，因此要同步更新其他表的品牌名
        if(!StringUtils.isEmptyOrWhitespaceOnly(brand.getName())){
            // 更新其他关联表品牌名
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());

            // TODO 更新其他关联
        }
    }

}