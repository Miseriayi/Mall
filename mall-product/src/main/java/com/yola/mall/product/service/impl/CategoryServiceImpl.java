package com.yola.mall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yola.common.utils.PageUtils;
import com.yola.common.utils.Query;

import com.yola.mall.product.dao.CategoryDao;
import com.yola.mall.product.entity.CategoryEntity;
import com.yola.mall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }


    /*
    在implement中实现具体服务逻辑，在controller中直接调用服务。
    该方法作用是返回树状分类结构
     */
    @Override
    public List<CategoryEntity> treeList() {
        /*MybatisPlus中的用法可以直接通过basemapper来访问数据实体
          所有的imp类都继承自Mybatisx的ServiceImpl类
          ServiceImpl中的两个泛型M和T分别是Dao和Entity，而Dao中又有一个泛型T
          在Dao的定义中可看到，每个dao实际上是继承了用Entity实例化后的basemapper
        */
        //1. 查出所有的分类数据返回，null参数是条件，无条件就是所有。
        List<CategoryEntity> entities = baseMapper.selectList(null);
        /*2. 组装为树形结构
              先找到所有的一级分类，也就是parent_cid为零的分类

        */
        List<CategoryEntity> level1Menus = entities.stream().filter(categoryEntity->
             categoryEntity.getParentCid()==0
        ).map((menu)->{menu.setChildrens( getChildren(menu,entities));return menu;}).collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public void deleteByIds(Long[] catIds) {
        //TODO 我们要的是逻辑删除。
        baseMapper.deleteBatchIds(Arrays.asList(catIds));
    }

    //该方法返回当前菜单的子菜单
    private List<CategoryEntity> getChildren( CategoryEntity categoryEntity, List<CategoryEntity> categoryEntityList){
        List<CategoryEntity> children = categoryEntityList.stream().
                filter(menu->categoryEntity.getCatId()==menu.getParentCid()).map(menu->{menu.setChildrens(getChildren(menu,categoryEntityList));return menu;}).
                collect(Collectors.toList());

        return children;
    }


}