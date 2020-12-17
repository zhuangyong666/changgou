package com.zy.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zy.entity.PageQuery;
import com.zy.entity.SQLSymbol;
import com.zy.goods.dao.BrandMapper;
import com.zy.goods.service.BrandService;
import com.zy.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Integer updateById(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public Integer deleteById(Integer id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Page<Brand> findByPage(PageQuery<Brand> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        Brand query = page.getQuery();
        if (Optional.ofNullable(query).isPresent()) {
            String name = query.getName();
            String letter = query.getLetter();
            if (Optional.ofNullable(name).isPresent()) {
                criteria.andLike("name", SQLSymbol.PERCENT_SIGN + name + SQLSymbol.PERCENT_SIGN);
            }
            if (Optional.ofNullable(letter).isPresent()) {
                criteria.andEqualTo("letter", letter);
            }
        }
        example.orderBy("id").asc();
        return (Page<Brand>) brandMapper.selectByExample(example);
    }
}
