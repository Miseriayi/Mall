package com.yola.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.yola.common.group.AddGroup;
import com.yola.common.group.UpdateGroup;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import javax.validation.groups.Default;

/**
 * 品牌
 * 
 * @author Miseria
 * @email YoLaTengo_@outlook.com
 * @date 2023-12-13 17:11:40
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 *  注意发请求的时候封装的数据标签和entity里面的名字一致
	 *  比如json： {"brandId":1}
	 *
	 */
	//@NotEmpty(message = "请指定修改的品牌id",groups = {UpdateGroup.class})
	@Null(message = "新增数据不需要指定id",groups = {AddGroup.class})
	@NotNull(message = "修改数据必须声明id", groups = {UpdateGroup.class})
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "新增/修改数据时，品牌名不能为空",groups = {UpdateGroup.class, AddGroup.class})
	private String name;
	/**
	 * 品牌logo地址
	 *
	 * logo只在新增的时候校验是否为空
	 * 而核对url是否合法的@URL注解在新增和修改下都会生效，但是没有提交url，字段为空的话就不会生效
	 * 也就是说，新增一个商品，会触发url不为空且合理，而修改商品时只会触发url是否合理，若为空就不会校验合理
	 */
	@NotBlank(message = "新增产品需要提供url", groups = {AddGroup.class})
	@URL(message = "url地址不合法",groups = {UpdateGroup.class, AddGroup.class})
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */

	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	//Pattern中可以自己写正则表达式
	@NotEmpty(message = "检索首字母不能为空",groups = {AddGroup.class})
	@Pattern(regexp = "^[a-zA-Z]$", message = "检索首字母必须是一个字母", groups = {AddGroup.class})
	private String firstLetter;
	/**
	 * 排序
	 */
	@NotNull(message = "排序不能为空")
	@Min(value = 0, message = "排序必须大于等于0")
	private Integer sort;

}
