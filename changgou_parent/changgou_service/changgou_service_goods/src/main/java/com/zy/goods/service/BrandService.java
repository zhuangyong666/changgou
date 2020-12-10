package com.zy.goods.service;

import com.zy.pojo.Brand;

import java.util.List;

public interface BrandService {
    /*** * 查询所有品牌 * @return */
    public List<Brand> findAll();
}
