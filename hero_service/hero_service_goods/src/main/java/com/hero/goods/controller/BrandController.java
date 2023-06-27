package com.hero.goods.controller;

import com.github.pagehelper.Page;
import com.hero.entity.PageResult;
import com.hero.entity.Result;
import com.hero.goods.pojo.Brand;
import com.hero.goods.service.BrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "品牌ID", defaultValue = "1")})
    @GetMapping("/{id}")
    public Result<Brand> findById(@PathVariable Integer id) {
        return Result.success(brandService.findById(id));
    }

    @ApiOperation(value = "添加品牌")
    @ApiImplicitParams({@ApiImplicitParam(name = "brand", value = "品牌信息")})
    @PostMapping
    public Result<?> add(@RequestBody Brand brand) {
        brandService.add(brand);
        return Result.success("添加成功");
    }

    @ApiOperation(value = "更新品牌信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "brand", value = "品牌信息")})
    @PutMapping
    public Result<?> update(@RequestBody Brand brand) {
        brandService.update(brand);
        return Result.success("更新成功");
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "删除指定ID的品牌信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "id", value = "品牌ID", defaultValue = "1")})
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        brandService.delete(id);
        return Result.success("删除成功");
    }


    /***
     * 多条件搜索品牌数据
     * @param searchMap
     * @return
     */
    @ApiOperation(value = "根据条件，查询品牌信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "searchMap", value = "品牌信息")})
    @GetMapping(value = "/search" )
    public Result<List<Brand>> findList(@RequestParam Map<String, Object> searchMap){
        List<Brand> list = brandService.findList(searchMap);
        return Result.success(list);
    }


//    /***
//     * 分页搜索实现
//     * @param searchMap
//     * @param page
//     * @param size
//     * @return
//     */
//    @ApiOperation(value = "查询品牌信息")
//    @ApiImplicitParams({@ApiImplicitParam(name = "searchMap", value = "品牌信息"), @ApiImplicitParam(name = "page", value = "起始页"), @ApiImplicitParam(name = "size", value = "每页数据量")})
//    @GetMapping(value = "/search/{page}/{size}" )
//    public Result<PageResult<Brand>> findPage(@RequestParam Map<String, Object> searchMap, @PathVariable  int page, @PathVariable  int size){
//        Page<Brand> pageList = brandService.findPage(searchMap, page, size);
//        PageResult<Brand> pageResult=new PageResult<Brand>(pageList.getTotal(),pageList.getResult());
//        return Result.success(pageResult);
//    }

    /***
     * 分页搜索实现
     *
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "查询品牌信息， 分页查询")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", value = "起始页", defaultValue = "1"), @ApiImplicitParam(name = "size", value = "每页数据量", defaultValue = "20")})
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageResult<Brand>> findPage(@PathVariable int page, @PathVariable int size){
        Page<Brand> pageList = brandService.findPage(page, size);
        PageResult<Brand> pageResult=new PageResult<>(pageList.getTotal(),pageList.getResult());
        return Result.success(pageResult);
    }

    /**
     * 根据分类名称查询品牌列表
     * @param category
     * @return
     */
    @ApiOperation(value = "根据品牌种类,查询品牌信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "category", value = "种类")})
    @GetMapping("/category/{category}")
    public Result<List<Brand>> findListByCategoryName(@PathVariable String category) {
        return Result.success(brandService.findListByCategoryName(category));
    }



}
