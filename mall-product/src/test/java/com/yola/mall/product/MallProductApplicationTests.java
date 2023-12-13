package com.yola.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yola.mall.product.entity.BrandEntity;
import com.yola.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallProductApplicationTests {
    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new  BrandEntity();
        brandEntity.setName("苹果");
        System.out.println("删除成功！");
        brandService.remove(new QueryWrapper<BrandEntity>(brandEntity));
    }

}
