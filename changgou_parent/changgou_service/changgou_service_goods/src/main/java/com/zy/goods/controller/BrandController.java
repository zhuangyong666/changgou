package com.zy.goods.controller;

import com.zy.entity.PageQuery;
import com.zy.entity.Result;
import com.zy.goods.service.BrandService;
import com.zy.pojo.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * BrandController.class
 *
 * @Author zhuangyong
 * @Date 2021年3月9日 15:47:46
 */
@RestController
@RequestMapping("brand")
@CrossOrigin
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

    @PostMapping("add")
    public Result add(@RequestBody Brand brand) {
        Integer total = brandService.add(brand);
        return Result.result(total);
    }

    @PutMapping("update")
    public Result update(@RequestBody Brand brand) {
        Integer total = brandService.updateById(brand);
        return Result.result(total);
    }

    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id) {
        Integer total = brandService.deleteById(id);
        return Result.result(total);
    }

    @PostMapping("page")
    public Result<Brand> findByPage(@RequestBody PageQuery<Brand> page) {
        return Result.success().addData(brandService.findByPage(page));
    }
}
