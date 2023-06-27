package com.hero.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hero.goods.mapper.BrandMapper;
import com.hero.goods.pojo.Brand;
import com.hero.goods.service.BrandService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: pzhu
 * @Date: 2023/6/26 13:15
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findListByCategoryName(String category) {
        return brandMapper.findListByCategoryName(category);
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.findById(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.addBrand(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.update(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.delete(id);
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Brand brand = getSearchBrand(searchMap);
        return brandMapper.findList(brand);
    }

    private Brand getSearchBrand(Map<String, Object> searchMap) {
        Brand brand = new Brand();
        val name = searchMap.get("name");
        val letter = searchMap.get("letter");
        brand.setName((String) name);
        brand.setLetter((String) letter);
        return brand;
    }

    @Override
    public Page<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
//        List<Brand> brands = brandMapper.findAll();
//        PageInfo<Brand> pageInfo = new PageInfo<>(brands);
        return (Page<Brand>) brandMapper.findAll();
    }

    @Override
    public Page<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Brand brand = getSearchBrand(searchMap);
        return (Page<Brand>) brandMapper.findList(brand);
    }
}
