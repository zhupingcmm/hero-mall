package com.hero.goods.service;

import com.hero.goods.pojo.Brand;

import java.util.List;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 13:05
 */
public interface BrandService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Brand findById(Integer id);


}
