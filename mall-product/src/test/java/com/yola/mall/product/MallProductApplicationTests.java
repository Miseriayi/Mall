package com.yola.mall.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yola.mall.product.entity.BrandEntity;
import com.yola.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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

    /*
    1. 引入starter
    2. 配置key和secret以及bucket信息
    3. 直接使用ossClient进行操作
     */
    @Test
    void testOSS() throws Exception {
        /*String endpoint = "https://oss-cn-beijing.aliyuncs.com";

        String accessKey = "LTAI5tRS1EadQS1B4hWTz49F";
        String accessSecret = "bknJqElrZuL9hu4rKDWr0q8eUea7wn";*/
        // 填写Bucket名称，例如examplebucket。
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "girl3.jpg";
        // 填写本地文件的完整路径，例如D:\\localpath\\examplefile.txt。
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "C:\\Users\\刘子恒\\Desktop\\test2.jpg";
        String bucketname = "mall-yola";


    }

}
