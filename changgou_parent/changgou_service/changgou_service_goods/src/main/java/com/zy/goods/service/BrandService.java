package com.zy.goods.service;

import com.github.pagehelper.Page;
import com.zy.entity.PageQuery;
import com.zy.pojo.Brand;

import java.util.List;

public interface BrandService {
    /*** * 查询所有品牌 * @return */
    List<Brand> findAll();

    Brand findById(Integer id);

    Integer add(Brand brand);

    Integer updateById(Brand brand);

    Integer deleteById(Integer id);

    Page<Brand> findByPage(PageQuery<Brand> page);
}
