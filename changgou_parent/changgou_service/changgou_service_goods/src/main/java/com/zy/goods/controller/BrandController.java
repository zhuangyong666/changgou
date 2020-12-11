package com.zy.goods.controller;

import com.zy.entity.Result;
import com.zy.goods.service.BrandService;
import com.zy.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("getAll")
    public Result<Brand> getAll() {
        List<Brand> brandList = brandService.findAll();
        return Result.success().addData(brandList);
    }

    @GetMapping("{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        Brand brand = brandService.findById(id);
        return Result.success().addData(brand);
    }
}
