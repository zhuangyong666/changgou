package com.zy.goods.service.impl;

import com.zy.goods.dao.BrandMapper;
import com.zy.goods.service.BrandService;
import com.zy.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer add(Brand brand) {
        return brandMapper.insert(brand);
    }
}
