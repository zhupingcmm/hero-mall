package com.hero.goods.controller;

import com.hero.entity.Result;
import com.hero.goods.pojo.Brand;
import com.hero.goods.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 13:36
 */

@Api(tags = {"品牌相关接口"})
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @ApiOperation(value = "获取所有品牌信息", notes = "获取所有")
    @GetMapping
    public Result<List<Brand>> findAll() {
        return Result.success(brandService.findAll());
    }

    @ApiOperation(value = "获取指定ID的品牌信息")
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        return Result.success(brandService.findById(id));
    }
}
