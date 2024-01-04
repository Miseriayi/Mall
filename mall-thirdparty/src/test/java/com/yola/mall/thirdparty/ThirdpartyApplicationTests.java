package com.yola.mall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class ThirdpartyApplicationTests {


    @Autowired
    OSSClient ossClient;
    @Test
    void contextLoads() {
    }
    @Test
    void testUpload() throws FileNotFoundException {
        String filepath = "C:\\Users\\刘子恒\\Desktop\\test3.jpg";
        String objectname = "girl6.jpg";
        String bucket = "mall-yola";
        InputStream inputStream = new FileInputStream(filepath);
        ossClient.putObject(bucket, objectname,inputStream);
        ossClient.shutdown();
    }

}
