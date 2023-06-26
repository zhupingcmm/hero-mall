package com.hero.goods.service.impl;

import com.hero.goods.mapper.BrandMapper;
import com.hero.goods.pojo.Brand;
import com.hero.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 13:15
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.findById(id);
    }
}
