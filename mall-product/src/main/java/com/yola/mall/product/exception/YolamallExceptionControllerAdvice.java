package com.yola.mall.product.exception;

import com.yola.common.exception.BizCodeEnume;
import com.yola.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*
    ControllerAdvice 集中处理异常。

    分组校验的实现，使用一个groups属性来设置，在groups里面需要传一个接口
    接口不用实现任何功能，只是用来区分在不同校验的情形
    比如添加数据时的校验，增加数据时的校验等等
    在字段上可以标注多个注解，用groups区分即可
    最后在对应的Controller中不适用@Valid注解，而是使用Spring框架的Validated注解，里面有group字段

    Note: 未标注分组的注解默认不会校验
 */
@Slf4j
// 原本注解： @ResponseBody + @ControllerAdvice(basePackages = "com.yola.mall.product.controller")
@RestControllerAdvice(basePackages = "com.yola.mall.product.controller")
public class YolamallExceptionControllerAdvice {
    /*
        该处理器专门处理验证异常
        将数据用json数据写出去，因此标注@ResponseBody注解，给该类标注@ResponseBody注解
        就生成了新注解：@ResponseBody + @ControllerAdvice = @RestControllerAdvice
     */
    //@ResponseBody
    @ExceptionHandler(value= MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e){
        log.error("数据校验错误{}, 异常类型{}",e.getMessage(),e.getClass());
        // MethodArgumentNotValidException 类中有属性BindingResult。
        BindingResult bindingResult = e.getBindingResult();
        Map<String,String> map = new HashMap<>();
        // 拿到所有信息遍历
        bindingResult.getFieldErrors().forEach((error)->{
            map.put(error.getField(),error.getDefaultMessage());
        });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(), BizCodeEnume.VALID_EXCEPTION.getMsg()).put("ErrorData",map);
    }

    //@ExceptionHandler(value = Throwable.class)
    public R handleOtherException(Exception e){
        return R.error(BizCodeEnume.UNKNOWN_EXCEPTION.getCode(), BizCodeEnume.UNKNOWN_EXCEPTION.getMsg());
    }

}
