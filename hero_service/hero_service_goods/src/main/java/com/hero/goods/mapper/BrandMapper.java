package com.hero.goods.mapper;

import com.hero.goods.pojo.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 13:23
 */
@Mapper
public interface BrandMapper {

    List<Brand> findAll();

    Brand findById(@Param(value = "id") Integer id);

}
