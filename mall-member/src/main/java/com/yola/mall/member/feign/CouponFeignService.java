package com.yola.mall.member.feign;

import com.yola.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("mall-coupon")
public interface CouponFeignService {

    //把coupon controller里面的方法复制到内部。
    //注意地址需写全
    @RequestMapping("/coupon/coupon/member/list")
    //@RequiresPermissions("coupon:coupon:list")
    public R membercoupons();
}
